package com.cii.bomse.base.auth.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:45
 * @since 1.0
 */
public class DataRoleEntity extends BaseEntity {

    @NotNull(message = "角色名称必填")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
