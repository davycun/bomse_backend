package com.cii.bomse.house.base.entity;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2020-01-06 11:37
 * @since 1.0
 */
public class ParkOwnerRelationEntity extends BaseEntity {

    /*园区ID*/
    private Long parkId;
    /*业主ID*/
    private Long houseOwnerId;

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getHouseOwnerId() {
        return houseOwnerId;
    }

    public void setHouseOwnerId(Long houseOwnerId) {
        this.houseOwnerId = houseOwnerId;
    }
}