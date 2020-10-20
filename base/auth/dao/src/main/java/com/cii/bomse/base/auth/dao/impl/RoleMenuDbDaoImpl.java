package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IRoleMenuDbDao;
import com.cii.bomse.base.auth.entity.RoleMenuEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:22
 */
@Repository
public class RoleMenuDbDaoImpl extends AbstractMyBatisDao<RoleMenuEntity,Long> implements IRoleMenuDbDao {
    @Override
    public int deleteByRoleId(Long roleId) {
        return this.getSqlSession().delete(this.mapperNamespace+"deleteByRoleId",roleId);
    }
}
