package com.cii.bomse.base.auth.manager;

import com.cii.bomse.base.auth.entity.DataRoleUserEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:57
 * @since 1.0
 */
public interface IDataRoleUserManager extends IManager<DataRoleUserEntity> {

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
    int deleteRoleUser(DataRoleUserEntity roleUser);

}
