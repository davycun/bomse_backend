package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceRelationDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceRelationEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryInvoiceRelationDaoImpl extends AbstractMyBatisDao<OrderIndustryInvoiceRelationEntity,Long> implements IOrderIndustryInvoiceRelationDao {
}
