package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IRoleUserDbDao;
import com.cii.bomse.base.auth.entity.RoleUserEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:25
 */
@Repository
public class RoleUserDbDaoImpl extends AbstractMyBatisDao<RoleUserEntity,Long> implements IRoleUserDbDao {
}
