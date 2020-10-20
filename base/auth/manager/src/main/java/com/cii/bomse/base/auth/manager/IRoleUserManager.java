package com.cii.bomse.base.auth.manager;

import com.cii.bomse.base.auth.entity.RoleUserEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/14 22:42
 */
public interface IRoleUserManager extends IManager<RoleUserEntity> {

    /**
     * 给一些用户分配一个指定的角色
     * @param roleId
     * @param userIds
     */
    public void allotRoleUser(Long roleId, List<Long> userIds);

    /**
     * 删除某个用户分配的角色
     * @param roleUser
     */
    int deleteRoleUser(RoleUserEntity roleUser);

}
