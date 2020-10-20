package com.cii.bomse.base.auth.dto;

import com.cii.bomse.base.auth.entity.RoleUserEntity;
import com.ciiframework.service.AbstractRestControllerRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/14 22:39
 */
public class RoleUserControllerRequest extends AbstractRestControllerRequest<RoleUserEntity> {

    @NotNull(message = "分配角色菜单ID不能为空")
    private Long roleId;

    @NotEmpty(message = "给用户分配角色，用户ID不能为空")
    @NotNull(message = "给用户分配角色，用户ID不能为空")
    private List<Long> userIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
