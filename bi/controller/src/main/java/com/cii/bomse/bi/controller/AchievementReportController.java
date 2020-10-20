package com.cii.bomse.bi.controller;

import com.cii.bomse.bi.dto.AchievementReportControllerRequest;
import com.cii.bomse.bi.dto.AchievementReportControllerResponse;
import com.cii.bomse.bi.entity.AchievementReportEntity;
import com.cii.bomse.bi.manager.IAchievementReportManager;
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
 * @description
 * 业绩统计报表
 * @auth david·cun
 * @date 2019-11-01 16:52
 * @since 1.0
 */

@RestController
@RequestMapping(path = "/achievementReport",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AchievementReportController extends AbstractRestController {

    @Autowired
    private IAchievementReportManager achievementReportManager;

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody AchievementReportControllerRequest request) {

        AchievementReportControllerResponse response = new AchievementReportControllerResponse();

        List<AchievementReportEntity> result = achievementReportManager.report(
                request.getEntity().getId(),
                request.getEntity().getReload(),
                request.getEntity().getStartTime(),
                request.getEntity().getEndTime());


        PageResult<AchievementReportEntity> pr = new PageResult<AchievementReportEntity>();

        pr.setData(result);

        response.setResult(pr);

        return this.success(response);
    }


}
