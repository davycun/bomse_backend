package com.cii.bomse.hrm.emp.dao.impl;

import com.cii.bomse.hrm.emp.dao.IEmployeeDbDao;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/17 11:59
 */
@Repository
public class EmployeeDbDaoImpl extends AbstractMyBatisDao<EmployeeEntity,Long> implements IEmployeeDbDao {
}
