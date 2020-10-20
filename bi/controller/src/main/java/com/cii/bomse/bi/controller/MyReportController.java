package com.cii.bomse.bi.controller;

import com.cii.bomse.bi.dto.MyReportControllerRequest;
import com.cii.bomse.bi.dto.MyReportControllerResponse;
import com.cii.bomse.bi.entity.MyReportEntity;
import com.cii.bomse.bi.manager.IMyReportManager;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/myReport",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyReportController extends AbstractRestController {

    @Autowired
    private IMyReportManager myReportManager;

    @RequestMapping(path = "/report",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody MyReportControllerRequest request){

        MyReportControllerResponse response = new MyReportControllerResponse();

        MyReportEntity result = myReportManager.myReport();;

        response.setResult(result);

        return this.success(response);
    }

}
