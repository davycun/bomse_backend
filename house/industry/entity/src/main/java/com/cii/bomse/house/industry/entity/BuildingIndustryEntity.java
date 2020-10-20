package com.cii.bomse.house.industry.entity;

import com.cii.bomse.house.base.dictionary.BuildingStructureType;
import com.cii.bomse.house.industry.dictionary.RailwayType;
import com.cii.bomse.house.industry.dictionary.UploadType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-06 14:38
 * @since 1.0
 */
public class BuildingIndustryEntity extends BaseEntity {

    /*园区ID*/
    @NotNull(message = "园区ID不能为空")
    private Long parkId;
    /*园区*/
    @NotGenerate
    private ParkIndustryEntity park;
    /*所有的楼层信息*/
    @NotGenerate
    private List<FloorIndustryEntity> floorList;
    /*楼名称，A栋，B栋，32栋*/
    private String bdName;
    /*楼栋名称描述，比如进门第一栋/有月台那一栋等*/
    private String bdNameDesc;
    /*建筑结构*/
    /**
     * @see BuildingStructureType
     */
    private String structureType;
    @NotGenerate
    private String structureTypeName;
    /*是否单层*/
    private Boolean singleFloor;

    /*是否有电梯/货梯*/
    private Boolean hasLift;
    /*有几部电梯*/
    private Integer liftCount;
    /*电梯承重*/
    private Float liftBearing;
    /*电梯描述，不保存数据库*/
    @NotGenerate
    private String liftDesc;

    /*===仓库特性，一楼的特性==========*/
    /*是否有月台*/
    private Boolean hasRailway;
    /*月台类型*/
    /**
     * @see com.cii.bomse.house.industry.dictionary.RailwayType
     */
    private String railwayType;
    @NotGenerate
    private String railwayTypeName;
    /*月台高度，单位米*/
    private Float railwayHeight;
    /*月台宽度，外置式才有宽度*/
    private Float railwayWidth;
    /*月台描述，不保存数据库*/
    @NotGenerate
    private String railwayDesc;

    /*是否有雨棚，月台上面遮盖的*/
    private Boolean hasCanopy;
    /*雨棚宽度，单位米*/
    private Float canopyWidth;
    /*雨棚描述，不保存数据库*/
    @NotGenerate
    private String canopyDesc;

    /*卸货/装车，单面/双面卸货*/
    /**
     * @see com.cii.bomse.house.industry.dictionary.UploadType
     */
    private String uploadType;
    @NotGenerate
    private String uploadTypeName;

    /*==其他统计信息====*/
    /*在租楼层的数量*/
    private Integer floorCount;

    public String getBdNameDesc() {
        return bdNameDesc;
    }

    public void setBdNameDesc(String bdNameDesc) {
        this.bdNameDesc = bdNameDesc;
    }

    public String getCanopyDesc() {
        if (ObjectUtils.isEmpty(canopyDesc)){
            if (ObjectUtils.isEmpty(hasCanopy)){
                canopyDesc = "未知";
            }else if(hasCanopy){
                canopyDesc = String.format("有雨棚，宽%.1f米",canopyWidth);
            }else{
                canopyDesc = "无雨棚";
            }
        }
        return canopyDesc;
    }

    public void setCanopyDesc(String canopyDesc) {
        this.canopyDesc = canopyDesc;
    }

    public String getRailwayDesc() {

        if (ObjectUtils.isEmpty(railwayDesc)){
            if (ObjectUtils.isEmpty(hasRailway)){
                railwayDesc = "未知";
            }else if(hasRailway){
                String tpName = "";
                if (ObjectUtils.isNotEmpty(railwayWidth) && railwayWidth>0){
                    tpName = String.format("，宽%.1f米",railwayWidth);
                }
                railwayDesc = String.format("%s月台，高%.1f米%s",getRailwayTypeName(),railwayHeight,tpName);
            }else{
                railwayDesc="无月台";
            }
        }

        return railwayDesc;
    }

    public void setRailwayDesc(String railwayDesc) {
        this.railwayDesc = railwayDesc;
    }

    public String getLiftDesc() {

        if (ObjectUtils.isEmpty(liftDesc)) {
            if (ObjectUtils.isEmpty(hasLift)) {
                liftDesc = "未知";
            } else if (hasLift) {
                liftDesc = String.format("货梯%d部，每部承重%.1f吨", liftCount, liftBearing);
            } else {
                liftDesc = "无货梯";
            }
        }

        return liftDesc;
    }

    public void setLiftDesc(String liftDesc) {
        this.liftDesc = liftDesc;
    }

    public ParkIndustryEntity getPark() {
        return park;
    }

    public void setPark(ParkIndustryEntity park) {
        this.park = park;
    }

    public List<FloorIndustryEntity> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<FloorIndustryEntity> floorList) {
        this.floorList = floorList;
    }

    public Boolean getSingleFloor() {
        return singleFloor;
    }

    public void setSingleFloor(Boolean singleFloor) {
        this.singleFloor = singleFloor;
    }

    public Boolean getHasRailway() {
        return hasRailway;
    }

    public void setHasRailway(Boolean hasRailway) {
        this.hasRailway = hasRailway;
    }

    public String getRailwayType() {
        return railwayType;
    }

    public void setRailwayType(String railwayType) {
        this.railwayType = railwayType;
    }

    public String getRailwayTypeName() {

        return DictionaryStorage.get(RailwayType.class.getName(),railwayType).getName();
    }

    public void setRailwayTypeName(String railwayTypeName) {
        this.railwayTypeName = railwayTypeName;
    }

    public Float getRailwayHeight() {
        return railwayHeight;
    }

    public void setRailwayHeight(Float railwayHeight) {
        this.railwayHeight = railwayHeight;
    }

    public Float getRailwayWidth() {
        return railwayWidth;
    }

    public void setRailwayWidth(Float railwayWidth) {
        this.railwayWidth = railwayWidth;
    }

    public Boolean getHasCanopy() {
        return hasCanopy;
    }

    public void setHasCanopy(Boolean hasCanopy) {
        this.hasCanopy = hasCanopy;
    }

    public Float getCanopyWidth() {
        return canopyWidth;
    }

    public void setCanopyWidth(Float canopyWidth) {
        this.canopyWidth = canopyWidth;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getUploadTypeName() {
        if (ObjectUtils.isEmpty(uploadTypeName)){
            uploadTypeName = DictionaryStorage.get(UploadType.class.getName(),uploadType).getName();
        }
        return uploadTypeName;
    }

    public void setUploadTypeName(String uploadTypeName) {
        this.uploadTypeName = uploadTypeName;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Boolean getHasLift() {
        return hasLift;
    }

    public void setHasLift(Boolean hasLift) {
        this.hasLift = hasLift;
    }

    public Integer getLiftCount() {
        return liftCount;
    }

    public void setLiftCount(Integer liftCount) {
        this.liftCount = liftCount;
    }

    public Float getLiftBearing() {
        return liftBearing;
    }

    public void setLiftBearing(Float liftBearing) {
        this.liftBearing = liftBearing;
    }

    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public String getStructureTypeName() {
        return DictionaryStorage.get(BuildingStructureType.class.getName(), getStructureType()).getName();
    }

    public void setStructureTypeName(String structureTypeName) {
        this.structureTypeName = structureTypeName;
    }
}
