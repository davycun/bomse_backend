package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryInvoiceDaoImpl extends AbstractMyBatisDao<OrderIndustryInvoiceEntity,Long> implements IOrderIndustryInvoiceDao {
}
