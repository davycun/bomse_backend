package com.cii.bomse.trade.order.industry.dto;

import com.cii.bomse.trade.order.industry.entity.OrderIndustryBackEntity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderIndustryBackDto extends OrderIndustryBackEntity {
    private Date backTimeStart;
    private Date backTimeEnd;

    private BigDecimal backAmountStart;
    private BigDecimal backAmountEnd;

    public Date getBackTimeStart() {
        return backTimeStart;
    }

    public void setBackTimeStart(Date backTimeStart) {
        this.backTimeStart = backTimeStart;
    }

    public Date getBackTimeEnd() {
        return backTimeEnd;
    }

    public void setBackTimeEnd(Date backTimeEnd) {
        this.backTimeEnd = backTimeEnd;
    }

    public BigDecimal getBackAmountStart() {
        return backAmountStart;
    }

    public void setBackAmountStart(BigDecimal backAmountStart) {
        this.backAmountStart = backAmountStart;
    }

    public BigDecimal getBackAmountEnd() {
        return backAmountEnd;
    }

    public void setBackAmountEnd(BigDecimal backAmountEnd) {
        this.backAmountEnd = backAmountEnd;
    }
}
