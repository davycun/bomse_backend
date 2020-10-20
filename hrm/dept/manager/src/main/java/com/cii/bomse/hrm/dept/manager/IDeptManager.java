package com.cii.bomse.hrm.dept.manager;

import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 14:09
 */
public interface IDeptManager extends IManager<DeptEntity> {

    /**
     * 树形返回查找的部门结构
     * @param param
     * @return
     */
    public List<DeptEntity> findByMapToTree(Map<String,Object> param);

    /**
     * @description 通过数据橘色编码查询部门
     * @author david·cun
     * @param
     * @return
     * @date 2019-06-25 13:45
     * @since 1.0
     */
    public List<DeptEntity> findByRoleToList(Long dataRoleId);

    /**
     * @description 通过用户编码查询，给用户分配的数据部门
     * @author david·cun
     * @param
     * @return
     * @date 2019-06-25 13:45
     * @since 1.0
     */
    public List<DeptEntity> findByUserToList(Long userId);

    /**
     * @description 查找我有权限的所有部门，返回list集合，包括数据权限及管理部门权限
     * @auth david·cun
     * @date 2019-04-10 11:47
     * @since 1.0
     */
    List<DeptEntity> findUserAuthDeptToList(Long userId);

    /**
     * @description 查找我有权限的所有部门，返回树形结构，包括数据权限及管理部门权限
     * @auth david·cun
     * @date 2019-04-10 11:47
     * @since 1.0
     */
    List<DeptEntity> findUserAuthDeptToTree(Long userId);

    /**
     * @description
     * 找出用户有权限的部门ID
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-10 11:38
     * @since 1.0
     */
    List<Long> findUserAuthDeptId(Long userId);

    /**
     * @description
     * 查找指定人员作为领导的所有部门及子部门数据，并且返回树形结构
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 17:04
     * @since 1.0
     */
    List<DeptEntity> findLeaderDeptToTree(Long userId);
    List<DeptEntity> findLeaderDeptToList(Long userId);

    /**
     * @description
     * 找到作为领导部门的所有部门或者子部门的ID
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 17:05
     * @since 1.0
     */
    List<Long> findLeaderDeptId(Long userId);



    /**
     * 把部门列表变为树形结构
     * @param list
     * @return
     */
    public List<DeptEntity> tree(List<DeptEntity> list);

    /**
     * @description 查找某个部门及所有子部门
     * @auth david·cun
     * @date 2019-04-10 11:47
     * @since 1.0
     */
    DeptEntity findByParentToTree(Long parentId);

    /**
     * @description 查找某个部门及所有子部门
     * @auth david·cun
     * @date 2019-04-10 11:47
     * @since 1.0
     */
    List<DeptEntity> findByParentToList(Long parentId);


    List<DeptEntity> treeToList(List<DeptEntity> list);



}
