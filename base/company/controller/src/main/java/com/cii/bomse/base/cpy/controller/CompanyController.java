package com.cii.bomse.base.cpy.controller;

import com.cii.bomse.base.cpy.entity.CompanyEntity;
import com.cii.bomse.base.cpy.manager.ICompanyManager;
import com.cii.bomse.base.cpy.dto.CompanyControllerRequest;
import com.cii.bomse.base.cpy.dto.CompanyControllerResponse;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.PageResult;
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

@RestController
@RequestMapping(path = "/cpy",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyController extends AbstractRestController {

    @Autowired
    private ICompanyManager companyManager;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CompanyControllerRequest request){

        CompanyControllerResponse response = new CompanyControllerResponse();

        companyManager.create(request.getEntity());

        response.setResult(request.getEntity());
        return this.success(response);
    }


    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CompanyControllerRequest request){
        CompanyControllerResponse response = new CompanyControllerResponse();
        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(),"id","cpyName");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }
        companyManager.update(request.getEntity());
        response.setResult(request.getEntity());
        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CompanyControllerRequest request){
        CompanyControllerResponse response = new CompanyControllerResponse();
        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));
        PageResult<CompanyEntity> result =companyManager.findByMap(param,request.getStartOrDefault(0),request.getPageSizeOrDefault(30));
        response.setResult(result);
        return this.success(response);
    }

    @RequestMapping(path = "/myCompany",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> myCompany(@RequestBody CompanyControllerRequest request){
        CompanyControllerResponse response = new CompanyControllerResponse();

        CompanyEntity result =companyManager.findById(CurrentContext.getCpyId());
        response.setResult(result);

        return this.success(response);
    }



}
