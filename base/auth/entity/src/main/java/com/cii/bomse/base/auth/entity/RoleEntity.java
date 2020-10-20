package com.cii.bomse.base.auth.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 16:38
 */
public class RoleEntity extends BaseEntity {

    @NotNull(message = "角色名称必填")
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
