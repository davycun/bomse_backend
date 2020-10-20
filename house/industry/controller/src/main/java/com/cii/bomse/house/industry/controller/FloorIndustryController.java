package com.cii.bomse.house.industry.controller;

import com.cii.bomse.house.industry.dto.FloorIndustryControllerRequest;
import com.cii.bomse.house.industry.dto.FloorIndustryControllerResponse;
import com.cii.bomse.house.industry.manager.IFloorIndustryManager;
import com.cii.bomse.house.industry.entity.FloorIndustryEntity;
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
@RequestMapping(path = "/floorIndustry",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FloorIndustryController extends AbstractRestController {

    @Autowired
    private IFloorIndustryManager floorIndustryManager;


    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody FloorIndustryControllerRequest request){

        FloorIndustryControllerResponse response = new FloorIndustryControllerResponse();

        floorIndustryManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody FloorIndustryControllerRequest request){

        FloorIndustryControllerResponse response = new FloorIndustryControllerResponse();

        floorIndustryManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody FloorIndustryControllerRequest request){

        FloorIndustryControllerResponse response = new FloorIndustryControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
            && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response,"详情查询请求参数ID必填");
        }

        FloorIndustryEntity result = floorIndustryManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody FloorIndustryControllerRequest request){

        FloorIndustryControllerResponse response = new FloorIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        processAdvantageTypeList(param,request);

        PageResult<FloorIndustryEntity> result = floorIndustryManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }
    @RequestMapping(path = "/querySimple",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody FloorIndustryControllerRequest request){

        FloorIndustryControllerResponse response = new FloorIndustryControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        processAdvantageTypeList(param,request);

        PageResult<FloorIndustryEntity> result = floorIndustryManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }



    private void processAdvantageTypeList(Map<String,Object> param,FloorIndustryControllerRequest request){

        if (ObjectUtils.isNotEmpty(request.getEntity()) && ObjectUtils.isNotEmpty(request.getEntity().getAdvantageTypeList())){

            List<String> adList = request.getEntity().getAdvantageTypeList();

            if (adList.contains("noTax")){
                param.put("hasTax",Boolean.FALSE);
            }
            if (adList.contains("canRegistry")){
                param.put("canRegistry",Boolean.TRUE);
            }
            if (adList.contains("hasMonitor")){
                param.put("hasMonitor",Boolean.TRUE);
            }
            if (adList.contains("hasGuard")){
                param.put("hasGuard",Boolean.TRUE);
            }
            if (adList.contains("hasCanteen")){
                param.put("hasCanteen",Boolean.TRUE);
            }
            if (adList.contains("hasOffice")){
                param.put("hasOffice",Boolean.TRUE);
            }
            if (adList.contains("hasParkingSpace")){
                param.put("hasParkingSpace",Boolean.TRUE);
            }
            if (adList.contains("singlePark")){
                param.put("singlePark",Boolean.TRUE);
            }
            if (adList.contains("singleFloor")){
                param.put("singleFloor",Boolean.TRUE);
            }
            if (adList.contains("hasLift")){
                param.put("hasLift",Boolean.TRUE);
            }
            if (adList.contains("hasRailway")){
                param.put("hasRailway",Boolean.TRUE);
            }
            if (adList.contains("hasCanopy")){
                param.put("hasCanopy",Boolean.TRUE);
            }
            if (adList.contains("hasBridgeCrane")){
                param.put("hasBridgeCrane",Boolean.TRUE);
            }
        }
    }

}
