package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryDivideDao;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryDivideManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryDivideEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class OrderIndustryDivideManagerImpl extends AbstractManager<OrderIndustryDivideEntity> implements IOrderIndustryDivideManager {

    @Autowired
    private IOrderIndustryDivideDao orderIndustryDivideDao;

    @Override
    protected IMyBatisBaseDao<OrderIndustryDivideEntity, Long> getMyBatisDao() {
        return orderIndustryDivideDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryDivideEntity> list) {
        for (OrderIndustryDivideEntity orderIndustryDivide : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<OrderIndustryDivideEntity> list) {
         for (OrderIndustryDivideEntity orderIndustryDivide : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
