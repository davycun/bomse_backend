package com.cii.bomse.hrm.emp.entity;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.hrm.emp.dictionary.EducationType;
import com.cii.bomse.hrm.emp.dictionary.HouseholdRegisterType;
import com.cii.bomse.hrm.emp.dictionary.MarryType;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 19:50
 */
public class EmployeeEntity extends BaseEntity {


    @NotNull(message = "员工姓名不能为空")
    private String empName;

    @NotNull(message = "员工电话不能为空")
    @Pattern(regexp = Constants.phoneRegexp,message = "手机号码错误")
    private String empPhone;

    /**
     * @see com.ciiframework.common.dictionary.SexType
     */
    @NotNull(message = "性别不能为空")
    private String sex;
    private String sexName;

    /**
     * 头像编码地址
     */
    private String avatar;

    /**
     * 工号
     */
    private String workNumber;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 岗位编码
     * @see PostEntity
     */
    @NotNull(message = "岗位不能为空")
    private Long postId;

    /**
     * 身份证号
     */
//    @NotNull(message = "身份证号不能为空")
    private String idCard;
    /**
     * 身份证照片正面（保存的图片编码）
     */
    private String idCardImageFront;

    /**
     * 身份证反面
     */
    private String idCardImageBack;

    /**
     * 入职日期
     */
    @NotNull(message = "入职日期不能为空")
    private Date enterDate;

    /**
     * 是否已离职
     */
    private Boolean hasQuit;

    /*离职日期*/
    private Date quitDate;

    /**
     * 学历
     * @see EducationType
     */
    @NotNull(message = "学历不能为空")
    private String educationType;
    private String educationTypeName;
    /**
     * 学历（毕业证照片，保存图片编码）
     */
//    private List<String> educationImage;

    private String educationImages;

    /**
     * 学校
     */
//    @NotNull(message = "毕业院校不能空")
    private String school;

    /**
     * 专业
     */
//    @NotNull(message = "专业不能为空")
    private String major;

    /**
     * 毕业日期
     */
//    @NotNull(message = "毕业日期不能为空")
    private Date graduationDate;
    /**
     * 出生日期
     */
//    @NotNull(message = "出生日期不能为空")
    private Date birthday;
    /**
     * 婚姻状况
     * @see MarryType
     */
//    @NotNull(message = "婚姻状况不能为空")
    private String marryType;
    private String marryTypeName;

    /**
     * 紧急联系人
     */
    //@NotNull(message = "紧急联系人1姓名不能为空")
    private String linkManOneName;
    //@NotNull(message = "紧急联系人1电话不能为空")
    //@Pattern(regexp = Constants.phoneRegexp,message = "联系人1手机号码错误")
    private String linkManOnePhone;
    private String linkManOneRelation;

    //@NotNull(message = "紧急联系人1姓名不能为空")
    private String linkManTwoName;
    //@NotNull(message = "紧急联系人1电话不能为空")
    //@Pattern(regexp = Constants.phoneRegexp,message = "联系人2手机号码错误")
    private String linkManTwoPhone;
    private String linkManTwoRelation;

    /**
     * 户籍
     * @see HouseholdRegisterType
     */
    //@NotNull(message = "户籍不能为空")
    private String householdRegisterType;
    private String householdRegisterTypeName;

    /**
     * 户籍所在地
     */
    //@NotNull(message = "户籍所在地必填")
    private String householdRegisterLocation;

    /**
     * 现居住地
     */
    //@NotNull(message = "现居住地必填")
    private String address;

    /**
     * 转正日期
     */
    @NotNull(message = "转正日期必填")
    private Date regularDate;

    /**
     * 合同签订日期
     */
    @NotNull(message = "合同签订开始日期不能为空")
    private Date contractStartDate;

    /**
     * 合同结束日期
     */
    @NotNull(message = "合同签订结束日期不能为空")
    private Date contractEndDate;

    /**
     * 工作经历
     */
    private String workExperience;

    /**
     * 银行卡号
     */
    //@NotNull(message = "银行卡不能为空")
    private String bankCardNumber;
    /**
     * 开户银行
     */
    //@NotNull(message = "开户银行不能为空")
    private String bankName;

    /**
     * 银行卡图片（保存的是图片编码）
     */
    private String bankCardImage;

    /*登录授权，是否允许登录*/
    private Boolean canLogin;

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getEducationImages() {
        return educationImages;
    }

    public void setEducationImages(String educationImages) {
        this.educationImages = educationImages;
    }

    public Boolean getCanLogin() {
        return canLogin;
    }

    public void setCanLogin(Boolean canLogin) {
        this.canLogin = canLogin;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardImageFront() {
        return idCardImageFront;
    }

    public void setIdCardImageFront(String idCardImageFront) {
        this.idCardImageFront = idCardImageFront;
    }

    public String getIdCardImageBack() {
        return idCardImageBack;
    }

    public void setIdCardImageBack(String idCardImageBack) {
        this.idCardImageBack = idCardImageBack;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Boolean getHasQuit() {
        return hasQuit;
    }

    public void setHasQuit(Boolean hasQuit) {
        this.hasQuit = hasQuit;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getEducationTypeName() {
        return DictionaryStorage.get(EducationType.class.getName(),getEducationType()).getName();
    }

    public void setEducationTypeName(String educationTypeName) {
        this.educationTypeName = educationTypeName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMarryType() {
        return marryType;
    }

    public void setMarryType(String marryType) {
        this.marryType = marryType;
    }

    public String getMarryTypeName() {
        return DictionaryStorage.get(MarryType.class.getName(),getMarryType()).getName();
    }

    public void setMarryTypeName(String marryTypeName) {
        this.marryTypeName = marryTypeName;
    }

    public String getLinkManOnePhone() {
        return linkManOnePhone;
    }

    public void setLinkManOnePhone(String linkManOnePhone) {
        this.linkManOnePhone = linkManOnePhone;
    }

    public String getLinkManOneName() {
        return linkManOneName;
    }

    public void setLinkManOneName(String linkManOneName) {
        this.linkManOneName = linkManOneName;
    }

    public String getLinkManOneRelation() {
        return linkManOneRelation;
    }

    public void setLinkManOneRelation(String linkManOneRelation) {
        this.linkManOneRelation = linkManOneRelation;
    }

    public String getLinkManTwoName() {
        return linkManTwoName;
    }

    public void setLinkManTwoName(String linkManTwoName) {
        this.linkManTwoName = linkManTwoName;
    }

    public String getLinkManTwoPhone() {
        return linkManTwoPhone;
    }

    public void setLinkManTwoPhone(String linkManTwoPhone) {
        this.linkManTwoPhone = linkManTwoPhone;
    }

    public String getLinkManTwoRelation() {
        return linkManTwoRelation;
    }

    public void setLinkManTwoRelation(String linkManTwoRelation) {
        this.linkManTwoRelation = linkManTwoRelation;
    }

    public String getHouseholdRegisterType() {
        return householdRegisterType;
    }

    public void setHouseholdRegisterType(String householdRegisterType) {
        this.householdRegisterType = householdRegisterType;
    }

    public String getHouseholdRegisterTypeName() {
        return DictionaryStorage.get(HouseholdRegisterType.class.getName(),getHouseholdRegisterType()).getName();
    }

    public void setHouseholdRegisterTypeName(String householdRegisterTypeName) {
        this.householdRegisterTypeName = householdRegisterTypeName;
    }

    public String getHouseholdRegisterLocation() {
        return householdRegisterLocation;
    }

    public void setHouseholdRegisterLocation(String householdRegisterLocation) {
        this.householdRegisterLocation = householdRegisterLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegularDate() {
        return regularDate;
    }

    public void setRegularDate(Date regularDate) {
        this.regularDate = regularDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }


    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardImage() {
        return bankCardImage;
    }

    public void setBankCardImage(String bankCardImage) {
        this.bankCardImage = bankCardImage;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexName() {
        return DictionaryStorage.get(SexType.class.getName(),this.getSex()).getName();
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
