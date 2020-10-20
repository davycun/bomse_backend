package com.cii.bomse.hrm.emp.dao.impl;

import com.cii.bomse.hrm.emp.dao.IEmployeeQuitDao;
import com.cii.bomse.hrm.emp.entity.EmployeeQuitEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeQuitDaoImpl extends AbstractMyBatisDao<EmployeeQuitEntity,Long> implements IEmployeeQuitDao {
}
