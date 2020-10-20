package com.cii.bomse.house.base.controller;

import com.cii.bomse.house.base.dto.HouseOwnerControllerRequest;
import com.cii.bomse.house.base.dto.HouseOwnerControllerResponse;
import com.cii.bomse.house.base.manager.IHouseOwnerManager;
import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.ciiframework.data.PageResult;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.service.AbstractRestController;
import com.ciiframework.service.IServiceResponse;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/houseOwner",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HouseOwnerController extends AbstractRestController {

    @Autowired
    private IHouseOwnerManager houseOwnerManager;


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        houseOwnerManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        houseOwnerManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> detail(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        if (ObjectUtils.isEmpty(request.getEntity())
                && ObjectUtils.isEmpty(request.getEntity().getId())) {
            return error(response, "详情查询请求参数ID必填");
        }

        HouseOwnerEntity result = houseOwnerManager.findById(request.getEntity().getId());

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<HouseOwnerEntity> result = houseOwnerManager.findByMap(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    @RequestMapping(path = "/querySimple", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> querySimple(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        PageResult<HouseOwnerEntity> result = houseOwnerManager.findByMapSimple(param,
                request.getStartOrDefault(0),
                request.getPageSizeOrDefault(30),
                request.getOrderByOrDefault("create_time"),
                request.getIsAscOrDefault(Boolean.FALSE));

        response.setResult(result);

        return this.success(response);
    }

    /**
     * @param
     * @return
     * @description 通过园区ID、建筑ID或者楼层ID来查询业主信息，所以需要关联房源表
     * @author david·cun
     * @date 2020-01-03 18:13
     * @since 1.0
     */
    @RequestMapping(path = "/queryByParkId", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryFromHouse(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        if (ObjectUtils.isNotEmpty(request.getEntity()) && ObjectUtils.isNotEmpty(request.getEntity().getParkId())) {
            List<HouseOwnerEntity> result = houseOwnerManager.findByParkId(request.getEntity().getParkId());

            if (ObjectUtils.isNotEmpty(result)) {
                for (HouseOwnerEntity owner : result) {
                    if (ObjectUtils.isNotEmpty(owner.getOwnPhone())) {
                        StringBuffer sb = new StringBuffer();
                        char[] cs = owner.getOwnPhone().toCharArray();
                        for (int i = 0; i < cs.length; i++) {
                            if (i > 2 && i < 7) {
                                sb.append("*");
                            } else {
                                sb.append(cs[i]);
                            }
                        }
                        owner.setOwnPhone(sb.toString());
                    }

                }
            }

            response.setResult(result);
        }
        return this.success(response);
    }

    /**
     * @param
     * @return
     * @description 更新业主手机号码
     * @author david·cun
     * @date 2020-01-07 15:08
     * @since 1.0
     */
    @RequestMapping(path = "/updatePhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> updatePhone(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        houseOwnerManager.updateHouseOwnerPhone(request.getEntity().getId(),
                request.getEntity().getOldPhone(),
                request.getEntity().getNewPhone());

        return this.success(response);
    }

    @RequestMapping(path = "/callPhone", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> callPhone(@RequestBody HouseOwnerControllerRequest request) {

        HouseOwnerControllerResponse response = new HouseOwnerControllerResponse();

        String phone = houseOwnerManager.callPhone(request.getEntity().getId());
        response.setResult(phone);

        return this.success(response);
    }

}
