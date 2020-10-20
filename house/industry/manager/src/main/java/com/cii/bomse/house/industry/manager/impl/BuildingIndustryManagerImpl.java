package com.cii.bomse.house.industry.manager.impl;

import com.cii.bomse.house.base.dictionary.HouseOperationType;
import com.cii.bomse.house.industry.dao.IBuildingIndustryDao;
import com.cii.bomse.house.industry.dao.IFloorIndustryDao;
import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.cii.bomse.house.industry.manager.IBuildingIndustryManager;
import com.cii.bomse.house.industry.entity.BuildingIndustryEntity;
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
public class BuildingIndustryManagerImpl extends AbstractManager<BuildingIndustryEntity> implements IBuildingIndustryManager {

    @Autowired
    private IBuildingIndustryDao buildingIndustryDao;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IFloorIndustryDao floorIndustryDao;

    @Override
    protected IMyBatisBaseDao<BuildingIndustryEntity, Long> getMyBatisDao() {
        return buildingIndustryDao;
    }

    @Override
    protected void beforeBatchCreate(List<BuildingIndustryEntity> list) {
        for (BuildingIndustryEntity buildingIndustry : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑

            ValidationResult vr = ValidationUtils.validateInclude(buildingIndustry);
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }

            exists(buildingIndustry);
        }
    }


    @Override
    protected void afterBatchCreate(List<BuildingIndustryEntity> list) {
        addOperationLog(list,true);
    }

    @Override
    protected void afterBatchUpdate(List<BuildingIndustryEntity> list) {
        addOperationLog(list,false);
    }

    private void exists(BuildingIndustryEntity building){
        Map<String,Object> param = new HashMap<>();
        param.put("parkId",building.getParkId());
        param.put("bdName",building.getBdName());

        int count = buildingIndustryDao.countByMap(param);
        if (count > 0){
            throw new BusinessException("园区内相同楼栋名已存在，不能重复创建");
        }

    }

    @Override
    public void updateBuildingFloorCount(Long buildingId) {

        if (ObjectUtils.isEmpty(buildingId)){
            return;
        }

        Map<String,Object> param = new HashMap<>();
        param.put("buildingId",buildingId);

        int count = floorIndustryDao.countByMap(param);
        if (count>0){
            BuildingIndustryEntity building = new BuildingIndustryEntity();
            building.setId(buildingId);
            building.setFloorCount(count);
            buildingIndustryDao.update(building);
        }


    }

    private void addOperationLog(List<BuildingIndustryEntity> list, boolean create) {

        List<OperationLogEntity> optLogList = new ArrayList<>();

        for (BuildingIndustryEntity building : list) {
            OperationLogEntity opt = new OperationLogEntity();
            opt.setBizId(building.getId());
            if (create){
                opt.setOptType(HouseOperationType.createBuilding);
            }else{
                opt.setOptType(HouseOperationType.updateBuilding);
            }
            opt.setContent(String.format("%s%s[%d]", CurrentContext.getUserName(),
                    DictionaryStorage.get(OperationType.class.getName(),opt.getOptType()).getName(),building.getId()));

            optLogList.add(opt);
        }
        if (ObjectUtils.isNotEmpty(optLogList)){
            operationLogManager.batchCreate(optLogList);
        }
    }

}
