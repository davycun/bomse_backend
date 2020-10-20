package com.cii.bomse.base.auth.dao.impl;

import com.cii.bomse.base.auth.dao.IMenuDbDao;
import com.cii.bomse.base.auth.entity.MenuEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:19
 */
@Repository
public class MenuDbDaoImpl extends AbstractMyBatisDao<MenuEntity,Long> implements IMenuDbDao {
}
