package com.cii.bomse.crm.customer.base.entity;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerSource;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.customer.base.dictionary.HouseUseType;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @description
 * 客户基本信息
 * @auth david·cun
 * @date 2019-11-20 14:14
 * @since 1.0
 */
public class BaseCustomerEntity extends BaseEntity {

    /*======1、客户的基本信息=======*/
    /*客户姓名*/
    @NotNull(message = "客户姓名必填")
    protected String cusName;
    /*客户电话*/
    @NotNull(message = "客户电话必填")
    @Pattern(regexp = Constants.phoneRegexp, message = "手机格式错误")
    protected String cusPhone;
    /**客户性别*/
    /**
     * @see com.ciiframework.common.dictionary.SexType
     */
    @NotNull(message = "客户性别必填")
    protected String sex;
    @NotGenerate
    protected String sexName;
    /*职位*/
    protected String post;

    /**
     * @see HouseUseType
     */
    /*租房用途*/
    protected String houseUseType;
    @NotGenerate
    protected String houseUseTypeName;

    /*===客户状态、来源、拉私/公开==============*/
    /*客户来源 */
    /**
     * @see CustomerSource
     */
    @NotNull(message = "客户来源必填")
    protected String cusSource;
    @NotGenerate
    protected String cusSourceName;
    /**
     * @see CustomerOwnerType
     */
    @NotNull(message = "客户类型必填")
    protected String cusOwnerType;
    @NotGenerate
    protected String cusOwnerTypeName;
    /*客户状态*/
    /**
     * @see CustomerStatus
     */
    protected String cusStatus;
    @NotGenerate
    protected String cusStatusName;

    /*拉私时间*/
    protected Date hideTime;
    /*公开人ID*/
    protected Long openUserId;
    /*公开人姓名*/
    protected String openUserName;
    /*公开时间*/
    protected Date openTime;

    /*===兼职信息===============*/
    /*兼职推荐*/
    protected Long ptId;
    /*兼职姓名*/
    protected String ptName;
    /*兼职电话*/
    protected String ptPhone;

    /*===上下架信息=============*/
    /*最后上架人编码*/
    protected Long lastUpUserId;
    /*最后上架人姓名*/
    protected String lastUpUserName;
    /*最后上架人部门ID*/
    protected Long lastUpUserDeptId;
    /*最后上架人部门编码*/
    protected String lastUpUserDeptName;
    /*最后上架时间*/
    protected Date lastUpTime;
    /*最后下架人ID*/
    protected Long lastDownUserId;
    /*最后下架人姓名*/
    protected String lastDownUserName;
    /*最后下架人部门ID*/
    protected Long lastDownUserDeptId;
    /*最后下架人部门名称*/
    protected String lastDownUserDeptName;
    /*最后下架时间*/
    protected Date lastDownTime;

    /*===其他属性===*/
    /*最后跟进时间*/
    protected Date lastFollowupTime;
    /*未跟进天数*/
    @NotGenerate
    protected Integer noFollowupDay;
    /*跟进次数*/
    protected Integer followupCount;
    /*下一次联系时间，下架之后此时间有用*/
    protected Date nextContactTime;

    public String getPtPhone() {
        return ptPhone;
    }

    public void setPtPhone(String ptPhone) {
        this.ptPhone = ptPhone;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return DictionaryStorage.get(SexType.class.getName(),sex).getName();
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getHouseUseType() {
        return houseUseType;
    }

    public void setHouseUseType(String houseUseType) {
        this.houseUseType = houseUseType;
    }

    public String getHouseUseTypeName() {
        return DictionaryStorage.get(HouseUseType.class.getName(),houseUseType).getName();
    }

    public void setHouseUseTypeName(String houseUseTypeName) {
        this.houseUseTypeName = houseUseTypeName;
    }

    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    public String getCusSourceName() {
        return DictionaryStorage.get(CustomerSource.class.getName(),cusSource).getName();
    }

    public void setCusSourceName(String cusSourceName) {
        this.cusSourceName = cusSourceName;
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

    public String getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }

    public String getCusStatusName() {
        return DictionaryStorage.get(CustomerStatus.class.getName(),cusStatus).getName();
    }

    public void setCusStatusName(String cusStatusName) {
        this.cusStatusName = cusStatusName;
    }

    public Date getHideTime() {
        return hideTime;
    }

    public void setHideTime(Date hideTime) {
        this.hideTime = hideTime;
    }

    public Long getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(Long openUserId) {
        this.openUserId = openUserId;
    }

    public String getOpenUserName() {
        return openUserName;
    }

    public void setOpenUserName(String openUserName) {
        this.openUserName = openUserName;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
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

    public Long getLastUpUserId() {
        return lastUpUserId;
    }

    public void setLastUpUserId(Long lastUpUserId) {
        this.lastUpUserId = lastUpUserId;
    }

    public String getLastUpUserName() {
        return lastUpUserName;
    }

    public void setLastUpUserName(String lastUpUserName) {
        this.lastUpUserName = lastUpUserName;
    }

    public Long getLastUpUserDeptId() {
        return lastUpUserDeptId;
    }

    public void setLastUpUserDeptId(Long lastUpUserDeptId) {
        this.lastUpUserDeptId = lastUpUserDeptId;
    }

    public String getLastUpUserDeptName() {
        return lastUpUserDeptName;
    }

    public void setLastUpUserDeptName(String lastUpUserDeptName) {
        this.lastUpUserDeptName = lastUpUserDeptName;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public Long getLastDownUserId() {
        return lastDownUserId;
    }

    public void setLastDownUserId(Long lastDownUserId) {
        this.lastDownUserId = lastDownUserId;
    }

    public String getLastDownUserName() {
        return lastDownUserName;
    }

    public void setLastDownUserName(String lastDownUserName) {
        this.lastDownUserName = lastDownUserName;
    }

    public Long getLastDownUserDeptId() {
        return lastDownUserDeptId;
    }

    public void setLastDownUserDeptId(Long lastDownUserDeptId) {
        this.lastDownUserDeptId = lastDownUserDeptId;
    }

    public String getLastDownUserDeptName() {
        return lastDownUserDeptName;
    }

    public void setLastDownUserDeptName(String lastDownUserDeptName) {
        this.lastDownUserDeptName = lastDownUserDeptName;
    }

    public Date getLastDownTime() {
        return lastDownTime;
    }

    public void setLastDownTime(Date lastDownTime) {
        this.lastDownTime = lastDownTime;
    }

    public Date getLastFollowupTime() {
        return lastFollowupTime;
    }

    public void setLastFollowupTime(Date lastFollowupTime) {
        this.lastFollowupTime = lastFollowupTime;
    }

    public Integer getNoFollowupDay() {
        if (null == lastFollowupTime) {
            return 0;
        }
        Date now = new Date();
        long ct = now.getTime() - lastFollowupTime.getTime();
        int t = (int) (ct / 1000 / 60 / 60 / 24);
        return t;
    }

    public void setNoFollowupDay(Integer noFollowupDay) {
        this.noFollowupDay = noFollowupDay;
    }

    public Integer getFollowupCount() {
        return followupCount;
    }

    public void setFollowupCount(Integer followupCount) {
        this.followupCount = followupCount;
    }

    public Date getNextContactTime() {
        return nextContactTime;
    }

    public void setNextContactTime(Date nextContactTime) {
        this.nextContactTime = nextContactTime;
    }
}
