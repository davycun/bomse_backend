package com.cii.bomse.hrm.dept.manager;

import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.ciiframework.common.business.IManager;

public interface IDeptConfigManager extends IManager<DeptConfigEntity> {

    DeptConfigEntity findByDeptId(Long deptId);

}
