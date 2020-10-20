package com.cii.bomse.house.industry.dto;

import com.cii.bomse.house.industry.entity.FloorIndustryEntity;

import java.util.Date;
import java.util.List;

public class FloorIndustryDto extends FloorIndustryEntity {

    /*===园区查询条件==========*/
    private Long cityId;
    private Long regionId;
    private Long streetId;
    private Long communityId;
    private String address;

    /*===楼栋查询条件===========*/
    private String pkName;
    private String bdName;
    private String bdNameDesc;
    private String structureType;
    private String uploadType;

    /*===楼层查询条件================*/
    private Float leaseAcreageMinStart;
    private Float leaseAcreageMinEnd;
    /*最低可租面积*/
    private Float leaseAcreageStart;
    /*最高可租面积*/
    private Float leaseAcreageEnd;
    /*最低价格*/
    private Float priceStart;
    /*最高价格*/
    private Float priceEnd;
    /*最低层高*/
    private Float floorHeightStart;
    /*最低楼层*/
    private Integer floorNumberStart;
    /*最高楼层*/
    private Integer floorNumberEnd;

    private Date createTimeStart;
    private Date createTimeEnd;
    private Date enterTimeStart;
    private Date enterTimeEnd;

    /**@see com.cii.bomse.house.industry.dictionary.AdvantageType*/
    private List<String> advantageTypeList;


    public Float getFloorHeightStart() {
        return floorHeightStart;
    }

    public void setFloorHeightStart(Float floorHeightStart) {
        this.floorHeightStart = floorHeightStart;
    }

    public Integer getFloorNumberStart() {
        return floorNumberStart;
    }

    public void setFloorNumberStart(Integer floorNumberStart) {
        this.floorNumberStart = floorNumberStart;
    }

    public Integer getFloorNumberEnd() {
        return floorNumberEnd;
    }

    public void setFloorNumberEnd(Integer floorNumberEnd) {
        this.floorNumberEnd = floorNumberEnd;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Date getEnterTimeStart() {
        return enterTimeStart;
    }

    public void setEnterTimeStart(Date enterTimeStart) {
        this.enterTimeStart = enterTimeStart;
    }

    public Date getEnterTimeEnd() {
        return enterTimeEnd;
    }

    public void setEnterTimeEnd(Date enterTimeEnd) {
        this.enterTimeEnd = enterTimeEnd;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public String getBdNameDesc() {
        return bdNameDesc;
    }

    public void setBdNameDesc(String bdNameDesc) {
        this.bdNameDesc = bdNameDesc;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public List<String> getAdvantageTypeList() {
        return advantageTypeList;
    }

    public void setAdvantageTypeList(List<String> advantageTypeList) {
        this.advantageTypeList = advantageTypeList;
    }

    public Float getLeaseAcreageMinStart() {
        return leaseAcreageMinStart;
    }

    public void setLeaseAcreageMinStart(Float leaseAcreageMinStart) {
        this.leaseAcreageMinStart = leaseAcreageMinStart;
    }

    public Float getLeaseAcreageMinEnd() {
        return leaseAcreageMinEnd;
    }

    public void setLeaseAcreageMinEnd(Float leaseAcreageMinEnd) {
        this.leaseAcreageMinEnd = leaseAcreageMinEnd;
    }

    public Float getLeaseAcreageStart() {
        return leaseAcreageStart;
    }

    public void setLeaseAcreageStart(Float leaseAcreageStart) {
        this.leaseAcreageStart = leaseAcreageStart;
    }

    public Float getLeaseAcreageEnd() {
        return leaseAcreageEnd;
    }

    public void setLeaseAcreageEnd(Float leaseAcreageEnd) {
        this.leaseAcreageEnd = leaseAcreageEnd;
    }

    public Float getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Float priceStart) {
        this.priceStart = priceStart;
    }

    public Float getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Float priceEnd) {
        this.priceEnd = priceEnd;
    }
}
