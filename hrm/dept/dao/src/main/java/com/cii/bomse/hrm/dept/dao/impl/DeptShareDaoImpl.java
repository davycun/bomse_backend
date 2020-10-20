package com.cii.bomse.hrm.dept.dao.impl;

import com.cii.bomse.hrm.dept.dao.IDeptShareDao;
import com.cii.bomse.hrm.dept.entity.DeptShareEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class DeptShareDaoImpl extends AbstractMyBatisDao<DeptShareEntity,Long> implements IDeptShareDao {
}
