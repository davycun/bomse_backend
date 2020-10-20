package com.cii.bomse.base.auth.manager.impl;

import com.cii.bomse.base.auth.dao.IRoleDbDao;
import com.cii.bomse.base.auth.entity.RoleEntity;
import com.cii.bomse.base.auth.manager.IRoleManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 角色管理
 * @auth david·cun
 * @date 2019-04-10 11:37
 * @since 1.0
 */
@Service
public class RoleManagerImpl extends AbstractManager<RoleEntity> implements IRoleManager {

    @Autowired
    private IRoleDbDao roleDbDao;

    @Override
    protected IMyBatisBaseDao<RoleEntity, Long> getMyBatisDao() {
        return this.roleDbDao;
    }

    @Override
    protected void beforeBatchCreate(List<RoleEntity> list) {


        for (RoleEntity role :list) {

            ValidationResult vr = ValidationUtils.validateInclude(role,"roleName");
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }
        }
    }

    @Override
    protected void beforeBatchUpdate(List<RoleEntity> t) {
        for (RoleEntity role : t) {

            if (ObjectUtils.isEmpty(role.getId())){
                throw new BusinessException("更新角色，ID不能为空");
            }
        }
    }
}
