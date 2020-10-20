package com.cii.bomse.crm.customer.industry.dto;


import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryPushEntity;
import com.cii.bomse.ums.user.entity.UserEntity;

import java.util.List;

public class CustomerIndustryPushDto extends CustomerIndustryPushEntity {

    private List<UserEntity> pushUsers;

    /**@see com.cii.bomse.crm.customer.base.dictionary.CustomerPushQueryType*/
    private String pushQueryType;

    public String getPushQueryType() {
        return pushQueryType;
    }

    public void setPushQueryType(String pushQueryType) {
        this.pushQueryType = pushQueryType;
    }

    public List<UserEntity> getPushUsers() {
        return pushUsers;
    }

    public void setPushUsers(List<UserEntity> pushUsers) {
        this.pushUsers = pushUsers;
    }
    
}