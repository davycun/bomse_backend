package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dto.DataRoleControllerRequest;
import com.cii.bomse.base.auth.dto.DataRoleControllerResponse;
import com.cii.bomse.base.auth.manager.IDataRoleManager;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 12:01
 * @since 1.0
 */
@RestController
@RequestMapping(path = "/dataRole",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataRoleController extends AbstractRestController {

    @Autowired
    private IDataRoleManager dataRoleManager;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody DataRoleControllerRequest request) {

        DataRoleControllerResponse response = new DataRoleControllerResponse();

        if (null == request.getEntity()){
            throw new BusinessException("请求实体entity不能为空");
        }
        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(),"roleName");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }
        dataRoleManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody DataRoleControllerRequest request){

        DataRoleControllerResponse response = new DataRoleControllerResponse();

        if (null == request.getEntity()){
            throw new BusinessException("请求实体entity不能为空");
        }

        dataRoleManager.update(request.getEntity());

        return this.success(response);
    }

    /**
     * @description 查询所有角色
     * @auth david·cun
     * @date 2019-04-10 11:29
     * @since 1.0
     */
    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody DataRoleControllerRequest request){
        DataRoleControllerResponse response = new DataRoleControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));
        param.put("isDeleted",Boolean.FALSE);

        response.setResult(dataRoleManager.findByMap(param,"id",true));

        return this.success(response);
    }

}
