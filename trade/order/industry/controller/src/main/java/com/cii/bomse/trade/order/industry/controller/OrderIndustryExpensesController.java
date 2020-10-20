package com.cii.bomse.trade.order.industry.controller;

import com.cii.bomse.trade.order.industry.dto.OrderIndustryExpensesControllerRequest;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryExpensesControllerResponse;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryExpensesManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryExpensesEntity;
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
@RequestMapping(path = "/orderIndustryExpenses",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderIndustryExpensesController extends AbstractRestController {

    @Autowired
    private IOrderIndustryExpensesManager orderIndustryExpensesManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody OrderIndustryExpensesControllerRequest request){

        OrderIndustryExpensesControllerResponse response = new OrderIndustryExpensesControllerResponse();

        orderIndustryExpensesManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody OrderIndustryExpensesControllerRequest request){

        OrderIndustryExpensesControllerResponse response = new OrderIndustryExpensesControllerResponse();

        orderIndustryExpensesManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody OrderIndustryExpensesControllerRequest request){

        OrderIndustryExpensesControllerResponse response = new OrderIndustryExpensesControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        OrderIndustryExpensesEntity result = orderIndustryExpensesManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody OrderIndustryExpensesControllerRequest request){

        OrderIndustryExpensesControllerResponse response = new OrderIndustryExpensesControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryExpensesEntity> result = orderIndustryExpensesManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody OrderIndustryExpensesControllerRequest request){

        OrderIndustryExpensesControllerResponse response = new OrderIndustryExpensesControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryExpensesEntity> result = orderIndustryExpensesManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
