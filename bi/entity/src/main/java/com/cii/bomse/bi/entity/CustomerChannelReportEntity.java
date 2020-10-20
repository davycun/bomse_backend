package com.cii.bomse.bi.entity;

import com.ciiframework.dictionary.DictionaryStorage;

/**
 * @description 渠道转化报表
 * @auth david·cun
 * @date 2019-09-19 14:42
 * @since 1.0
 */
public class CustomerChannelReportEntity extends BaseReportEntity {

    /*客户来源*/
    private String cusSource;

    /*个人获客量*/
    private Float customerPersonalCount = 0f;
    /*公司获客量*/
    private Float customerCompanyCount = 0f;
    /*已确定位置的*/
    private Float customerHasRentCount = 0f;
    /*可承接*/
    private Float customerAcceptCount = 0f;
    /*有效客户，可承接概率*/
    private Float customerAcceptPercentage = 0f;
    /*总勘查量*/
    private Float customerSurveyCount = 0f;
    /*新（单位时间内）获客勘查量*/
    private Float newCustomerSurveyCount = 0f;
    /*获客勘查率*/
    private Float newCustomerSurveyPercentage = 0f;
    /*签约量*/
    private Float orderCount = 0f;
    /*新（单位时间内）客户签约量*/
    private Float newCustomerOrderCount = 0f;
    /*获客成交*/
    private Float newCustomerOrderPercentage = 0f;

    public Float getCustomerAcceptPercentage() {

        if (customerPersonalCount+customerCompanyCount >0){
            customerAcceptPercentage = customerAcceptCount/Float.valueOf(customerPersonalCount+customerCompanyCount);
        }
        return customerAcceptPercentage;
    }

    public void setCustomerAcceptPercentage(Float customerAcceptPercentage) {
        this.customerAcceptPercentage = customerAcceptPercentage;
    }

    public Float getNewCustomerSurveyPercentage() {
        if (customerPersonalCount+customerCompanyCount >0){
            newCustomerSurveyPercentage = newCustomerSurveyCount/Float.valueOf(customerPersonalCount+customerCompanyCount);
        }
        return newCustomerSurveyPercentage;
    }

    public void setNewCustomerSurveyPercentage(Float newCustomerSurveyPercentage) {
        this.newCustomerSurveyPercentage = newCustomerSurveyPercentage;
    }

    public Float getNewCustomerOrderPercentage() {
        if (customerPersonalCount+customerCompanyCount >0){
            newCustomerOrderPercentage = newCustomerOrderCount/Float.valueOf(customerPersonalCount+customerCompanyCount);
        }
        return newCustomerOrderPercentage;
    }

    public void setNewCustomerOrderPercentage(Float newCustomerOrderPercentage) {
        this.newCustomerOrderPercentage = newCustomerOrderPercentage;
    }

    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
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

    public Float getCustomerHasRentCount() {
        return customerHasRentCount;
    }

    public void setCustomerHasRentCount(Float customerHasRentCount) {
        this.customerHasRentCount = customerHasRentCount;
    }

    public Float getCustomerAcceptCount() {
        return customerAcceptCount;
    }

    public void setCustomerAcceptCount(Float customerAcceptCount) {
        this.customerAcceptCount = customerAcceptCount;
    }

    public Float getCustomerSurveyCount() {
        return customerSurveyCount;
    }

    public void setCustomerSurveyCount(Float customerSurveyCount) {
        this.customerSurveyCount = customerSurveyCount;
    }

    public Float getNewCustomerSurveyCount() {
        return newCustomerSurveyCount;
    }

    public void setNewCustomerSurveyCount(Float newCustomerSurveyCount) {
        this.newCustomerSurveyCount = newCustomerSurveyCount;
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
}
