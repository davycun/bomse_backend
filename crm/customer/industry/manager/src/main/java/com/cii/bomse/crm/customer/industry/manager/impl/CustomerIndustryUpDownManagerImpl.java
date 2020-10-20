package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.base.dao.IBaseCustomerDao;
import com.cii.bomse.crm.customer.base.manager.impl.BaseCustomerUpDownManager;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryDao;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryUpDownDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryUpDownEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryUpDownManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerIndustryUpDownManagerImpl extends BaseCustomerUpDownManager<CustomerIndustryUpDownEntity, CustomerIndustryEntity> implements ICustomerIndustryUpDownManager {

    @Autowired
    private ICustomerIndustryUpDownDao customerIndustryUpDownDao;

    @Autowired
    private ICustomerIndustryDao customerIndustryDao;

    @Override
    protected IMyBatisBaseDao<CustomerIndustryUpDownEntity, Long> getMyBatisDao() {
        return customerIndustryUpDownDao;
    }

    @Override
    public IBaseCustomerDao<CustomerIndustryEntity> getCustomerDao() {
        return customerIndustryDao;
    }
}
