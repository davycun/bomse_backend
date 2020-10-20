package com.cii.bomse.house.land.entity;

import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.house.base.dictionary.AcreageUnit;
import com.cii.bomse.house.base.dictionary.BusinessType;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-23 10:50
 * @since 1.0
 */
public class BlankLandEntity extends BaseEntity {

    private Long cityId;
    private String cityName;
    private Long regionId;
    private String regionName;
    private Long streetId;
    private String streetName;
    private Long communityId;
    private String communityName;
    /**详细地址*/
    private String address;
    /**经度*/
    protected Double longitude;
    /**纬度*/
    protected Double latitude;

    /**
     * 交易类型
     * @see com.cii.bomse.house.base.dictionary.BusinessType
     */
    private String businessType;
    @NotGenerate
    private String businessTypeName;

    /**
     * 面积，注意新增的时候需要是平方米
     */
    private Float acreage;
    private String acreageUnit;
    @NotGenerate
    private String acreageUnitName;

    /**出租价格*/
    private Float leasePrice;
    /**
     * @see com.cii.bomse.common.dictionary.IndustryPriceUnitType
     */
    private String leasePriceUnit;
    @NotGenerate
    private String leasePriceUnitName;
    /**出售价格*/
    private Float sellPrice;

    private String landImages;
    @NotGenerate
    private String[] landImageList;

    //===联系人信息==
    private String contactName;
    private String contactPhone;
    private String contactSex;
    private String contactSexName;

    //===房源SEO相关，官网
    /**房源标题*/
    private String title;
    /**房源关键字*/
    private String keywords;
    /**房源描述*/
    private String description;
    /**内容里面的标题*/
    private String slogan;
    /**内容里面的副标题*/
    private String chiefSlogan;

    public String getContactSexName() {
        return DictionaryStorage.get(SexType.class.getName(),contactSex).getName();
    }

    public void setContactSexName(String contactSexName) {
        this.contactSexName = contactSexName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactSex() {
        return contactSex;
    }

    public void setContactSex(String contactSex) {
        this.contactSex = contactSex;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAcreageUnit() {
        return acreageUnit;
    }

    public void setAcreageUnit(String acreageUnit) {
        this.acreageUnit = acreageUnit;
    }

    public String getAcreageUnitName() {
        return DictionaryStorage.get(AcreageUnit.class.getName(),acreageUnit).getName();
    }

    public void setAcreageUnitName(String acreageUnitName) {
        this.acreageUnitName = acreageUnitName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTypeName() {
        return DictionaryStorage.get(BusinessType.class.getName(),businessType).getName();
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public Float getAcreage() {
        return acreage;
    }

    public void setAcreage(Float acreage) {
        this.acreage = acreage;
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

    public String getLeasePriceUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(),leasePriceUnit).getName();
    }

    public void setLeasePriceUnitName(String leasePriceUnitName) {
        this.leasePriceUnitName = leasePriceUnitName;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getLandImages() {

        if (ObjectUtils.isEmpty(landImages) && ObjectUtils.isNotEmpty(landImageList)){
            landImages = StringUtils.join(landImageList);
        }
        return landImages;
    }

    public void setLandImages(String landImages) {
        this.landImages = landImages;
    }

    public String[] getLandImageList() {

        if (ObjectUtils.isEmpty(landImageList) && ObjectUtils.isNotEmpty(landImages)){
            landImageList = landImages.split(",");
        }
        return landImageList;
    }

    public void setLandImageList(String[] landImageList) {
        this.landImageList = landImageList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getChiefSlogan() {
        return chiefSlogan;
    }

    public void setChiefSlogan(String chiefSlogan) {
        this.chiefSlogan = chiefSlogan;
    }
}
