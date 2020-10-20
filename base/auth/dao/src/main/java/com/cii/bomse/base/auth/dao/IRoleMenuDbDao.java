package com.cii.bomse.base.auth.dao;

import com.cii.bomse.base.auth.entity.RoleMenuEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:22
 */
public interface IRoleMenuDbDao extends IMyBatisBaseDao<RoleMenuEntity,Long> {

    /**
     * 物理删除角色关联的所有菜单
     * @param roleId
     * @return
     */
    public int deleteByRoleId(Long roleId);

}
