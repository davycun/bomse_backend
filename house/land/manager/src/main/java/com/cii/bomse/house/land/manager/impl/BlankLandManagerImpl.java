package com.cii.bomse.house.land.manager.impl;

import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.house.base.dictionary.AcreageUnit;
import com.cii.bomse.house.land.dao.IBlankLandDao;
import com.cii.bomse.house.land.dictionary.BlankLandOperationType;
import com.cii.bomse.house.land.manager.IBlankLandManager;
import com.cii.bomse.house.land.entity.BlankLandEntity;
import com.cii.bomse.hrm.dept.manager.IDataAuthValidator;
import com.cii.bomse.hrm.dept.manager.IDeptAreaManager;
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
import java.util.List;
import java.util.Map;


@Component
public class BlankLandManagerImpl extends AbstractManager<BlankLandEntity> implements IBlankLandManager {

    @Autowired
    private IBlankLandDao blankLandDao;
    @Autowired
    private IDeptAreaManager deptAreaManager;
    @Autowired
    private IDataAuthValidator dataAuthValidator;
    @Autowired
    private IOperationLogManager operationLogManager;

    @Override
    protected IMyBatisBaseDao<BlankLandEntity, Long> getMyBatisDao() {
        return blankLandDao;
    }

    @Override
    protected void beforeBatchCreate(List<BlankLandEntity> list) {

        beforeCreateOrUpdateProcessUnit(list);
    }
    @Override
    protected void beforeBatchUpdate(List<BlankLandEntity> list) {

         beforeCreateOrUpdateProcessUnit(list);
    }

    private void beforeCreateOrUpdateProcessUnit(List<BlankLandEntity> list){

        for (BlankLandEntity blank : list){
            validateLeasePrice(blank);
            processAcreageUnit(blank);
        }
    }

    /**
     * @description
     * 校验价格是否合理，并且价格单位只是保存平方米
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-24 10:38
     * @since 1.0
     */
    private void validateLeasePrice(BlankLandEntity blank) {

        String msg = "价格不真实，或者价格与价格单位不匹配";
        if (ObjectUtils.isNotEmpty(blank.getLeasePrice()) && IndustryPriceUnitType.Day.equals(blank.getLeasePriceUnit())) {
            if (blank.getLeasePrice().compareTo(5.0f) > -1) {
                throw new BusinessException(msg);
            }
        } else if (ObjectUtils.isNotEmpty(blank.getLeasePrice()) && IndustryPriceUnitType.Month.equals(blank.getLeasePriceUnit())) {
            if (blank.getLeasePrice().compareTo(150.0f) > -1) {
                throw new BusinessException(msg);
            }

            blank.setLeasePrice(blank.getLeasePrice()*12/365);
            blank.setLeasePriceUnit(IndustryPriceUnitType.Day);

        }else if(ObjectUtils.isNotEmpty(blank.getLeasePrice()) && IndustryPriceUnitType.Year.equals(blank.getLeasePriceUnit())){
            if (blank.getLeasePrice().compareTo(780.0f) > -1) {
                throw new BusinessException(msg);
            }

            blank.setLeasePrice(blank.getLeasePrice()/365);
            blank.setLeasePriceUnit(IndustryPriceUnitType.Day);
        }
    }

    /**
     * @description
     * 数据库只是保存平方米单位
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-24 10:38
     * @since 1.0
     */
    private void processAcreageUnit(BlankLandEntity blank) {

        if (ObjectUtils.isNotEmpty(blank.getAcreage()) && AcreageUnit.Mu.equals(blank.getAcreageUnit())) {
            //1亩 = 666.6666667平方米
            blank.setAcreage(blank.getAcreage()*666.6666667f);
            blank.setAcreageUnit(AcreageUnit.Square);
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //如果没有传入区域条件，那么只能查询部门关联的城市房源
        if (!param.containsKey("cityId")
                && !param.containsKey("regionId")
                && !param.containsKey("streetId")
                && !param.containsKey("communityId")
                && ObjectUtils.isNotEmpty(CurrentContext.getOwnerDeptId())) {

            List<Long> cityIds = deptAreaManager.findDeptCityId(CurrentContext.getOwnerDeptId());

            if (ObjectUtils.isNotEmpty(cityIds)){
                if (cityIds.size()>1){
                    param.put("cityIds",cityIds);
                }else{
                    param.put("cityId",cityIds.get(0));
                }
            }
        }


    }

    @Override
    public String callPhone(Long blId) {

        BlankLandEntity blank = findById(blId,"id","contact_phone","owner_id","owner_dept_id","create_id","create_dept_id");

        String phone = null;

        ValidationResult vr = null;

        if ((vr = dataAuthValidator.validateEntityBelongToUser(blank,CurrentContext.getUserInfo())).getSuccess()){
            phone = blank.getContactPhone();
        }else if((vr = dataAuthValidator.validateEntityBelongToUserDept(blank,CurrentContext.getUserInfo())).getSuccess()){
            phone = blank.getContactPhone();
        }else if((vr = dataAuthValidator.validateEntityBelongToUserAuthDept(blank,CurrentContext.getUserInfo())).getSuccess()){
            phone = blank.getContactPhone();
        }else{
            throw new BusinessException("只有相同部门的同事，或者自己的录入的场地信息才可查看号码!");
        }

        if (ObjectUtils.isNotEmpty(phone)){
            //if success ,record a log of call phone
            OperationLogEntity log = new OperationLogEntity();
            log.setBizId(blId);
            log.setOptType(BlankLandOperationType.blankCallPhone);
            log.setContent(String.format("%s拨打了场地[%d]的联系人电话",CurrentContext.getUserName(),blank.getId()));

            operationLogManager.create(log);
        }

        return phone;
    }

    @Override
    public void updatePhone(Long blId, String oldPhone, String newPhone) {

        BlankLandEntity land = findById(blId,"id","contact_phone");


        land.setContactPhone(newPhone);

        update(land);
    }
}
