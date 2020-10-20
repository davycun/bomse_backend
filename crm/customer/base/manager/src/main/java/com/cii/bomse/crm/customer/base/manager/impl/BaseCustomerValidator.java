package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerPushManager;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerValidator;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.manager.IDeptConfigManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.cii.bomse.hrm.dept.manager.IDeptShareManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.common.entity.BaseUserEntity;
import com.ciiframework.user.business.IBaseUserManager;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-12 14:18
 * @since 1.0
 */
public abstract class BaseCustomerValidator<T extends BaseCustomerEntity> implements IBaseCustomerValidator<T> {

    @Autowired
    private IDeptManager deptManager;
    @Autowired
    private IDeptConfigManager deptConfigManager;
    @Autowired
    private IBaseUserManager userManager;
    @Autowired
    protected IDeptShareManager deptShareManager;

    public abstract IBaseCustomerPushManager getCustomerPushManager();
    
    @Override
    public ValidationResult validateCustomerInUserPersonal(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("不是自己的客户");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Personal.equals(customer.getCusOwnerType())){
            if (user.getId().equals(customer.getOwnerId())){
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s的个人客户里已经存在相同号码的客户",user.getUserName()));
            }
        }
        return vr;
    }

    @Override
    public ValidationResult validateSharePersonalCustomerInDept(BaseCustomerEntity customer, BaseUserEntity user) {
        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("部门内部不共享");

        if (CustomerOwnerType.Personal.equals(customer.getCusOwnerType())){

            DeptConfigEntity config = deptConfigManager.findByDeptId(user.getOwnerDeptId());

            if (ObjectUtils.isNotEmpty(config.getSharePersonalCustomer()) && config.getSharePersonalCustomer()){
                BaseUserEntity tmpUser = (BaseUserEntity) userManager.findById(customer.getOwnerId(),"id,owner_dept_id");

                if (tmpUser.getOwnerDeptId().equals(user.getOwnerDeptId())){
                    vr.setSuccess(Boolean.TRUE);
                    vr.setMessage(String.format("部门内部共享，部门内部可以查看"));
                }

            }
        }

        return vr;
    }

    @Override
    public ValidationResult validateCustomerInUserAuthDeptPersonal(BaseCustomerEntity customer, BaseUserEntity user) {
        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("不在自己的个人客户列表里");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Personal.equals(customer.getCusOwnerType())){
            if (ObjectUtils.isNotEmpty(deptManager.findUserAuthDeptId(user.getId()))
                    && deptManager.findUserAuthDeptId(user.getId()).contains(customer.getOwnerDeptId())){
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s的个人客户列表里已经存在相同号码的客户",user.getUserName()));
            }
        }
        return vr;
    }

    public ValidationResult validateCustomerInUserPrivate(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("没有拉私此客户!");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Hide.equals(customer.getCusOwnerType())) {
            if (user.getId().equals(customer.getOwnerId())) {
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s的私盘里已经存在此客户",user.getUserName()));
            }
        }

        return vr;
    }

    public ValidationResult validateCustomerInUserAuthDeptPrivate(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("此客户不在自己部门的私盘里");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Hide.equals(customer.getCusOwnerType())) {
            if (user.getOwnerDeptId().equals(customer.getOwnerDeptId())
                    || (ObjectUtils.isNotEmpty(deptManager.findUserAuthDeptId(user.getId()))
                    && deptManager.findUserAuthDeptId(user.getId()).contains(customer.getOwnerDeptId()))) {

                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s公盘里已经存在此客户，被%s拉私了",user.getUserName(), customer.getOwnerName()));
            }
        }
        return vr;
    }

    public ValidationResult validateCustomerInUserAuthDeptPublic(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("此客户不在自己部门公盘内");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Company.equals(customer.getCusOwnerType())) {
            if (user.getOwnerDeptId().equals(customer.getOwnerDeptId())
                    || (ObjectUtils.isNotEmpty(deptManager.findUserAuthDeptId(user.getId()))
                    && deptManager.findUserAuthDeptId(user.getId()).contains(customer.getOwnerDeptId()))) {

                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s部门公盘里已经存在此客户",user.getUserName()));
            }
        }


        return vr;
    }

    public ValidationResult validateCustomerInShareDeptPublic(BaseCustomerEntity customer,BaseUserEntity user){

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("此客户不在公盘共享部门");

        if (ObjectUtils.isNotEmpty(customer) && CustomerOwnerType.Company.equals(customer.getCusOwnerType())){

            List<Long> shareDeptIdList = deptShareManager.findAllShareDeptByDeptId(CurrentContext.getOwnerDeptId());

            if (shareDeptIdList.contains(customer.getOwnerDeptId())){
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage("部门公盘共享部门中已存在此客户");
            }
        }

        return vr;
    }

    public ValidationResult validateCustomerInUserPush(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("客户推送列表里面此客户不存在");

        Map<String, Object> param = new HashMap<>();
        param.clear();
        param.put("cusId", customer.getId());
        param.put("receiveUserId", user.getId());
//        param.put("pushStatus", CustomerPushStatus.HasReceive);

        int count = getCustomerPushManager().countByMap(param);

        if (count > 0) {
            vr.setSuccess(Boolean.TRUE);
            vr.setMessage(String.format("已经有人给%s推送过此客户",user.getUserName()));
        }

        return vr;
    }

    public ValidationResult validateCustomerInUserAuthDeptPush(BaseCustomerEntity customer, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();

        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("客户推送列表里面此客户不存在");

        if (ObjectUtils.isNotEmpty(deptManager.findUserAuthDeptId(user.getId()))) {
            Map<String, Object> param = new HashMap<>();
            param.clear();
            param.put("cusId", customer.getId());
//            param.put("pushStatus", CustomerPushStatus.HasReceive);
            param.put("receiveDeptIds", deptManager.findUserAuthDeptId(user.getId()));

            int count = getCustomerPushManager().countByMap(param);

            if (count > 0) {
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage(String.format("%s的推送列表里已经存在此客户",user.getUserName()));
            }
        }

        return vr;
    }
}
