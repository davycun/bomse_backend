package com.cii.bomse.house.base.dto;

import com.cii.bomse.house.base.entity.HouseOwnerEntity;

public class HouseOwnerDto extends HouseOwnerEntity {

    /*园区ID*/
    private Long parkId;
    /*建筑ID*/
    private Long buildingId;

    /*更新号码的时候用的*/
    private String oldPhone;
    private String newPhone;

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
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
}
