package com.cii.bomse.crm.tenant.dao.impl;

import com.cii.bomse.crm.tenant.dao.ITenantFollowupDao;
import com.cii.bomse.crm.tenant.entity.TenantFollowupEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class TenantFollowupDaoImpl extends AbstractMyBatisDao<TenantFollowupEntity,Long> implements ITenantFollowupDao {
}
