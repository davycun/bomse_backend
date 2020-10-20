package com.cii.bomse.hrm.dept.manager.impl;

import com.cii.bomse.hrm.dept.manager.IDataAuthValidator;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.entity.BaseUserEntity;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-26 17:00
 * @since 1.0
 */
@Component
@Primary
public class DefaultDataAuthValidatorImpl implements IDataAuthValidator {

    @Autowired
    private IDeptManager deptManager;

    @Override
    public ValidationResult validateEntityBelongToUser(BaseEntity entity, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("当前信息不属于当前用户");

        if (ObjectUtils.isNotEmpty(entity) && ObjectUtils.isNotEmpty(user)) {

            if (ObjectUtils.isNotEmpty(entity.getOwnerId())
                    && entity.getOwnerId().equals(user.getId())) {

                vr.setSuccess(Boolean.TRUE);
                vr.setMessage("当前信息归诸于当前用户!");

            }
        }

        return vr;
    }

    @Override
    public ValidationResult validateEntityBelongToUserDept(BaseEntity entity, BaseUserEntity user) {
        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("当前信息不属于当前用户所属部门");

        if (ObjectUtils.isNotEmpty(entity) && ObjectUtils.isNotEmpty(user)) {
            if (ObjectUtils.isNotEmpty(entity.getOwnerDeptId())
                    && entity.getOwnerDeptId().equals(user.getOwnerDeptId())) {
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage("当前信息归诸于当前用户所属部门");
            }
        }

        return vr;
    }

    @Override
    public ValidationResult validateEntityBelongToUserAuthDept(BaseEntity entity, BaseUserEntity user) {

        ValidationResult vr = new ValidationResult();
        vr.setSuccess(Boolean.FALSE);
        vr.setMessage("当前信息不属于当前用户权限部门");

        if (ObjectUtils.isNotEmpty(entity)
                && ObjectUtils.isNotEmpty(entity.getOwnerDeptId())
                && ObjectUtils.isNotEmpty(user)) {

            List<Long> authDeptIds = deptManager.findUserAuthDeptId(user.getId());

            if (ObjectUtils.isNotEmpty(authDeptIds)
                    && authDeptIds.contains(entity.getOwnerDeptId())) {
                vr.setSuccess(Boolean.TRUE);
                vr.setMessage("当前信息属于当前用户权限部门!");
            }
        }

        return vr;
    }
}
