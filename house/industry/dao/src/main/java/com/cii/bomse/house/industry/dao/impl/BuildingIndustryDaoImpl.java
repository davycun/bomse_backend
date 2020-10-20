package com.cii.bomse.house.industry.dao.impl;

import com.cii.bomse.house.industry.dao.IBuildingIndustryDao;
import com.cii.bomse.house.industry.entity.BuildingIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingIndustryDaoImpl extends AbstractMyBatisDao<BuildingIndustryEntity,Long> implements IBuildingIndustryDao {
}
