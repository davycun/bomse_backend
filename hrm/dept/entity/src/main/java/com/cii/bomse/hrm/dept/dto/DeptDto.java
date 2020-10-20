package com.cii.bomse.hrm.dept.dto;

import com.cii.bomse.hrm.dept.entity.DeptEntity;

import javax.validation.constraints.NotNull;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-23 18:46
 * @since 1.0
 */
public class DeptDto extends DeptEntity {

    @NotNull(message = "数据角色ID不能为空")
    private Long roleId;
    @NotNull(message = "用户ID不能为空")
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
