package com.cii.bomse.hrm.emp.dto;

import com.cii.bomse.hrm.emp.entity.EmployeeEntity;

import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-19 11:15
 * @since 1.0
 */
public class EmployeeDto extends EmployeeEntity {

    private Date enterDateStart;
    private Date enterDateEnd;
    private Date graduationDateStart;
    private Date graduationDateEnd;
    private Date birthdayStart;
    private Date birthdayEnd;
    private Date regularDateStart;
    private Date regularDateEnd;

    /**修改手机号，老手机号码*/
    private String oldPhone;
    /**修改手机号，新手机号码*/
    private String newPhone;

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public Date getEnterDateStart() {
        return enterDateStart;
    }

    public void setEnterDateStart(Date enterDateStart) {
        this.enterDateStart = enterDateStart;
    }

    public Date getEnterDateEnd() {
        return enterDateEnd;
    }

    public void setEnterDateEnd(Date enterDateEnd) {
        this.enterDateEnd = enterDateEnd;
    }

    public Date getGraduationDateStart() {
        return graduationDateStart;
    }

    public void setGraduationDateStart(Date graduationDateStart) {
        this.graduationDateStart = graduationDateStart;
    }

    public Date getGraduationDateEnd() {
        return graduationDateEnd;
    }

    public void setGraduationDateEnd(Date graduationDateEnd) {
        this.graduationDateEnd = graduationDateEnd;
    }

    public Date getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Date getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public Date getRegularDateStart() {
        return regularDateStart;
    }

    public void setRegularDateStart(Date regularDateStart) {
        this.regularDateStart = regularDateStart;
    }

    public Date getRegularDateEnd() {
        return regularDateEnd;
    }

    public void setRegularDateEnd(Date regularDateEnd) {
        this.regularDateEnd = regularDateEnd;
    }
}
