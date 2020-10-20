package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryDaoImpl extends AbstractMyBatisDao<OrderIndustryEntity,Long> implements IOrderIndustryDao {
}
