package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * 一个客户成交可能对应多个楼层房源
 * @auth david·cun
 * @date 2020-01-09 16:15
 * @since 1.0
 */
public class OrderIndustryHouseEntity extends BaseEntity {
    /*订单ID*/
    private Long orderId;
    /*园区ID*/
    private Long parkId;
    /*建筑ID*/
    private Long buildingId;
    /*楼层ID*/
    private Long floorId;
    /*房源位置*/
    private Long cityId;
    private String cityName;
    /*区域*/
    private Long regionId;
    private String regionName;
    /*街道ID*/
    private Long streetId;
    private String streetName;
    /*社区ID*/
    private Long communityId;
    private String communityName;
    /*x详细地址*/
    private String address;
    private String bdName;
    private Integer floorNumber;

    /*租赁面积*/
    private Float leaseAcreage;
    /*租赁价格*/
    private Float leasePrice;
    /*租赁价格单位*/
    private String leasePriceUnit;
    @NotGenerate
    private String leasePriceUnitName;

    public String getLeasePriceUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(),leasePriceUnit).getName();
    }

    public void setLeasePriceUnitName(String leasePriceUnitName) {
        this.leasePriceUnitName = leasePriceUnitName;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getLeaseAcreage() {
        return leaseAcreage;
    }

    public void setLeaseAcreage(Float leaseAcreage) {
        this.leaseAcreage = leaseAcreage;
    }

    public Float getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(Float leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeasePriceUnit() {
        return leasePriceUnit;
    }

    public void setLeasePriceUnit(String leasePriceUnit) {
        this.leasePriceUnit = leasePriceUnit;
    }
}
