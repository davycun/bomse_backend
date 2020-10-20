package com.cii.bomse.trade.order.industry.controller;

import com.cii.bomse.trade.order.industry.dto.OrderIndustryInvoiceControllerRequest;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryInvoiceControllerResponse;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;
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
@RequestMapping(path = "/orderIndustryInvoice",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderIndustryInvoiceController extends AbstractRestController {

    @Autowired
    private IOrderIndustryInvoiceManager orderIndustryInvoiceManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        orderIndustryInvoiceManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        orderIndustryInvoiceManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        OrderIndustryInvoiceEntity result = orderIndustryInvoiceManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryInvoiceEntity> result = orderIndustryInvoiceManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryInvoiceEntity> result = orderIndustryInvoiceManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/mailOrSend",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> mail(@RequestBody OrderIndustryInvoiceControllerRequest request){

        OrderIndustryInvoiceControllerResponse response = new OrderIndustryInvoiceControllerResponse();

        orderIndustryInvoiceManager.mail(request.getEntity());

        return this.success(response);
    }
}
