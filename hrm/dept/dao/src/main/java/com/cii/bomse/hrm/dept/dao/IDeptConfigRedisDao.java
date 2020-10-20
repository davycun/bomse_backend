package com.cii.bomse.hrm.dept.dao;

import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.ciiframework.data.redis.IRedisDao;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-30 20:33
 * @since 1.0
 */
public interface IDeptConfigRedisDao extends IRedisDao<DeptConfigEntity> {

    DeptConfigEntity getDeptConfigByDeptId(Long deptId);

    void setDeptConfigByDeptId(Long deptId,DeptConfigEntity deptConfig);

    DeptConfigEntity getDefaultDeptConfig();

    void deleteDeptConfigByDeptId(Long deptId);
}
