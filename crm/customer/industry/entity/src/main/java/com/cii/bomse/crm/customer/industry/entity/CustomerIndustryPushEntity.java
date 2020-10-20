package com.cii.bomse.crm.customer.industry.entity;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerPushEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 18:36
 * @since 1.0
 */
public class CustomerIndustryPushEntity extends BaseCustomerPushEntity {

    private CustomerIndustryEntity customer;

    public CustomerIndustryEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerIndustryEntity customer) {
        this.customer = customer;
    }
}
