package com.cii.bomse.house.industry.manager.impl;

import com.cii.bomse.house.base.dictionary.HouseOperationType;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
import com.cii.bomse.house.base.manager.IParkOwnerRelationManager;
import com.cii.bomse.house.industry.dao.IBuildingIndustryDao;
import com.cii.bomse.house.industry.dao.IFloorIndustryDao;
import com.cii.bomse.house.industry.dao.IParkIndustryDao;
import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.cii.bomse.house.industry.manager.IParkIndustryManager;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ParkIndustryManagerImpl extends AbstractManager<ParkIndustryEntity> implements IParkIndustryManager {

    @Autowired
    private IParkIndustryDao parkIndustryDao;
    @Autowired
    private IBuildingIndustryDao buildingIndustryDao;
    @Autowired
    private IFloorIndustryDao floorIndustryDao;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IParkOwnerRelationManager parkOwnerRelationManager;

    @Override
    protected IMyBatisBaseDao<ParkIndustryEntity, Long> getMyBatisDao() {
        return parkIndustryDao;
    }

    @Override
    protected void beforeBatchCreate(List<ParkIndustryEntity> list) {

        for (ParkIndustryEntity parkIndustry : list) {
            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑

            ValidationResult vr = ValidationUtils.validateInclude(parkIndustry);
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
            //校验是否房源位置重复
            exists(parkIndustry);
        }
    }

    @Override
    protected void beforeBatchUpdate(List<ParkIndustryEntity> list) {
        for (ParkIndustryEntity parkIndustry : list) {
            //在更新数据之前的动作，比如校验数据唯一键必填
        }
    }

    @Override
    protected void afterBatchCreate(List<ParkIndustryEntity> list) {
        addOperationLog(list,true);
        //创建业主与园区的关联关系
        createHouseOwnerRelation(list);
    }

    @Override
    protected void afterBatchUpdate(List<ParkIndustryEntity> list) {
        addOperationLog(list,false);
    }

    private void createHouseOwnerRelation(List<ParkIndustryEntity> list){
        List<ParkOwnerRelationEntity> relationList = new ArrayList<>();
        for (ParkIndustryEntity park : list){

            ParkOwnerRelationEntity relation = new ParkOwnerRelationEntity();
            relation.setParkId(park.getId());
            relation.setHouseOwnerId(park.getHouseOwnerId());
            relationList.add(relation);
        }

        if (ObjectUtils.isNotEmpty(relationList)){
            parkOwnerRelationManager.batchCreate(relationList);
        }
    }

    private void exists(ParkIndustryEntity park) {
        Map<String, Object> param = new HashMap<>();
        param.put("streetId", park.getStreetId());
        param.put("address", park.getAddress());

        if (ObjectUtils.isNotEmpty(CurrentContext.getCpyId())) {
            param.put("cpyId", CurrentContext.getCpyId());
        }

        //是全部地址
        int count = parkIndustryDao.countByMap(param);

        if (count > 0) {
            throw new BusinessException("相同地址的园区已经存在，不可重复新增，请选择园区");
        }
    }

    private void addOperationLog(List<ParkIndustryEntity> parkList,boolean createPark) {

        List<OperationLogEntity> optLogList = new ArrayList<>();

        for (ParkIndustryEntity park : parkList) {

            OperationLogEntity opt = new OperationLogEntity();
            opt.setBizId(park.getId());
            if (createPark){
                opt.setOptType(HouseOperationType.createPark);
            }else{
                opt.setOptType(HouseOperationType.updatePark);
            }
            opt.setContent(String.format("%s%s[%d]",CurrentContext.getUserName(),
                    DictionaryStorage.get(OperationType.class.getName(),opt.getOptType()).getName(),park.getId()));

            optLogList.add(opt);

        }
        if (ObjectUtils.isNotEmpty(optLogList)){
            operationLogManager.batchCreate(optLogList);
        }
    }

    @Override
    @Transactional
    public void updateParkStatistic(Long parkId) {

        if (ObjectUtils.isEmpty(parkId)){
            throw new BusinessException("更新园区统计数据，园区id不能为空");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("parkId", parkId);

        ParkIndustryEntity park = new ParkIndustryEntity();
        park.setId(parkId);

        //更新楼栋总数
        int count = buildingIndustryDao.countByMap(param);
        park.setBuildingCount(count);

        //更新面积及价格信息
        FloorIndustryEntity floor = floorIndustryDao.statisticPark(parkId);
        park.setLeaseAcreage(floor.getLeaseAcreage());
        park.setLeaseAcreageMin(floor.getLeaseAcreageMin());
        park.setPriceMin(floor.getPrice());
        park.setPriceMinUnit(floor.getPriceUnit());
        park.setFloorHeightMax(floor.getFloorHeight());

        parkIndustryDao.update(park);
    }


}
