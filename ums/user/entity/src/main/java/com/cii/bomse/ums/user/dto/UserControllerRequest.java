package com.cii.bomse.ums.user.dto;

import com.ciiframework.service.AbstractRestControllerRequest;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/19 21:20
 */
public class UserControllerRequest extends AbstractRestControllerRequest<UserDto> {

    private String tokenType;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
