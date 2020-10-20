package com.cii.bomse.house.land.dao.impl;

import com.cii.bomse.house.land.dao.IBlankLandDao;
import com.cii.bomse.house.land.entity.BlankLandEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class BlankLandDaoImpl extends AbstractMyBatisDao<BlankLandEntity,Long> implements IBlankLandDao {
}
