package com.cii.bomse.trade.order.industry.dao.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryExpensesDao;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryExpensesEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIndustryExpensesDaoImpl extends AbstractMyBatisDao<OrderIndustryExpensesEntity,Long> implements IOrderIndustryExpensesDao {
}
