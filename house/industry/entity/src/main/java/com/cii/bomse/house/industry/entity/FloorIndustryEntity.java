package com.cii.bomse.house.industry.entity;

import com.cii.bomse.common.dictionary.Industry;
import com.cii.bomse.house.base.dictionary.*;
import com.cii.bomse.house.industry.dictionary.HouseIndustryUseType;
import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-07 16:40
 * @since 1.0
 */
public class FloorIndustryEntity extends BaseEntity {

    /*园区ID*/
    @NotNull(message = "园区ID不能为空")
    private Long parkId;
    @NotGenerate
    private ParkIndustryEntity park;
    /*建筑ID*/
    @NotNull(message = "楼栋ID不能为空")
    private Long buildingId;
    @NotGenerate
    private BuildingIndustryEntity building;

    /*===基本信息======*/
    /*当前层数*/
    private Integer floorNumber;
    /*房源用途*/
    /**
     * @see com.cii.bomse.house.industry.dictionary.HouseIndustryUseType
     */
    private String houseUseType;
    @NotGenerate
    private String houseUseTypeName;
    /**
     * 存储多种用途形式
     */
    @NotGenerate
    private String[] houseUseTypeList;
    /**
     * 存储多种形式用途名称
     */
    @NotGenerate
    private String[] houseUseTypeNameList;
    /*楼层总面积*/
    private Float totalAcreage;
    /*可租面积*/
    private Float leaseAcreage;
    /*起租面积*/
    private Float leaseAcreageMin;
    /*单价*/
    private Float price;
    /*必须转换成：元/平米/天的价格存储，换算的方式是年单价，price*365，月单价是price*365/12*/
    /**
     * @see IndustryPriceUnitType
     */
    private String priceUnit;
    @NotGenerate
    private String priceUnitName;
    /*层高*/
    private Float floorHeight;
    /*承重，多少吨/平米*/
    private Float bearing;
    /*地坪类型*/
    /**
     * @see com.cii.bomse.house.base.dictionary.FloorBoardType
     */
    private String floorBoardType;
    @NotGenerate
    private String floorBoardTypeName;
    /*消防设施*/
    /**
     * @see com.cii.bomse.house.base.dictionary.FireDeviceType
     */
    private String fireDeviceType;
    @NotGenerate
    private String fireDeviceTypeName;
    @NotGenerate
    private String[] fireDeviceTypeList;
    @NotGenerate
    private String[] fireDeviceTypeNameList;
    /*是否有行车*/
    private Boolean hasBridgeCrane;

    /*租赁类型*/
    /**
     * @see com.cii.bomse.house.base.dictionary.LeaseType
     */
    private String leaseType;
    @NotGenerate
    private String leaseTypeName;

    /*===通用信息=========*/
    /*最短租期，不填写或者填写0表示可协商，可短租*/
    private Integer leaseTermMin;
    /*可入住时间*/
    private Date enterTime;
    /*入住时间描述，不保存数据库*/
    @NotGenerate
    private String enterTimeDesc;
    //*适合行业/产业导向：*/
    /**
     * @see Industry
     */
    private String fitIndustry;
    @NotGenerate
    private String fitIndustryName;
    /*适合行业集合*/
    @NotGenerate
    private String[] fitIndustryList;
    @NotGenerate
    private String[] fitIndustryNameList;

    /*===其他信息相关==========*/
    /*房源来源*/
    /**
     * @see com.cii.bomse.house.base.dictionary.HouseFrom
     */
    @Deprecated
    private String houseFrom;
    @Deprecated
    @NotGenerate
    private String houseFromName;
    /*协议图片*/
    private String agreementImages;

    /*===房源SEO相关，官网=====*/
    /*房源标题*/
    private String title;
    /*房源关键字*/
    private String keywords;
    /*房源描述*/
    private String description;

    /*内容里面的标题*/
    private String slogan;
    /*内容里面的副标题*/
    private String chiefSlogan;

    /*优势*/
    @NotGenerate
    private List<String> advantageTags;

    /*房源照片，只展示楼层*/
    private String floorImages;
    @NotGenerate
    private String[] floorImagesList;

    public String getHouseUseType() {
        if (ObjectUtils.isEmpty(houseUseType) && ObjectUtils.isNotEmpty(houseUseTypeList)) {
            houseUseType = StringUtils.join(houseUseTypeList, ",");
        }
        return houseUseType;
    }

    public void setHouseUseType(String houseUseType) {
        this.houseUseType = houseUseType;
    }

    public String getHouseUseTypeName() {
        if (ObjectUtils.isEmpty(houseUseTypeNameList) && ObjectUtils.isNotEmpty(getHouseUseTypeList())) {
            String[] useTypeList = getHouseUseTypeList();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < useTypeList.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(DictionaryStorage.get(HouseIndustryUseType.class.getName(),useTypeList[i]).getName());
            }
            houseUseTypeName = sb.toString();
        }
        return houseUseTypeName;
    }

    public void setHouseUseTypeName(String houseUseTypeName) {
        this.houseUseTypeName = houseUseTypeName;
    }

    public String[] getHouseUseTypeList() {
        if (ObjectUtils.isEmpty(houseUseTypeList) && ObjectUtils.isNotEmpty(houseUseType)) {
            houseUseTypeList = houseUseType.split(",");
        }
        return houseUseTypeList;
    }

    public void setHouseUseTypeList(String[] houseUseTypeList) {
        this.houseUseTypeList = houseUseTypeList;
    }

    public String[] getHouseUseTypeNameList() {
        if (ObjectUtils.isEmpty(houseUseTypeNameList) && ObjectUtils.isNotEmpty(getHouseUseTypeName())) {
            houseUseTypeNameList = getHouseUseTypeName().split(",");
        }
        return houseUseTypeNameList;
    }

    public void setHouseUseTypeNameList(String[] houseUseTypeNameList) {
        this.houseUseTypeNameList = houseUseTypeNameList;
    }

    public Float getTotalAcreage() {
        return totalAcreage;
    }

    public void setTotalAcreage(Float totalAcreage) {
        this.totalAcreage = totalAcreage;
    }

    public String getFloorImages() {

        if (ObjectUtils.isEmpty(floorImages) && ObjectUtils.isNotEmpty(floorImagesList)) {
            floorImages = StringUtils.join(floorImagesList,",");
        }
        return floorImages;
    }

    public void setFloorImages(String floorImages) {
        this.floorImages = floorImages;
    }

    public String[] getFloorImagesList() {

        if (ObjectUtils.isEmpty(floorImagesList) && ObjectUtils.isNotEmpty(floorImages)) {
            floorImagesList = floorImages.split(",");
        }
        return floorImagesList;
    }

    public void setFloorImagesList(String[] floorImagesList) {
        this.floorImagesList = floorImagesList;
    }

    public String getEnterTimeDesc() {

        if (ObjectUtils.isEmpty(enterTimeDesc)) {
            if (ObjectUtils.isEmpty(enterTime)) {
                enterTimeDesc = "立即入住";
            } else {
                Calendar calendar = Calendar.getInstance();

                if (enterTime.compareTo(calendar.getTime()) < 1) {
                    enterTimeDesc = "立即入住";
                } else {
                    String unit = "天";
                    float d = (enterTime.getTime() - calendar.getTime().getTime()) / (24 * 60 * 60 * 1000);

                    if (d < 30) {

                    } else if (d >= 30 && d <= 365) {
                        d = d / 30;
                        unit = "月";
                    } else {
                        d = d / 365;
                        unit = "年";
                    }
                    enterTimeDesc = String.format("%.1f%s后可入住", d, unit);
                }
            }
        }
        return enterTimeDesc;
    }

    public void setEnterTimeDesc(String enterTimeDesc) {
        this.enterTimeDesc = enterTimeDesc;
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

    public ParkIndustryEntity getPark() {
        return park;
    }

    public void setPark(ParkIndustryEntity park) {
        this.park = park;
    }

    public BuildingIndustryEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingIndustryEntity building) {
        this.building = building;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Float getLeaseAcreage() {
        return leaseAcreage;
    }

    public void setLeaseAcreage(Float leaseAcreage) {
        this.leaseAcreage = leaseAcreage;
    }

    public Float getLeaseAcreageMin() {
        return leaseAcreageMin;
    }

    public void setLeaseAcreageMin(Float leaseAcreageMin) {
        this.leaseAcreageMin = leaseAcreageMin;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getPriceUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(), priceUnit).getName();
    }

    public void setPriceUnitName(String priceUnitName) {
        this.priceUnitName = priceUnitName;
    }

    public Float getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Float floorHeight) {
        this.floorHeight = floorHeight;
    }

    public Float getBearing() {
        return bearing;
    }

    public void setBearing(Float bearing) {
        this.bearing = bearing;
    }

    public String getFloorBoardType() {
        return floorBoardType;
    }

    public void setFloorBoardType(String floorBoardType) {
        this.floorBoardType = floorBoardType;
    }

    public String getFloorBoardTypeName() {
        return DictionaryStorage.get(FloorBoardType.class.getName(), floorBoardType).getName();
    }

    public void setFloorBoardTypeName(String floorBoardTypeName) {
        this.floorBoardTypeName = floorBoardTypeName;
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

    public Boolean getHasBridgeCrane() {
        return hasBridgeCrane;
    }

    public void setHasBridgeCrane(Boolean hasBridgeCrane) {
        this.hasBridgeCrane = hasBridgeCrane;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public String getFitIndustry() {

        if (ObjectUtils.isEmpty(fitIndustry) && ObjectUtils.isNotEmpty(fitIndustryList)) {
            fitIndustry = StringUtils.join(fitIndustryList, ",");
        }

        return fitIndustry;
    }

    public void setFitIndustry(String fitIndustry) {
        this.fitIndustry = fitIndustry;
    }

    public String getFitIndustryName() {
        if (ObjectUtils.isEmpty(fitIndustryName) && ObjectUtils.isNotEmpty(getFitIndustryNameList())) {
            fitIndustryName = StringUtils.join(getFitIndustryNameList(), ",");
        }
        return fitIndustryName;
    }

    public void setFitIndustryName(String fitIndustryName) {
        this.fitIndustryName = fitIndustryName;
    }

    public String[] getFitIndustryList() {
        if (ObjectUtils.isEmpty(fitIndustryList) && ObjectUtils.isNotEmpty(fitIndustry)) {
            fitIndustryList = fitIndustry.split(",");
        }
        return fitIndustryList;
    }

    public void setFitIndustryList(String[] fitIndustryList) {
        this.fitIndustryList = fitIndustryList;
    }

    public String[] getFitIndustryNameList() {
        if (ObjectUtils.isEmpty(fitIndustryNameList) && ObjectUtils.isNotEmpty(getFitIndustryList())) {
            String[] ks = getFitIndustryList();
            fitIndustryNameList = new String[ks.length];
            for (int i = 0; i < ks.length; i++) {
                fitIndustryNameList[i] = DictionaryStorage.get(Industry.class.getName(), ks[i]).getName();
            }
        }
        return fitIndustryNameList;
    }

    public void setFitIndustryNameList(String[] fitIndustryNameList) {
        this.fitIndustryNameList = fitIndustryNameList;
    }

    public Integer getLeaseTermMin() {
        return leaseTermMin;
    }

    public void setLeaseTermMin(Integer leaseTermMin) {
        this.leaseTermMin = leaseTermMin;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getLeaseTypeName() {
        return DictionaryStorage.get(LeaseType.class.getName(), leaseType).getName();
    }

    public void setLeaseTypeName(String leaseTypeName) {
        this.leaseTypeName = leaseTypeName;
    }

    public String getHouseFrom() {
        return houseFrom;
    }

    public void setHouseFrom(String houseFrom) {
        this.houseFrom = houseFrom;
    }

    public String getHouseFromName() {
        return DictionaryStorage.get(HouseFrom.class.getName(), houseFrom).getName();
    }

    public void setHouseFromName(String houseFromName) {
        this.houseFromName = houseFromName;
    }

    public String getAgreementImages() {
        return agreementImages;
    }

    public void setAgreementImages(String agreementImages) {
        this.agreementImages = agreementImages;
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

    public List<String> getAdvantageTags() {
        if (ObjectUtils.isEmpty(advantageTags)) {
            advantageTags = new ArrayList<>();

            if (ObjectUtils.isNotEmpty(this.getFloorHeight()) && this.getFloorHeight() > 5) {
                advantageTags.add("层高高");
            }
            if (ObjectUtils.isNotEmpty(this.getFireDeviceTypeList()) && this.getFireDeviceTypeList().length >= 4) {
                advantageTags.add("消防齐全");
            }
            if (ObjectUtils.isNotEmpty(this.getHasBridgeCrane()) && this.getHasBridgeCrane()) {
                advantageTags.add("带行车");
            }
        }

        return advantageTags;
    }

    public void setAdvantageTags(List<String> advantageTags) {
        this.advantageTags = advantageTags;
    }
}
