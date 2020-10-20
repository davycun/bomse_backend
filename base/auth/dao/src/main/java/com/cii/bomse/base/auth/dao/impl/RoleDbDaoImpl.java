package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IRoleDbDao;
import com.cii.bomse.base.auth.entity.RoleEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:21
 */
@Repository
public class RoleDbDaoImpl extends AbstractMyBatisDao<RoleEntity,Long> implements IRoleDbDao {
}
