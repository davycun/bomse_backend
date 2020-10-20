package com.cii.bomse.base.area.entity;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description 行政区域类型
 * @auth david·cun
 * @date 2019-04-29 12:34
 * @since 1.0
 */
public class AreaEntity extends BaseEntity {

    /**/
    //区域ID，在BaseEntity中定义了
    /*父级区域编码*/
    @NotNull(message = "父级别区域ID不能为空")
    protected Long parentId;
    /*区域名称*/
    @NotNull(message = "区域名不能为空")
    protected String areaName;
    /*简称*/
    @NotNull(message = "区域名简称不能为空")
    protected String shortName;
    /*区域类型*/
    @NotNull(message = "区域类型不能为空")
    protected String areaType;
    protected String areaTypeName;
    /*经度*/
    protected Double longitude;
    /*纬度*/
    protected Double latitude;
    protected Integer sort;
    protected Boolean isLeaf;

    protected List<AreaEntity> children;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsLeaf() {

        if (AreaType.Street.equals(this.getAreaType())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void setIsLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

    public List<AreaEntity> getChildren() {
        return children;
    }

    public void setChildren(List<AreaEntity> children) {
        this.children = children;
    }


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaTypeName() {
        return DictionaryStorage.get(AreaType.class.getName(), this.getAreaType()).getName();
    }

    public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
}
