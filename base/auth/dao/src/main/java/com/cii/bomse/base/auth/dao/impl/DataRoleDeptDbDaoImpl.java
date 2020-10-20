package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IDataRoleDeptDbDao;
import com.cii.bomse.base.auth.entity.DataRoleDeptEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:54
 * @since 1.0
 */
@Repository
public class DataRoleDeptDbDaoImpl extends AbstractMyBatisDao<DataRoleDeptEntity,Long> implements IDataRoleDeptDbDao {

    @Override
    public int deleteByRoleId(Long roleId) {
        return this.getSqlSession().delete(this.mapperNamespace+"deleteByRoleId",roleId);
    }

}

