package com.cii.bomse.base.auth.manager.impl;

import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import com.cii.bomse.base.auth.dao.IMenuDbDao;
import com.cii.bomse.base.auth.entity.MenuEntity;
import com.cii.bomse.base.auth.manager.IMenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description 菜单管理业务类
 * @auth david·cun
 * @date 2019-04-10 11:36
 * @since 1.0
 */
@Service
public class MenuManagerImpl extends AbstractManager<MenuEntity> implements IMenuManager {

    @Autowired
    private IMenuDbDao menuDbDao;

    @Override
    protected IMyBatisBaseDao<MenuEntity, Long> getMyBatisDao() {
        return this.menuDbDao;
    }

    @Override
    protected void beforeBatchCreate(List<MenuEntity> list) {

        Map<String,Object> param = new HashMap<>();

        for (MenuEntity menu : list) {

            ValidationResult vr = ValidationUtils.validateInclude(menu,"menuName","menuType","itemId");

            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }
            if (ObjectUtils.isEmpty(menu.getParentId())) {
                menu.setParentId(0L);
            }

            param.put("itemId",menu.getItemId());

            int count = menuDbDao.countByMap(param);

            if (count > 0){
                throw new BusinessException("已经存在相同名字的itemId，请重新输入");
            }

        }
    }

    @Override
    protected void beforeBatchUpdate(List<MenuEntity> t) {
        for (MenuEntity menu : t) {
            if (ObjectUtils.isEmpty(menu.getId())){
                throw new BusinessException("更新菜单ID不能为空");
            }
        }
    }

    /**
     * @description 菜单，通过树形接口返回
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:34
     * @since 1.0
     */
    public List<MenuEntity> findByMapToTree(Map<String,Object> param) {

        List<MenuEntity> menus = menuDbDao.selectByMap(param,"sort",true);

        return treeAndSort(menus);
    }

    /**
     * @description 通过角色编码查找菜单，并且返回树形结构
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:35
     * @since 1.0
     */
    @Override
    public List<MenuEntity> findByRoleToTree(Long roleId) {

        return treeAndSort(findByRoleNoTree(roleId));
    }

    /**
     * @description 通过角色编码查找菜单，并且返回非树形结构
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:35
     * @since 1.0
     */
    @Override
    public List<MenuEntity> findByRoleNoTree(Long roleId) {

        Map<String,Object> param = new HashMap<>();

        param.put("roleId", roleId);
        List<MenuEntity> menus = menuDbDao.selectByStatement("selectMenuByRole",param);

        return menus;
    }

    @Override
    public List<MenuEntity> findByUserToTree(Long userId) {
        return treeAndSort(findByUserNoTree(userId));
    }

    @Override
    public List<MenuEntity> findByUserNoTree(Long userId) {
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        List<MenuEntity> menus = menuDbDao.selectByStatement("selectMenuByUser",param);
        return menus;
    }

    @Override
    public List<MenuEntity> findByUserMenuTypeNoTree(Long userId, String menuType) {
        Map<String,Object> param = new HashMap<>();

        param.put("userId", userId);
        param.put("menuType",menuType);
        List<MenuEntity> menus = menuDbDao.selectByStatement("selectMenuByUser",param);

        return menus;
    }

    /**
     * @description 组织成树形结构，并且排序，排序根据菜单排序字段，从小到大排序
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:36
     * @since 1.0
     */
    public List<MenuEntity> treeAndSort(List<MenuEntity> menus) {
        List<MenuEntity> result = new ArrayList<>();

        Map<Long, MenuEntity> tmp = new HashMap<>();
        List<Long> removeCode = new ArrayList<>();

        for (MenuEntity menu : menus) {
            tmp.put(menu.getId(), menu);
        }

        //把每个节点关联上
        for (MenuEntity menu : menus) {
            MenuEntity parentMenu = tmp.get(menu.getParentId());
            if (ObjectUtils.isNotEmpty(parentMenu)) {
                List<MenuEntity> children = parentMenu.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parentMenu.setChildren(children);
                }
                children.add(menu);
                removeCode.add(menu.getId());
            }
        }

        //把已经关联上的节点从顶层移除
        for (Long code : removeCode) {
            tmp.remove(code);
        }

        for (Map.Entry<Long, MenuEntity> entry : tmp.entrySet()) {
            result.add(entry.getValue());
        }

        sort(result);

        return result;
    }

    public void sort(List<MenuEntity> menus) {
        for (MenuEntity menu : menus) {
            if (ObjectUtils.isNotEmpty(menu.getChildren())) {
                sort(menu.getChildren());
            }
        }
        Collections.sort(menus);
    }
}
