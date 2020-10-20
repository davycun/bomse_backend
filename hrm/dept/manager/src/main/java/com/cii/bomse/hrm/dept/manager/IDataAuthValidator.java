package com.cii.bomse.hrm.dept.manager;

import com.ciiframework.common.entity.BaseUserEntity;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ValidationResult;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-26 16:56
 * @since 1.0
 */
public interface IDataAuthValidator {

    /**
     * @description
     * 验证当前信息是否归属指定用户
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-07 15:36
     * @since 1.0
     */
    public ValidationResult validateEntityBelongToUser(BaseEntity entity, BaseUserEntity user);

    /**
     * @description
     * 验证当前信息是否归属指定用户的所属部门
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-07 15:37
     * @since 1.0
     */
    public ValidationResult validateEntityBelongToUserDept(BaseEntity entity, BaseUserEntity user);

    /**
     * @description
     * 验证当前信息是否归属当前用户的所具有的权限部门
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-08 09:25
     * @since 1.0
     */
    public ValidationResult validateEntityBelongToUserAuthDept(BaseEntity entity, BaseUserEntity user);
}
