package com.cii.bomse.hrm.dept.controller;

import com.cii.bomse.hrm.dept.dto.DeptShareControllerRequest;
import com.cii.bomse.hrm.dept.dto.DeptShareControllerResponse;
import com.cii.bomse.hrm.dept.manager.IDeptShareManager;
import com.cii.bomse.hrm.dept.entity.DeptShareEntity;
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

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/deptShare",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeptShareController extends AbstractRestController {

    @Autowired
    private IDeptShareManager deptShareManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody DeptShareControllerRequest request){

        DeptShareControllerResponse response = new DeptShareControllerResponse();

        deptShareManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody DeptShareControllerRequest request){

        DeptShareControllerResponse response = new DeptShareControllerResponse();

        deptShareManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody DeptShareControllerRequest request){

        DeptShareControllerResponse response = new DeptShareControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        DeptShareEntity result = deptShareManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody DeptShareControllerRequest request){

        DeptShareControllerResponse response = new DeptShareControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<DeptShareEntity> result = deptShareManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody DeptShareControllerRequest request){

        DeptShareControllerResponse response = new DeptShareControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<DeptShareEntity> result = deptShareManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> delete(@RequestBody DeptShareControllerRequest request){
        DeptShareControllerResponse response = new DeptShareControllerResponse();

        deptShareManager.deleteById(request.getEntity().getId());

        return this.success(response);
    }
}
