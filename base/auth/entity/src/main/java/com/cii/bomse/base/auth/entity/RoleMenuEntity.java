package com.cii.bomse.base.auth.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 16:39
 */
public class RoleMenuEntity extends BaseEntity{

    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
