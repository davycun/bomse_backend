package com.cii.bomse.base.news.dto;

import com.cii.bomse.base.news.entity.NewsEntity;

import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-23 17:52
 * @since 1.0
 */
public class NewsDto extends NewsEntity {

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
