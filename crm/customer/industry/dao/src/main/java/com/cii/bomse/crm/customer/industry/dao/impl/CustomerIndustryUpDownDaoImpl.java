package com.cii.bomse.crm.customer.industry.dao.impl;

import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryUpDownDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryUpDownEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerIndustryUpDownDaoImpl extends AbstractMyBatisDao<CustomerIndustryUpDownEntity,Long> implements ICustomerIndustryUpDownDao {
}
