package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.crm.customer.base.dao.IBaseCustomerDao;
import com.cii.bomse.crm.customer.base.dictionary.CustomerFollowupType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOperationType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.cii.bomse.crm.customer.base.entity.BaseCustomerFollowupEntity;
import com.cii.bomse.crm.customer.base.manager.IBaseCustomerFollowupManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.common.utils.OperateFillUtils;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 16:02
 * @since 1.0
 */
public abstract class BaseCustomerFollowupManager<T extends BaseCustomerFollowupEntity, C extends BaseCustomerEntity> extends AbstractManager<T> implements IBaseCustomerFollowupManager<T> {

    @Autowired
    protected IDeptManager deptManager;
    @Autowired
    protected IOperationLogManager operationLogManager;

    public abstract IBaseCustomerDao<C> getCustomerDao();

    @Override
    protected void beforeBatchCreate(List<T> list) {

        for (T followupEntity : list) {
            ValidationResult vr = ValidationUtils.validateInclude(followupEntity);
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
        }
    }

    @Override
    protected void afterBatchCreate(List<T> list) {

        updateCustomer(list, false);

        afterCreateAddLog(list);

    }

    public void afterCreateAddLog(List<T> list) {

        List<OperationLogEntity> optLogList = new ArrayList<>();
        for (T followupEntity : list) {
            OperationLogEntity opt = new OperationLogEntity();

            opt.setBizId(followupEntity.getCusId());
            if (CustomerFollowupType.Phone.equals(followupEntity.getFollowupType())) {
                opt.setOptType(CustomerOperationType.cusFollowupPhone);
                opt.setContent(String.format("%s电话跟进了客户[%d]",
                        followupEntity.getCreateName(), followupEntity.getCusId()));
            } else {
                opt.setOptType(CustomerOperationType.cusFollowupScene);
                opt.setContent(String.format("%s带看了客户[%d]",
                        followupEntity.getCreateName(), followupEntity.getCusId()));
            }

            optLogList.add(opt);
        }
        if (ObjectUtils.isNotEmpty(optLogList)) {
            operationLogManager.batchCreate(optLogList);
        }
    }

    @Transactional
    public void processCustomer(T followup) {

        OperateFillUtils.fill(followup);
        followup.setId(idGenerate.generate());
        int rs = getMyBatisDao().insert(followup);

        List<T> list = new ArrayList<>();
        list.add(followup);

        updateCustomer(list, true);
        afterCreateAddLog(list);

    }

    /**
     * @description 更新客户最后跟进时间，跟进次数和跟进人信息
     * @auth david·cun
     * @date 2020-03-31 22:59
     * @since 1.0
     */
    protected void updateCustomer(List<T> list, boolean process) {

        List<C> customers = new ArrayList<>();

        for (T followupEntity : list) {

            Map<String, Object> param = new HashMap<>();
            param.put("cusId", followupEntity.getCusId());

            C cus = (C) ObjectUtils.createInstance(GenericsUtils.getSuperClassGenricType(getClass(), 1));

            int count = getMyBatisDao().countByMap(param);
            cus.setId(followupEntity.getCusId());
            cus.setLastFollowupTime(new Date());
            cus.setFollowupCount(count);

            ObjectUtils.isNotEmpty(followupEntity.getNextContactTime(), followupEntity, cus,
                    (f, c) -> c.setNextContactTime(f.getNextContactTime()));

            //客户待处理，就是录入跟进信息即可变成已处理状态（待判断）
            if (process) {
                C old = getCustomerDao().selectById(followupEntity.getCusId(), "id", "cus_status");
                if (CustomerStatus.WaitProcess.equals(old.getCusStatus())) {
                    cus.setCusStatus(CustomerStatus.Followup);
                }
            }

            customers.add(cus);
        }

        if (customers.size() > 0) {
            getCustomerDao().batchUpdate(customers);
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //确定是否是查看某个客户的跟进信息，如果是查询某个客户跟进信息，就不能查看隐藏者的跟进
        if (param.containsKey("cusId")) {

            C cus = getCustomerDao().selectById(Long.valueOf(param.get("cusId").toString()),
                    "id", "cus_owner_type", "owner_id", "owner_dept_id");

            List<Long> authDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

            //隐藏状态的客户，别人不能查看隐藏者的跟进内容
            if (CustomerOwnerType.Hide.equals(cus.getCusOwnerType())
                    && !CurrentContext.getUserId().equals(cus.getOwnerId())
                    && ObjectUtils.isNotEmpty(authDeptIds)
                    && !authDeptIds.contains(cus.getOwnerDeptId())) {

                param.put("notCreateId", cus.getOwnerId());
            }
        } else {

            //跟进只能查询自己的或者自己子部门的数据

            List<Long> ownerDeptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

            if (ObjectUtils.isNotEmpty(ownerDeptIds)) {
                param.put("authCreateDeptIds", ownerDeptIds);
                param.put("authCreateId", CurrentContext.getUserId());
            } else if (!param.containsKey("cusId")) {
                //查询跟进列表的时候才加上此条件
                param.put("createId", CurrentContext.getUserId());
            }
        }

    }
}
