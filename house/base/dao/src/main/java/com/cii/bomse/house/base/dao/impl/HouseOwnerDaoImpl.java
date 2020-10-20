package com.cii.bomse.house.base.dao.impl;

import com.cii.bomse.house.base.dao.IHouseOwnerDao;
import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HouseOwnerDaoImpl extends AbstractMyBatisDao<HouseOwnerEntity,Long> implements IHouseOwnerDao {

    private static final String selectByHouse = "selectByHouse";

    @Override
    public List<HouseOwnerEntity> selectByParkId(Long parkId) {

        Map<String,Object> param = new HashMap<>();
        param.put("parkId",parkId);
        return this.selectByStatement(selectByHouse,param);
    }

    @Override
    public List<HouseOwnerEntity> selectByBuildingId(Long buildingId) {
        Map<String,Object> param = new HashMap<>();
        param.put("buildingId",buildingId);
        return this.selectByStatement(selectByHouse,param);
    }
}
