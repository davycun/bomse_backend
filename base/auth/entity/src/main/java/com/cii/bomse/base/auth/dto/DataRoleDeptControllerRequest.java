package com.cii.bomse.base.auth.dto;

import com.cii.bomse.base.auth.entity.DataRoleDeptEntity;
import com.ciiframework.service.AbstractRestControllerRequest;
import com.ciiframework.validation.ListNotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 12:38
 * @since 1.0
 */
public class DataRoleDeptControllerRequest extends AbstractRestControllerRequest<DataRoleDeptEntity> {


    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @ListNotEmpty(message = "没有勾选相应的菜单")
    private List<Long> deptIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Long> deptIds) {
        this.deptIds = deptIds;
    }
}
