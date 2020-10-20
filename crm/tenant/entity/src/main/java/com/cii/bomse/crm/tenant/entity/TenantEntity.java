package com.cii.bomse.crm.tenant.entity;

import com.cii.bomse.common.dictionary.Industry;
import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.tenant.dictionary.TenantStatus;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-24 14:07
 * @since 1.0
 */
public class TenantEntity extends BaseEntity {

    /**
     * 租户姓名
     */
    @NotNull(message = "用户姓名不能为空")
    private String tntName;
    /**
     * 租户电话
     */
    @Pattern(regexp = Constants.phoneRegexp,message = "手机格式错误")
    private String tntPhone;
    /**
     * 租户性别
     */
    private String tntSex;
    @NotGenerate
    private String tntSexName;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 租户行业
     * @see Industry
     */
    private String industry;
    /**租户行业名称*/
    @NotGenerate
    private String industryName;
    /**
     * 租户做什么的
     */
    private String product;
    /**
     * 租赁面积
     */
    private Float leaseAcreage;
    /**
     * 租赁结束日期
     */
    private Date leaseTimeEnd;

    /**租户租住园区ID*/
    private Long parkId;
    /**租户租住楼栋ID*/
    private Long buildingId;
    /**租户租住的楼层ID*/
    private Long floorId;

    /**
     * 租赁的位置
     */
    private Long cityId;
    private String cityName;
    private Long regionId;
    private String regionName;
    private Long streetId;
    private String streetName;
    private Long communityId;
    private String communityName;
    private String address;
    /**内部地址：A栋第一层*/
    private String innerAddress;
    /**
     * 租户状态
     * @see com.cii.bomse.crm.tenant.dictionary.TenantStatus
     */
    private String tntStatus;
    @NotGenerate
    private String tntStatusName;
    /**最后跟进时间*/
    private Date lastFollowupTime;
    /**未跟进天数*/
    @NotGenerate
    private Integer noFollowupDay;
    /**跟进次数*/
    private Integer followupCount;

    /**下一次联系时间*/
    private Date nextContactTime;

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }

    public Date getLastFollowupTime() {
        return lastFollowupTime;
    }

    public void setLastFollowupTime(Date lastFollowupTime) {
        this.lastFollowupTime = lastFollowupTime;
    }

    public Integer getNoFollowupDay() {
        if (null == lastFollowupTime) {
            return 0;
        }
        Date now = Calendar.getInstance().getTime();
        long ct = now.getTime() - lastFollowupTime.getTime();
        int t = (int) (ct / 1000 / 60 / 60 / 24);
        return t;
    }

    public void setNoFollowupDay(Integer noFollowupDay) {
        this.noFollowupDay = noFollowupDay;
    }

    public Integer getFollowupCount() {
        return followupCount;
    }

    public void setFollowupCount(Integer followupCount) {
        this.followupCount = followupCount;
    }

    public String getInnerAddress() {
        return innerAddress;
    }

    public void setInnerAddress(String innerAddress) {
        this.innerAddress = innerAddress;
    }

    public String getIndustryName() {
        return DictionaryStorage.get(Industry.class.getName(),industry).getName();
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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

    public String getTntStatus() {
        return tntStatus;
    }

    public void setTntStatus(String tntStatus) {
        this.tntStatus = tntStatus;
    }

    public String getTntStatusName() {
        return DictionaryStorage.get(TenantStatus.class.getName(),tntStatus).getName();
    }

    public void setTntStatusName(String tntStatusName) {
        this.tntStatusName = tntStatusName;
    }

    public String getTntName() {
        return tntName;
    }

    public void setTntName(String tntName) {
        this.tntName = tntName;
    }

    public String getTntPhone() {
        return tntPhone;
    }

    public void setTntPhone(String tntPhone) {
        this.tntPhone = tntPhone;
    }

    public String getTntSex() {
        return tntSex;
    }

    public void setTntSex(String tntSex) {
        this.tntSex = tntSex;
    }

    public String getTntSexName() {
        return DictionaryStorage.get(SexType.class.getName(), tntSex).getName();
    }

    public void setTntSexName(String tntSexName) {
        this.tntSexName = tntSexName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getLeaseAcreage() {
        return leaseAcreage;
    }

    public void setLeaseAcreage(Float leaseAcreage) {
        this.leaseAcreage = leaseAcreage;
    }

    public Date getLeaseTimeEnd() {
        return leaseTimeEnd;
    }

    public void setLeaseTimeEnd(Date leaseTimeEnd) {
        this.leaseTimeEnd = leaseTimeEnd;
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
}
