package com.cii.bomse.base.area.controller;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.cii.bomse.base.area.dto.AreaControllerRequest;
import com.cii.bomse.base.area.dto.AreaControllerResponse;
import com.cii.bomse.base.area.entity.AreaCpyEntity;
import com.cii.bomse.base.area.manager.IAreaCpyManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.BeanMapConvertUtils;
import io.swagger.annotations.*;
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
 * @description 每个独立公司进行区域独立管理
 * @auth david·cun
 * @date 2019-05-29 18:39
 * @since 1.0
 */
@Api(value = "企业行政区域查询借口")
@RestController
@RequestMapping(path = "/areaCpy",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AreaCpyController extends AbstractRestController {

    @Autowired
    private IAreaCpyManager areaCpyManager;

    @ApiOperation(value = "行政区域查询",notes = "分野查询接口")
    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<AreaCpyEntity> result = areaCpyManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("t.id"),
                request.getIsAscOrDefault(Boolean.TRUE));

        response.setResult(result);

        return this.success(response);
    }

    /**
     * @description 查询本公司省市区相关信息以列表形式返回
     * @author david·cun
     * @param
     * @return
     * @date 2019-05-29 18:43
     * @since 1.0
     */
    @RequestMapping(path = "/queryAllToList",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryToList(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        List<AreaCpyEntity> areas = areaCpyManager.findByMapToSort(param);
        response.setResult(areas);

        return this.success(response);

    }

    /**
     * @description 查询本公司全部有效的区域信息以树形结构返回给前端
     * @auth david·cun
     * @date 2019-05-31 16:08
     * @since 1.0
     */
    @RequestMapping(path = "/queryAllToTree",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryToTree(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        List<AreaCpyEntity> areas = areaCpyManager.findByMapToTree(param);
        response.setResult(areas);
        return this.success(response);

    }

    /**
     * @description
     * 从城市开始查区域的树型数据
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-03 18:57
     * @since 1.0
     */
    @RequestMapping(path = "/queryFromCityToTree",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryFromCityToTree(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();
        Map<String,Object> param = new HashMap<>();
        param.put("isDeleted",Boolean.FALSE);
        param.put("notAreaType", AreaType.Province);
        List<AreaCpyEntity> areas = areaCpyManager.findByMapToTree(param);
        response.setResult(areas);
        return this.success(response);

    }

    @RequestMapping(path = "enableArea",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> enableArea(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        areaCpyManager.enableArea(request.getEntity().getId());

        return this.success(response);
    }

    @RequestMapping(path = "disableArea",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> disableArea(@RequestBody AreaControllerRequest request){

        AreaControllerResponse response = new AreaControllerResponse();

        areaCpyManager.disableArea(request.getEntity().getId());

        return this.success(response);
    }
}
