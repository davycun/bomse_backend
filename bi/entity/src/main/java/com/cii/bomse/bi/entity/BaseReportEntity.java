package com.cii.bomse.bi.entity;

import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 16:14
 * @since 1.0
 */
public class BaseReportEntity extends BaseEntity {

    //统计一个维度用的名称
    protected String name;
    /*映射浮点型*/
    protected Float count=0f;

    protected String resultStatus = ResultStatus.Normal;

    protected String resultStatusName;

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }

    public String getResultStatusName() {
        return DictionaryStorage.get(ResultStatus.class.getName(),resultStatus).getName();
    }

    public void setResultStatusName(String resultStatusName) {
        this.resultStatusName = resultStatusName;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
