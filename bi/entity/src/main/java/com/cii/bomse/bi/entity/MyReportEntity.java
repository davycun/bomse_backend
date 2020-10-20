package com.cii.bomse.bi.entity;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2020-05-17 21:44
 * @since 1.0
 */
public class MyReportEntity extends BaseEntity {

    /**客户量*/
    private float customerCount = 0f;
    /**园区数量*/
    private float parkCount = 0f;
    /**楼层量*/
    private float floorCount = 0f;
    /**订单量*/
    private float orderCount = 0f;
    /**分成金额*/
    private float divideAmount = 0f;

    public float getParkCount() {
        return parkCount;
    }

    public void setParkCount(float parkCount) {
        this.parkCount = parkCount;
    }

    public float getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(float customerCount) {
        this.customerCount = customerCount;
    }

    public float getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(float floorCount) {
        this.floorCount = floorCount;
    }

    public float getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(float orderCount) {
        this.orderCount = orderCount;
    }

    public float getDivideAmount() {
        return divideAmount;
    }

    public void setDivideAmount(float divideAmount) {
        this.divideAmount = divideAmount;
    }
}
