package com.cii.bomse.trade.order.industry.dto;
import com.ciiframework.service.AbstractRestControllerRequest;

public class OrderIndustryInvoiceControllerRequest extends AbstractRestControllerRequest<OrderIndustryInvoiceDto> {

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
