package com.cii.bomse.hrm.emp.dao.impl;

import com.cii.bomse.hrm.emp.dao.IPostDbDao;
import com.cii.bomse.hrm.emp.entity.PostEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/21 15:50
 */
@Repository
public class PostDbDaoImpl extends AbstractMyBatisDao<PostEntity,Long> implements IPostDbDao {



}
