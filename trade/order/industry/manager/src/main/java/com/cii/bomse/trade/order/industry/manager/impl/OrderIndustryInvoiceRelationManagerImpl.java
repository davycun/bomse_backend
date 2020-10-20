package com.cii.bomse.trade.order.industry.manager.impl;

import com.cii.bomse.trade.order.industry.dao.IOrderIndustryInvoiceRelationDao;
import com.cii.bomse.trade.order.industry.manager.IOrderIndustryInvoiceRelationManager;
import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceRelationEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class OrderIndustryInvoiceRelationManagerImpl extends AbstractManager<OrderIndustryInvoiceRelationEntity> implements IOrderIndustryInvoiceRelationManager {

    @Autowired
    private IOrderIndustryInvoiceRelationDao orderIndustryInvoiceRelationDao;

    @Override
    protected IMyBatisBaseDao<OrderIndustryInvoiceRelationEntity, Long> getMyBatisDao() {
        return orderIndustryInvoiceRelationDao;
    }

    @Override
    protected void beforeBatchCreate(List<OrderIndustryInvoiceRelationEntity> list) {
        for (OrderIndustryInvoiceRelationEntity orderIndustryInvoiceRelation : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<OrderIndustryInvoiceRelationEntity> list) {
         for (OrderIndustryInvoiceRelationEntity orderIndustryInvoiceRelation : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
