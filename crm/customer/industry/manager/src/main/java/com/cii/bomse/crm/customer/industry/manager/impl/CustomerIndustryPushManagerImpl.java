package com.cii.bomse.crm.customer.industry.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerOperationType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerPushStatus;
import com.cii.bomse.crm.customer.base.manager.impl.BaseCustomerPushManager;
import com.cii.bomse.crm.customer.industry.dao.ICustomerIndustryPushDao;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryPushEntity;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryManager;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryPushManager;
import com.cii.bomse.crm.customer.industry.manager.ICustomerIndustryValidator;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerIndustryPushManagerImpl extends BaseCustomerPushManager<CustomerIndustryPushEntity> implements ICustomerIndustryPushManager {

    @Autowired
    private ICustomerIndustryPushDao customerIndustryPushDao;
    @Autowired
    private ICustomerIndustryValidator customerIndustryValidator;
    @Autowired
    private ICustomerIndustryManager customerIndustryManager;
    @Autowired
    private IUserManager userManager;

    @Override
    protected IMyBatisBaseDao<CustomerIndustryPushEntity, Long> getMyBatisDao() {
        return customerIndustryPushDao;
    }

    @Override
    protected void beforeBatchCreate(List<CustomerIndustryPushEntity> list) {
        for (CustomerIndustryPushEntity customerIndustryPush : list) {
            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
            if (ObjectUtils.isEmpty(customerIndustryPush.getPushStatus())) {
                customerIndustryPush.setPushStatus(CustomerPushStatus.WaitReceive);
            }

            if (ObjectUtils.isEmpty(customerIndustryPush.getCusId())) {
                throw new BusinessException("推送客户，客户ID必填");
            }
        }

        validatePush(list);
    }

    @Override
    protected void beforeBatchUpdate(List<CustomerIndustryPushEntity> list) {
        for (CustomerIndustryPushEntity customerIndustryPush : list) {
            //在更新数据之前的动作，比如校验数据唯一键必填
        }
    }

    @Override
    protected void afterBatchCreate(List<CustomerIndustryPushEntity> list) {
        this.createOperationLog(list);
    }

    public void validatePush(List<CustomerIndustryPushEntity> list) {
        for (CustomerIndustryPushEntity push : list) {
            CustomerIndustryEntity customer = customerIndustryManager.findById(push.getCusId(),
                    "id", "cus_phone", "cus_owner_type", "cus_status", "owner_id",
                    "owner_name", "owner_dept_id", "owner_dept_name");

            UserEntity receiveUser = userManager.findById(push.getReceiveUserId());

            if (ObjectUtils.isEmpty(receiveUser)) {
                throw new BusinessException("接收人不存在");
            }



            ValidationResult vr;

            //以下是判断接受者是否可以接受
            if ((vr = customerIndustryValidator.validateCustomerInUserPersonal(customer, receiveUser)).getSuccess()) {
                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPersonal(customer, receiveUser)).getSuccess()) {

                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPublic(customer, receiveUser)).getSuccess()) {

                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserPrivate(customer, receiveUser)).getSuccess()) {

                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPrivate(customer, receiveUser)).getSuccess()) {

                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserPush(customer, receiveUser)).getSuccess()) {

                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPush(customer, receiveUser)).getSuccess()) {
                throw new BusinessException(customer.getId().toString(), vr.getMessage() + "，不能推送给" + push.getReceiveUserName());
            }

            //以下是判断自己是否有权限推送此客户给别人
            if ((vr = customerIndustryValidator.validateCustomerInUserPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPersonal(customer, CurrentContext.getUserInfo())).getSuccess()) {
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPublic(customer, CurrentContext.getUserInfo())).getSuccess()) {
            } else if ((vr = customerIndustryValidator.validateCustomerInUserPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
            } else if ((vr = customerIndustryValidator.validateCustomerInUserAuthDeptPrivate(customer, CurrentContext.getUserInfo())).getSuccess()) {
            } else{
                throw new BusinessException("此客户你没有权限推送，因为此客户不在你部门公盘，也不是您个人客户!");
            }
        }
    }

    private void createOperationLog(List<CustomerIndustryPushEntity> list) {

        List<OperationLogEntity> logList = new ArrayList<>();

        for (CustomerIndustryPushEntity push : list) {
            OperationLogEntity log = new OperationLogEntity();

            log.setBizId(push.getCusId());
            log.setOptType(CustomerOperationType.cusPush);
            log.setContent(String.format("%s推送了客户[%d]给%s，等待对方确认",
                    CurrentContext.getUserName(), push.getCusId(), push.getReceiveUserName()));

            logList.add(log);
        }

        if (ObjectUtils.isNotEmpty(logList)) {
            operationLogManager.batchCreate(logList);
        }
    }
}
