package com.cii.bomse.crm.customer.base.entity;

import com.cii.bomse.crm.customer.base.dictionary.CustomerFollowupType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 15:46
 * @since 1.0
 */
public class BaseCustomerFollowupEntity extends BaseEntity {

    /*客户编码*/
    @NotNull(message = "客户ID必填")
    protected Long cusId;
    /*客户跟进类型*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerFollowupType */
    @NotNull(message = "跟进类型必填")
    protected String followupType;
    @NotGenerate
    protected String followupTypeName;
    /*跟进内容*/
    @NotNull(message = "跟进内容必填")
    protected String followupContent;

    protected String followupImages;
    @NotGenerate
    protected String[] followupImagesList;

    /**下一次联系时间，用来设置客户对应字段*/
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

    public String getFollowupImages() {

        if (ObjectUtils.isEmpty(followupImages) && ObjectUtils.isNotEmpty(followupImagesList)){
            followupImages = StringUtils.join(followupImagesList,",");
        }

        return followupImages;
    }

    public void setFollowupImages(String followupImages) {
        this.followupImages = followupImages;
    }

    public String[] getFollowupImagesList() {
        if (ObjectUtils.isEmpty(followupImagesList) && ObjectUtils.isNotEmpty(followupImages)){
            followupImagesList = followupImages.split(",");
        }
        return followupImagesList;
    }

    public void setFollowupImagesList(String[] followupImagesList) {
        this.followupImagesList = followupImagesList;
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getFollowupTypeName() {
        return DictionaryStorage.get(CustomerFollowupType.class.getName(),followupType).getName();
    }

    public void setFollowupTypeName(String followupTypeName) {
        this.followupTypeName = followupTypeName;
    }

    public String getFollowupContent() {
        return followupContent;
    }

    public void setFollowupContent(String followupContent) {
        this.followupContent = followupContent;
    }
}
