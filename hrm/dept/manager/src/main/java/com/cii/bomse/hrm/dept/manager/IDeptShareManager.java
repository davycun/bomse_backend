package com.cii.bomse.hrm.dept.manager;

import com.cii.bomse.hrm.dept.entity.DeptShareEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

public interface IDeptShareManager extends IManager<DeptShareEntity> {


    /**
     * @description
     * 查找与指定部门ID共享的所有部门
     * @author david·cun
     * @param
     * @return
     * @date 2020-05-31 16:39
     * @since 1.0
     */
    List<Long> findAllShareDeptByDeptId(Long deptId);

}
