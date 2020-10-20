package com.cii.bomse.house.land.dto;

import com.cii.bomse.house.land.entity.BlankLandEntity;

import java.util.Date;

public class BlankLandDto extends BlankLandEntity {

     private Float acreageStart;
     private Float acreageEnd;
     private Float sellPriceStart;
     private Float sellPriceEnd;
     private Float leasePriceStart;
     private Float leasePriceEnd;
     private Date createTimeStart;
     private Date createTimeEnd;

    public Float getAcreageStart() {
        return acreageStart;
    }

    public void setAcreageStart(Float acreageStart) {
        this.acreageStart = acreageStart;
    }

    public Float getAcreageEnd() {
        return acreageEnd;
    }

    public void setAcreageEnd(Float acreageEnd) {
        this.acreageEnd = acreageEnd;
    }

    public Float getSellPriceStart() {
        return sellPriceStart;
    }

    public void setSellPriceStart(Float sellPriceStart) {
        this.sellPriceStart = sellPriceStart;
    }

    public Float getSellPriceEnd() {
        return sellPriceEnd;
    }

    public void setSellPriceEnd(Float sellPriceEnd) {
        this.sellPriceEnd = sellPriceEnd;
    }

    public Float getLeasePriceStart() {
        return leasePriceStart;
    }

    public void setLeasePriceStart(Float leasePriceStart) {
        this.leasePriceStart = leasePriceStart;
    }

    public Float getLeasePriceEnd() {
        return leasePriceEnd;
    }

    public void setLeasePriceEnd(Float leasePriceEnd) {
        this.leasePriceEnd = leasePriceEnd;
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
}
