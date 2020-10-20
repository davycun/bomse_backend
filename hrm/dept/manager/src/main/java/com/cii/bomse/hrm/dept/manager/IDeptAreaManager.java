package com.cii.bomse.hrm.dept.manager;

import com.cii.bomse.hrm.dept.entity.DeptAreaEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

public interface IDeptAreaManager extends IManager<DeptAreaEntity> {

    /*通过部门ID查询*/
    List<DeptAreaEntity> findByDeptId(Long deptId);

    /**
     * @description
     * 查找部门规划的城市ID
     * @author david·cun
     * @param
     * @return
     * @date 2019-12-31 11:23
     * @since 1.0
     */
    List<Long> findDeptCityId(Long deptId);

    /**
     * @description
     * 找到部门规划的区域ID
     * @author david·cun
     * @param
     * @return
     * @date 2019-12-31 11:23
     * @since 1.0
     */
    List<Long> findDeptRegionId(Long deptId);

    /**
     * @description
     * 找到部门规划的街道ID
     * @author david·cun
     * @param
     * @return
     * @date 2019-12-31 11:23
     * @since 1.0
     */
    List<Long> findDeptStreetId(Long deptId);
    /**
     * @description
     * 找到部门规划的社区
     * @author david·cun
     * @param
     * @return
     * @date 2019-12-31 11:22
     * @since 1.0
     */
    List<Long> findDeptCommunityId(Long deptId);

    public List<Long> findAreaIds(Long deptId, String areaType);



}
