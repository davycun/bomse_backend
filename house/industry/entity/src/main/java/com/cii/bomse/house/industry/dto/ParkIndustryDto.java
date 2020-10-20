package com.cii.bomse.house.industry.dto;

import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.ciiframework.utils.ObjectUtils;

import java.util.Calendar;
import java.util.Date;

public class ParkIndustryDto extends ParkIndustryEntity {

    private Float leaseAcreageMinStart;
    private Float leaseAcreageMinEnd;
    private Float leaseAcreageStart;
    private Float leaseAcreageEnd;
    private Float priceMinStart;
    private Float priceMinEnd;

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

    public Float getLeaseAcreageMinStart() {
        return leaseAcreageMinStart;
    }

    public void setLeaseAcreageMinStart(Float leaseAcreageMinStart) {
        this.leaseAcreageMinStart = leaseAcreageMinStart;
    }

    public Float getLeaseAcreageMinEnd() {
        return leaseAcreageMinEnd;
    }

    public void setLeaseAcreageMinEnd(Float leaseAcreageMinEnd) {
        this.leaseAcreageMinEnd = leaseAcreageMinEnd;
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

    public Float getPriceMinStart() {
        return priceMinStart;
    }

    public void setPriceMinStart(Float priceMinStart) {
        this.priceMinStart = priceMinStart;
    }

    public Float getPriceMinEnd() {
        return priceMinEnd;
    }

    public void setPriceMinEnd(Float priceMinEnd) {
        this.priceMinEnd = priceMinEnd;
    }
}
