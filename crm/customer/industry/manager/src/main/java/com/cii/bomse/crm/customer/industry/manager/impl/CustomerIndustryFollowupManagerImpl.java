package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.base.dao.IBaseCustomerDao;
import com.cii.bomse.crm.customer.base.manager.impl.BaseCustomerFollowupManager;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryDao;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryFollowupDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupHouseEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryFollowupHouseManager;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryFollowupManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class CustomerIndustryFollowupManagerImpl extends BaseCustomerFollowupManager<CustomerIndustryFollowupEntity, CustomerIndustryEntity> implements ICustomerIndustryFollowupManager {

    @Autowired
    private ICustomerIndustryFollowupDao customerIndustryFollowupDao;
    @Autowired
    private ICustomerIndustryDao customerIndustryDao;
    @Autowired
    private ICustomerIndustryFollowupHouseManager customerIndustryFollowupHouseManager;

    @Override
    protected IMyBatisBaseDao<CustomerIndustryFollowupEntity, Long> getMyBatisDao() {
        return customerIndustryFollowupDao;
    }

    @Override
    public IBaseCustomerDao<CustomerIndustryEntity> getCustomerDao() {
        return customerIndustryDao;
    }

    @Override
    protected void afterBatchCreate(List<CustomerIndustryFollowupEntity> list) {

        updateCustomer(list, false);

        afterCreateAddLog(list);

        list.forEach((followup)->afterCreateProcessHouse(followup,followup.getFollowupHouseList()));
    }

    private void afterCreateProcessHouse(CustomerIndustryFollowupEntity followup,List<CustomerIndustryFollowupHouseEntity> list){

        ObjectUtils.forEach(list,followup,(house,up)->{
            house.setFollowupId(up.getId());
            house.setCusId(up.getCusId());
        });

        customerIndustryFollowupHouseManager.batchCreate(list);
    }

    @Override
    public void processCustomer(CustomerIndustryFollowupEntity followup) {

        super.processCustomer(followup);

        List<CustomerIndustryFollowupEntity> list = new ArrayList<>();
        list.add(followup);

        list.forEach((fl)->afterCreateProcessHouse(fl,fl.getFollowupHouseList()));
    }
}
