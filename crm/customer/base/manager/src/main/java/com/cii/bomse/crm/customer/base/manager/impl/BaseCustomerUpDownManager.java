package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.crm.customer.base.dao.IBaseCustomerDao;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOperationType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.customer.base.dictionary.CustomerUpDownType;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerUpDownEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerValidator;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 17:28
 * @since 1.0
 */
public abstract class BaseCustomerUpDownManager<T extends BaseCustomerUpDownEntity, C extends BaseCustomerEntity> extends AbstractManager<T> {

    @Autowired
    protected IOperationLogManager operationLogManager;
    @Autowired
    protected IBaseCustomerValidator customerValidator;

    public abstract IBaseCustomerDao<C> getCustomerDao();

    @Override
    protected void beforeBatchCreate(List<T> list) {

        List<C> customers = new ArrayList<>();
        for (T customerUpDown : list) {

            C customer = getCustomerDao().selectById(customerUpDown.getCusId(),
                    "id", "cus_phone", "cus_owner_type", "cus_status", "owner_id", "owner_name", "owner_dept_id", "owner_dept_name");

            //判断必填字段参数
            validateField(customer, customerUpDown);

            //查看是否有操作权限
            validateAuth(customer, customerUpDown);

            //设置需要更新的客户信息
            customers.add(fillCustomer(customerUpDown));

        }

        if (customers.size() > 0) {
            getCustomerDao().batchUpdate(customers);
        }
    }

    @Override
    protected void afterBatchCreate(List<T> list) {

        List<OperationLogEntity> optList = new ArrayList<>();
        for (T upDown : list) {
            optList.add(fillOperationLog(upDown));
        }

        if (ObjectUtils.isNotEmpty(optList)) {
            operationLogManager.batchCreate(optList);
        }
    }

    private ValidationResult validateAuth(C customer, T customerUpDown) {

        ValidationResult vr;

        if ((vr = customerValidator.validateCustomerInUserPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserAuthDeptPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserAuthDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserAuthDeptPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserPush(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else if ((vr = customerValidator.validateCustomerInUserAuthDeptPush(customer, CurrentContext.getUserInfo())).getSuccess()) {
        } else {
            throw new BusinessException("没有权限下架此客户号码");
        }
        return vr;
    }

    private void validateField(C customer, T customerUpDown) {

        ValidationResult vr;

        if (CustomerUpDownType.Down.equals(customerUpDown.getUpDownType())) {
            if (CustomerStatus.HasDown.equals(customer.getCusStatus())) {
                throw new BusinessException("客户已经是下架状态，不能重复下架，如果是订单成交，请先上架客户！");
            }
            vr = ValidationUtils.validateInclude(customerUpDown, "cusId", "upDownType", "downReason", "nextContactTime");
        } else {
            if (!CustomerStatus.HasDown.equals(customer.getCusStatus())) {
                throw new BusinessException("客户已经是上架状态，不能重复上架");
            }
            vr = ValidationUtils.validateInclude(customerUpDown, "cusId", "upDownType");
        }
        if (!vr.getSuccess()) {
            throw new BusinessException(vr.getMessage());
        }
    }

    private C fillCustomer(T customerUpDown) {

        C cus = (C) ObjectUtils.createInstance(GenericsUtils.getSuperClassGenricType(getClass(), 1));

        cus.setId(customerUpDown.getCusId());
        if (CustomerUpDownType.Down.equals(customerUpDown.getUpDownType())) {
            cus.setLastDownTime(new Date());
            cus.setLastDownUserId(CurrentContext.getUserId());
            cus.setLastDownUserName(CurrentContext.getUserName());
            cus.setLastDownUserDeptId(CurrentContext.getOwnerDeptId());
            cus.setLastDownUserDeptName(CurrentContext.getOwnerDeptName());
            cus.setNextContactTime(customerUpDown.getNextContactTime());
            cus.setCusStatus(CustomerStatus.HasDown);
        } else {
            cus.setLastUpTime(new Date());
            cus.setLastUpUserId(CurrentContext.getUserId());
            cus.setLastUpUserName(CurrentContext.getUserName());
            cus.setLastUpUserDeptId(CurrentContext.getOwnerDeptId());
            cus.setLastUpUserDeptName(CurrentContext.getOwnerDeptName());
            cus.setCusStatus(CustomerStatus.Followup);
        }

        return cus;
    }


    private OperationLogEntity fillOperationLog(T upDown) {

        OperationLogEntity opt = new OperationLogEntity();

        opt.setBizId(upDown.getCusId());

        if (CustomerUpDownType.Down.equals(upDown.getUpDownType())) {
            opt.setOptType(CustomerOperationType.cusDown);
        } else {
            opt.setOptType(CustomerOperationType.cusUp);
        }

        opt.setContent(String.format("%s%s了客户[%d]",
                CurrentContext.getUserName(),
                upDown.getUpDownTypeName(), upDown.getCusId()));

        return opt;
    }
}
