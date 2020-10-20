package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dto.RoleMenuControllerRequest;
import com.cii.bomse.base.auth.dto.RoleMenuControllerResponse;
import com.cii.bomse.base.auth.manager.IRoleMenuManager;
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
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 角色分配的菜单（权限）的控制器
 * @auth david·cun
 * @date 2019-04-10 11:30
 * @since 1.0
 */
@RestController
@RequestMapping(path = "/roleMenu",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleMenuController extends AbstractRestController {

    @Autowired
    private IRoleMenuManager roleMenuManager;

    /**
     * @description 为角色分配菜单的时候调用此方法
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:30
     * @since 1.0
     */
    @RequestMapping(path = "/update")
    public ResponseEntity<IServiceResponse> update(@RequestBody RoleMenuControllerRequest request){
        RoleMenuControllerResponse response = new RoleMenuControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request,"roleId","menuIds");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }

        roleMenuManager.updateRoleMenu(request.getRoleId(),request.getMenuIds());

        return this.success(response);
    }
}
