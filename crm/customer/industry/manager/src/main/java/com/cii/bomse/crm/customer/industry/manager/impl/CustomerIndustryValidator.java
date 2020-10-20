package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.base.manager.IBaseCustomerPushManager;
import com.cii.bomse.crm.customer.base.manager.impl.BaseCustomerValidator;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryPushManager;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 18:54
 * @since 1.0
 */
@Component
public class CustomerIndustryValidator extends BaseCustomerValidator<CustomerIndustryEntity> implements ICustomerIndustryValidator {

    @Autowired
    private ICustomerIndustryPushManager customerIndustryPushManager;

    @Override
    public IBaseCustomerPushManager getCustomerPushManager() {
        return customerIndustryPushManager;
    }
}
