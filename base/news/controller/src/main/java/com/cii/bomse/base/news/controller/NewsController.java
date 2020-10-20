package com.cii.bomse.base.news.controller;

import com.cii.bomse.base.news.dto.NewsControllerRequest;
import com.cii.bomse.base.news.dto.NewsControllerResponse;
import com.cii.bomse.base.news.entity.NewsEntity;
import com.cii.bomse.base.news.manager.INewsManager;
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

/**
 * @description
 * @auth david·cun
 * @date 2019-04-10 10:45
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/news",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NewsController extends AbstractRestController {

    @Autowired
    private INewsManager newsManager;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody NewsControllerRequest request){

        NewsControllerResponse response = new NewsControllerResponse();

        newsManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody NewsControllerRequest request){
        NewsControllerResponse response = new NewsControllerResponse();

        newsManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody NewsControllerRequest request){
        NewsControllerResponse response = new NewsControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<NewsEntity> result = newsManager.findByMap(param,request.getStartOrDefault(0),request.getPageSizeOrDefault(30),"create_time",false);

        response.setResult(result);

        return this.success(response);
    }
}
