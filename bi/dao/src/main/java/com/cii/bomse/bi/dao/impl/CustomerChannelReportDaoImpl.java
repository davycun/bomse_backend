package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.ICustomerChannelReportDao;
import com.cii.bomse.bi.entity.CustomerChannelReportEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerChannelReportDaoImpl extends AbstractMyBatisDao<CustomerChannelReportEntity,Long> implements ICustomerChannelReportDao {
}
