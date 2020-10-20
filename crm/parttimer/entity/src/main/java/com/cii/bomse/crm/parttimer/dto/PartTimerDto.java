package com.cii.bomse.crm.parttimer.dto;

import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;

import java.util.Date;

public class PartTimerDto extends PartTimerEntity {
    private Date createTimeStart;
    private Date createTimeEnd;

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
