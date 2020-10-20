package com.cii.bomse.house.industry.controller;

import com.cii.bomse.house.industry.dto.HouseIndustryControllerRequest;
import com.cii.bomse.house.industry.dto.HouseIndustryControllerResponse;
import com.cii.bomse.house.industry.entity.HouseIndustryEntity;
import com.cii.bomse.house.industry.manager.IHouseIndustryManager;
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
@RequestMapping(path = "/houseIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HouseIndustryController extends AbstractRestController {

    @Autowired
    private IHouseIndustryManager houseIndustryManager;


    /**
     * @description
     * 房源列表查询
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-10 22:07
     * @since 1.0
     */
    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody HouseIndustryControllerRequest request){

        HouseIndustryControllerResponse response = new HouseIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<HouseIndustryEntity> result = houseIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
}
