package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IDataRoleDbDao;
import com.cii.bomse.base.auth.entity.DataRoleEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:53
 * @since 1.0
 */
@Repository
public class DataRoleDbDaoImpl extends AbstractMyBatisDao<DataRoleEntity,Long> implements IDataRoleDbDao {
}
