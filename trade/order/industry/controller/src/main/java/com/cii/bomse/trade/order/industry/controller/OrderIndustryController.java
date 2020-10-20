package com.cii.bomse.trade.order.industry.controller;

import com.cii.bomse.trade.order.industry.dictionary.OrderStatus;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryControllerRequest;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryControllerResponse;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;
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

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/orderIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderIndustryController extends AbstractRestController {

    @Autowired
    private IOrderIndustryManager orderIndustryManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        orderIndustryManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        orderIndustryManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        OrderIndustryEntity result = orderIndustryManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryEntity> result = orderIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryEntity> result = orderIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    /**
     * @description
     * 查询可以申请发票的订单
     * @author david·cun
     * @param
     * @return
     * @date 2020-02-21 21:19
     * @since 1.0
     */
    @RequestMapping(path = "/queryOrderInvoiceApply",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryInvoiceApply(@RequestBody OrderIndustryControllerRequest request){

        OrderIndustryControllerResponse response = new OrderIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));
        param.put("notOrderStatus", OrderStatus.HasCancel);
        param.put("canApplyInvoice",Boolean.TRUE);

        PageResult<OrderIndustryEntity> result = orderIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
