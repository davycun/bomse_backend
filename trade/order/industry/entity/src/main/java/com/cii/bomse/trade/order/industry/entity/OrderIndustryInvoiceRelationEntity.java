package com.cii.bomse.trade.order.industry.entity;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-10 13:53
 * @since 1.0
 */
public class OrderIndustryInvoiceRelationEntity extends BaseEntity {

    /*回款ID*/
    private Long backId;
    /*发票ID*/
    private Long invoiceId;
    /*订单ID*/
    private Long orderId;

    public Long getBackId() {
        return backId;
    }

    public void setBackId(Long backId) {
        this.backId = backId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
