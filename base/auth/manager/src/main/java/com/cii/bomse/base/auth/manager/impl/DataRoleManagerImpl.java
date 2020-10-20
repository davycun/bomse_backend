package com.cii.bomse.base.auth.manager.impl;

import com.cii.bomse.base.auth.dao.IDataRoleDbDao;
import com.cii.bomse.base.auth.entity.DataRoleEntity;
import com.cii.bomse.base.auth.manager.IDataRoleManager;
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
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:58
 * @since 1.0
 */
@Service
public class DataRoleManagerImpl extends AbstractManager<DataRoleEntity> implements IDataRoleManager {

    @Autowired
    private IDataRoleDbDao dataRoleDbDao;

    @Override
    protected IMyBatisBaseDao<DataRoleEntity, Long> getMyBatisDao() {
        return dataRoleDbDao;
    }

    @Override
    protected void beforeBatchCreate(List<DataRoleEntity> list) {

        for (DataRoleEntity role :list) {
            ValidationResult vr = ValidationUtils.validateInclude(role,"roleName");
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }
        }
    }

    @Override
    protected void beforeBatchUpdate(List<DataRoleEntity> t) {
        for (DataRoleEntity role : t) {

            if (ObjectUtils.isEmpty(role.getId())){
                throw new BusinessException("更新角色，ID不能为空");
            }
        }
    }
}
