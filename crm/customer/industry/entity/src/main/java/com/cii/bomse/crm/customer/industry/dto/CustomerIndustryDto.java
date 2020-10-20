package com.cii.bomse.crm.customer.industry.dto;


import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerIndustryDto extends CustomerIndustryEntity {

    /*创建时间开始*/
    private Date createTimeStart;
    /*创建时间*/
    private Date createTimeEnd;
    /*旧电话号码*/
    private String oldCusPhone;
    /*新手机号*/
    private String newCusPhone;

    private Date nextContactTimeStart;
    private Date nextContactTimeEnd;

    private List<String> cusStatuses;

    private String notCusStatus;

    /**
     * 未跟进天数大于
     */
    private Integer noFollowupDayStart;
    /**
     * 未跟进天数小于
     */
    private Integer noFollowupDayEnd;

    private Date lastFollowupTimeStart;

    private Date lastFollowupTimeEnd;

    /**查询待联系的，跟进时间小于下次联系时间的跟进中的客户*/
    private Boolean waitContact;
    /**查询待上架的客户，两个月内到期，但是5天内却没有跟进过的客户*/
    private Boolean waitUp;

    /**需求面积大于*/
    private Float needAcreageStart;
    /**需求面积小于*/
    private Float needAcreageEnd;

    public Float getNeedAcreageStart() {
        return needAcreageStart;
    }

    public void setNeedAcreageStart(Float needAcreageStart) {
        this.needAcreageStart = needAcreageStart;
    }

    public Float getNeedAcreageEnd() {
        return needAcreageEnd;
    }

    public void setNeedAcreageEnd(Float needAcreageEnd) {
        this.needAcreageEnd = needAcreageEnd;
    }

    public Boolean getWaitContact() {
        return waitContact;
    }

    public void setWaitContact(Boolean waitContact) {
        this.waitContact = waitContact;
    }

    public Boolean getWaitUp() {
        return waitUp;
    }

    public void setWaitUp(Boolean waitUp) {
        this.waitUp = waitUp;
    }

    public Date getLastFollowupTimeStart() {
        if (ObjectUtils.isEmpty(lastFollowupTimeStart) && noFollowupDayEnd != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - noFollowupDayEnd);
            lastFollowupTimeStart =calendar.getTime();
        }
        return lastFollowupTimeStart;
    }

    public void setLastFollowupTimeStart(Date lastFollowupTimeStart) {
        this.lastFollowupTimeStart = lastFollowupTimeStart;
    }

    public Date getLastFollowupTimeEnd() {

        if (ObjectUtils.isEmpty(lastFollowupTimeEnd) && noFollowupDayStart != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - noFollowupDayStart);
            lastFollowupTimeEnd =calendar.getTime();
        }

        return lastFollowupTimeEnd;
    }

    public void setLastFollowupTimeEnd(Date lastFollowupTimeEnd) {
        this.lastFollowupTimeEnd = lastFollowupTimeEnd;
    }

    public Integer getNoFollowupDayStart() {
        return noFollowupDayStart;
    }

    public void setNoFollowupDayStart(Integer noFollowupDayStart) {
        this.noFollowupDayStart = noFollowupDayStart;
    }

    public Integer getNoFollowupDayEnd() {
        return noFollowupDayEnd;
    }

    public void setNoFollowupDayEnd(Integer noFollowupDayEnd) {
        this.noFollowupDayEnd = noFollowupDayEnd;
    }

    public String getNotCusStatus() {
        return notCusStatus;
    }

    public void setNotCusStatus(String notCusStatus) {
        this.notCusStatus = notCusStatus;
    }

    public List<String> getCusStatuses() {
        return cusStatuses;
    }

    public void setCusStatuses(List<String> cusStatuses) {
        this.cusStatuses = cusStatuses;
    }

    public Date getNextContactTimeStart() {
        return nextContactTimeStart;
    }

    public void setNextContactTimeStart(Date nextContactTimeStart) {
        this.nextContactTimeStart = nextContactTimeStart;
    }

    public Date getNextContactTimeEnd() {
        return nextContactTimeEnd;
    }

    public void setNextContactTimeEnd(Date nextContactTimeEnd) {
        this.nextContactTimeEnd = nextContactTimeEnd;
    }

    public String getOldCusPhone() {
        return oldCusPhone;
    }

    public void setOldCusPhone(String oldCusPhone) {
        this.oldCusPhone = oldCusPhone;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getNewCusPhone() {
        return newCusPhone;
    }

    public void setNewCusPhone(String newCusPhone) {
        this.newCusPhone = newCusPhone;
    }
}
