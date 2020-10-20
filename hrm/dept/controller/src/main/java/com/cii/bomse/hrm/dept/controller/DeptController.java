package com.cii.bomse.hrm.dept.controller;

import com.cii.bomse.hrm.dept.dto.DeptControllerRequest;
import com.cii.bomse.hrm.dept.dto.DeptControllerResponse;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.context.CurrentContext;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 16:00
 */
@RestController
@RequestMapping(path = "/dept",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeptController extends AbstractRestController {

    @Autowired
    private IDeptManager deptManager;

    @RequestMapping(path = "/create",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> create(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        deptManager.create(request.getEntity());

        return this.success(response);

    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> update(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        deptManager.update(request.getEntity());

        return this.success(response);
    }

    @RequestMapping(path = "/query",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> query(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        List<DeptEntity> list = deptManager.findByMap(param);
        response.setResult(list);
        return this.success(response);
    }

    /**
     * @description
     * 部门管理的时候查询部门组织结构树
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-23 19:13
     * @since 1.0
     */
    @RequestMapping(path = "/queryToTree",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryToTree(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        Map<String,Object> param = BeanMapConvertUtils.convertInclude(request);
        param.putAll(BeanMapConvertUtils.convertInclude(request.getEntity()));

        List<DeptEntity> list = deptManager.findByMapToTree(param);
        response.setResult(list);

        return this.success(response);
    }

    /**
     * @description
     * 查询哪些部门编码被分配给了指定角色
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-23 19:10
     * @since 1.0
     */
    @RequestMapping(path = "/queryRoleDeptCode",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryDataRoleDeptCode(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        List<DeptEntity> list = deptManager.findByRoleToList(request.getEntity().getRoleId());

        List<Long> deptCodes = new ArrayList<>();

        for (DeptEntity d: list) {
            deptCodes.add(d.getId());
        }

        response.setResult(deptCodes);

        return this.success(response);
    }

    /**
     * @description
     * 查询我有权限的组织结构树，包括我是领导的及分给我的数据权限
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-24 11:41
     * @since 1.0
     */
    @RequestMapping(path = "/queryMyAuthDeptTree",method = RequestMethod.POST)
    public ResponseEntity<IServiceResponse> queryMyAuthDeptTree(@RequestBody DeptControllerRequest request){

        DeptControllerResponse response = new DeptControllerResponse();

        List<DeptEntity> list = deptManager.findUserAuthDeptToTree(CurrentContext.getUserId());

        response.setResult(list);

        return this.success(response);
    }

}
