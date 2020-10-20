package com.cii.bomse.crm.customer.industry.dao.impl;

import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryFollowupDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerIndustryFollowupDaoImpl extends AbstractMyBatisDao<CustomerIndustryFollowupEntity,Long> implements ICustomerIndustryFollowupDao {
}
