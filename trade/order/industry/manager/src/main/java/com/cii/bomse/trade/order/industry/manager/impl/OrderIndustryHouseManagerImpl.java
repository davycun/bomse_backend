package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryHouseDao;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryHouseManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryHouseEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class OrderIndustryHouseManagerImpl extends AbstractManager<OrderIndustryHouseEntity> implements IOrderIndustryHouseManager {

    @Autowired
    private IOrderIndustryHouseDao orderIndustryHouseDao;

    @Override
    protected IMyBatisBaseDao<OrderIndustryHouseEntity, Long> getMyBatisDao() {
        return orderIndustryHouseDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryHouseEntity> list) {
        for (OrderIndustryHouseEntity orderIndustryHouse : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<OrderIndustryHouseEntity> list) {
         for (OrderIndustryHouseEntity orderIndustryHouse : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
