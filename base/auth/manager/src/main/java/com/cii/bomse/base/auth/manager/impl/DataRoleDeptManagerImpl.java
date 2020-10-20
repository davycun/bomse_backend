package com.cii.bomse.base.auth.manager.impl;

import com.cii.bomse.base.auth.dao.IDataRoleDeptDbDao;
import com.cii.bomse.base.auth.entity.DataRoleDeptEntity;
import com.cii.bomse.base.auth.manager.IDataRoleDeptManager;
import com.cii.bomse.common.observer.IDataAuthSubject;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:59
 * @since 1.0
 */
@Service
public class DataRoleDeptManagerImpl extends AbstractManager<DataRoleDeptEntity> implements IDataRoleDeptManager {

    @Autowired
    private IDataRoleDeptDbDao dataRoleDeptDbDao;

    @Override
    protected IMyBatisBaseDao<DataRoleDeptEntity, Long> getMyBatisDao() {
        return dataRoleDeptDbDao;
    }

    @Autowired
    private IDataAuthSubject dataAuthSubject;


    @Transactional
    @Override
    public void updateDataRoleDept(Long roleId, List<Long> deptIds) {

        if (ObjectUtils.isEmpty(roleId) || ObjectUtils.isEmpty(deptIds)) {
            throw new BusinessException("为角色分配菜单的时候，角色ID和菜单ID不能为空");
        }

        List<DataRoleDeptEntity> roleMenus = new ArrayList<>();

        for (Long deptId : deptIds) {
            DataRoleDeptEntity rme = new DataRoleDeptEntity();
            rme.setDeptId(deptId);
            rme.setRoleId(roleId);
            roleMenus.add(rme);
        }

        dataRoleDeptDbDao.deleteByRoleId(roleId);

        this.batchCreate(roleMenus);

        //权限变更，通知
        dataAuthSubject.notifyAllObserver();
    }
}
