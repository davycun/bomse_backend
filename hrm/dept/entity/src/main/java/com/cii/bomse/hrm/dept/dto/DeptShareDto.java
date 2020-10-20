package com.cii.bomse.hrm.dept.dto;

import com.cii.bomse.hrm.dept.entity.DeptShareEntity;

public class DeptShareDto extends DeptShareEntity {

    /**参与共享的部门列表*/
    private Long deptId;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
