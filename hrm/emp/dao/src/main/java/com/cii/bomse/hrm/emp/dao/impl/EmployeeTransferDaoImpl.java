package com.cii.bomse.hrm.emp.dao.impl;

import com.cii.bomse.hrm.emp.dao.IEmployeeTransferDao;
import com.cii.bomse.hrm.emp.entity.EmployeeTransferEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeTransferDaoImpl extends AbstractMyBatisDao<EmployeeTransferEntity,Long> implements IEmployeeTransferDao {
}
