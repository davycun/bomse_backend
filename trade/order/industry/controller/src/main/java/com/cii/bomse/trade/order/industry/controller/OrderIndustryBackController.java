package com.cii.bomse.trade.order.industry.controller;

import com.cii.bomse.trade.order.industry.dictionary.OrderBackStatus;
import com.cii.bomse.trade.order.industry.dictionary.OrderBackType;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryBackControllerRequest;
import com.cii.bomse.trade.order.industry.dto.OrderIndustryBackControllerResponse;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryBackManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;
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

import java.util.Map;


@RestController
@RequestMapping(path = "/orderIndustryBack",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderIndustryBackController extends AbstractRestController {

    @Autowired
    private IOrderIndustryBackManager orderIndustryBackManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody OrderIndustryBackControllerRequest request){

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        orderIndustryBackManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody OrderIndustryBackControllerRequest request){

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        orderIndustryBackManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody OrderIndustryBackControllerRequest request){

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        OrderIndustryBackEntity result = orderIndustryBackManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody OrderIndustryBackControllerRequest request){

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryBackEntity> result = orderIndustryBackManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody OrderIndustryBackControllerRequest request){

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<OrderIndustryBackEntity> result = orderIndustryBackManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    /**
     * @description
     * 对回款进行认领
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-27 13:56
     * @since 1.0
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> confirm(@RequestBody OrderIndustryBackControllerRequest request) {

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(), "orderId", "id");

        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }

        orderIndustryBackManager.confirm(request.getEntity().getOrderId(), request.getEntity().getId());

        return this.success(response);
    }

    /**
     * @description
     * 发票索取查询可以申请发票的回款记录，必须是已经被认领的回款及没有被申请过发票的回款
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-10 14:15
     * @since 1.0
     */
    @RequestMapping(path = "/queryInvoiceApply", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryInvoiceApply(@RequestBody OrderIndustryBackControllerRequest request) {

        OrderIndustryBackControllerResponse response = new OrderIndustryBackControllerResponse();


        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request.getEntity());
        param.putAll(BeanMapConvertUtils.convertInclude(request));
        param.put("backStatus", OrderBackStatus.HasConfirm);
        param.put("hasInvoice", Boolean.FALSE);
        param.put("backType", OrderBackType.ReceiveMoney);

        PageResult<OrderIndustryBackEntity> result =
                orderIndustryBackManager.findByMap(param,
                        request.getStartOrDefault(0), request.getPageSizeOrDefault(30));

        response.setResult(result);

        return this.success(response);
    }
}
