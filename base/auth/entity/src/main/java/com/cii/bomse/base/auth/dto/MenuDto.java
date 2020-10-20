package com.cii.bomse.base.auth.dto;

import com.cii.bomse.base.auth.entity.MenuEntity;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 16:35
 */
public class MenuDto extends MenuEntity {

    @NotNull(message = "请求参数角色编码必填")
    private Long roleId;

    @NotNull(message = "请求参数用户编码必填")
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
