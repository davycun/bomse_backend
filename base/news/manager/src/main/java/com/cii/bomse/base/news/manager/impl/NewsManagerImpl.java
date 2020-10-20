package com.cii.bomse.base.news.manager.impl;

import com.cii.bomse.base.news.dao.INewsDao;
import com.cii.bomse.base.news.entity.NewsEntity;
import com.cii.bomse.base.news.manager.INewsManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.utils.CodeGenUtils;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsManagerImpl extends AbstractManager<NewsEntity> implements INewsManager {

    @Autowired
    private INewsDao newsDao;

    @Override
    protected IMyBatisBaseDao<NewsEntity, Long> getMyBatisDao() {
        return this.newsDao;
    }

    @Override
    protected void beforeBatchCreate(List<NewsEntity> list) {
        for (NewsEntity news : list) {

            ValidationResult vr = ValidationUtils.validateInclude(news);

            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
        }
    }
}
