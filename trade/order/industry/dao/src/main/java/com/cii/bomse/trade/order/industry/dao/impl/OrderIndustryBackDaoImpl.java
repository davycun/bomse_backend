package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryBackDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryBackDaoImpl extends AbstractMyBatisDao<OrderIndustryBackEntity,Long> implements IOrderIndustryBackDao {
}
