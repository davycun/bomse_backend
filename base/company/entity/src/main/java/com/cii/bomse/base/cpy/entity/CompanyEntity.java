package com.cii.bomse.base.cpy.entity;

import com.cii.bomse.common.utils.Constants;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 帐套管理
 */
public class CompanyEntity extends BaseEntity {

    /**
     * 编码别名
     */
    private String aliasCode;
    /*创建公司的时候的登录邮箱*/
    @Email(message = "请填写正确的管理员邮箱")
    private String adminEmail;

    @Pattern(regexp = Constants.phoneRegexp,message = "请填写正确的管理员手机号")
    private String adminPhone;

    /*LOGO图片*/
    private String logo;
    /*标语*/
    private String slogan;

    /**可支持的创建员工最大数量*/
    private Integer employeeCount;

    /**系统服务开始日期*/
    private Date contractStartTime;
    /**系统服务结束日期*/
    private Date contractEndTime;

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAliasCode() {
        return aliasCode;
    }

    public void setAliasCode(String aliasCode) {
        this.aliasCode = aliasCode;
    }
}
