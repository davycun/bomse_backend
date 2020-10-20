package com.cii.bomse.base.auth.entity;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:48
 * @since 1.0
 */
public class DataRoleDeptEntity extends BaseEntity {

    private Long roleId;

    private Long deptId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
