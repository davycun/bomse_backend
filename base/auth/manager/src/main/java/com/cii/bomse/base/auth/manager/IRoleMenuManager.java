package com.cii.bomse.base.auth.manager;

import com.cii.bomse.base.auth.entity.RoleMenuEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/8 00:00
 */
public interface IRoleMenuManager extends IManager<RoleMenuEntity> {

    public void updateRoleMenu(Long roleId, List<Long> menuIds);
}
