package com.cii.bomse.crm.customer.industry.controller;

import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryControllerRequest;
import com.cii.bomse.crm.customer.industry.dto.CustomerIndustryControllerResponse;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(path = "/customerIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerIndustryController extends AbstractRestController {

    @Autowired
    private ICustomerIndustryManager customerIndustryManager;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        customerIndustryManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        customerIndustryManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
                || ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response, "详情查询请求参数ID必填");
        }

        CustomerIndustryEntity result = customerIndustryManager.findById(request.getEntity().getId());

        result.setCusPhone(null);

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        //查询待联系的客户
        if (param.containsKey("waitContact") && !param.containsKey("cusStatus")){
            param.put("cusStatus", CustomerStatus.Followup);
            param.put("nextContactTimeEnd",Calendar.getInstance().getTime());
        }
        //查询待上架的客户，两个月内到期，但是5天内却没有跟进过的客户
        if (param.containsKey("waitUp")){
            Date now = Calendar.getInstance().getTime();
            param.put("cusStatus",CustomerStatus.HasDown);
            param.put("nextContactTimeStart", DateUtils.addMonths(now,-2));
            param.put("lastFollowupTimeEnd",DateUtils.addDays(now,-5));
        }

        PageResult<CustomerIndustryEntity> result = customerIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByToSqlFieldOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        if (ObjectUtils.isNotEmpty(result.getData())) {
            for (CustomerIndustryEntity cus : result.getData()) {
                cus.setCusPhone(null);
            }
        }

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/querySimple", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<CustomerIndustryEntity> result = customerIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/hide", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> hide(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(), "id");
        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }

        customerIndustryManager.hide(request.getEntity().getId());

        return this.success(response);
    }

    @RequestMapping(path = "/open", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> open(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(), "id");
        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }

        customerIndustryManager.open(request.getEntity().getId());

        return this.success(response);
    }

    @RequestMapping(path = "/checkExist", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> checkExist(@RequestBody CustomerIndustryControllerRequest request) {
        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        customerIndustryManager.validateCreateCustomer(request.getEntity().getCusPhone());

        return this.success(response);
    }

    @RequestMapping(path = "/callPhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> callPhone(@RequestBody CustomerIndustryControllerRequest request) {
        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        String cusPhone = customerIndustryManager.callPhone(request.getEntity().getId());

        response.setResult(cusPhone);

        return this.success(response);
    }

    @RequestMapping(path = "/updatePhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> updatePhone(@RequestBody CustomerIndustryControllerRequest request) {

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        customerIndustryManager.updateCustomerPhone(request.getEntity().getId(),
                request.getEntity().getOldCusPhone(), request.getEntity().getNewCusPhone());

        return this.success(response);
    }

    /**
     * @description
     * 客户代办统计
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-19 10:39
     * @since 1.0
     */
    @RequestMapping(path = "/statistic",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> statistic(@RequestBody CustomerIndustryControllerRequest request){

        CustomerIndustryControllerResponse response = new CustomerIndustryControllerResponse();

        response.setResult(customerIndustryManager.waitWorkStatistic());

        return this.success(response);
    }

}
