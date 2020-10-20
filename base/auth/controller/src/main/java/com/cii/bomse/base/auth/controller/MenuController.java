package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dictionary.MenuType;
import com.cii.bomse.base.auth.dto.MenuControllerRequest;
import com.cii.bomse.base.auth.dto.MenuControllerResponse;
import com.cii.bomse.base.auth.entity.MenuEntity;
import com.cii.bomse.base.auth.manager.IMenuManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.configure.CiiProperty;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:42
 */
@RestController
@RequestMapping(path = "/menu",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MenuController extends AbstractRestController {

    @Autowired
    private IMenuManager menuManager;
    @Autowired
    private CiiProperty ciiProperty;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody MenuControllerRequest request) {

        MenuControllerResponse response = new MenuControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(),"menuName","menuType");

        if (vr.getSuccess()){

            menuManager.create(request.getEntity());

        }else{
            return this.error(response,vr.getMessage());
        }
        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody MenuControllerRequest request){
        MenuControllerResponse response = new MenuControllerResponse();

        menuManager.update(request.getEntity());

        return this.success(response);
    }

    /**
     * @description 查询所有菜单，此接口只有超级管理员才能用
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:32
     * @since 1.0
     */
    @RequestMapping(path = "/queryAll", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody MenuControllerRequest request) {

        MenuControllerResponse response = new MenuControllerResponse();

        Map<String,Object> param = new HashMap<>();

        response.setResult(menuManager.findByMapToTree(param));

        return this.success(response);
    }


    /**
     * @description 查询当前用户应该具有的菜单，展示系统左侧菜单数据
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:32
     * @since 1.0
     */
    @RequestMapping(path = "/queryMyMenu")
    public ResponseEntity<IServiceResponse> queryRoleAndMyMenu(@RequestBody MenuControllerRequest request){

        MenuControllerResponse response = new MenuControllerResponse();

        List<MenuEntity> menus = menuManager.treeAndSort(
                menuManager.findByUserMenuTypeNoTree(
                        CurrentContext.getUserId(), MenuType.Menu));

        response.setResult(menus);

        return this.success(response);
    }

    /**
     * @description 查询我的功能权限，控制某个按钮功能对当前用户是否在前端可见
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:32
     * @since 1.0
     */
    @RequestMapping(path = "/queryMyFunction")
    public ResponseEntity<IServiceResponse> queryMyAuthFunction(@RequestBody MenuControllerRequest request){

        MenuControllerResponse response = new MenuControllerResponse();

        List<MenuEntity> menus =
                menuManager.findByUserMenuTypeNoTree(CurrentContext.getUserId(), MenuType.Function);

        response.setResult(menus);

        return this.success(response);
    }

    /**
     * @description 查询我可以分配的菜单权限，角色管理中，给角色分配菜单功能
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:32
     * @since 1.0
     */
    @RequestMapping(path = "/queryMyAllotMenu")
    public ResponseEntity<IServiceResponse> queryMyAllotMenu(@RequestBody MenuControllerRequest request){

        MenuControllerResponse response = new MenuControllerResponse();

        List<MenuEntity> menus = null;

        if (ciiProperty.getPlatformCpyId().equals(CurrentContext.getCpyId())){
            menus = menuManager.findByMapToTree(new HashMap<>());
        }else{
            menus = menuManager.treeAndSort(
                    menuManager.findByUserNoTree(CurrentContext.getUserId()));
        }

        response.setResult(menus);

        return this.success(response);
    }

    /**
     * @description 查询顶层菜单，为的是实现前端菜单树只能展开一个
     * @author david·cun
     * @param
     * @return
     * @date 2019-04-24 14:26
     * @since 1.0
     */
    @RequestMapping(path = "/queryFirstLevelMenu")
    public ResponseEntity<IServiceResponse> queryFirstLevelMenu(@RequestBody MenuControllerRequest request){

        MenuControllerResponse response = new MenuControllerResponse();

        Map<String,Object> param = new HashMap<>();
        param.put("isDeleted",Boolean.FALSE);

        List<MenuEntity> menu = menuManager.findByMapToTree(param);

        List<String> itemId = new ArrayList<>();
        for (MenuEntity mn : menu){
            itemId.add(mn.getItemId());
        }

        response.setResult(itemId);

        return this.success(response);
    }

    /**
     * 通过角色编码查询菜单
     * @param request
     * @return
     */
    @RequestMapping(path = "/queryRoleMenuCode")
    public ResponseEntity<IServiceResponse> queryRoleMenuCode(@RequestBody MenuControllerRequest request){

        MenuControllerResponse response = new MenuControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(),"roleId");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }

        List<MenuEntity> menus = menuManager.findByRoleNoTree(request.getEntity().getRoleId());

        List<Long> menuCodes = new ArrayList<>();

        for (MenuEntity menu: menus) {
            menuCodes.add(menu.getId());
        }

        response.setResult(menuCodes);

        return this.success(response);
    }
}
