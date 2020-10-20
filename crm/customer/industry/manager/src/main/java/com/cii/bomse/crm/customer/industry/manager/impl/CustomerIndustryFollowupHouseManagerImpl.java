package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryFollowupHouseDao;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryFollowupHouseManager;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupHouseEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class CustomerIndustryFollowupHouseManagerImpl extends AbstractManager<CustomerIndustryFollowupHouseEntity> implements ICustomerIndustryFollowupHouseManager {

    @Autowired
    private ICustomerIndustryFollowupHouseDao customerIndustryFollowupHouseDao;

    @Override
    protected IMyBatisBaseDao<CustomerIndustryFollowupHouseEntity, Long> getMyBatisDao() {
        return customerIndustryFollowupHouseDao;
    }
}
