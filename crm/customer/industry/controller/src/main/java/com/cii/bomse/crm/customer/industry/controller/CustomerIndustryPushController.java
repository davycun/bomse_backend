package com.cii.bomse.crm.customer.industry.controller;

import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryPushControllerRequest;
import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryPushControllerResponse;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryPushEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryPushManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.common.entity.BaseUserEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/customerIndustryPush",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerIndustryPushController extends AbstractRestController {

    @Autowired
    private ICustomerIndustryPushManager customerIndustryPushManager;


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CustomerIndustryPushControllerRequest request) {

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        List<CustomerIndustryPushEntity> pushes = new ArrayList<>();

        for (BaseUserEntity user : request.getEntity().getPushUsers()) {
            CustomerIndustryPushEntity push = new CustomerIndustryPushEntity();
            push.setCusId(request.getEntity().getCusId());
            push.setPushRemark(request.getEntity().getPushRemark());

            push.setPushUserId(CurrentContext.getUserId());
            push.setPushUserName(CurrentContext.getUserName());
            push.setPushDeptId(CurrentContext.getOwnerDeptId());
            push.setPushDeptName(CurrentContext.getOwnerDeptName());

            push.setReceiveUserId(user.getId());
            push.setReceiveUserName(user.getUserName());
            push.setReceiveDeptId(user.getOwnerDeptId());
            push.setReceiveDeptName(user.getOwnerDeptName());

            pushes.add(push);
        }

        customerIndustryPushManager.batchCreate(pushes);

        return this.success(response);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CustomerIndustryPushControllerRequest request) {

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        customerIndustryPushManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/receive",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> receive(@RequestBody CustomerIndustryPushControllerRequest request){

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        customerIndustryPushManager.receive(request.getEntity().getId());

        return this.success(response);
    }
    @RequestMapping(path = "/refuse",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> refuse(@RequestBody CustomerIndustryPushControllerRequest request){

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        customerIndustryPushManager.refuse(request.getEntity().getId(),request.getEntity().getRefuseReason());

        return this.success(response);
    }


    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody CustomerIndustryPushControllerRequest request) {

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
                && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response, "详情查询请求参数ID必填");
        }

        CustomerIndustryPushEntity result = customerIndustryPushManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerIndustryPushControllerRequest request) {

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryPushEntity> result = customerIndustryPushManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/querySimple", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody CustomerIndustryPushControllerRequest request) {

        CustomerIndustryPushControllerResponse response = new CustomerIndustryPushControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryPushEntity> result = customerIndustryPushManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
