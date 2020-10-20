package com.cii.bomse.base.area.controller;

import com.cii.bomse.base.area.dto.AreaControllerRequest;
import com.cii.bomse.base.area.dto.AreaControllerResponse;
import com.cii.bomse.base.area.entity.AreaEntity;
import com.cii.bomse.base.area.manager.IAreaManager;
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
@RequestMapping(path = "/area",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AreaController extends AbstractRestController {

    @Autowired
    private IAreaManager areaManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        areaManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        areaManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<AreaEntity> result = areaManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("t.id"),
                request.getIsAscOrDefault(Boolean.TRUE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<AreaEntity> result = areaManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("t.id"),
                request.getIsAscOrDefault(Boolean.TRUE));

        response.setResult(result);

        return this.success(response);
    }
}
