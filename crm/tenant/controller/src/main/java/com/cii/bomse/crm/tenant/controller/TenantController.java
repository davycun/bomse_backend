package com.cii.bomse.crm.tenant.controller;

import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.tenant.dto.TenantControllerRequest;
import com.cii.bomse.crm.tenant.dto.TenantControllerResponse;
import com.cii.bomse.crm.tenant.manager.ITenantManager;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.ciiframework.data.PageResult;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Map;


@RestController
@RequestMapping(path = "/tenant",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TenantController extends AbstractRestController {

    @Autowired
    private ITenantManager tenantManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody TenantControllerRequest request){

        TenantControllerResponse response = new TenantControllerResponse();

        tenantManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody TenantControllerRequest request){

        TenantControllerResponse response = new TenantControllerResponse();

        tenantManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody TenantControllerRequest request) {

        TenantControllerResponse response = new TenantControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
                && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response, "详情查询请求参数ID必填");
        }

        TenantEntity result = tenantManager.findById(request.getEntity().getId());

        result.setTntPhone(null);

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody TenantControllerRequest request) {

        TenantControllerResponse response = new TenantControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        //查询待联系的客户
        if (param.containsKey("waitContact")){
            param.put("nextContactTimeEnd", Calendar.getInstance().getTime());
        }

        PageResult<TenantEntity> result = tenantManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        if (ObjectUtils.isNotEmpty(result.getData())){
            result.getData().forEach((tnt)->tnt.setTntPhone(null));
        }

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/querySimple", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody TenantControllerRequest request) {

        TenantControllerResponse response = new TenantControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<TenantEntity> result = tenantManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        if (ObjectUtils.isNotEmpty(result.getData())){
            result.getData().forEach((tnt)->tnt.setTntPhone(null));
        }

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/callPhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> callPhone(@RequestBody TenantControllerRequest request) {

        TenantControllerResponse response = new TenantControllerResponse();

        response.setResult(tenantManager.callPhone(request.getEntity().getId()));

        return this.success(response);
    }

    @RequestMapping(path = "/updatePhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> updatePhone(@RequestBody TenantControllerRequest request) {

        TenantControllerResponse response = new TenantControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(), "id", "oldPhone", "newPhone");

        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }

        tenantManager.updatePhone(request.getEntity().getId(),
                request.getEntity().getOldPhone(),
                request.getEntity().getNewPhone());

        return this.success(response);
    }

    @RequestMapping(path = "/statistic",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> statistic(@RequestBody TenantControllerRequest request){

        TenantControllerResponse response = new TenantControllerResponse();

        response.setResult(tenantManager.statistic());

        return this.success(response);

    }
}
