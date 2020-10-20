package com.cii.bomse.hrm.emp.manager.impl;

import com.cii.bomse.hrm.emp.dao.IPostDbDao;
import com.cii.bomse.hrm.emp.entity.PostEntity;
import com.cii.bomse.hrm.emp.manager.IPostManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/21 15:53
 */
@Service
public class PostManagerImpl extends AbstractManager<PostEntity> implements IPostManager {

    @Autowired
    private IPostDbDao postDbDao;

    @Override
    protected IMyBatisBaseDao<PostEntity, Long> getMyBatisDao() {
        return this.postDbDao;
    }


    @Override
    protected void beforeBatchCreate(List<PostEntity> list) {
        for (PostEntity post : list){

            ValidationResult vr = ValidationUtils.validateInclude(post, "postName");
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }

        }
    }
}
