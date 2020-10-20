package com.cii.bomse.base.auth.dto;

import com.cii.bomse.base.auth.entity.DataRoleUserEntity;
import com.ciiframework.service.AbstractRestControllerRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 12:39
 * @since 1.0
 */
public class DataRoleUserControllerRequest extends AbstractRestControllerRequest<DataRoleUserEntity> {

    @NotNull(message = "分配角色菜单编码不能为空")
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
