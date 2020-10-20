package com.cii.bomse.house.base.entity;

import com.cii.bomse.house.base.dictionary.HouseFollowupType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-11 17:16
 * @since 1.0
 */
public class BaseHouseFollowupEntity extends BaseEntity {

    /*客户编码*/
    @NotNull(message = "客户ID必填")
    protected Long parkId;
    /*客户跟进类型*/
    /**@see HouseFollowupType */
    @NotNull(message = "跟进类型必填")
    protected String followupType;
    @NotGenerate
    protected String followupTypeName;
    /*跟进内容*/
    @NotNull(message = "跟进内容必填")
    protected String followupContent;

    protected String followupImages;

    protected String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getFollowupTypeName() {
        return DictionaryStorage.get(HouseFollowupType.class.getName(),followupType).getName();
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

    public String getFollowupImages() {
        return followupImages;
    }

    public void setFollowupImages(String followupImages) {
        this.followupImages = followupImages;
    }
}
