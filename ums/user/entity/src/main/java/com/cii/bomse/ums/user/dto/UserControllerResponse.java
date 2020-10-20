package com.cii.bomse.ums.user.dto;

import com.ciiframework.service.AbstractRestControllerResponse;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/19 21:32
 */
public class UserControllerResponse extends AbstractRestControllerResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
