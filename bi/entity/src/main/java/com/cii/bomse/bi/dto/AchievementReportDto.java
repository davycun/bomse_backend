package com.cii.bomse.bi.dto;

import com.cii.bomse.bi.entity.AchievementReportEntity;

import java.util.Date;

public class AchievementReportDto extends AchievementReportEntity {

    private Date startTime;
    private Date endTime;
    private boolean reload = false;

    public boolean getReload() {
        return reload;
    }

    public void setReload(boolean reload) {
        this.reload = reload;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
