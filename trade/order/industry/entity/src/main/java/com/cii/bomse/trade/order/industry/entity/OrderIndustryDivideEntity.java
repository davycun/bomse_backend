package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.trade.order.industry.dictionary.OrderDivideType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-07-18 12:39
 * @since 1.0
 */
public class OrderIndustryDivideEntity extends BaseEntity {

    /*订单编号*/
    private Long orderId;
    /*业绩日期*/
    private Date orderTime;
    /*分成类型*/
    /**
     * @see OrderDivideType
     */
    private String divideType;
    @NotGenerate
    private String divideTypeName;
    @NotGenerate
    private String[] divideTypeList;
    @NotGenerate
    private String[] divideTypeNameList;
    /*业绩分成百分比*/
    private Float dividePercentage;
    /*分成金额*/
    private BigDecimal divideAmount;
    /*工资提成*/
    private Float wagesPercentage;

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDivideType() {
        if (ObjectUtils.isEmpty(divideType)
                && ObjectUtils.isNotEmpty(divideTypeList)) {
            divideType = StringUtils.join(divideTypeList, ",");
        }
        return divideType;
    }

    public void setDivideType(String divideType) {
        this.divideType = divideType;
    }

    public String getDivideTypeName() {
        if (ObjectUtils.isEmpty(divideTypeName)
                && ObjectUtils.isNotEmpty(getDivideTypeNameList())) {
            divideTypeName = StringUtils.join(getDivideTypeNameList(), ",");
        }
        return divideTypeName;
    }

    public void setDivideTypeName(String divideTypeName) {
        this.divideTypeName = divideTypeName;
    }

    public String[] getDivideTypeList() {

        if (ObjectUtils.isNotEmpty(divideType)
                && ObjectUtils.isEmpty(divideTypeList)) {
            divideTypeList = divideType.split(",");
        }
        return divideTypeList;
    }

    public void setDivideTypeList(String[] divideTypeList) {
        this.divideTypeList = divideTypeList;
    }

    public String[] getDivideTypeNameList() {

        if (ObjectUtils.isEmpty(divideTypeNameList)
                && ObjectUtils.isNotEmpty(getDivideTypeList())) {
            String[] tmp = getDivideTypeList();
            divideTypeNameList = new String[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                divideTypeNameList[i] = DictionaryStorage.get(OrderDivideType.class.getName(), tmp[i]).getName();
            }
        }

        return divideTypeNameList;
    }

    public void setDivideTypeNameList(String[] divideTypeNameList) {
        this.divideTypeNameList = divideTypeNameList;
    }


    public Float getDividePercentage() {
        return dividePercentage;
    }

    public void setDividePercentage(Float dividePercentage) {
        this.dividePercentage = dividePercentage;
    }

    public BigDecimal getDivideAmount() {
        return divideAmount;
    }

    public void setDivideAmount(BigDecimal divideAmount) {
        this.divideAmount = divideAmount;
    }

    public Float getWagesPercentage() {
        return wagesPercentage;
    }

    public void setWagesPercentage(Float wagesPercentage) {
        this.wagesPercentage = wagesPercentage;
    }
}
