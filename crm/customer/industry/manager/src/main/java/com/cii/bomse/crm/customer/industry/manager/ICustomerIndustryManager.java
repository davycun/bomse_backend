package com.cii.bomse.crm.customer.industry.manager;


import com.cii.bomse.crm.customer.base.manager.IBaseCustomerManager;
import com.cii.bomse.crm.customer.industry.dto.CustomerStatisticDto;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;

public interface ICustomerIndustryManager extends IBaseCustomerManager<CustomerIndustryEntity> {

    public CustomerStatisticDto waitWorkStatistic();
}
