package com.cii.bomse.house.base.dao.impl;

import com.cii.bomse.house.base.dao.IParkOwnerRelationDao;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class ParkOwnerRelationDaoImpl extends AbstractMyBatisDao<ParkOwnerRelationEntity,Long> implements IParkOwnerRelationDao {
}
