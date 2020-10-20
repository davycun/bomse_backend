package com.cii.bomse.crm.tenant.dao.impl;

import com.cii.bomse.crm.tenant.dao.ITenantDao;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class TenantDaoImpl extends AbstractMyBatisDao<TenantEntity,Long> implements ITenantDao {
}
