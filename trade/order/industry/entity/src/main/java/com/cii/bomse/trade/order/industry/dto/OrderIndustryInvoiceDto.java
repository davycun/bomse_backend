package com.cii.bomse.trade.order.industry.dto;

import com.cii.bomse.trade.order.industry.entity.OrderIndustryInvoiceEntity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderIndustryInvoiceDto extends OrderIndustryInvoiceEntity {

    private Date createTimeStart;
    private Date createTimeEnd;
    private Date mailTimeStart;
    private Date mailTimeEnd;
    private BigDecimal invoiceAmountStart;
    private BigDecimal invoiceAmountEnd;

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

    public Date getMailTimeStart() {
        return mailTimeStart;
    }

    public void setMailTimeStart(Date mailTimeStart) {
        this.mailTimeStart = mailTimeStart;
    }

    public Date getMailTimeEnd() {
        return mailTimeEnd;
    }

    public void setMailTimeEnd(Date mailTimeEnd) {
        this.mailTimeEnd = mailTimeEnd;
    }

    public BigDecimal getInvoiceAmountStart() {
        return invoiceAmountStart;
    }

    public void setInvoiceAmountStart(BigDecimal invoiceAmountStart) {
        this.invoiceAmountStart = invoiceAmountStart;
    }

    public BigDecimal getInvoiceAmountEnd() {
        return invoiceAmountEnd;
    }

    public void setInvoiceAmountEnd(BigDecimal invoiceAmountEnd) {
        this.invoiceAmountEnd = invoiceAmountEnd;
    }
}
