package com.cii.bomse.crm.customer.industry.dao.impl;

import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryPushDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryPushEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerIndustryPushDaoImpl extends AbstractMyBatisDao<CustomerIndustryPushEntity,Long> implements ICustomerIndustryPushDao {
}
