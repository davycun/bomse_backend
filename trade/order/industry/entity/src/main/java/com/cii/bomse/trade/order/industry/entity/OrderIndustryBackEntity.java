package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.trade.order.industry.dictionary.OrderBackChannel;
import com.cii.bomse.trade.order.industry.dictionary.OrderBackStatus;
import com.cii.bomse.trade.order.industry.dictionary.OrderBackType;
import com.cii.bomse.trade.order.industry.dictionary.OrderBadBackReason;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description
 * 订单回款记录
 * @auth david·cun
 * @date 2019-08-07 13:59
 * @since 1.0
 */
public class OrderIndustryBackEntity extends BaseEntity {

    /*订单编号*/
    @NotNull(message = "订单编码必填")
    private Long orderId;
    /*回款时间*/
    @NotNull(message = "回款时间必填")
    private Date backTime;
    /*回款金额*/
    @NotNull(message = "回款金额必填")
    @Min(0)
    private BigDecimal backAmount;
    /*回款类型*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.OrderBackType */
    @NotNull(message = "回款类型必填")
    private String backType;
    @NotGenerate
    private String backTypeName;

    /*坏账原因*/
    /**@see OrderBadBackReason*/
    private String badBackReason;
    @NotGenerate
    private String badBackReasonName;

    /*回款渠道*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.OrderBackChannel */
    @NotNull(message = "回款渠道必填")
    private String backChannel;
    @NotGenerate
    private String backChannelName;

    /*付款方账户*/
    private String backAccount;
    /*收款方账户，针对集团公司多个子公司有用*/
    private String payAccount;

    /*渠道回款流水号*/
    private String channelNumber;

    /*确认状态*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.OrderBackStatus */
    private String backStatus;
    @NotGenerate
    private String backStatusName;

    /*认领人编码*/
    private Long confirmId;
    /*认领人姓名*/
    private String confirmName;

    /*认领之后关联到订单*/
    @NotGenerate
    private OrderIndustryEntity order;

    /*是否已开发票*/
    private Boolean hasInvoice;

    @NotGenerate
    private List<OrderIndustryInvoiceRelationEntity> orderBackRelationList;

    public List<OrderIndustryInvoiceRelationEntity> getOrderBackRelationList() {
        return orderBackRelationList;
    }

    public void setOrderBackRelationList(List<OrderIndustryInvoiceRelationEntity> orderBackRelationList) {
        this.orderBackRelationList = orderBackRelationList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getBadBackReason() {
        return badBackReason;
    }

    public void setBadBackReason(String badBackReason) {
        this.badBackReason = badBackReason;
    }

    public String getBadBackReasonName() {
        return DictionaryStorage.get(OrderBadBackReason.class.getName(),badBackReason).getName();
    }

    public void setBadBackReasonName(String badBackReasonName) {
        this.badBackReasonName = badBackReasonName;
    }

    public Boolean getHasInvoice() {
        return hasInvoice;
    }

    public void setHasInvoice(Boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    public OrderIndustryEntity getOrder() {
        return order;
    }

    public void setOrder(OrderIndustryEntity order) {
        this.order = order;
    }

    public Long getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Long confirmId) {
        this.confirmId = confirmId;
    }

    public String getConfirmName() {
        return confirmName;
    }

    public void setConfirmName(String confirmName) {
        this.confirmName = confirmName;
    }

    public String getBackAccount() {
        return backAccount;
    }

    public void setBackAccount(String backAccount) {
        this.backAccount = backAccount;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getBackTypeName() {
        return DictionaryStorage.get(OrderBackType.class.getName(),backType).getName();
    }

    public void setBackTypeName(String backTypeName) {
        this.backTypeName = backTypeName;
    }

    public String getBackChannelName() {
        return DictionaryStorage.get(OrderBackChannel.class.getName(),backChannel).getName();
    }

    public void setBackChannelName(String backChannelName) {
        this.backChannelName = backChannelName;
    }

    public String getBackStatusName() {
        return DictionaryStorage.get(OrderBackStatus.class.getName(),backStatus).getName();
    }

    public void setBackStatusName(String backStatusName) {
        this.backStatusName = backStatusName;
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(String channelNumber) {
        this.channelNumber = channelNumber;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public BigDecimal getBackAmount() {
        return backAmount;
    }

    public void setBackAmount(BigDecimal backAmount) {
        this.backAmount = backAmount;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public String getBackChannel() {
        return backChannel;
    }

    public void setBackChannel(String backChannel) {
        this.backChannel = backChannel;
    }

    public String getBackStatus() {
        return backStatus;
    }

    public void setBackStatus(String backStatus) {
        this.backStatus = backStatus;
    }
}
