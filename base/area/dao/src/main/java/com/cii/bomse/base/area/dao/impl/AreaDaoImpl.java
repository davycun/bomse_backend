package com.cii.bomse.base.area.dao.impl;

import com.cii.bomse.base.area.dao.IAreaDao;
import com.cii.bomse.base.area.entity.AreaEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class AreaDaoImpl extends AbstractMyBatisDao<AreaEntity,Long> implements IAreaDao {
}
