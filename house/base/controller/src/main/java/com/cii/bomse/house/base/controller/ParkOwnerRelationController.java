package com.cii.bomse.house.base.controller;

import com.cii.bomse.house.base.dto.ParkOwnerRelationControllerRequest;
import com.cii.bomse.house.base.dto.ParkOwnerRelationControllerResponse;
import com.cii.bomse.house.base.manager.IParkOwnerRelationManager;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
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
@RequestMapping(path = "/parkOwnerRelation",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ParkOwnerRelationController extends AbstractRestController {

    @Autowired
    private IParkOwnerRelationManager parkOwnerRelationManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody ParkOwnerRelationControllerRequest request){

        ParkOwnerRelationControllerResponse response = new ParkOwnerRelationControllerResponse();

        parkOwnerRelationManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody ParkOwnerRelationControllerRequest request){

        ParkOwnerRelationControllerResponse response = new ParkOwnerRelationControllerResponse();

        parkOwnerRelationManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody ParkOwnerRelationControllerRequest request){

        ParkOwnerRelationControllerResponse response = new ParkOwnerRelationControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        ParkOwnerRelationEntity result = parkOwnerRelationManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody ParkOwnerRelationControllerRequest request){

        ParkOwnerRelationControllerResponse response = new ParkOwnerRelationControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkOwnerRelationEntity> result = parkOwnerRelationManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody ParkOwnerRelationControllerRequest request){

        ParkOwnerRelationControllerResponse response = new ParkOwnerRelationControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<ParkOwnerRelationEntity> result = parkOwnerRelationManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
