package com.cii.bomse.ums.user.dto;

import com.cii.bomse.ums.user.entity.UserEntity;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/11/19 21:25
 */
public class UserDto extends UserEntity {

    @NotNull(message = "通过角色编码查询用户，角色编码不能空")
    private Long roleId;

    /**
     * 手机验证码
     */
    private String verifyCode;

    /*旧密码*/
    @NotNull(message = "修改密码，原密码必填")
    private String oldPassword;

    /*新密码*/
    @NotNull(message = "修改密码，新密码必填")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
