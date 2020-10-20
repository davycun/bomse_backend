package com.cii.bomse.crm.parttimer.controller;

import com.cii.bomse.crm.parttimer.dto.PartTimerControllerRequest;
import com.cii.bomse.crm.parttimer.dto.PartTimerControllerResponse;
import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;
import com.cii.bomse.crm.parttimer.manager.IPartTimerManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
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
@RequestMapping(path = "/partTimer",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PartTimerController extends AbstractRestController {

    @Autowired
    private IPartTimerManager partTimerManager;


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody PartTimerControllerRequest request) {

        PartTimerControllerResponse response = new PartTimerControllerResponse();

        partTimerManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody PartTimerControllerRequest request) {

        PartTimerControllerResponse response = new PartTimerControllerResponse();

        partTimerManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody PartTimerControllerRequest request) {

        PartTimerControllerResponse response = new PartTimerControllerResponse();
        if (ObjectUtils.isEmpty(request.getEntity())
                && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }
        PartTimerEntity pt = partTimerManager.findById(request.getEntity().getId());
        response.setResult(pt);

        return this.success(response);
    }

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody PartTimerControllerRequest request) {

        PartTimerControllerResponse response = new PartTimerControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));


        PageResult<PartTimerEntity> result = partTimerManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/querySimple", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody PartTimerControllerRequest request) {

        PartTimerControllerResponse response = new PartTimerControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<PartTimerEntity> result = partTimerManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30), "create_time", false);

        response.setResult(result);

        return this.success(response);
    }
}
