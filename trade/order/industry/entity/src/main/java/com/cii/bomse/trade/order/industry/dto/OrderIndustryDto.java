package com.cii.bomse.trade.order.industry.dto;

import com.cii.bomse.trade.order.industry.entity.OrderIndustryEntity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderIndustryDto extends OrderIndustryEntity {

    private Date orderTimeStart;
    private Date orderTimeEnd;
    private BigDecimal contractAmountStart;
    private BigDecimal contractAmountEnd;
    private Date createTimeStart;
    private Date createTimeEnd;

    public Date getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(Date orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public Date getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(Date orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public BigDecimal getContractAmountStart() {
        return contractAmountStart;
    }

    public void setContractAmountStart(BigDecimal contractAmountStart) {
        this.contractAmountStart = contractAmountStart;
    }

    public BigDecimal getContractAmountEnd() {
        return contractAmountEnd;
    }

    public void setContractAmountEnd(BigDecimal contractAmountEnd) {
        this.contractAmountEnd = contractAmountEnd;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
