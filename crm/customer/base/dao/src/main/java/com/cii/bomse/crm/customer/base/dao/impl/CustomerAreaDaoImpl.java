package com.cii.bomse.crm.customer.base.dao.impl;

import com.cii.bomse.crm.customer.base.dao.ICustomerAreaDao;
import com.cii.bomse.crm.customer.base.entity.CustomerAreaEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAreaDaoImpl extends AbstractMyBatisDao<CustomerAreaEntity,Long> implements ICustomerAreaDao {
}
