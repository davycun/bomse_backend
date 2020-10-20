package com.cii.bomse.bi.controller;

import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.bi.dto.CustomerStatisticReportControllerRequest;
import com.cii.bomse.bi.dto.CustomerStatisticReportControllerResponse;
import com.cii.bomse.bi.entity.CustomerStatisticReportEntity;
import com.cii.bomse.bi.manager.ICustomerStatisticReportManager;
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
 * @description 客户总计报表
 * @auth david·cun
 * @date 2019-11-01 16:52
 * @since 1.0
 */

@RestController
@RequestMapping(path = "/customerStatisticReport",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerStatisticReportController extends AbstractRestController {

    @Autowired
    private ICustomerStatisticReportManager customerStatisticReportManager;

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody CustomerStatisticReportControllerRequest request) {

        CustomerStatisticReportControllerResponse response = new CustomerStatisticReportControllerResponse();

        List<CustomerStatisticReportEntity> result = customerStatisticReportManager.report(
                request.getEntity().getId(),
                request.getEntity().getReload());

        if (ObjectUtils.isNotEmpty(result) && result.size() > 1) {

            CustomerStatisticReportEntity sum = new CustomerStatisticReportEntity();
            sum.setName("合计");
            for (CustomerStatisticReportEntity tmp : result) {

                sum.setFollowupCustomerCount(sum.getFollowupCustomerCount() + tmp.getFollowupCustomerCount());
                sum.setHideCustomerCount(sum.getHideCustomerCount() + tmp.getHideCustomerCount());
                sum.setWaitJudgeCustomerCount(sum.getWaitJudgeCustomerCount() + tmp.getWaitJudgeCustomerCount());
                sum.setWaitSurveyCustomerCount(sum.getWaitSurveyCustomerCount() + tmp.getWaitSurveyCustomerCount());
                sum.setHasSurveyCustomerCount(sum.getHasSurveyCustomerCount() + tmp.getHasSurveyCustomerCount());
                sum.setCustomerIntentionYouCount(sum.getCustomerIntentionYouCount() + tmp.getCustomerIntentionYouCount());
                sum.setCustomerIntentionLiangCount(sum.getCustomerIntentionLiangCount() + tmp.getCustomerIntentionLiangCount());
                sum.setCustomerIntentionZhongCount(sum.getCustomerIntentionZhongCount() + tmp.getCustomerIntentionZhongCount());
                sum.setCustomerIntentionChaCount(sum.getCustomerIntentionChaCount() + tmp.getCustomerIntentionChaCount());
                sum.setCustomerIntentionUnknownCount(sum.getCustomerIntentionUnknownCount() + tmp.getCustomerIntentionUnknownCount());
                sum.setCustomerNotFollowup3DayCount(sum.getCustomerNotFollowup3DayCount() + tmp.getCustomerNotFollowup3DayCount());
                sum.setCustomerNotFollowup7DayCount(sum.getCustomerNotFollowup7DayCount() + tmp.getCustomerNotFollowup7DayCount());
            }

            result.add(0, sum);

        }

        PageResult<CustomerStatisticReportEntity> pr = new PageResult<CustomerStatisticReportEntity>();
        pr.setData(result);

        response.setResult(pr);

        return this.success(response);
    }
}
