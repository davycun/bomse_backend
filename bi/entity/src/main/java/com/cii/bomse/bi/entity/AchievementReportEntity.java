package com.cii.bomse.bi.entity;

import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.entity.BaseEntity;
import io.netty.util.internal.MathUtil;

import java.math.BigDecimal;

/**
 * @description 业绩统计报表
 * @auth david·cun
 * @date 2019-09-11 08:19
 * @since 1.0
 */
public class AchievementReportEntity extends BaseReportEntity {

    /*个人获客量*/
    private Float customerPersonalCount = 0f;
    /*部门获客隐藏的量*/
    private Float customerHideCount = 0f;
    /*部门获客量*/
    private Float customerCompanyCount = 0f;
    /*客户跟进量*/
    private Float customerFollowupCount = 0f;
    /*客户带看量*/
    private Float customerSeeHouseCount = 0f;
    /*兼职开发*/
    private Float partTimerCount = 0f;
    /*下架面积*/
    private Float houseDownAcreageCount=0.0f;
    /*新增面积*/
    private Float houseUpAcreageCount = 0.0f;
    /*房源跟进量*/
    private Float houseFollowupCount=0f;
    /*签约量*/
    private Float orderCount = 0f;
    /*新（单位时间内）客户签约量*/
    private Float newCustomerOrderCount = 0f;
    /*新客户成交占比*/
    @NotGenerate
    private Float newCustomerOrderPercentage = 0f;
    /*合同金额*/
    private Float contractAmountCount = 0f;
    /*营收金额*/
    private Float achievementAmountCount = 0f;
    /*分成金额*/
    private Float divideAmountCount = 0f;
    /*回款金额总和*/
    private Float orderBackAmountCount = 0f;

    public Float getCustomerHideCount() {
        return customerHideCount;
    }

    public void setCustomerHideCount(Float customerHideCount) {
        this.customerHideCount = customerHideCount;
    }

    public Float getCustomerPersonalCount() {
        return customerPersonalCount;
    }

    public void setCustomerPersonalCount(Float customerPersonalCount) {
        this.customerPersonalCount = customerPersonalCount;
    }

    public Float getCustomerCompanyCount() {
        return customerCompanyCount;
    }

    public void setCustomerCompanyCount(Float customerCompanyCount) {
        this.customerCompanyCount = customerCompanyCount;
    }

    public Float getCustomerFollowupCount() {
        return customerFollowupCount;
    }

    public void setCustomerFollowupCount(Float customerFollowupCount) {
        this.customerFollowupCount = customerFollowupCount;
    }

    public Float getCustomerSeeHouseCount() {
        return customerSeeHouseCount;
    }

    public void setCustomerSeeHouseCount(Float customerSeeHouseCount) {
        this.customerSeeHouseCount = customerSeeHouseCount;
    }

    public Float getPartTimerCount() {
        return partTimerCount;
    }

    public void setPartTimerCount(Float partTimerCount) {
        this.partTimerCount = partTimerCount;
    }

    public Float getHouseDownAcreageCount() {
        return houseDownAcreageCount;
    }

    public void setHouseDownAcreageCount(Float houseDownAcreageCount) {
        this.houseDownAcreageCount = houseDownAcreageCount;
    }

    public Float getHouseUpAcreageCount() {
        return houseUpAcreageCount;
    }

    public void setHouseUpAcreageCount(Float houseUpAcreageCount) {
        this.houseUpAcreageCount = houseUpAcreageCount;
    }

    public Float getHouseFollowupCount() {
        return houseFollowupCount;
    }

    public void setHouseFollowupCount(Float houseFollowupCount) {
        this.houseFollowupCount = houseFollowupCount;
    }

    public Float getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Float orderCount) {
        this.orderCount = orderCount;
    }

    public Float getNewCustomerOrderCount() {
        return newCustomerOrderCount;
    }

    public void setNewCustomerOrderCount(Float newCustomerOrderCount) {
        this.newCustomerOrderCount = newCustomerOrderCount;
    }

    public Float getNewCustomerOrderPercentage() {
        if (customerPersonalCount + customerCompanyCount > 0) {
            newCustomerOrderPercentage = newCustomerOrderCount / (Float.valueOf(customerPersonalCount + customerCompanyCount));
        }
        return newCustomerOrderPercentage;
    }

    public void setNewCustomerOrderPercentage(Float newCustomerOrderPercentage) {
        this.newCustomerOrderPercentage = newCustomerOrderPercentage;
    }

    public Float getContractAmountCount() {
        return contractAmountCount;
    }

    public void setContractAmountCount(Float contractAmountCount) {
        this.contractAmountCount = contractAmountCount;
    }

    public Float getAchievementAmountCount() {
        return achievementAmountCount;
    }

    public void setAchievementAmountCount(Float achievementAmountCount) {
        this.achievementAmountCount = achievementAmountCount;
    }

    public Float getDivideAmountCount() {
        return divideAmountCount;
    }

    public void setDivideAmountCount(Float divideAmountCount) {
        this.divideAmountCount = divideAmountCount;
    }

    public Float getOrderBackAmountCount() {
        return orderBackAmountCount;
    }

    public void setOrderBackAmountCount(Float orderBackAmountCount) {
        this.orderBackAmountCount = orderBackAmountCount;
    }
}
