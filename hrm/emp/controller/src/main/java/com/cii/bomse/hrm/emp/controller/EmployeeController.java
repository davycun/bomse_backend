package com.cii.bomse.hrm.emp.controller;

import com.cii.bomse.hrm.emp.dto.EmployeeControllerRequest;
import com.cii.bomse.hrm.emp.dto.EmployeeControllerResponse;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.manager.IEmployeeManager;
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
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/17 12:03
 */
@RestController
@RequestMapping(path = "/emp",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController extends AbstractRestController {

    @Autowired
    private IEmployeeManager employeeManager;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody EmployeeControllerRequest request) {

        EmployeeControllerResponse response = new EmployeeControllerResponse();

        employeeManager.create(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody EmployeeControllerRequest request) {

        EmployeeControllerResponse response = new EmployeeControllerResponse();

        employeeManager.update(request.getEntity());

        return this.success(response);
    }


    /**
     * @param request
     * @return
     */
    @RequestMapping(path = "/query", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody EmployeeControllerRequest request) {

        EmployeeControllerResponse response = new EmployeeControllerResponse();

        Map<String, Object> param = BeanMapConvertUtils.convertExclude(request, "class", "entity");
        param.putAll(BeanMapConvertUtils.convertExclude(request.getEntity(), "class"));

        PageResult<EmployeeEntity> result = employeeManager.findByMap(param,
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
     * @description 关闭登录权限
     * @author david·cun
     * @ate 2019-04-15 18:11
     * @since 1.0
     */
    @RequestMapping(path = "/closeLogin", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> closeLogin(@RequestBody EmployeeControllerRequest request) {
        EmployeeControllerResponse response = new EmployeeControllerResponse();
        employeeManager.closeLogin(request.getEntity().getId());
        return this.success(response);
    }

    /**
     * @param
     * @return
     * @description 关闭登录权限
     * @author david·cun
     * @ate 2019-04-15 18:11
     * @since 1.0
     */
    @RequestMapping(path = "/openLogin", method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> openLogin(@RequestBody EmployeeControllerRequest request) {
        EmployeeControllerResponse response = new EmployeeControllerResponse();
        employeeManager.openLogin(request.getEntity().getId());
        return this.success(response);
    }

    @RequestMapping(path = "/updatePhone",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> updatePhone(@RequestBody EmployeeControllerRequest request) {

        EmployeeControllerResponse response = new EmployeeControllerResponse();
        employeeManager.updatePhone(request.getEntity().getId(),
                request.getEntity().getOldPhone(),
                request.getEntity().getNewPhone());
        return this.success(response);
    }

    @RequestMapping(path = "/rehire",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> rehire(@RequestBody EmployeeControllerRequest request) {

        EmployeeControllerResponse response = new EmployeeControllerResponse();

        employeeManager.rehire(request.getEntity());

        return this.success(response);
    }
}
