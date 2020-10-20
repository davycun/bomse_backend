package com.cii.bomse.base.auth.controller;

import com.cii.bomse.base.auth.dto.DataRoleDeptControllerRequest;
import com.cii.bomse.base.auth.dto.DataRoleDeptControllerResponse;
import com.cii.bomse.base.auth.manager.IDataRoleDeptManager;
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
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:50
 * @since 1.0
 */
@RestController
@RequestMapping(path = "/dataRoleDept",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataRoleDeptController extends AbstractRestController {

    @Autowired
    private IDataRoleDeptManager dataRoleDeptManager;

    /**
     * @description 为数据角色分配部门的时候调用此方法
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:30
     * @since 1.0
     */
    @RequestMapping(path = "/update")
    public ResponseEntity<IServiceResponse> update(@RequestBody DataRoleDeptControllerRequest request){

        DataRoleDeptControllerResponse response = new DataRoleDeptControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request,"roleId","deptIds");

        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }

        dataRoleDeptManager.updateDataRoleDept(request.getRoleId(),request.getDeptIds());

        return this.success(response);
    }

}
