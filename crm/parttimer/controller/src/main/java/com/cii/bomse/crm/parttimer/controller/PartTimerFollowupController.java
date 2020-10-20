package com.cii.bomse.crm.parttimer.controller;

import com.cii.bomse.crm.parttimer.dto.PartTimerFollowupControllerRequest;
import com.cii.bomse.crm.parttimer.dto.PartTimerFollowupControllerResponse;
import com.cii.bomse.crm.parttimer.entity.PartTimerFollowupEntity;
import com.cii.bomse.crm.parttimer.manager.IPartTimerFollowupManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "/partTimerFollowup",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PartTimerFollowupController extends AbstractRestController {

    @Autowired
    private IPartTimerFollowupManager partTimerFollowupManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody PartTimerFollowupControllerRequest request){

        PartTimerFollowupControllerResponse response = new PartTimerFollowupControllerResponse();

        partTimerFollowupManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody PartTimerFollowupControllerRequest request){

        PartTimerFollowupControllerResponse response = new PartTimerFollowupControllerResponse();

        partTimerFollowupManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody PartTimerFollowupControllerRequest request){

        PartTimerFollowupControllerResponse response = new PartTimerFollowupControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<PartTimerFollowupEntity> result = partTimerFollowupManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),"create_time",false);

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody PartTimerFollowupControllerRequest request){

        PartTimerFollowupControllerResponse response = new PartTimerFollowupControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<PartTimerFollowupEntity> result = partTimerFollowupManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),"create_time",false);

        response.setResult(result);

        return this.success(response);
    }
}
