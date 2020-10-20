package com.cii.bomse.house.industry.dao.impl;

import com.cii.bomse.house.industry.dao.IHouseIndustryDao;
import com.cii.bomse.house.industry.entity.HouseIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class HouseIndustryDaoImpl extends AbstractMyBatisDao<HouseIndustryEntity,Long> implements IHouseIndustryDao {
}
