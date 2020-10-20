package com.cii.bomse.house.industry.entity;

import com.cii.bomse.common.dictionary.Industry;
import com.cii.bomse.house.base.dictionary.LandUseType;
import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.house.industry.dictionary.ParkCertificateType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description 工业园区
 * @auth david·cun
 * @date 2019-12-06 14:37
 * @since 1.0
 */
public class ParkIndustryEntity extends BaseEntity {

    /*==位置信息===========*/
    /*城市ID*/
    @NotNull(message = "城市信息不能为空")
    protected Long cityId;
    protected String cityName;
    /*区域ID*/
    @NotNull(message = "区域信息不能为空")
    protected Long regionId;
    protected String regionName;
    /*街道ID*/
    @NotNull(message = "街道信息不能为空")
    protected Long streetId;
    protected String streetName;
    /*社区ID*/
    protected Long communityId;
    protected String communityName;
    /*详细地址，路段及号牌*/
    @NotNull(message = "详细地址不能为空")
    protected String address;
    /**
     * 从cityName、regionName、address等拼接
     */
    @NotGenerate
    protected String detailAddress;
    /*园区名称*/
    protected String pkName;
    /*经度*/
    protected Double longitude;
    /*纬度*/
    protected Double latitude;

    /*===证件信息===============*/
    /*证件类型，多选，通过逗号隔开*/
    /**
     * @see com.cii.bomse.house.industry.dictionary.ParkCertificateType
     */
    protected String certificateType;
    @NotGenerate
    protected String certificateTypeName;
    @NotGenerate
    protected String[] certificateTypeList;
    @NotGenerate
    protected String[] certificateTypeNameList;

    /*===土地信息==================*/
    /*土地性质*/
    /**
     * @see com.cii.bomse.house.base.dictionary.LandUseType
     */
    protected String landUseType;
    @NotGenerate
    protected String landUseTypeName;

    /*===生产信息============*/
    /*配电量*/
    protected Float voltage;
    /*是否有税收要求*/
    protected Boolean hasTax;
    /*是否可注册公司*/
    protected Boolean canRegistry;

    /*===配套设施=============*/
    /*是否有监控设施*/
    protected Boolean hasMonitor;
    /*是否有保安*/
    protected Boolean hasGuard;

    /*===配套服务=============*/
    /*是否有食堂*/
    protected Boolean hasCanteen;
    /*是否配套办公*/
    protected Boolean hasOffice;
    /*是否有停车位*/
    protected Boolean hasParkingSpace;
    /*是否独门独院*/
    protected Boolean singlePark;
    /*场地/空点面积*/
    protected Float openSpaceAcreage;

    /*区位优势：通过百度地图POI自动生成，周边高速，及拼接一些周边信息*/
    protected String locationAdvantage;

    /*适合行业/产业导向：*/
    protected String fitIndustry;
    @NotGenerate
    protected String fitIndustryName;
    /*适合行业集合*/
    @NotGenerate
    protected String[] fitIndustryList;
    @NotGenerate
    protected String[] fitIndustryNameList;

    /*===动态更新信息=============*/
    /*楼栋数，不需要用户填写*/
    protected Integer buildingCount;
    /*起租面积*/
    protected Float leaseAcreageMin;
    /*可租面积*/
    protected Float leaseAcreage;
    /*最低价格*/
    protected Float priceMin;
    /*最低价格单位*/
    protected String priceMinUnit;
    @NotGenerate
    protected String priceMinUnitName;
    /*最高层高*/
    protected Float floorHeightMax;

    /*===SEO相关的====*/
    /*房源标题*/
    protected String title;
    /*房源关键字*/
    protected String keywords;
    /*房源描述*/
    protected String description;

    /*内容里面的标题*/
    protected String slogan;
    /*内容里面的副标题*/
    protected String chiefSlogan;

    /*房源建筑信息*/
    @NotGenerate
    protected List<BuildingIndustryEntity> buildingList;
    /*所有的楼层房源*/
    @NotGenerate
    protected List<FloorIndustryEntity> floorList;

    /*园区照片*/
    protected String parkImages;
    @NotGenerate
    protected String[] parkImagesList;

    @NotGenerate
    protected List<String> advantageTags;

    /*===业主信息=========*/
    /*用来新增园区的时候上传一个业主ID*/
    @NotGenerate
    protected Long houseOwnerId;


    /*====跟进或者拜访信息======*/
    /*最后跟进时间*/
    protected Date lastFollowupTime;
    /*未跟进天数*/
    @NotGenerate
    protected Integer noFollowupDay;
    /*跟进次数*/
    protected Integer followupCount;

    public String getDetailAddress() {

        if (ObjectUtils.isEmpty(detailAddress)) {
            StringBuffer sb = new StringBuffer();

            sb.append(cityName).append(regionName).append(streetName).append(communityName != null ? communityName : "").append(address);
            detailAddress = sb.toString();
        }

        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
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
        Date now = new Date();
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

    public Long getHouseOwnerId() {
        return houseOwnerId;
    }

    public void setHouseOwnerId(Long houseOwnerId) {
        this.houseOwnerId = houseOwnerId;
    }

    public List<String> getAdvantageTags() {

        if (ObjectUtils.isEmpty(advantageTags)) {
            advantageTags = new ArrayList<>();

            if (ObjectUtils.isNotEmpty(this.getVoltage()) && this.getVoltage() > 300) {
                this.advantageTags.add("电量大");
            }
            if (ObjectUtils.isNotEmpty(this.getCertificateTypeList()) && this.getCertificateTypeList().length >= 3) {
                this.advantageTags.add("证件齐全");
            }
            if (ObjectUtils.isNotEmpty(this.getHasTax()) && !this.getHasTax()) {
                this.advantageTags.add("无税收");
            }
            if (ObjectUtils.isNotEmpty(this.getCanRegistry()) && this.getCanRegistry()) {
                this.advantageTags.add("可注册");
            }
            if (ObjectUtils.isNotEmpty(this.getHasCanteen()) && this.getHasCanteen()) {
                this.advantageTags.add("配食堂");
            }
            if (ObjectUtils.isNotEmpty(this.getHasOffice()) && this.getHasOffice()) {
                this.advantageTags.add("配办公");
            }
            if (ObjectUtils.isNotEmpty(this.getHasParkingSpace()) && this.getHasParkingSpace()) {
                this.advantageTags.add("车位充足");
            }
            if (ObjectUtils.isNotEmpty(this.getSinglePark()) && this.getSinglePark()) {
                this.advantageTags.add("独门独院");
            }

            if (ObjectUtils.isNotEmpty(this.getOpenSpaceAcreage()) && this.getOpenSpaceAcreage() > 200) {
                this.advantageTags.add("场地大");
            }

        }
        return advantageTags;
    }

    public void setAdvantageTags(List<String> advantageTags) {
        this.advantageTags = advantageTags;
    }

    public Float getFloorHeightMax() {
        return floorHeightMax;
    }

    public void setFloorHeightMax(Float floorHeightMax) {
        this.floorHeightMax = floorHeightMax;
    }

    public String getParkImages() {
        if (ObjectUtils.isEmpty(parkImages) && ObjectUtils.isNotEmpty(parkImagesList)) {
            parkImages = StringUtils.join(parkImagesList, ",");
        }
        return parkImages;
    }

    public void setParkImages(String parkImages) {
        this.parkImages = parkImages;
    }

    public String[] getParkImagesList() {
        if (ObjectUtils.isEmpty(parkImagesList) && ObjectUtils.isNotEmpty(parkImages)) {
            this.parkImagesList = parkImages.split(",");
        }
        return parkImagesList;
    }

    public void setParkImagesList(String[] parkImagesList) {
        this.parkImagesList = parkImagesList;
    }

    public List<FloorIndustryEntity> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<FloorIndustryEntity> floorList) {
        this.floorList = floorList;
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

    public List<BuildingIndustryEntity> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<BuildingIndustryEntity> buildingList) {
        this.buildingList = buildingList;
    }

    public String getPriceMinUnit() {
        return priceMinUnit;
    }

    public void setPriceMinUnit(String priceMinUnit) {
        this.priceMinUnit = priceMinUnit;
    }

    public String getPriceMinUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(), priceMinUnit).getName();
    }

    public void setPriceMinUnitName(String priceMinUnitName) {
        this.priceMinUnitName = priceMinUnitName;
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

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
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

    public String getCertificateType() {
        if (ObjectUtils.isEmpty(certificateType) && ObjectUtils.isNotEmpty(certificateTypeList)) {
            certificateType = StringUtils.join(certificateTypeList, ",");
        }
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateTypeName() {
        if (ObjectUtils.isEmpty(certificateTypeName)
                && ObjectUtils.isNotEmpty(getCertificateTypeNameList())) {
            certificateTypeName = StringUtils.join(getCertificateTypeNameList(), ",");
        }
        return certificateTypeName;
    }

    public void setCertificateTypeName(String certificateTypeName) {
        this.certificateTypeName = certificateTypeName;
    }

    public String[] getCertificateTypeList() {
        if (ObjectUtils.isEmpty(certificateTypeList)
                && ObjectUtils.isNotEmpty(certificateType)) {
            certificateTypeList = certificateType.split(",");
        }
        return certificateTypeList;
    }

    public void setCertificateTypeList(String[] certificateTypeList) {
        this.certificateTypeList = certificateTypeList;
    }

    public String[] getCertificateTypeNameList() {
        if (ObjectUtils.isEmpty(certificateTypeNameList)
                && ObjectUtils.isNotEmpty(getCertificateTypeList())) {
            String[] list = getCertificateTypeList();
            certificateTypeNameList = new String[list.length];
            for (int i = 0; i < list.length; i++) {
                certificateTypeNameList[i] = DictionaryStorage.get(ParkCertificateType.class.getName(), list[i]).getName();
            }
        }
        return certificateTypeNameList;
    }

    public void setCertificateTypeNameList(String[] certificateTypeNameList) {
        this.certificateTypeNameList = certificateTypeNameList;
    }

    public String getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(String landUseType) {
        this.landUseType = landUseType;
    }

    public String getLandUseTypeName() {
        return DictionaryStorage.get(LandUseType.class.getName(), landUseType).getName();
    }

    public void setLandUseTypeName(String landUseTypeName) {
        this.landUseTypeName = landUseTypeName;
    }

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }

    public Boolean getHasTax() {
        return hasTax;
    }

    public void setHasTax(Boolean hasTax) {
        this.hasTax = hasTax;
    }

    public Boolean getCanRegistry() {
        return canRegistry;
    }

    public void setCanRegistry(Boolean canRegistry) {
        this.canRegistry = canRegistry;
    }

    public Boolean getHasMonitor() {
        return hasMonitor;
    }

    public void setHasMonitor(Boolean hasMonitor) {
        this.hasMonitor = hasMonitor;
    }

    public Boolean getHasGuard() {
        return hasGuard;
    }

    public void setHasGuard(Boolean hasGuard) {
        this.hasGuard = hasGuard;
    }

    public Boolean getHasCanteen() {
        return hasCanteen;
    }

    public void setHasCanteen(Boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }

    public Boolean getHasOffice() {
        return hasOffice;
    }

    public void setHasOffice(Boolean hasOffice) {
        this.hasOffice = hasOffice;
    }

    public Boolean getHasParkingSpace() {
        return hasParkingSpace;
    }

    public void setHasParkingSpace(Boolean hasParkingSpace) {
        this.hasParkingSpace = hasParkingSpace;
    }

    public Boolean getSinglePark() {
        return singlePark;
    }

    public void setSinglePark(Boolean singlePark) {
        this.singlePark = singlePark;
    }

    public Float getOpenSpaceAcreage() {
        return openSpaceAcreage;
    }

    public void setOpenSpaceAcreage(Float openSpaceAcreage) {
        this.openSpaceAcreage = openSpaceAcreage;
    }

    public String getLocationAdvantage() {
        return locationAdvantage;
    }

    public void setLocationAdvantage(String locationAdvantage) {
        this.locationAdvantage = locationAdvantage;
    }

    public Integer getBuildingCount() {
        return buildingCount;
    }

    public void setBuildingCount(Integer buildingCount) {
        this.buildingCount = buildingCount;
    }

    public Float getLeaseAcreageMin() {
        return leaseAcreageMin;
    }

    public void setLeaseAcreageMin(Float leaseAcreageMin) {
        this.leaseAcreageMin = leaseAcreageMin;
    }

    public Float getLeaseAcreage() {
        return leaseAcreage;
    }

    public void setLeaseAcreage(Float leaseAcreage) {
        this.leaseAcreage = leaseAcreage;
    }

    public Float getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Float priceMin) {
        this.priceMin = priceMin;
    }
}
