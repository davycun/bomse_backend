package com.cii.bomse.hrm.dept.dao.impl;

import com.cii.bomse.hrm.dept.dao.IDeptDao;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 14:05
 */
@Repository
public class DeptDaoImpl extends AbstractMyBatisDao<DeptEntity,Long> implements IDeptDao {
}
