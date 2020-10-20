package com.cii.bomse.house.industry.manager.impl;

import com.cii.bomse.house.base.dictionary.HouseFollowupType;
import com.cii.bomse.house.base.dictionary.HouseOperationType;
import com.cii.bomse.house.industry.dao.IParkIndustryDao;
import com.cii.bomse.house.industry.dao.IParkIndustryFollowupDao;
import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.cii.bomse.house.industry.manager.IParkIndustryFollowupManager;
import com.cii.bomse.house.industry.entity.ParkIndustryFollowupEntity;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class ParkIndustryFollowupManagerImpl extends AbstractManager<ParkIndustryFollowupEntity> implements IParkIndustryFollowupManager {

    @Autowired
    private IParkIndustryFollowupDao parkIndustryFollowupDao;
    @Autowired
    private IParkIndustryDao parkIndustryDao;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<ParkIndustryFollowupEntity, Long> getMyBatisDao() {
        return parkIndustryFollowupDao;
    }

    @Override
    protected void afterBatchCreate(List<ParkIndustryFollowupEntity> list) {

        //跟新园区跟进信息
        afterCreateProcessParkFollowupInfo(list);
        //添加园区操作日志
        addParkFollowupLog(list);
    }

    /**
     * @description
     * 更新园区的跟进信息
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-11 17:44
     * @since 1.0
     */
    private void afterCreateProcessParkFollowupInfo(List<ParkIndustryFollowupEntity> list){

        List<ParkIndustryEntity> parkList = new ArrayList<>();

        Map<String,Object> param = new HashMap<>();

        for (ParkIndustryFollowupEntity followup : list){

            ParkIndustryEntity park = new ParkIndustryEntity();
            park.setId(followup.getParkId());
            park.setLastFollowupTime(new Date());

            param.put("parkId",followup.getParkId());
            int count = parkIndustryFollowupDao.countByMap(param);
            park.setFollowupCount(count);

            parkList.add(park);
        }

        if (ObjectUtils.isNotEmpty(parkList)){
            parkIndustryDao.batchUpdate(parkList);
        }
    }

    /**
     * @description
     * 添加园区关联操作日志
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-11 17:51
     * @since 1.0
     */
    private void addParkFollowupLog(List<ParkIndustryFollowupEntity> list){

        List<OperationLogEntity> optLogList = new ArrayList<>();
        for (ParkIndustryFollowupEntity followupEntity : list) {
            OperationLogEntity opt = new OperationLogEntity();

            opt.setBizId(followupEntity.getParkId());
            if (HouseFollowupType.Phone.equals(followupEntity.getFollowupType())) {
                opt.setOptType(HouseOperationType.parkFollowupPhone);
                opt.setContent(String.format("%s电话跟进了园区[%d]",
                        followupEntity.getCreateName(), followupEntity.getParkId()));
            } else {
                opt.setOptType(HouseOperationType.parkFollowupScene);
                opt.setContent(String.format("%s上门拜访了园区[%d]",
                        followupEntity.getCreateName(), followupEntity.getParkId()));
            }

            optLogList.add(opt);
        }
        if (ObjectUtils.isNotEmpty(optLogList)) {
            operationLogManager.batchCreate(optLogList);
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //查询房源跟进列表的时候只能查询自己或者有权限或者子部门的数据
        if (!param.containsKey("parkId")) {
            //跟进只能查询自己的或者自己子部门的数据

            List<Long> ownerDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

            if (ObjectUtils.isNotEmpty(ownerDeptIds)) {
                param.put("authCreateDeptIds", ownerDeptIds);
                param.put("authCreateId", CurrentContext.getUserId());
            } else{
                //查询跟进列表的时候才加上此条件
                param.put("createId", CurrentContext.getUserId());
            }
        }
    }
}
