package com.cii.bomse.hrm.dept.dao.impl;

import com.cii.bomse.hrm.dept.dao.IDeptConfigDao;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class DeptConfigDaoImpl extends AbstractMyBatisDao<DeptConfigEntity,Long> implements IDeptConfigDao {
}
