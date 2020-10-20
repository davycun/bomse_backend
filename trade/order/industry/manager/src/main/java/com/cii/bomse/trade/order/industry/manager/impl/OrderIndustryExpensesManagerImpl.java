package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryExpensesDao;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryExpensesManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryExpensesEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class OrderIndustryExpensesManagerImpl extends AbstractManager<OrderIndustryExpensesEntity> implements IOrderIndustryExpensesManager {

    @Autowired
    private IOrderIndustryExpensesDao orderIndustryExpensesDao;

    @Override
    protected IMyBatisBaseDao<OrderIndustryExpensesEntity, Long> getMyBatisDao() {
        return orderIndustryExpensesDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryExpensesEntity> list) {
        for (OrderIndustryExpensesEntity orderIndustryExpenses : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<OrderIndustryExpensesEntity> list) {
         for (OrderIndustryExpensesEntity orderIndustryExpenses : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
