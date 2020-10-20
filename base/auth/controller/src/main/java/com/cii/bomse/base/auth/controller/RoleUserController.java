package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dto.RoleUserControllerRequest;
import com.cii.bomse.base.auth.dto.RoleUserControllerResponse;
import com.cii.bomse.base.auth.manager.IRoleUserManager;
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

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/14 22:38
 */
@RestController
@RequestMapping(path = "/roleUser",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleUserController extends AbstractRestController {

    @Autowired
    private IRoleUserManager roleUserManager;

    /**
     * @description 给某个角色分配给多个用户
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:30
     * @since 1.0
     */
    @RequestMapping(path = "/allot", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> allot(@RequestBody RoleUserControllerRequest request) {
        RoleUserControllerResponse response = new RoleUserControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request, "roleId", "userIds");
        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }

        roleUserManager.allotRoleUser(request.getRoleId(), request.getUserIds());
        return this.success(response);
    }

    /**
     * @description 删除用户角色
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:31
     * @since 1.0
     */
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> delete(@RequestBody RoleUserControllerRequest request) {

        RoleUserControllerResponse response = new RoleUserControllerResponse();

        int i = roleUserManager.deleteRoleUser(request.getEntity());

        if(i > 0){
            return this.success(response);
        } else{
            return this.error(response,"删除失败!");
        }
    }

}
