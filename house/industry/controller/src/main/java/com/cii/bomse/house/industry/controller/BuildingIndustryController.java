package com.cii.bomse.house.industry.controller;

import com.cii.bomse.house.industry.dto.BuildingIndustryControllerRequest;
import com.cii.bomse.house.industry.dto.BuildingIndustryControllerResponse;
import com.cii.bomse.house.industry.manager.IBuildingIndustryManager;
import com.cii.bomse.house.industry.entity.BuildingIndustryEntity;
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
@RequestMapping(path = "/buildingIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BuildingIndustryController extends AbstractRestController {

    @Autowired
    private IBuildingIndustryManager buildingIndustryManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody BuildingIndustryControllerRequest request){

        BuildingIndustryControllerResponse response = new BuildingIndustryControllerResponse();

        buildingIndustryManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody BuildingIndustryControllerRequest request){

        BuildingIndustryControllerResponse response = new BuildingIndustryControllerResponse();

        buildingIndustryManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody BuildingIndustryControllerRequest request){

        BuildingIndustryControllerResponse response = new BuildingIndustryControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        BuildingIndustryEntity result = buildingIndustryManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody BuildingIndustryControllerRequest request){

        BuildingIndustryControllerResponse response = new BuildingIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<BuildingIndustryEntity> result = buildingIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody BuildingIndustryControllerRequest request){

        BuildingIndustryControllerResponse response = new BuildingIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<BuildingIndustryEntity> result = buildingIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
