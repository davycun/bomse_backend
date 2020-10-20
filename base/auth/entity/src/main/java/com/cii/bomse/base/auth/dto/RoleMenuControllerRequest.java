package com.cii.bomse.base.auth.dto;

import com.cii.bomse.base.auth.entity.RoleMenuEntity;
import com.ciiframework.service.AbstractRestControllerRequest;
import com.ciiframework.validation.ListNotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/7 23:55
 */
public class RoleMenuControllerRequest extends AbstractRestControllerRequest<RoleMenuEntity> {

    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @ListNotEmpty(message = "没有勾选相应的菜单")
    private List<Long> menuIds;

    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}
