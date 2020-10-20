package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IDataRoleUserDbDao;
import com.cii.bomse.base.auth.entity.DataRoleUserEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:54
 * @since 1.0
 */
@Repository
public class DataRoleUserDbDaoImpl extends AbstractMyBatisDao<DataRoleUserEntity,Long> implements IDataRoleUserDbDao {
}
