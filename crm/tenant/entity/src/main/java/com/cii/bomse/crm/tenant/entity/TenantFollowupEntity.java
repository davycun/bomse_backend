package com.cii.bomse.crm.tenant.entity;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerFollowupEntity;
import com.cii.bomse.crm.tenant.dictionary.TenantFollowupType;
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
 * @date 2020-04-01 13:57
 * @since 1.0
 */
public class TenantFollowupEntity extends BaseEntity {

    /*客户编码*/
    @NotNull(message = "租户ID必填")
    private Long tntId;
    /*客户跟进类型*/
    /**
     * @see com.cii.bomse.crm.tenant.dictionary.TenantFollowupType
     */
    @NotNull(message = "跟进类型必填")
    private String followupType;
    @NotGenerate
    private String followupTypeName;
    /*跟进内容*/
    @NotNull(message = "跟进内容必填")
    private String followupContent;

    private String followupImages;
    @NotGenerate
    private String[] followupImagesList;

    /**录入跟进的时候用来同时更新客户的下一次联系时间*/
    @NotGenerate
    private Date nextContactTime;

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

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Long getTntId() {
        return tntId;
    }

    public void setTntId(Long tntId) {
        this.tntId = tntId;
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getFollowupTypeName() {
        return DictionaryStorage.get(TenantFollowupType.class.getName(), followupType).getName();
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
