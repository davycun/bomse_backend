package com.cii.bomse.house.land.controller;

import com.cii.bomse.house.land.dto.BlankLandControllerRequest;
import com.cii.bomse.house.land.dto.BlankLandControllerResponse;
import com.cii.bomse.house.land.manager.IBlankLandManager;
import com.cii.bomse.house.land.entity.BlankLandEntity;
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
@RequestMapping(path = "/blankLand",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BlankLandController extends AbstractRestController {

    @Autowired
    private IBlankLandManager blankLandManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        blankLandManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        blankLandManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        BlankLandEntity result = blankLandManager.findById(request.getEntity().getId());

        result.setContactPhone(null);

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<BlankLandEntity> result = blankLandManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        ObjectUtils.forEach(result.getData(),(l)->l.setContactPhone(null));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<BlankLandEntity> result = blankLandManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        ObjectUtils.forEach(result.getData(),(l)->l.setContactPhone(null));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/callPhone",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> callPhone(@RequestBody BlankLandControllerRequest request){

        BlankLandControllerResponse response = new BlankLandControllerResponse();

        response.setResult(blankLandManager.callPhone(request.getEntity().getId()));

        return this.success(response);
    }
}
