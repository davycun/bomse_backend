package com.cii.bomse.trade.order.industry.manager;

import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;
import com.ciiframework.common.business.IManager;

public interface IOrderIndustryBackManager extends IManager<OrderIndustryBackEntity> {

    /**
     * @description
     * 认领当前回款记录，其实就是做一个与订单的关联
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-09 22:16
     * @since 1.0
     */
    void confirm(Long orderId,Long backId);
}
