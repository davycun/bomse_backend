package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dto.RoleControllerRequest;
import com.cii.bomse.base.auth.dto.RoleControllerResponse;
import com.cii.bomse.base.auth.manager.IRoleManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 角色管理控制器
 * @auth david·cun
 * @date 2019-04-10 11:28
 * @since 1.0
 */
@RestController
@RequestMapping(path = "/role",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController extends AbstractRestController {

    @Autowired
    private IRoleManager roleManager;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody RoleControllerRequest request) {

        RoleControllerResponse response = new RoleControllerResponse();

        roleManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody RoleControllerRequest request){

        RoleControllerResponse response = new RoleControllerResponse();

        if (null == request.getEntity()){
            throw new BusinessException("请求实体entity不能为空");
        }

        roleManager.update(request.getEntity());

        return this.success(response);
    }

    /**
     * @description 查询所有角色
     * @auth david·cun
     * @date 2019-04-10 11:29
     * @since 1.0
     */
    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody RoleControllerRequest request){
        RoleControllerResponse response = new RoleControllerResponse();

        Map<String,Object> param = new HashMap<>();
        param.put("isDeleted",Boolean.FALSE);

        response.setResult(roleManager.findByMap(param,"id",true));

        return this.success(response);
    }
}
