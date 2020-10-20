package com.cii.bomse.crm.customer.base.entity;

import com.cii.bomse.crm.customer.base.dictionary.CustomerDownReasonType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerUpDownType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 17:20
 * @since 1.0
 */
public class BaseCustomerUpDownEntity extends BaseEntity {
    /*客户编码*/
    @NotNull(message = "客户编码必填")
    protected Long cusId;
    /*上下架类型*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerUpDownType */
    @NotNull(message = "客户上下架类型必填")
    protected String upDownType;
    protected String upDownTypeName;
    /*下架原因*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerDownReasonType*/
    @NotNull(message = "下架原因必填")
    protected String downReason;
    protected String downReasonName;

    /*表示下一次可以上架的日期，下架之后下一次联系这个客户的时间*/
    @NotNull(message = "下一次联系时间必填")
    protected Date nextContactTime;

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getDownReasonName() {
        return DictionaryStorage.get(CustomerDownReasonType.class.getName(),downReason).getName();
    }

    public void setDownReasonName(String downReasonName) {
        this.downReasonName = downReasonName;
    }

    public String getUpDownType() {
        return upDownType;
    }

    public void setUpDownType(String upDownType) {
        this.upDownType = upDownType;
    }

    public String getUpDownTypeName() {
        return DictionaryStorage.get(CustomerUpDownType.class.getName(),upDownType).getName();
    }

    public void setUpDownTypeName(String upDownTypeName) {
        this.upDownTypeName = upDownTypeName;
    }

    public String getDownReason() {
        return downReason;
    }

    public void setDownReason(String downReason) {
        this.downReason = downReason;
    }
}
