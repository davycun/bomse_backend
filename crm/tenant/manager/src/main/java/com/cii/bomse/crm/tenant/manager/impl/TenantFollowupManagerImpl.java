package com.cii.bomse.crm.tenant.manager.impl;

import com.cii.bomse.crm.tenant.dao.ITenantDao;
import com.cii.bomse.crm.tenant.dao.ITenantFollowupDao;
import com.cii.bomse.crm.tenant.dictionary.TenantFollowupType;
import com.cii.bomse.crm.tenant.dictionary.TenantOperationType;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.cii.bomse.crm.tenant.entity.TenantFollowupEntity;
import com.cii.bomse.crm.tenant.manager.ITenantFollowupManager;
import com.ciiframework.common.business.AbstractManager;
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


@Component
public class TenantFollowupManagerImpl extends AbstractManager<TenantFollowupEntity> implements ITenantFollowupManager {

    @Autowired
    private ITenantFollowupDao tenantFollowupDao;
    @Autowired
    private ITenantDao tenantDao;
    @Autowired
    private IOperationLogManager operationLogManager;

    @Override
    protected IMyBatisBaseDao<TenantFollowupEntity, Long> getMyBatisDao() {
        return tenantFollowupDao;
    }

    @Override
    protected void beforeBatchCreate(List<TenantFollowupEntity> list) {
        for (TenantFollowupEntity followupEntity : list) {
            ValidationResult vr = ValidationUtils.validateInclude(followupEntity);
            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }
        }
    }

    @Override
    protected void afterBatchCreate(List<TenantFollowupEntity> list) {
        updateCustomer(list);
        afterCreateAddLog(list);
    }

    public void afterCreateAddLog(List<TenantFollowupEntity> list){

        List<OperationLogEntity> optLogList = new ArrayList<>();

        ObjectUtils.forEach(list,optLogList,(followupEntity,optList)->{
            OperationLogEntity opt = new OperationLogEntity();
            opt.setBizId(followupEntity.getTntId());
            if (TenantFollowupType.Phone.equals(followupEntity.getFollowupType())) {
                opt.setOptType(TenantOperationType.tenantFollowupPhone);
                opt.setContent(String.format("%s电话跟进了租户[%d]",
                        followupEntity.getCreateName(), followupEntity.getTntId()));
            } else {
                opt.setOptType(TenantOperationType.tenantFollowupScene);
                opt.setContent(String.format("%s现场拜访了客户[%d]",
                        followupEntity.getCreateName(), followupEntity.getTntId()));
            }

            optList.add(opt);
        });

        if (ObjectUtils.isNotEmpty(optLogList)) {
            operationLogManager.batchCreate(optLogList);
        }
    }

    /**
     * @description
     * 更新客户最后跟进时间，跟进次数和跟进人信息
     * @auth david·cun
     * @date 2020-03-31 22:59
     * @since 1.0
     */
    protected void updateCustomer(List<TenantFollowupEntity> list) {

        List<TenantEntity> tenantList = new ArrayList<>();

        for (TenantFollowupEntity followupEntity : list) {

            Map<String, Object> param = new HashMap<>();
            param.put("tntId", followupEntity.getTntId());

            TenantEntity tenant = new TenantEntity();

            int count = tenantFollowupDao.countByMap(param);
            tenant.setId(followupEntity.getTntId());
            tenant.setLastFollowupTime(new Date());
            tenant.setFollowupCount(count);
            ObjectUtils.isNotEmpty(followupEntity.getNextContactTime(),followupEntity,tenant,
                    (f,t)->t.setNextContactTime(f.getNextContactTime()));

            tenantList.add(tenant);
        }

        if (tenantList.size() > 0) {
            tenantDao.batchUpdate(tenantList);
        }
    }

}
