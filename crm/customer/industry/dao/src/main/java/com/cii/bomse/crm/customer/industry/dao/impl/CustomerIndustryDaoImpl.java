package com.cii.bomse.crm.customer.industry.dao.impl;

import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerIndustryDaoImpl extends AbstractMyBatisDao<CustomerIndustryEntity,Long> implements ICustomerIndustryDao {
}
