package com.cii.bomse.hrm.emp.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-08 10:41
 * @since 1.0
 */
public class EmployeeTransferEntity extends BaseEntity {

    /*员工ID*/
    @NotNull(message = "异动员工ID不能为空")
    private Long empId;
    /*异动人员姓名*/
    @NotNull(message = "异动员工姓名不能为空")
    private String empName;
    /*异动日期*/
    private Date transferDate;
    /*原部门ID*/
    private Long fromDeptId;
    /*原部门名称*/
    private String fromDeptName;
    /*异动后部门ID*/
    @NotNull(message = "异动后部门Id不能为空")
    private Long toDeptId;
    /*异动后部门名称*/
    @NotNull(message = "异动后部门名称不能为空")
    private String toDeptName;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Long getFromDeptId() {
        return fromDeptId;
    }

    public void setFromDeptId(Long fromDeptId) {
        this.fromDeptId = fromDeptId;
    }

    public String getFromDeptName() {
        return fromDeptName;
    }

    public void setFromDeptName(String fromDeptName) {
        this.fromDeptName = fromDeptName;
    }

    public Long getToDeptId() {
        return toDeptId;
    }

    public void setToDeptId(Long toDeptId) {
        this.toDeptId = toDeptId;
    }

    public String getToDeptName() {
        return toDeptName;
    }

    public void setToDeptName(String toDeptName) {
        this.toDeptName = toDeptName;
    }
}
