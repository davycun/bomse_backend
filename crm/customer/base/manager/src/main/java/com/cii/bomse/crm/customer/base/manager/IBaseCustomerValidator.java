package com.cii.bomse.crm.customer.base.manager;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.ciiframework.common.entity.BaseUserEntity;
import com.ciiframework.utils.ValidationResult;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-12 20:23
 * @since 1.0
 */
public interface IBaseCustomerValidator<T extends BaseCustomerEntity> {

    /**
     * @description
     * 判断是否是我的个人客户
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 22:21
     * @since 1.0
     */
    ValidationResult validateCustomerInUserPersonal(BaseCustomerEntity customer, BaseUserEntity user);

    /**
     * @description
     * 判断当前个人客户所属个人所在的部门是否为内部共享
     * @author david·cun
     * @param
     * @return
     * @date 2020-05-31 09:57
     * @since 1.0
     */
    ValidationResult validateSharePersonalCustomerInDept(BaseCustomerEntity customer,BaseUserEntity user);

    /**
     * @description
     * 验证客户是否是我权限范围内部门的个人客户
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 22:21
     * @since 1.0
     */
    ValidationResult validateCustomerInUserAuthDeptPersonal(BaseCustomerEntity customer, BaseUserEntity user);

    /**
     * @description
     * 验证当前客户是否在我的私盘里
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 20:24
     * @since 1.0
     */
    ValidationResult validateCustomerInUserPrivate(BaseCustomerEntity customer, BaseUserEntity user);

    /**
     * @description
     * 验证当前客户是否在部门权限的私盘里
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 20:24
     * @since 1.0
     */
    ValidationResult validateCustomerInUserAuthDeptPrivate(BaseCustomerEntity customer, BaseUserEntity user);

    /**
     * @description
     * 验证当前客户是否在我权限部门的公盘里
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 20:24
     * @since 1.0
     */
    ValidationResult validateCustomerInUserAuthDeptPublic(BaseCustomerEntity customer, BaseUserEntity user);


    /**
     * @description
     * 公盘客户，校验是否有共享部门已经存在此客户
     * @author david·cun
     * @param
     * @return
     * @date 2020-05-31 17:04
     * @since 1.0
     */
    ValidationResult validateCustomerInShareDeptPublic(BaseCustomerEntity customer,BaseUserEntity user);

    /**
     * @description
     * 验证当前客户是否在我的推送列表里
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 20:25
     * @since 1.0
     */
    ValidationResult validateCustomerInUserPush(BaseCustomerEntity customer, BaseUserEntity user);

    /**
     * @description
     * 验证当前客户是否在我的推送部门权限范围里
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 20:25
     * @since 1.0
     */
    ValidationResult validateCustomerInUserAuthDeptPush(BaseCustomerEntity customer, BaseUserEntity user);
}
