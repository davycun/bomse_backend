package com.cii.bomse.house.industry.dao.impl;

import com.cii.bomse.house.industry.dao.IParkIndustryDao;
import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class ParkIndustryDaoImpl extends AbstractMyBatisDao<ParkIndustryEntity,Long> implements IParkIndustryDao {
}
