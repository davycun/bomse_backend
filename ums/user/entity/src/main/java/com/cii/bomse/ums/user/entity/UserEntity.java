package com.cii.bomse.ums.user.entity;

import com.cii.bomse.common.utils.Constants;
import com.ciiframework.common.entity.BaseUserEntity;

import javax.validation.constraints.Pattern;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/17 14:33
 */
public class UserEntity extends BaseUserEntity {


    private String workNumber;

    private String deviceToken;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    @Override
    @Pattern(regexp = Constants.phoneRegexp,message = "请填写正确的手机号码")
    public String getUserPhone() {
        return userPhone;
    }

    @Override
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
