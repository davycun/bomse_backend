package com.cii.bomse.crm.parttimer.entity;

import com.cii.bomse.crm.parttimer.dictionary.PartTimerFollowupType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-04 15:42
 * @since 1.0
 */
public class PartTimerFollowupEntity extends BaseEntity {

    /*兼职ID*/
    private Long ptId;
    /*兼职类型*/
    /**@see PartTimerFollowupType*/
    private String ptFollowupType;
    private String ptFollowupTypeName;
    /*跟进类型*/
    private String content;

    public Long getPtId() {
        return ptId;
    }

    public void setPtId(Long ptId) {
        this.ptId = ptId;
    }

    public String getPtFollowupType() {
        return ptFollowupType;
    }

    public void setPtFollowupType(String ptFollowupType) {
        this.ptFollowupType = ptFollowupType;
    }

    public String getPtFollowupTypeName() {
        return DictionaryStorage.get(PartTimerFollowupType.class.getName(),ptFollowupType).getName();
    }

    public void setPtFollowupTypeName(String ptFollowupTypeName) {
        this.ptFollowupTypeName = ptFollowupTypeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
