package com.cii.bomse.crm.parttimer.entity;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.parttimer.dictionary.FromType;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-28 08:56
 * @since 1.0
 */
public class PartTimerEntity extends BaseEntity {

    /*兼职电话*/
    @Pattern(regexp = Constants.phoneRegexp)
    private String ptPhone;
    /*兼职姓名*/
    @NotNull(message = "姓名必填")
    private String ptName;
    /*性别*/
    /**@see SexType*/
    @NotNull(message = "性别必填")
    private String sex;
    private String sexName;
    /*岗位*/
    @NotNull(message = "岗位必填")
    private String post;
    /*单位/公司*/
    @NotNull(message = "单位/公司必填")
    private String company;

    /*来源*/
    /**@see FromType*/
    private String fromType;
    private String fromTypeName;

    /*职业*/
    private String job;

    /*联系地址*/
    private Long cityId;
    private String cityName;
    private Long regionId;
    private String regionName;
    @NotNull(message = "市区街道必填")
    private Long streetId;
    private String streetName;
    private String address;
    /**从联系地址自动拼接*/
    @NotGenerate
    private String detailAddress;


    /*==统计记录信息=======================*/
    /*推荐客户数量*/
    private Integer recommendCount;
    /*最后推荐客户的时间*/
    private Date lastRecommendTime;

    public String getDetailAddress() {
        if (ObjectUtils.isEmpty(detailAddress)){
            StringBuffer sb = new StringBuffer();
            if (ObjectUtils.isNotEmpty(cityName)){
                sb.append(cityName);
            }
            if (ObjectUtils.isNotEmpty(regionName)){
                sb.append(regionName);
            }
            if (ObjectUtils.isNotEmpty(streetName)){
                sb.append(streetName);
            }
            if (ObjectUtils.isNotEmpty(address)){
                sb.append(address);
            }
            detailAddress = sb.toString();

        }
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Integer recommendCount) {
        this.recommendCount = recommendCount;
    }

    public Date getLastRecommendTime() {
        return lastRecommendTime;
    }

    public void setLastRecommendTime(Date lastRecommendTime) {
        this.lastRecommendTime = lastRecommendTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return DictionaryStorage.get(SexType.class.getName(),sex).getName();
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getPtPhone() {
        return ptPhone;
    }

    public void setPtPhone(String ptPhone) {
        this.ptPhone = ptPhone;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getFromTypeName() {
        return DictionaryStorage.get(FromType.class.getName(),fromType).getName();
    }

    public void setFromTypeName(String fromTypeName) {
        this.fromTypeName = fromTypeName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
