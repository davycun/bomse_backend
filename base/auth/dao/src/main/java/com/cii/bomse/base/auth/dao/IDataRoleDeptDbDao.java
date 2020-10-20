package com.cii.bomse.base.auth.dao;

import com.cii.bomse.base.auth.entity.DataRoleDeptEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:50
 * @since 1.0
 */
public interface IDataRoleDeptDbDao extends IMyBatisBaseDao<DataRoleDeptEntity,Long> {

    /**
     * 物理删除角色关联的所有部门
     * @param roleId
     * @return
     */
    public int deleteByRoleId(Long roleId);
}
