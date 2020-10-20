package com.cii.bomse.house.base.entity;

import com.cii.bomse.house.base.dictionary.HouseOwnerType;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-08 10:23
 * @since 1.0
 */
public class HouseOwnerEntity extends BaseEntity {

    /*业主姓名*/
    private String ownName;
    /*业主电话*/
    private String ownPhone;
    /*业主性别*/
    private String sex;
    @NotGenerate
    private String sexName;
    /*房东类型*/
    /**@see HouseOwnerType*/
    private String ownType;
    @NotGenerate
    private String ownTypeName;
    /*公司名称*/
    private String company;
    /*岗位*/
    private String post;
    /*此处只是用来做关联，无需保存数据库*/
    @NotGenerate
    private Long parkId;

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getOwnType() {
        return ownType;
    }

    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }

    public String getOwnTypeName() {
        return DictionaryStorage.get(HouseOwnerType.class.getName(),ownType).getName();
    }

    public void setOwnTypeName(String ownTypeName) {
        this.ownTypeName = ownTypeName;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getOwnPhone() {
        return ownPhone;
    }

    public void setOwnPhone(String ownPhone) {
        this.ownPhone = ownPhone;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
