package com.cii.bomse.trade.order.industry.manager;

import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;
import com.ciiframework.common.business.IManager;

public interface IOrderIndustryInvoiceManager extends IManager<OrderIndustryInvoiceEntity> {

    /**
     * @description
     * 纸质的发票就邮寄后填写邮寄信息
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-10 21:34
     * @since 1.0
     */
    public void mail(OrderIndustryInvoiceEntity invoice);
}
