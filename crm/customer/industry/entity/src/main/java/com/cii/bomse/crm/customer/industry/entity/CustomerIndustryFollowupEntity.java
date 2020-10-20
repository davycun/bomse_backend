package com.cii.bomse.crm.customer.industry.entity;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerFollowupEntity;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 15:45
 * @since 1.0
 */
public class CustomerIndustryFollowupEntity extends BaseCustomerFollowupEntity {

    private List<CustomerIndustryFollowupHouseEntity> followupHouseList;

    public List<CustomerIndustryFollowupHouseEntity> getFollowupHouseList() {
        return followupHouseList;
    }

    public void setFollowupHouseList(List<CustomerIndustryFollowupHouseEntity> followupHouseList) {
        this.followupHouseList = followupHouseList;
    }
}
