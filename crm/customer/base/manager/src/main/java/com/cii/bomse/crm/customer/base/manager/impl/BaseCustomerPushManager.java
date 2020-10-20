package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerOperationType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerPushQueryType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerPushStatus;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerPushEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerPushManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-25 21:14
 * @since 1.0
 */
public abstract class BaseCustomerPushManager<T extends BaseCustomerPushEntity> extends AbstractManager<T> implements IBaseCustomerPushManager<T> {

    @Autowired
    protected IOperationLogManager operationLogManager;
    @Autowired
    protected IDeptManager deptManager;

    @Transactional
    @Override
    public void receive(Long id) {

        T old = findById(id,"id","cus_id","push_user_name","receive_user_id","push_status");

        if (ObjectUtils.isEmpty(old)){
            throw new BusinessException("接受的推送ID不存在!");
        }

        if (!CustomerPushStatus.WaitReceive.equals(old.getPushStatus())){
            throw new BusinessException("只有待接收状态的推送才能进行接受处理");
        }

        if (!CurrentContext.getUserId().equals(old.getReceiveUserId())){
            throw new BusinessException("不是推送给您的，不能进行接受动作");
        }

        old.setPushStatus(CustomerPushStatus.HasReceive);
        //接受或者拒绝时间
        old.setProcessTime(new Date());
        update(old);

        OperationLogEntity log = new OperationLogEntity();
        log.setBizId(old.getCusId());
        log.setOptType(CustomerOperationType.cusPushReceive);
        log.setContent(String.format("%s接受了%s推送的客户[%s]",
                CurrentContext.getUserName(),old.getPushUserName(),old.getCusId()));
        log.setRemark(old.getId().toString());

        operationLogManager.create(log);

    }

    @Transactional
    @Override
    public void refuse(Long id,String refuseReason) {


        T old = findById(id,"id","cus_id",
                "push_user_name","receive_user_id","push_status");

        if (ObjectUtils.isEmpty(id)
                || ObjectUtils.isEmpty(old)
                || ObjectUtils.isEmpty(refuseReason)){
            throw new BusinessException("拒绝原因和ID必填");
        }

        if (!CustomerPushStatus.WaitReceive.equals(old.getPushStatus())){
            throw new BusinessException("只有待接收状态的推送才能进行拒绝处理");
        }

        if (!CurrentContext.getUserId().equals(old.getReceiveUserId())){
            throw new BusinessException("不是推送给您的，不能进行拒绝动作");
        }

        old.setPushStatus(CustomerPushStatus.HasRefuse);
        old.setRefuseReason(refuseReason);
        //接受或者拒绝时间
        old.setProcessTime(new Date());
        update(old);

        OperationLogEntity log = new OperationLogEntity();
        log.setBizId(old.getCusId());
        log.setOptType(CustomerOperationType.cusPushRefuse);
        log.setContent(String.format("%s拒绝了%s推送的客户[%s]",
                CurrentContext.getUserName(),old.getPushUserName(),old.getCusId()));
        log.setRemark(old.getId().toString());

        operationLogManager.create(log);

    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

        if (param.containsKey("pushQueryType")){

            if (param.get("pushQueryType").equals(CustomerPushQueryType.push)){
                if (ObjectUtils.isNotEmpty(deptIds)){
                    param.put("authPushDeptIds",deptIds);
                    param.put("authPushUserId",CurrentContext.getUserId());
                }else{
                    param.put("pushUserId",CurrentContext.getUserId());
                }
            }else{
                if (ObjectUtils.isNotEmpty(deptIds)){
                    param.put("authReceiveDeptIds",deptIds);
                    param.put("authReceiveUserId",CurrentContext.getUserId());
                }else{
                    param.put("receiveUserId",CurrentContext.getUserId());
                }
            }
        }else{

            if (ObjectUtils.isNotEmpty(deptIds)){
                param.put("authPushDeptIds",deptIds);
                param.put("authPushUserId",CurrentContext.getUserId());

                param.put("authReceiveDeptIds",deptIds);
                param.put("authReceiveUserId",CurrentContext.getUserId());
            }else{
                param.put("authPushUserId",CurrentContext.getUserId());
                param.put("authReceiveUserId",CurrentContext.getUserId());
            }

        }
    }
}
