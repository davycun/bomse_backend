package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryHouseDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryHouseEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryHouseDaoImpl extends AbstractMyBatisDao<OrderIndustryHouseEntity,Long> implements IOrderIndustryHouseDao {
}
