package com.cii.bomse.house.industry.dao;

import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;

public interface IFloorIndustryDao extends IMyBatisBaseDao<FloorIndustryEntity,Long> {

    FloorIndustryEntity statisticPark(Long parkId);
}
