package com.cii.bomse.hrm.emp.entity;

import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 19:50
 */
public class PostEntity extends BaseEntity {

    @NotNull(message = "岗位编码不能为空")
    private String postName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
