package com.cii.bomse.hrm.emp.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-08 10:48
 * @since 1.0
 */
public class EmployeeQuitEntity extends BaseEntity {

    /*员工ID*/
    @NotNull(message = "员工ID不能为空")
    private Long empId;
    /*离职人员姓名*/
    private String empName;
    /*离职员工所在部门ID*/
    private Long empDeptId;
    private String empDeptName;
    /*入职日期*/
    private Date enterDate;
    /*离职日期*/
    @NotNull(message = "离职日期不能为空")
    private Date quitDate;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(Long empDeptId) {
        this.empDeptId = empDeptId;
    }

    public String getEmpDeptName() {
        return empDeptName;
    }

    public void setEmpDeptName(String empDeptName) {
        this.empDeptName = empDeptName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }
}
