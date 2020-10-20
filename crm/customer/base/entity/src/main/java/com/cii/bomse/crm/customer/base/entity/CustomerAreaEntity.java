package com.cii.bomse.crm.customer.base.entity;

import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;

/**
 * @description 客户需求区域信息
 * @auth david·cun
 * @date 2019-10-22 11:36
 * @since 1.0
 */
public class CustomerAreaEntity extends BaseEntity {

    /*客户ID*/
    private Long cusId;
    /*城市ID*/
    private Long cityId;
    private String cityName;
    /*区域ID*/
    private Long regionId;
    private String regionName;
    /*街道ID*/
    private Long streetId;
    private String streetName;
    /*社区ID*/
    private Long communityId;
    private String communityName;

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getNameString() {
        StringBuffer sb = new StringBuffer();
        sb.append(ObjectUtils.isNotEmpty(cityName) ? cityName : "");
        sb.append(ObjectUtils.isNotEmpty(regionName) ? regionName : "");
        sb.append(ObjectUtils.isNotEmpty(streetName) ? streetName : "");
        sb.append(ObjectUtils.isNotEmpty(communityName) ? communityName : "");
        return sb.toString();
    }

    public String getIdString() {
        StringBuffer sb = new StringBuffer();
        sb.append(ObjectUtils.isNotEmpty(cityId) ? cityId.toString(): "");
        sb.append(ObjectUtils.isNotEmpty(regionId) ? "," + regionId.toString() : "");
        sb.append(ObjectUtils.isNotEmpty(streetId) ? "," + streetId.toString() : "");
        sb.append(ObjectUtils.isNotEmpty(communityId) ? "," + communityId.toString() : "");
        return sb.toString();
    }
}
