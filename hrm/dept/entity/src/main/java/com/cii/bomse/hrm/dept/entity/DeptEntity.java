package com.cii.bomse.hrm.dept.entity;

import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * @description 部门实体
 * @auth david·cun
 * @date 2019-04-10 11:41
 * @since 1.0
 */
public class DeptEntity extends BaseEntity implements Comparable<DeptEntity> {


    private String deptName;

    private Long parentId;

    private Long leaderId;

    private String leaderName;

    private String address;
    /*部门排序*/
    private Integer sort = Integer.valueOf(0);

    /*子部门*/
    @NotGenerate
    private List<DeptEntity> children;

    /*删除/撤销日期*/
    private Date deleteDate;

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<DeptEntity> getChildren() {
        return children;
    }

    public void setChildren(List<DeptEntity> children) {
        this.children = children;
    }

    @Override
    public int compareTo(DeptEntity o) {

        //当前对象小，就返回负整数，等于就返回0，大于就返回正整数
        if (ObjectUtils.isNotEmpty(o)){
            return this.getSort() - o.getSort();
        }
        return 1;
    }
}
