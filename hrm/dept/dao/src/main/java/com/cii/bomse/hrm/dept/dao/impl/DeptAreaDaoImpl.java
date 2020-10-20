package com.cii.bomse.hrm.dept.dao.impl;

import com.cii.bomse.hrm.dept.dao.IDeptAreaDao;
import com.cii.bomse.hrm.dept.entity.DeptAreaEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class DeptAreaDaoImpl extends AbstractMyBatisDao<DeptAreaEntity,Long> implements IDeptAreaDao {
}
