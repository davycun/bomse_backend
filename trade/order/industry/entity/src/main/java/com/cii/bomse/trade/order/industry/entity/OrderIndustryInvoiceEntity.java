package com.cii.bomse.trade.order.industry.entity;

import com.cii.bomse.trade.order.industry.dictionary.InvoiceProperty;
import com.cii.bomse.trade.order.industry.dictionary.InvoiceStatus;
import com.cii.bomse.trade.order.industry.dictionary.InvoiceType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description
 * 开票记录
 * 1、开具类型为个人，则无需填写企业任何信息
 * 2、企业增值税普通发票，发票抬头，税务号必填
 * 3、增值税专用发票，所有信息必填
 * 4、组织（非企业）增值税普通发票，发票抬头必填，一般是政府及非营利机构
 * @auth david·cun
 * @date 2019-08-08 15:28
 * @since 1.0
 */
public class OrderIndustryInvoiceEntity extends BaseEntity {

    /*发票编号*/
    private String invNumber;
    /*开票金额*/
    private BigDecimal invoiceAmount;

    /*==发票信息===========*/
    /*发票类型：企业增值税普通发票，增值税专用发票，组织（非企业）增值税普通发票*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.InvoiceType*/
    private String invoiceType;
    @NotGenerate
    private String invoiceTypeName;
    /*发票性质：纸质，电子*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.InvoiceProperty*/
    private String invoiceProp;
    @NotGenerate
    private String invoicePropName;
    /*发票抬头*/
    private String invoiceTitle;
    /*税务登记证号*/
    private String taxNumber;
    /*基本开户银行名称，公司名称*/
    private String accountBankName;
    /*基本开户账号，银行卡号*/
    private String accountBankNumber;
    /*注册场所地址*/
    private String registerAddress;
    /*注册固定电话*/
    private String registerTelephone;

    /*==电子发票邮件发送=======*/
    private String email;
    /*如果是电子发票，就填写发票地址*/
    private String invoiceUrl;

    /*==物流信息============*/
    /*快递公司*/
    @NotNull(message = "快递公司名称必填")
    private String expressCompany;
    /*物流单号*/
    @NotNull(message = "快递单号必填")
    private String expressCode;
    /*联系人*/
    private String linkMan;
    /*联系人电话*/
    private String linkManPhone;
    /*联系地址*/
    private String address;

    /*邮件的时间*/
    private Date mailTime;

    /*==其他属性信息========*/
    /*开票状态，申请中、已邮寄、已发送（针对电子邮件发送Email）*/
    /**@see com.cii.bomse.trade.order.industry.dictionary.InvoiceStatus*/
    private String invoiceStatus;
    @NotGenerate
    private String invoiceStatusName;

    /*开票的回款金额,如果先回款再开票,那么回款金额等于开票金额*/
    private BigDecimal backAmount;

    /*订单/回款/发票关联表*/
    @Size(min = 1,message = "发票申请，必须有回款才能申请!")
    private List<OrderIndustryInvoiceRelationEntity> orderBackRelations;

    public BigDecimal getBackAmount() {
        return backAmount;
    }

    public void setBackAmount(BigDecimal backAmount) {
        this.backAmount = backAmount;
    }

    public Date getMailTime() {
        return mailTime;
    }

    public void setMailTime(Date mailTime) {
        this.mailTime = mailTime;
    }

    public String getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(String invNumber) {
        this.invNumber = invNumber;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public List<OrderIndustryInvoiceRelationEntity> getOrderBackRelations() {
        return orderBackRelations;
    }

    public void setOrderBackRelations(List<OrderIndustryInvoiceRelationEntity> orderBackRelations) {
        this.orderBackRelations = orderBackRelations;
    }

    public String getInvoiceTypeName() {
        return DictionaryStorage.get(InvoiceType.class.getName(),invoiceType).getName();
    }

    public void setInvoiceTypeName(String invoiceTypeName) {
        this.invoiceTypeName = invoiceTypeName;
    }

    public String getInvoicePropName() {
        return DictionaryStorage.get(InvoiceProperty.class.getName(),invoiceProp).getName();
    }

    public void setInvoicePropName(String invoicePropName) {
        this.invoicePropName = invoicePropName;
    }

    public String getInvoiceStatusName() {
        return DictionaryStorage.get(InvoiceStatus.class.getName(),invoiceStatus).getName();
    }

    public void setInvoiceStatusName(String invoiceStatusName) {
        this.invoiceStatusName = invoiceStatusName;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceProp() {
        return invoiceProp;
    }

    public void setInvoiceProp(String invoiceProp) {
        this.invoiceProp = invoiceProp;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAccountBankName() {
        return accountBankName;
    }

    public void setAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName;
    }

    public String getAccountBankNumber() {
        return accountBankNumber;
    }

    public void setAccountBankNumber(String accountBankNumber) {
        this.accountBankNumber = accountBankNumber;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getRegisterTelephone() {
        return registerTelephone;
    }

    public void setRegisterTelephone(String registerTelephone) {
        this.registerTelephone = registerTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkManPhone() {
        return linkManPhone;
    }

    public void setLinkManPhone(String linkManPhone) {
        this.linkManPhone = linkManPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
