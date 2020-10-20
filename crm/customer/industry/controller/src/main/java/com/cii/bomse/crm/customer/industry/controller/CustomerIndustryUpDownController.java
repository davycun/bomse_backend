package com.cii.bomse.crm.customer.industry.controller;

import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryUpDownControllerRequest;
import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryUpDownControllerResponse;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryUpDownEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryUpDownManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "/customerIndustryUpDown",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerIndustryUpDownController extends AbstractRestController {

    @Autowired
    private ICustomerIndustryUpDownManager customerIndustryUpDownManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CustomerIndustryUpDownControllerRequest request){

        CustomerIndustryUpDownControllerResponse response = new CustomerIndustryUpDownControllerResponse();

        customerIndustryUpDownManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CustomerIndustryUpDownControllerRequest request){

        CustomerIndustryUpDownControllerResponse response = new CustomerIndustryUpDownControllerResponse();

        customerIndustryUpDownManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody CustomerIndustryUpDownControllerRequest request){

        CustomerIndustryUpDownControllerResponse response = new CustomerIndustryUpDownControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        CustomerIndustryUpDownEntity result = customerIndustryUpDownManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerIndustryUpDownControllerRequest request){

        CustomerIndustryUpDownControllerResponse response = new CustomerIndustryUpDownControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryUpDownEntity> result = customerIndustryUpDownManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody CustomerIndustryUpDownControllerRequest request){

        CustomerIndustryUpDownControllerResponse response = new CustomerIndustryUpDownControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryUpDownEntity> result = customerIndustryUpDownManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
