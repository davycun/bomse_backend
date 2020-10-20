package com.cii.bomse.crm.customer.base.controller;

import com.cii.bomse.crm.customer.base.dto.CustomerAreaControllerRequest;
import com.cii.bomse.crm.customer.base.dto.CustomerAreaControllerResponse;
import com.cii.bomse.crm.customer.base.entity.CustomerAreaEntity;
import com.cii.bomse.crm.customer.base.manager.ICustomerAreaManager;
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
@RequestMapping(path = "/customerArea",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerAreaController extends AbstractRestController {

    @Autowired
    private ICustomerAreaManager customerAreaManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        customerAreaManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        customerAreaManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        CustomerAreaEntity result = customerAreaManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerAreaEntity> result = customerAreaManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerAreaEntity> result = customerAreaManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<IServiceResponse> delete(@RequestBody CustomerAreaControllerRequest request){

        CustomerAreaControllerResponse response = new CustomerAreaControllerResponse();

        customerAreaManager.deleteById(request.getEntity().getId());

        return this.success(response);
    }
}
