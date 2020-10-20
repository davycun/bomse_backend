package com.cii.bomse.hrm.emp.controller;

import com.cii.bomse.hrm.emp.dto.PostControllerRequest;
import com.cii.bomse.hrm.emp.dto.PostControllerResponse;
import com.cii.bomse.hrm.emp.entity.PostEntity;
import com.cii.bomse.hrm.emp.manager.IPostManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/21 14:24
 */
@RestController
@RequestMapping(path = "/post",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PostController extends AbstractRestController {

    @Autowired
    private IPostManager postManager;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody PostControllerRequest request) {

        PostControllerResponse response = new PostControllerResponse();

        postManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody PostControllerRequest request){

        PostControllerResponse response = new PostControllerResponse();

        ValidationResult vr = ValidationUtils.validateInclude(request.getEntity(), "postName");

        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }

        postManager.update(request.getEntity());

        return this.success(response);

    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody PostControllerRequest request){

        PostControllerResponse response = new PostControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<PostEntity> posts = postManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),"create_time",false);

        response.setResult(posts);

        return this.success(response);

    }

    @RequestMapping(path = "/queryAll",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryAll(@RequestBody PostControllerRequest request){

        PostControllerResponse response = new PostControllerResponse();

        Map<String,Object> param = new HashMap<>();

        List<PostEntity> posts = postManager.findByMap(param);

        response.setResult(posts);

        return this.success(response);

    }

}
