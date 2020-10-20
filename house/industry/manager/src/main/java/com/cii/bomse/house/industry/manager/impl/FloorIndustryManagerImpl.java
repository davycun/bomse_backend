package com.cii.bomse.house.industry.manager.impl;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.cii.bomse.house.base.dictionary.HouseOperationType;
import com.cii.bomse.house.industry.dao.IFloorIndustryDao;
import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
import com.cii.bomse.house.industry.manager.IBuildingIndustryManager;
import com.cii.bomse.house.industry.manager.IFloorIndustryManager;
import com.cii.bomse.house.industry.manager.IParkIndustryManager;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.manager.IDeptAreaManager;
import com.cii.bomse.hrm.dept.manager.IDeptConfigManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.dictionary.OperationType;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class FloorIndustryManagerImpl extends AbstractManager<FloorIndustryEntity> implements IFloorIndustryManager {

    @Autowired
    private IFloorIndustryDao floorIndustryDao;
    @Autowired
    private IParkIndustryManager parkIndustryManager;
    @Autowired
    private IBuildingIndustryManager buildingIndustryManager;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IDeptAreaManager deptAreaManager;
    @Autowired
    private IDeptConfigManager deptConfigManager;

    @Override
    protected IMyBatisBaseDao<FloorIndustryEntity, Long> getMyBatisDao() {
        return floorIndustryDao;
    }

    @Override
    protected void beforeBatchCreate(List<FloorIndustryEntity> list) {
        for (FloorIndustryEntity floorIndustry : list){

            ValidationResult vr = ValidationUtils.validateInclude(floorIndustry);
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }

            //判断价格是否真实
            validatePrice(floorIndustry);

            //判断楼层总面及是否大于可出租面积
            validateAcreage(floorIndustry);

            //判断房源是否重复
            exists(floorIndustry);
        }
    }
    @Override
    protected void beforeBatchUpdate(List<FloorIndustryEntity> list) {
         for (FloorIndustryEntity floorIndustry : list){

             //判断价格是否真实
             validatePrice(floorIndustry);

             //判断楼层总面及是否大于可出租面积
             validateAcreage(floorIndustry);
         }
    }


    @Override
    protected void afterBatchCreate(List<FloorIndustryEntity> list) {
        for (FloorIndustryEntity floorIndustry : list){
            parkIndustryManager.updateParkStatistic(floorIndustry.getParkId());
            buildingIndustryManager.updateBuildingFloorCount(floorIndustry.getBuildingId());
        }

        addOperationLog(list,true);
    }

    @Override
    protected void afterBatchUpdate(List<FloorIndustryEntity> list) {
        for (FloorIndustryEntity floorIndustry : list){
            parkIndustryManager.updateParkStatistic(floorIndustry.getParkId());
        }

        addOperationLog(list,false);
    }

    private void exists(FloorIndustryEntity floor){
        Map<String,Object> param = new HashMap<>();
        param.put("parkId",floor.getParkId());
        param.put("buildingId",floor.getBuildingId());
        param.put("floorNumber",floor.getFloorNumber());

        int count = floorIndustryDao.countByMap(param);
        if (count > 0){
            throw new BusinessException("园区内相同楼栋的楼层已经创建过，不可重复创建！");
        }

    }

    private void addOperationLog(List<FloorIndustryEntity> list, boolean create) {

        List<OperationLogEntity> optLogList = new ArrayList<>();

        for (FloorIndustryEntity floor : list) {
            OperationLogEntity opt = new OperationLogEntity();
            opt.setBizId(floor.getId());
            if (create){
                opt.setOptType(HouseOperationType.createFloor);
            }else{
                opt.setOptType(HouseOperationType.updateFloor);
            }
            opt.setContent(String.format("%s%s[%d]", CurrentContext.getUserName(),
                    DictionaryStorage.get(OperationType.class.getName(),opt.getOptType()).getName(),floor.getId()));

            optLogList.add(opt);
        }
        if (ObjectUtils.isNotEmpty(optLogList)){
            operationLogManager.batchCreate(optLogList);
        }
    }

    private void validatePrice(FloorIndustryEntity floor) {

        String msg = "价格不真实，或者价格与价格单位不匹配";
        if (ObjectUtils.isNotEmpty(floor.getPrice()) && IndustryPriceUnitType.Day.equals(floor.getPriceUnit())) {
            if (floor.getPrice().compareTo(5.0f) > -1) {
                throw new BusinessException(msg);
            }
        } else if (ObjectUtils.isNotEmpty(floor.getPrice()) && IndustryPriceUnitType.Month.equals(floor.getPriceUnit())) {
            if (floor.getPrice().compareTo(150.0f) > -1) {
                throw new BusinessException(msg);
            }

            floor.setPrice(floor.getPrice()*12/365);
            floor.setPriceUnit(IndustryPriceUnitType.Day);

        }else if(ObjectUtils.isNotEmpty(floor.getPrice()) && IndustryPriceUnitType.Year.equals(floor.getPriceUnit())){
            if (floor.getPrice().compareTo(780.0f) > -1) {
                throw new BusinessException(msg);
            }

            floor.setPrice(floor.getPrice()/365);
            floor.setPriceUnit(IndustryPriceUnitType.Day);
        }
    }

    private void validateAcreage(FloorIndustryEntity floor){
        if (ObjectUtils.isNotEmpty(floor.getTotalAcreage()) && ObjectUtils.isNotEmpty(floor.getLeaseAcreage())){

            if (floor.getLeaseAcreage()>floor.getTotalAcreage()){
                throw new BusinessException("楼层总面积必须大于楼层可出租面积");
            }
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //如果没有传入区域条件，那么只能查询部门关联的城市房源
        if ((param.containsKey("cityId")
                || param.containsKey("regionId")
                || param.containsKey("streetId")
                || param.containsKey("communityId"))
                && ObjectUtils.isNotEmpty(CurrentContext.getOwnerDeptId())) {

            DeptConfigEntity config = deptConfigManager.findByDeptId(CurrentContext.getOwnerDeptId());
            List<Long> areaIds = deptAreaManager.findAreaIds(CurrentContext.getOwnerDeptId(),config.getAreaType());

            switch (config.getAreaType()){
                case AreaType.Community:
                    param.put("communityIds",areaIds);
                    break;
                case AreaType.Street:
                    param.put("streetIds",areaIds);
                    break;
                case AreaType.Region:
                    param.put("regionIds",areaIds);
                    break;
                case AreaType.City:
                    param.put("cityIds",areaIds);
            }
        }
    }
}
