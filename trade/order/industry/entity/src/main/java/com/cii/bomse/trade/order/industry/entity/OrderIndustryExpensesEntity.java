package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.trade.order.industry.dictionary.OrderExpensesType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * @description
 * 费用支出明细
 * @auth david·cun
 * @date 2019-08-02 10:51
 * @since 1.0
 */
public class OrderIndustryExpensesEntity extends BaseEntity {

    /*订单编码*/
    private Long orderId;
    /*费用支出类型*/
    /**@see OrderExpensesType*/
    private String expensesType;
    @NotGenerate
    private String expensesTypeName;

    /*支出金额*/
    private BigDecimal expensesAmount;

    /*是否扣除分成业绩*/
    private Boolean hasDeductDivideAmount;
    /*是否扣除营收业绩*/
    private Boolean hasDeductAchievementAmount;

    public Boolean getHasDeductAchievementAmount() {
        return hasDeductAchievementAmount;
    }

    public void setHasDeductAchievementAmount(Boolean hasDeductAchievementAmount) {
        this.hasDeductAchievementAmount = hasDeductAchievementAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getExpensesType() {
        return expensesType;
    }

    public void setExpensesType(String expensesType) {
        this.expensesType = expensesType;
    }

    public String getExpensesTypeName() {
        return DictionaryStorage.get(OrderExpensesType.class.getName(),expensesType).getName();
    }

    public void setExpensesTypeName(String expensesTypeName) {
        this.expensesTypeName = expensesTypeName;
    }

    public Boolean getHasDeductDivideAmount() {
        return hasDeductDivideAmount;
    }

    public void setHasDeductDivideAmount(Boolean hasDeductDivideAmount) {
        this.hasDeductDivideAmount = hasDeductDivideAmount;
    }

    public BigDecimal getExpensesAmount() {
        return expensesAmount;
    }

    public void setExpensesAmount(BigDecimal expensesAmount) {
        this.expensesAmount = expensesAmount;
    }
}
