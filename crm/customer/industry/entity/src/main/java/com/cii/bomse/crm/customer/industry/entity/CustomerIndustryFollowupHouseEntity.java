package com.cii.bomse.crm.customer.industry.entity;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-27 22:25
 * @since 1.0
 */
public class CustomerIndustryFollowupHouseEntity extends BaseEntity {

    /**看房客户ID*/
    private Long cusId;
    /**跟进ID*/
    private Long followupId;
    /**园区ID*/
    private Long parkId;
    /**建筑ID*/
    private Long buildingId;
    /**楼层ID*/
    private Long floorId;
    /**房源位置*/
    private String address;

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public Long getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Long followupId) {
        this.followupId = followupId;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
