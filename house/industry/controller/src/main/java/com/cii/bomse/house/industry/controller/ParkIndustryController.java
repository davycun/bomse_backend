package com.cii.bomse.house.industry.controller;

import com.cii.bomse.house.industry.dto.ParkIndustryControllerRequest;
import com.cii.bomse.house.industry.dto.ParkIndustryControllerResponse;
import com.cii.bomse.house.industry.manager.IParkIndustryManager;
import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
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
@RequestMapping(path = "/parkIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ParkIndustryController extends AbstractRestController {

    @Autowired
    private IParkIndustryManager parkIndustryManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody ParkIndustryControllerRequest request){

        ParkIndustryControllerResponse response = new ParkIndustryControllerResponse();

        parkIndustryManager.create(request.getEntity());

        response.setResult(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody ParkIndustryControllerRequest request){

        ParkIndustryControllerResponse response = new ParkIndustryControllerResponse();

        parkIndustryManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody ParkIndustryControllerRequest request){

        ParkIndustryControllerResponse response = new ParkIndustryControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        ParkIndustryEntity result = parkIndustryManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody ParkIndustryControllerRequest request){

        ParkIndustryControllerResponse response = new ParkIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkIndustryEntity> result = parkIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody ParkIndustryControllerRequest request){

        ParkIndustryControllerResponse response = new ParkIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkIndustryEntity> result = parkIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }


}
