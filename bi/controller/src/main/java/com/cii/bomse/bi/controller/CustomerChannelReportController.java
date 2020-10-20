package com.cii.bomse.bi.controller;

import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.bi.dto.CustomerChannelReportControllerRequest;
import com.cii.bomse.bi.dto.CustomerChannelReportControllerResponse;
import com.cii.bomse.bi.entity.CustomerChannelReportEntity;
import com.cii.bomse.bi.manager.ICustomerChannelReportManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 客户渠道统计报表
 * @auth david·cun
 * @date 2019-11-01 16:52
 * @since 1.0
 */


@RestController
@RequestMapping(path = "/customerChannelReport",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerChannelReportController extends AbstractRestController {

    @Autowired
    private ICustomerChannelReportManager customerChannelReportManager;

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerChannelReportControllerRequest request) {

        CustomerChannelReportControllerResponse response = new CustomerChannelReportControllerResponse();

        List<CustomerChannelReportEntity> result = customerChannelReportManager.report(
                request.getEntity().getId(),
                request.getEntity().getReload(),
                request.getEntity().getStartTime(),
                request.getEntity().getEndTime());

        if (ObjectUtils.isNotEmpty(result) && result.size() > 1) {
            CustomerChannelReportEntity sum = new CustomerChannelReportEntity();
            sum.setName("合计");
            for (CustomerChannelReportEntity tmp : result) {
                sum.setCustomerPersonalCount(sum.getCustomerPersonalCount() + tmp.getCustomerPersonalCount());
                sum.setCustomerCompanyCount(sum.getCustomerCompanyCount() + tmp.getCustomerCompanyCount());
                sum.setCustomerHasRentCount(sum.getCustomerHasRentCount() + tmp.getCustomerHasRentCount());
                sum.setCustomerAcceptCount(sum.getCustomerAcceptCount() + tmp.getCustomerAcceptCount());
                sum.setCustomerSurveyCount(sum.getCustomerSurveyCount() + tmp.getCustomerSurveyCount());
                sum.setNewCustomerSurveyCount(sum.getNewCustomerSurveyCount() + tmp.getNewCustomerSurveyCount());
                sum.setOrderCount(sum.getOrderCount() + tmp.getOrderCount());
                sum.setNewCustomerOrderCount(sum.getNewCustomerOrderCount() + tmp.getNewCustomerOrderCount());
            }
            result.add(0,sum);
        }

        PageResult<CustomerChannelReportEntity> pr = new PageResult<CustomerChannelReportEntity>();
        pr.setData(result);

        response.setResult(pr);


        return this.success(response);
    }
}
