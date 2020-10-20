package com.cii.bomse.crm.customer.industry.entity;

import com.cii.bomse.common.dictionary.Industry;
import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerNeedLayerType;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.cii.bomse.crm.customer.base.entity.CustomerAreaEntity;
import com.cii.bomse.house.base.dictionary.FireDeviceType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-04-27 16:48
 * @since 1.0
 */
public class CustomerIndustryEntity extends BaseCustomerEntity {

    /*公司名*/
    private String company;
    /*所属行业*/
    /**
     * @see Industry
     */
    @NotNull(message = "客户行业必填")
    private String industry;
    @NotGenerate
    private String industryName;
    /*产品信息，客户是做什么的*/
    @NotNull(message = "客户产品信息必填")
    private String product;

    /*========客户需求信息===============*/
    /*需求面积*/
    private Float needAcreage;
    /*期望价格*/
    private Float needPrice;
    /**
     * 价格单位
     *
     * @see IndustryPriceUnitType
     */
    private String priceUnit;
    @NotGenerate
    private String priceUnitName;
    /*楼层需求*/
    /**
     * @see com.cii.bomse.crm.customer.base.dictionary.CustomerNeedLayerType
     */
    private String needLayer;
    @NotGenerate
    private String needLayerName;
    /*层高要求*/
    private Float layerHeight;
    /*电量要求，KVA*/
    private Float needVoltage;
    /*最晚入住时间*/
    private Date enterTime;
    /*期望租期，月位单位*/
    private Integer rentLong;

    /**
     * @see com.cii.bomse.house.base.dictionary.FireDeviceType
     */
    /*消防设施需求*/
    private String fireDeviceType;
    @NotGenerate
    private String fireDeviceTypeName;
    @NotGenerate
    private String[] fireDeviceTypeList;
    @NotGenerate
    private String[] fireDeviceTypeNameList;

    /*是否需要环评*/
    private Boolean needEia;
    /*是否需要注册*/
    private Boolean needRegister;
    /*是否需要产证*/
    private Boolean needCertificate;
    /*是否需要办公*/
    private Boolean needOffice;
    /*是否需要独栋*/
    private Boolean needSingleBuilding;
    /*是否需要独院*/
    private Boolean needSinglePark;

    @NotGenerate
    private List<CustomerAreaEntity> areas;

    /*存储需求区域的拼接字符串*/
    private String areaString;

    /**
     * 通过是否需要环评、注册、产证、办公等组成文字描述
     */
    @NotGenerate
    private String otherRemark;

    public String getOtherRemark() {
        if (ObjectUtils.isEmpty(otherRemark)) {
            StringBuffer sb = new StringBuffer();
            if (ObjectUtils.isNotEmpty(needEia) && needEia){
                sb.append("能办环评 ");
            }
            if (ObjectUtils.isNotEmpty(needRegister) && needRegister){
                sb.append("可注册公司 ");
            }
            if (ObjectUtils.isNotEmpty(needCertificate) && needCertificate){
                sb.append("产证齐全 ");
            }
            if (ObjectUtils.isNotEmpty(needOffice) && needOffice){
                sb.append("有办公区 ");
            }
            if (ObjectUtils.isNotEmpty(needSingleBuilding) && needSingleBuilding){
                sb.append("需要独栋 ");
            }
            if (ObjectUtils.isNotEmpty(needSinglePark) && needSinglePark){
                sb.append("需要独院 ");
            }
            otherRemark = sb.toString();
        }
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    public String getPriceUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(), priceUnit).getName();
    }

    public void setPriceUnitName(String priceUnitName) {
        this.priceUnitName = priceUnitName;
    }

    public String getFireDeviceType() {
        if (ObjectUtils.isEmpty(fireDeviceType) && ObjectUtils.isNotEmpty(fireDeviceTypeList)) {
            fireDeviceType = StringUtils.join(fireDeviceTypeList, ",");
        }
        return fireDeviceType;
    }

    public void setFireDeviceType(String fireDeviceType) {
        this.fireDeviceType = fireDeviceType;
    }

    public String getFireDeviceTypeName() {
        if (ObjectUtils.isEmpty(fireDeviceTypeName) && ObjectUtils.isNotEmpty(getFireDeviceTypeNameList())) {
            fireDeviceTypeName = StringUtils.join(getFireDeviceTypeNameList(), ",");
        }
        return fireDeviceTypeName;
    }

    public void setFireDeviceTypeName(String fireDeviceTypeName) {
        this.fireDeviceTypeName = fireDeviceTypeName;
    }

    public String[] getFireDeviceTypeList() {
        if (ObjectUtils.isEmpty(fireDeviceTypeList) && ObjectUtils.isNotEmpty(fireDeviceType)) {
            fireDeviceTypeList = fireDeviceType.split(",");
        }
        return fireDeviceTypeList;
    }

    public void setFireDeviceTypeList(String[] fireDeviceTypeList) {
        this.fireDeviceTypeList = fireDeviceTypeList;
    }

    public String[] getFireDeviceTypeNameList() {
        if (ObjectUtils.isEmpty(fireDeviceTypeNameList) && ObjectUtils.isNotEmpty(getFireDeviceTypeList())) {
            String[] arr = getFireDeviceTypeList();
            fireDeviceTypeNameList = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                fireDeviceTypeNameList[i] = DictionaryStorage.get(FireDeviceType.class.getName(), arr[i]).getName();
            }

        }
        return fireDeviceTypeNameList;
    }

    public void setFireDeviceTypeNameList(String[] fireDeviceTypeNameList) {
        this.fireDeviceTypeNameList = fireDeviceTypeNameList;
    }

    public List<CustomerAreaEntity> getAreas() {
        return areas;
    }

    public void setAreas(List<CustomerAreaEntity> areas) {
        this.areas = areas;
    }

    public String getAreaString() {
        return areaString;
    }

    public void setAreaString(String areaString) {
        this.areaString = areaString;
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

    public String getIndustryName() {
        return DictionaryStorage.get(Industry.class.getName(), industry).getName();
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getNeedAcreage() {
        return needAcreage;
    }

    public void setNeedAcreage(Float needAcreage) {
        this.needAcreage = needAcreage;
    }

    public Float getNeedPrice() {
        return needPrice;
    }

    public void setNeedPrice(Float needPrice) {
        this.needPrice = needPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getNeedLayer() {
        return needLayer;
    }

    public void setNeedLayer(String needLayer) {
        this.needLayer = needLayer;
    }

    public String getNeedLayerName() {
        return DictionaryStorage.get(CustomerNeedLayerType.class.getName(), needLayer).getName();
    }

    public void setNeedLayerName(String needLayerName) {
        this.needLayerName = needLayerName;
    }

    public Float getLayerHeight() {
        return layerHeight;
    }

    public void setLayerHeight(Float layerHeight) {
        this.layerHeight = layerHeight;
    }

    public Float getNeedVoltage() {
        return needVoltage;
    }

    public void setNeedVoltage(Float needVoltage) {
        this.needVoltage = needVoltage;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Integer getRentLong() {
        return rentLong;
    }

    public void setRentLong(Integer rentLong) {
        this.rentLong = rentLong;
    }

    public Boolean getNeedEia() {
        return needEia;
    }

    public void setNeedEia(Boolean needEia) {
        this.needEia = needEia;
    }

    public Boolean getNeedRegister() {
        return needRegister;
    }

    public void setNeedRegister(Boolean needRegister) {
        this.needRegister = needRegister;
    }

    public Boolean getNeedCertificate() {
        return needCertificate;
    }

    public void setNeedCertificate(Boolean needCertificate) {
        this.needCertificate = needCertificate;
    }

    public Boolean getNeedOffice() {
        return needOffice;
    }

    public void setNeedOffice(Boolean needOffice) {
        this.needOffice = needOffice;
    }

    public Boolean getNeedSingleBuilding() {
        return needSingleBuilding;
    }

    public void setNeedSingleBuilding(Boolean needSingleBuilding) {
        this.needSingleBuilding = needSingleBuilding;
    }

    public Boolean getNeedSinglePark() {
        return needSinglePark;
    }

    public void setNeedSinglePark(Boolean needSinglePark) {
        this.needSinglePark = needSinglePark;
    }
}
