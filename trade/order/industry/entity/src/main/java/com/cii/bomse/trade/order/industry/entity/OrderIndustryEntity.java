package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.common.dictionary.IndustryPriceUnitType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerSource;
import com.cii.bomse.trade.order.industry.dictionary.OrderStatus;
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
 * @auth david·cun
 * @date 2019-07-08 23:06
 * @since 1.0
 */
public class OrderIndustryEntity extends BaseEntity {

    /*==基本信息=======================*/
    /*客户编码*/
    @NotNull(message = "客户编码必填")
    private Long cusId;
    /*客户姓名*/
    @NotNull(message = "客户姓名必填")
    private String cusName;
    /*客户电话*/
    @NotNull(message = "客户电话必填")
    private String cusPhone;
    /*客户公司名称*/
    @NotNull(message = "客户公司名称必填")
    private String company;
    /*客户来源*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerSource*/
    @NotNull(message = "客户来源必填")
    private String cusSource;
    @NotGenerate
    private String cusSourceName;
    /*客户类型*/
    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType*/
    private String cusOwnerType;
    @NotGenerate
    private String cusOwnerTypeName;


    private String houseType;

    /*租赁总面积*/
    /*成交房源的位置，如果是多个房源，通过逗号隔开*/
    private String houseAddress;
    private Float leaseAcreage;
    private Float leasePrice;
    private String leasePriceUnit;
    @NotGenerate
    private String leasePriceUnitName;
    /*合同开始时间*/
    private Date contractTimeStart;
    /*合同结束时间*/
    private Date contractTimeEnd;

    /*====兼职ID，兼职推荐的客户签约*/
    private Long ptId;
    /*兼职姓名*/
    private String ptName;
    /*兼职电话*/
    private String ptPhone;

    /*业绩日期*/
    @NotNull(message = "业绩日期必填")
    private Date orderTime;
    /*订单状态*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.OrderStatus*/
    private String orderStatus;
    @NotGenerate
    private String orderStatusName;

    /*==收入相关信息==========================*/
    /*房东佣金*/
    private BigDecimal landlordContractAmount;
    /*客户佣金*/
    private BigDecimal customerContractAmount;

    /*订单总佣金，等于房东佣金和客户佣金之和*/
    private BigDecimal contractAmount;
    /*业绩金额*/
    /*业绩金额 = 合同金额 - 返佣 - 兼职分钱 - ...*/
    @NotNull(message = "业绩金额必填")
    @Min(value = 0,message = "业绩金额不能小于零")
    private BigDecimal achievementAmount;
    /*分成金额*/
    /*分成金额 = 业绩金额 - 税额 - ...*/
    @NotNull(message = "分成金额必填")
    @Min(value = 0,message = "分成金额不能小于零")
    private BigDecimal divideAmount;

    /*订单分成明细*/
    @NotGenerate
    private List<OrderIndustryDivideEntity> orderDivides;

    /*订单费用支出*/
    @NotGenerate
    private List<OrderIndustryExpensesEntity> orderExpenses;
    /*订单成交的房源列表*/
    @NotGenerate
    private List<OrderIndustryHouseEntity> orderHouses;

    /*已经回款的金额*/
    private BigDecimal backedAmount;
    /*坏账的金额*/
    private BigDecimal badBackAmount;
    /*已开票金额*/
    private BigDecimal invoiceAmount;

    public String getLeasePriceUnitName() {
        return DictionaryStorage.get(IndustryPriceUnitType.class.getName(),leasePriceUnit).getName();
    }

    public void setLeasePriceUnitName(String leasePriceUnitName) {
        this.leasePriceUnitName = leasePriceUnitName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public List<OrderIndustryHouseEntity> getOrderHouses() {
        return orderHouses;
    }

    public void setOrderHouses(List<OrderIndustryHouseEntity> orderHouses) {
        this.orderHouses = orderHouses;
    }

    public Float getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(Float leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeasePriceUnit() {
        return leasePriceUnit;
    }

    public void setLeasePriceUnit(String leasePriceUnit) {
        this.leasePriceUnit = leasePriceUnit;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Float getLeaseAcreage() {
        return leaseAcreage;
    }

    public void setLeaseAcreage(Float leaseAcreage) {
        this.leaseAcreage = leaseAcreage;
    }

    public Date getContractTimeStart() {
        return contractTimeStart;
    }

    public void setContractTimeStart(Date contractTimeStart) {
        this.contractTimeStart = contractTimeStart;
    }

    public Date getContractTimeEnd() {
        return contractTimeEnd;
    }

    public void setContractTimeEnd(Date contractTimeEnd) {
        this.contractTimeEnd = contractTimeEnd;
    }

    public BigDecimal getLandlordContractAmount() {
        return landlordContractAmount;
    }

    public void setLandlordContractAmount(BigDecimal landlordContractAmount) {
        this.landlordContractAmount = landlordContractAmount;
    }

    public BigDecimal getCustomerContractAmount() {
        return customerContractAmount;
    }

    public void setCustomerContractAmount(BigDecimal customerContractAmount) {
        this.customerContractAmount = customerContractAmount;
    }

    public Long getPtId() {
        return ptId;
    }

    public void setPtId(Long ptId) {
        this.ptId = ptId;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getPtPhone() {
        return ptPhone;
    }

    public void setPtPhone(String ptPhone) {
        this.ptPhone = ptPhone;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getCusOwnerType() {
        return cusOwnerType;
    }

    public void setCusOwnerType(String cusOwnerType) {
        this.cusOwnerType = cusOwnerType;
    }

    public String getCusOwnerTypeName() {
        return DictionaryStorage.get(CustomerOwnerType.class.getName(),cusOwnerType).getName();
    }

    public void setCusOwnerTypeName(String cusOwnerTypeName) {
        this.cusOwnerTypeName = cusOwnerTypeName;
    }

    public BigDecimal getBackedAmount() {
        return backedAmount;
    }

    public void setBackedAmount(BigDecimal backedAmount) {
        this.backedAmount = backedAmount;
    }

    public BigDecimal getBadBackAmount() {
        return badBackAmount;
    }

    public void setBadBackAmount(BigDecimal badBackAmount) {
        this.badBackAmount = badBackAmount;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public List<OrderIndustryExpensesEntity> getOrderExpenses() {
        return orderExpenses;
    }

    public void setOrderExpenses(List<OrderIndustryExpensesEntity> orderExpenses) {
        this.orderExpenses = orderExpenses;
    }

    public List<OrderIndustryDivideEntity> getOrderDivides() {
        return orderDivides;
    }

    public void setOrderDivides(List<OrderIndustryDivideEntity> orderDivides) {
        this.orderDivides = orderDivides;
    }

    public String getCusSourceName() {
        return DictionaryStorage.get(CustomerSource.class.getName(),cusSource).getName();
    }

    public void setCusSourceName(String cusSourceName) {
        this.cusSourceName = cusSourceName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return DictionaryStorage.get(OrderStatus.class.getName(),orderStatus).getName();
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public BigDecimal getAchievementAmount() {
        return achievementAmount;
    }

    public void setAchievementAmount(BigDecimal achievementAmount) {
        this.achievementAmount = achievementAmount;
    }

    public BigDecimal getDivideAmount() {
        return divideAmount;
    }

    public void setDivideAmount(BigDecimal divideAmount) {
        this.divideAmount = divideAmount;
    }

}
