package com.cii.bomse.house.base.manager.impl;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.house.base.dao.IHouseOwnerDao;
import com.cii.bomse.house.base.dictionary.HouseOwnerOperationType;
import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
import com.cii.bomse.house.base.manager.IHouseOwnerManager;
import com.cii.bomse.house.base.manager.IParkOwnerRelationManager;
import com.cii.bomse.hrm.dept.manager.IDataAuthValidator;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Component
public class HouseOwnerManagerImpl extends AbstractManager<HouseOwnerEntity> implements IHouseOwnerManager {

    @Autowired
    private IHouseOwnerDao houseOwnerDao;
    @Autowired
    private IDeptManager deptManager;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IDataAuthValidator dataAuthValidator;
    @Autowired
    private IParkOwnerRelationManager parkOwnerRelationManager;

    @Override
    protected IMyBatisBaseDao<HouseOwnerEntity, Long> getMyBatisDao() {
        return houseOwnerDao;
    }

    @Override
    protected void beforeBatchCreate(List<HouseOwnerEntity> list) {
    }

    @Override
    protected void beforeBatchUpdate(List<HouseOwnerEntity> list) {
    }

    @Override
    protected void afterBatchCreate(List<HouseOwnerEntity> list) {

        //新增联系人关系
        createHouseOwnerRelation(list);
    }

    private void createHouseOwnerRelation(List<HouseOwnerEntity> list) {
        List<ParkOwnerRelationEntity> relationList = new ArrayList<>();
        for (HouseOwnerEntity owner : list) {
            if (ObjectUtils.isNotEmpty(owner.getParkId())) {
                ParkOwnerRelationEntity relation = new ParkOwnerRelationEntity();
                relation.setParkId(owner.getParkId());
                relation.setHouseOwnerId(owner.getId());
                relationList.add(relation);
            }
        }

        if (ObjectUtils.isNotEmpty(relationList)) {
            parkOwnerRelationManager.batchCreate(relationList);
        }
    }

    @Override
    public String callPhone(Long houseOwnerId) {

        ValidationResult vr = null;

        HouseOwnerEntity owner = findById(houseOwnerId, "id", "own_phone", "owner_id", "owner_dept_id");

        String phone = null;

        if ((vr = dataAuthValidator.validateEntityBelongToUser(
                owner, CurrentContext.getUserInfo())).getSuccess()) {
            phone = owner.getOwnPhone();

        } else if ((vr = dataAuthValidator.validateEntityBelongToUserDept(
                owner, CurrentContext.getUserInfo())).getSuccess()) {
            phone = owner.getOwnPhone();
        } else if ((vr = dataAuthValidator.validateEntityBelongToUserAuthDept(
                owner, CurrentContext.getUserInfo())).getSuccess()) {
            phone = owner.getOwnPhone();
        }else{
            throw new BusinessException("只有相同部门同事，或者自己的录入的业主信息才可查看!");
        }

        if (ObjectUtils.isNotEmpty(phone)){
            recordUpdateOrCallPhoneLog(houseOwnerId,owner.getOwnPhone(),false);
        }

        return phone;
    }

    @Transactional
    public void updateHouseOwnerPhone(Long ownId, String oldPhone, String newPhone) {

        if (ObjectUtils.isNotEmpty(ownId)
                && ObjectUtils.isNotEmpty(oldPhone)
                && ObjectUtils.isNotEmpty(newPhone)) {

            HouseOwnerEntity owner =
                    Optional.ofNullable(findById(ownId, "id", "own_phone"))
                            .orElseThrow(()-> new BusinessException(String.format("客户[%d]不存在", ownId)));

            if (owner.getOwnPhone().equals(oldPhone)
                    && Pattern.matches(Constants.phoneRegexp, newPhone)) {

                //更新客户号码
                owner.setOwnPhone(newPhone);
                getMyBatisDao().update(owner);
//                update(owner);

                recordUpdateOrCallPhoneLog(ownId, oldPhone,true);

            } else {
                throw new BusinessException("手机号码格式不对，或者原号码不匹配");
            }
        }
    }

    private OperationLogEntity createLog(ParkOwnerRelationEntity relation,Long ownId,String phone,boolean update){
        //记录与园区ID关联的日志
        OperationLogEntity opt = new OperationLogEntity();
        opt.setBizId(relation.getParkId());

        if (update){
            opt.setOptType(HouseOwnerOperationType.updateOwnerPhone);
            opt.setContent(String.format("%s更新了业主联系人[%d]的号码，老号码为%s",
                    CurrentContext.getUserName(), relation.getHouseOwnerId(), phone));
        }else{
            opt.setOptType(HouseOwnerOperationType.callOwnerPhone);
            opt.setContent(String.format("%s拨打了业主联系人[%d]号码", CurrentContext.getUserName(), ownId));
        }
        opt.setRemark(ownId.toString());

        return opt;
    }

    private void recordUpdateOrCallPhoneLog(Long ownId, String phone,boolean update) {

        Map<String, Object> param = new HashMap<>();
        param.put("houseOwnerId", ownId);

        List<ParkOwnerRelationEntity> relationList = parkOwnerRelationManager.findByMap(param);

        if (ObjectUtils.isNotEmpty(relationList)) {

            List<OperationLogEntity> optList = relationList.stream().map(
                    (relation)->createLog(relation,ownId,phone,update)).collect(Collectors.toList());
            if (ObjectUtils.isNotEmpty(optList)){
                operationLogManager.batchCreate(optList);
            }
        }

        //记录与业主ID关联的日志
        OperationLogEntity opt = new OperationLogEntity();
        opt.setBizId(ownId);
        if (update){
            opt.setOptType(HouseOwnerOperationType.updateOwnerPhone);
            opt.setContent(String.format("%s更新了业主联系人[%d]号码，老号码为%s", CurrentContext.getUserName(), ownId, phone));
        }else{
            opt.setOptType(HouseOwnerOperationType.callOwnerPhone);
            opt.setContent(String.format("%s拨打了业主联系人[%d]号码", CurrentContext.getUserName(), ownId));
        }
        opt.setRemark(phone);
        operationLogManager.create(opt);
    }

    @Override
    public List<HouseOwnerEntity> findByParkId(Long parkId) {
        return houseOwnerDao.selectByParkId(parkId);
    }

    @Override
    public List<HouseOwnerEntity> findByBuildingId(Long buildingId) {
        return houseOwnerDao.selectByBuildingId(buildingId);
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        if (ObjectUtils.isNotEmpty(CurrentContext.getUserId())) {
            List<Long> ownerDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());
            if (ObjectUtils.isNotEmpty(ownerDeptIds)) {
                param.put("authOwnerDeptIds", ownerDeptIds);
                param.put("authOwnerId", CurrentContext.getUserId());
            } else {
                param.put("ownerId", CurrentContext.getUserId());
            }
        }
    }
}
