package com.cii.bomse.house.industry.dao.impl;

import com.cii.bomse.house.industry.dao.IFloorIndustryDao;
import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FloorIndustryDaoImpl extends AbstractMyBatisDao<FloorIndustryEntity, Long> implements IFloorIndustryDao {
    @Override
    public FloorIndustryEntity statisticPark(Long parkId) {

        Map<String,Object> param = new HashMap<>();
        param.put("parkId",parkId);
        return this.getSqlSession().selectOne(this.mapperNamespace + "selectParkStatistic", param);

    }
}
