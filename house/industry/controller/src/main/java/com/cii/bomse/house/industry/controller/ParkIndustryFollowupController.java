package com.cii.bomse.house.industry.controller;

import com.cii.bomse.house.industry.dto.ParkIndustryFollowupControllerRequest;
import com.cii.bomse.house.industry.dto.ParkIndustryFollowupControllerResponse;
import com.cii.bomse.house.industry.manager.IParkIndustryFollowupManager;
import com.cii.bomse.house.industry.entity.ParkIndustryFollowupEntity;
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
@RequestMapping(path = "/parkIndustryFollowup",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ParkIndustryFollowupController extends AbstractRestController {

    @Autowired
    private IParkIndustryFollowupManager parkIndustryFollowupManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody ParkIndustryFollowupControllerRequest request){

        ParkIndustryFollowupControllerResponse response = new ParkIndustryFollowupControllerResponse();

        parkIndustryFollowupManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody ParkIndustryFollowupControllerRequest request){

        ParkIndustryFollowupControllerResponse response = new ParkIndustryFollowupControllerResponse();

        parkIndustryFollowupManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody ParkIndustryFollowupControllerRequest request){

        ParkIndustryFollowupControllerResponse response = new ParkIndustryFollowupControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        ParkIndustryFollowupEntity result = parkIndustryFollowupManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody ParkIndustryFollowupControllerRequest request){

        ParkIndustryFollowupControllerResponse response = new ParkIndustryFollowupControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkIndustryFollowupEntity> result = parkIndustryFollowupManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody ParkIndustryFollowupControllerRequest request){

        ParkIndustryFollowupControllerResponse response = new ParkIndustryFollowupControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkIndustryFollowupEntity> result = parkIndustryFollowupManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
