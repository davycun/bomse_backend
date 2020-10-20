package com.cii.bomse.crm.tenant.dto;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.ciiframework.utils.ObjectUtils;

import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.Date;

public class TenantDto extends TenantEntity {

    private Float leaseAcreageStart;
    private Float leaseAcreageEnd;

    private Date leaseTimeEndStart;
    private Date leaseTimeEndEnd;

    private Date createTimeStart;
    private Date createTimeEnd;

    /**修改号码，老号码*/
    @Pattern(regexp = Constants.phoneRegexp,message = "老号码格式错误")
    private String oldPhone;
    /**修改号码，新号码*/
    @Pattern(regexp = Constants.phoneRegexp,message = "新号码格式错误")
    private String newPhone;

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

    public Boolean getWaitContact() {
        return waitContact;
    }

    public void setWaitContact(Boolean waitContact) {
        this.waitContact = waitContact;
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

    public Float getLeaseAcreageStart() {
        return leaseAcreageStart;
    }

    public void setLeaseAcreageStart(Float leaseAcreageStart) {
        this.leaseAcreageStart = leaseAcreageStart;
    }

    public Float getLeaseAcreageEnd() {
        return leaseAcreageEnd;
    }

    public void setLeaseAcreageEnd(Float leaseAcreageEnd) {
        this.leaseAcreageEnd = leaseAcreageEnd;
    }

    public Date getLeaseTimeEndStart() {
        return leaseTimeEndStart;
    }

    public void setLeaseTimeEndStart(Date leaseTimeEndStart) {
        this.leaseTimeEndStart = leaseTimeEndStart;
    }

    public Date getLeaseTimeEndEnd() {
        return leaseTimeEndEnd;
    }

    public void setLeaseTimeEndEnd(Date leaseTimeEndEnd) {
        this.leaseTimeEndEnd = leaseTimeEndEnd;
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
    
}
