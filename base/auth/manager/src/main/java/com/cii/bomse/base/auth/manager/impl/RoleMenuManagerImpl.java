package com.cii.bomse.base.auth.manager.impl;

import com.cii.bomse.common.observer.IMenuAuthSubject;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.base.auth.dao.IRoleMenuDbDao;
import com.cii.bomse.base.auth.entity.RoleMenuEntity;
import com.cii.bomse.base.auth.manager.IRoleMenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 角色菜单管理
 * @auth david·cun
 * @date 2019-04-10 11:37
 * @since 1.0
 */
@Service
public class RoleMenuManagerImpl extends AbstractManager<RoleMenuEntity> implements IRoleMenuManager {

    @Autowired
    private IRoleMenuDbDao roleMenuDbDao;

    @Autowired
    private IMenuAuthSubject menuAuthSubject;

    @Override
    protected IMyBatisBaseDao<RoleMenuEntity, Long> getMyBatisDao() {
        return this.roleMenuDbDao;
    }

    @Transactional
    @Override
    public void updateRoleMenu(Long roleId, List<Long> menuIds) {

        if (ObjectUtils.isEmpty(roleId) || ObjectUtils.isEmpty(menuIds)) {
            throw new BusinessException("为角色分配菜单的时候，角色编码和菜单编码不能为空");
        }

        List<RoleMenuEntity> roleMenus = new ArrayList<>();

        for (Long menuId : menuIds) {
            RoleMenuEntity rme = new RoleMenuEntity();
            rme.setMenuId(menuId);
            rme.setRoleId(roleId);
            roleMenus.add(rme);
        }

        roleMenuDbDao.deleteByRoleId(roleId);

        this.batchCreate(roleMenus);

        menuAuthSubject.notifyAllObserver();
    }
}
