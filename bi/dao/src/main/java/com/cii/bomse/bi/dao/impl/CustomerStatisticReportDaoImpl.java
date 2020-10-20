package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.ICustomerStatisticReportDao;
import com.cii.bomse.bi.entity.CustomerStatisticReportEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerStatisticReportDaoImpl extends AbstractMyBatisDao<CustomerStatisticReportEntity,Long> implements ICustomerStatisticReportDao {

}
