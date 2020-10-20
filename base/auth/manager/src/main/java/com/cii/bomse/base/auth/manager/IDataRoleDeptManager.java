package com.cii.bomse.base.auth.manager;

import com.cii.bomse.base.auth.entity.DataRoleDeptEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 11:57
 * @since 1.0
 */
public interface IDataRoleDeptManager extends IManager<DataRoleDeptEntity> {

    public void updateDataRoleDept(Long roleId, List<Long> deptIds);

}
