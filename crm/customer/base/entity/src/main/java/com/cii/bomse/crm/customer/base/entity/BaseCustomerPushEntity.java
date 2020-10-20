package com.cii.bomse.crm.customer.base.entity;

import com.cii.bomse.crm.customer.base.dictionary.CustomerPushStatus;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 18:35
 * @since 1.0
 */
public class BaseCustomerPushEntity extends BaseEntity {

    /*客户ID*/
    protected Long cusId;
    /*推送者ID*/
    protected Long pushUserId;
    /*推送者姓名*/
    protected String pushUserName;
    /*推送部门ID*/
    protected Long pushDeptId;
    /*推送部门名称*/
    protected String pushDeptName;
    /*接受者ID*/
    protected Long receiveUserId;
    /*接受者姓名*/
    protected String receiveUserName;
    /*接受者部门ID*/
    protected Long receiveDeptId;
    /*接受者部门名称*/
    protected String receiveDeptName;

    /*客户推送状态*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerPushStatus*/

    protected String pushStatus;
    protected String pushStatusName;
    /*处理时间，接收或者拒绝*/
    protected Date processTime;
    /*推送备注*/
    protected String pushRemark;
    /*拒绝原因*/
    protected String refuseReason;

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Date processTime) {
        this.processTime = processTime;
    }

    public String getPushRemark() {
        return pushRemark;
    }

    public void setPushRemark(String pushRemark) {
        this.pushRemark = pushRemark;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(String pushStatus) {
        this.pushStatus = pushStatus;
    }

    public String getPushStatusName() {
        return DictionaryStorage.get(CustomerPushStatus.class.getName(),pushStatus).getName();
    }

    public void setPushStatusName(String pushStatusName) {
        this.pushStatusName = pushStatusName;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public Long getPushDeptId() {
        return pushDeptId;
    }

    public void setPushDeptId(Long pushDeptId) {
        this.pushDeptId = pushDeptId;
    }

    public String getPushDeptName() {
        return pushDeptName;
    }

    public void setPushDeptName(String pushDeptName) {
        this.pushDeptName = pushDeptName;
    }

    public Long getReceiveDeptId() {
        return receiveDeptId;
    }

    public void setReceiveDeptId(Long receiveDeptId) {
        this.receiveDeptId = receiveDeptId;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public Long getPushUserId() {
        return pushUserId;
    }

    public void setPushUserId(Long pushUserId) {
        this.pushUserId = pushUserId;
    }

    public String getPushUserName() {
        return pushUserName;
    }

    public void setPushUserName(String pushUserName) {
        this.pushUserName = pushUserName;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }
}
