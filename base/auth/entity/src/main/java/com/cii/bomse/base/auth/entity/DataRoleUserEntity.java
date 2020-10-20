package com.cii.bomse.base.auth.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:47
 * @since 1.0
 */
public class DataRoleUserEntity extends BaseEntity {

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
