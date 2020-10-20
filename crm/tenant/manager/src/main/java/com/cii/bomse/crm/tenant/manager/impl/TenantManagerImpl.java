package com.cii.bomse.crm.tenant.manager.impl;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.cii.bomse.crm.tenant.dao.ITenantDao;
import com.cii.bomse.crm.tenant.dictionary.TenantOperationType;
import com.cii.bomse.crm.tenant.dictionary.TenantStatus;
import com.cii.bomse.crm.tenant.dto.TenantStatisticDto;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.cii.bomse.crm.tenant.manager.ITenantManager;
import com.cii.bomse.hrm.dept.manager.IDataAuthValidator;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.log.entity.OperationLogEntity;
import com.ciiframework.log.manager.IOperationLogManager;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Pattern;


@Component
public class TenantManagerImpl extends AbstractManager<TenantEntity> implements ITenantManager {

    @Autowired
    private ITenantDao tenantDao;
    @Autowired
    private IDataAuthValidator dataAuthValidator;
    @Autowired
    private IOperationLogManager operationLogManager;
    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<TenantEntity, Long> getMyBatisDao() {
        return tenantDao;
    }

    @Override
    protected void beforeBatchCreate(List<TenantEntity> list) {
        for (TenantEntity tenantIndustry : list) {

            ValidationResult vr = ValidationUtils.validateInclude(tenantIndustry);

            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }

            ObjectUtils.isEmpty(tenantIndustry.getTntStatus(),tenantIndustry,
                    (t)->t.setTntStatus(TenantStatus.Leasing));
            ObjectUtils.isEmpty(tenantIndustry.getLastFollowupTime(),tenantIndustry,
                    (t)->t.setLastFollowupTime(new Date()));
            ObjectUtils.isEmpty(tenantIndustry.getNextContactTime(),tenantIndustry,
                    (t)->t.setNextContactTime(t.getLeaseTimeEnd()));
        }
    }

    @Override
    public String callPhone(Long tntId) {

        TenantEntity tenant = findById(tntId, "id", "tnt_phone", "owner_id", "owner_dept_id", "create_id", "create_dept_id");

        String phone = null;

        ValidationResult vr = null;

        if ((vr = dataAuthValidator.validateEntityBelongToUser(tenant, CurrentContext.getUserInfo())).getSuccess()) {
            phone = tenant.getTntPhone();
        } else if ((vr = dataAuthValidator.validateEntityBelongToUserDept(tenant, CurrentContext.getUserInfo())).getSuccess()) {
            phone = tenant.getTntPhone();
        } else if ((vr = dataAuthValidator.validateEntityBelongToUserAuthDept(tenant, CurrentContext.getUserInfo())).getSuccess()) {
            phone = tenant.getTntPhone();
        } else {
            throw new BusinessException("只有相同部门的同事，或者自己录入的租户信息才可查看号码!");
        }

        if (ObjectUtils.isNotEmpty(phone)) {
            //if success ,record a log of call phone
            OperationLogEntity log = new OperationLogEntity();
            log.setBizId(tntId);
            log.setOptType(TenantOperationType.tenantCallPhone);
            log.setContent(String.format("%s拨打了租户[%d]的联系人电话", CurrentContext.getUserName(), tenant.getId()));

            operationLogManager.create(log);
        }

        return phone;
    }

    @Override
    public void updatePhone(Long tntId, String oldPhone, String newPhone) {
        if (ObjectUtils.isNotEmpty(tntId)
                && ObjectUtils.isNotEmpty(oldPhone)
                && ObjectUtils.isNotEmpty(newPhone)) {

            TenantEntity tenant =
                    Optional.ofNullable(findById(tntId, "id", "tnt_phone"))
                            .orElseThrow(() -> new BusinessException(String.format("客户[%d]不存在", tntId)));

            ObjectUtils.ifFalseThrow(
                    (!tenant.getTntPhone().equals(oldPhone) || !Pattern.matches(Constants.phoneRegexp, newPhone)),
                    () -> new BusinessException("手机号码格式不对，或者原号码不匹配"));

            //更新客户号码
            tenant.setTntPhone(newPhone);
            update(tenant);
            getMyBatisDao().update(tenant);

            //记录与业主ID关联的日志
            OperationLogEntity opt = new OperationLogEntity();
            opt.setBizId(tntId);
            opt.setOptType(TenantOperationType.tenantUpdatePhone);
            opt.setContent(String.format("%s更新了租户[%d]号码，老号码为%s", CurrentContext.getUserName(), tntId, oldPhone));
            opt.setRemark(newPhone);
            operationLogManager.create(opt);
        }
    }

    @Override
    public TenantStatisticDto statistic() {

        TenantStatisticDto statistic = new TenantStatisticDto();
        Map<String, Object> param = new HashMap<>();
        Date now = Calendar.getInstance().getTime();

        param.clear();
        //最后跟进小于下一次联系时间的数据
        param.put("waitContact", Boolean.TRUE);
        param.put("nextContactTimeEnd", now);
        statistic.setWaitContactCount(countByMap(param));

        return statistic;
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        List<Long> ownerUserDeptIdList = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

        //查询自己有权限部门和自己的数据
        if (ObjectUtils.isNotEmpty(ownerUserDeptIdList)) {
            param.put("authOwnerDeptIdList", ownerUserDeptIdList);
            param.put("authOwnerId", CurrentContext.getUserId());
        } else {
            //查询自己和自己部门的数据
            param.put("authOwnerId", CurrentContext.getUserId());
            param.put("authOwnerDeptId", CurrentContext.getOwnerDeptId());
        }

    }
}
