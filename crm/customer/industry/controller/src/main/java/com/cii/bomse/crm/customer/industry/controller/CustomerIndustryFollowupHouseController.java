package com.cii.bomse.crm.customer.industry.controller;

import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryFollowupHouseControllerRequest;
import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryFollowupHouseControllerResponse;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryFollowupHouseManager;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupHouseEntity;
import com.ciiframework.data.PageResult;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
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
@RequestMapping(path = "/customerIndustryFollowupHouse",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerIndustryFollowupHouseController extends AbstractRestController {

    @Autowired
    private ICustomerIndustryFollowupHouseManager customerIndustryFollowupHouseManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CustomerIndustryFollowupHouseControllerRequest request){

        CustomerIndustryFollowupHouseControllerResponse response = new CustomerIndustryFollowupHouseControllerResponse();

        customerIndustryFollowupHouseManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CustomerIndustryFollowupHouseControllerRequest request){

        CustomerIndustryFollowupHouseControllerResponse response = new CustomerIndustryFollowupHouseControllerResponse();

        customerIndustryFollowupHouseManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody CustomerIndustryFollowupHouseControllerRequest request){

        CustomerIndustryFollowupHouseControllerResponse response = new CustomerIndustryFollowupHouseControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        CustomerIndustryFollowupHouseEntity result = customerIndustryFollowupHouseManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerIndustryFollowupHouseControllerRequest request){

        CustomerIndustryFollowupHouseControllerResponse response = new CustomerIndustryFollowupHouseControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryFollowupHouseEntity> result = customerIndustryFollowupHouseManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody CustomerIndustryFollowupHouseControllerRequest request){

        CustomerIndustryFollowupHouseControllerResponse response = new CustomerIndustryFollowupHouseControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryFollowupHouseEntity> result = customerIndustryFollowupHouseManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
