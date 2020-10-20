package com.cii.bomse.bi.controller;

import com.cii.bomse.bi.dto.RankingReportControllerRequest;
import com.cii.bomse.bi.dto.RankingReportControllerResponse;
import com.cii.bomse.bi.manager.IRankingReportManager;
import com.cii.bomse.bi.entity.RankingReportEntity;
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

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/rankingReport",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RankingReportController extends AbstractRestController {

    @Autowired
    private IRankingReportManager rankingReportManager;

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody RankingReportControllerRequest request){

        RankingReportControllerResponse response = new RankingReportControllerResponse();

//        RankingReportEntity result = rankingReportManager.ranking();

//        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/monthAchievement",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> monthAchievement(@RequestBody RankingReportControllerRequest request){

        RankingReportControllerResponse response = new RankingReportControllerResponse();

        List<RankingReportEntity> result = rankingReportManager.monthAchievement();

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/rankingEmployeeAchievement",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> rankingEmployeeAchievement(@RequestBody RankingReportControllerRequest request){

        RankingReportControllerResponse response = new RankingReportControllerResponse();

        List<RankingReportEntity> result = rankingReportManager.rankingEmployeeAchievement();


        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/monthCustomer",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> monthCustomer(@RequestBody RankingReportControllerRequest request){

        RankingReportControllerResponse response = new RankingReportControllerResponse();

        List<RankingReportEntity> result = rankingReportManager.monthCustomerPersonal();

        result.addAll(rankingReportManager.monthCustomerCompany());
        result.addAll(rankingReportManager.monthCustomerHide());

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/rankingCustomerPersonal",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> rankingCustomerPersonal(@RequestBody RankingReportControllerRequest request){

        RankingReportControllerResponse response = new RankingReportControllerResponse();

        List<RankingReportEntity> result = rankingReportManager.rankingCustomerPersonal();

        response.setResult(result);

        return this.success(response);
    }


}
