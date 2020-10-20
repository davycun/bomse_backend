package com.cii.bomse.base.auth.manager;

import com.cii.bomse.base.auth.entity.MenuEntity;
import com.ciiframework.common.business.IManager;

import java.util.*;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:26
 */
public interface IMenuManager extends IManager<MenuEntity> {

    public List<MenuEntity> findByMapToTree(Map<String, Object> param);

    public List<MenuEntity> findByRoleToTree(Long roleId);

    public List<MenuEntity> findByRoleNoTree(Long roleId);

    public List<MenuEntity> findByUserToTree(Long userId);

    /**
     * @description 查询所有当前用户分配角色的菜单，包括功能类型
     * @author david·cun
     * @param
     * @return
     * @date 2019-04-17 09:05
     * @since 1.0
     */
    public List<MenuEntity> findByUserNoTree(Long userId);

    /**
     * @description 根据用户编码及菜单类型查询菜单权限
     * @author david·cun
     * @param
     * @return
     * @date 2019-04-17 09:05
     * @since 1.0
     */
    public List<MenuEntity> findByUserMenuTypeNoTree(Long userId, String menuType);

    /**
     * 把菜单通过树整理，并且排序
     *
     * @param menus
     * @return
     */
    public List<MenuEntity> treeAndSort(List<MenuEntity> menus);

    /**
     * 通过menuEntity的sort字段排序
     *
     * @param menus
     */
    public void sort(List<MenuEntity> menus);
}
