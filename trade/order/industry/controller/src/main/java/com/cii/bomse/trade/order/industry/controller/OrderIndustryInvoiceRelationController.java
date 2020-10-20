package com.cii.bomse.trade.order.industry.controller;

import com.cii.bomse.trade.order.industry.dto.OrderIndustryInvoiceRelationControllerRequest;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryInvoiceRelationControllerResponse;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceRelationManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceRelationEntity;
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
@RequestMapping(path = "/orderIndustryInvoiceRelation",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderIndustryInvoiceRelationController extends AbstractRestController {

    @Autowired
    private IOrderIndustryInvoiceRelationManager orderIndustryInvoiceRelationManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody OrderIndustryInvoiceRelationControllerRequest request){

        OrderIndustryInvoiceRelationControllerResponse response = new OrderIndustryInvoiceRelationControllerResponse();

        orderIndustryInvoiceRelationManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody OrderIndustryInvoiceRelationControllerRequest request){

        OrderIndustryInvoiceRelationControllerResponse response = new OrderIndustryInvoiceRelationControllerResponse();

        orderIndustryInvoiceRelationManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody OrderIndustryInvoiceRelationControllerRequest request){

        OrderIndustryInvoiceRelationControllerResponse response = new OrderIndustryInvoiceRelationControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        OrderIndustryInvoiceRelationEntity result = orderIndustryInvoiceRelationManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody OrderIndustryInvoiceRelationControllerRequest request){

        OrderIndustryInvoiceRelationControllerResponse response = new OrderIndustryInvoiceRelationControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryInvoiceRelationEntity> result = orderIndustryInvoiceRelationManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody OrderIndustryInvoiceRelationControllerRequest request){

        OrderIndustryInvoiceRelationControllerResponse response = new OrderIndustryInvoiceRelationControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryInvoiceRelationEntity> result = orderIndustryInvoiceRelationManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
