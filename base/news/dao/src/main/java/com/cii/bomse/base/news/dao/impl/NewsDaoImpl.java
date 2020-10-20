package com.cii.bomse.base.news.dao.impl;

import com.cii.bomse.base.news.dao.INewsDao;
import com.cii.bomse.base.news.entity.NewsEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends AbstractMyBatisDao<NewsEntity,Long> implements INewsDao {
}
