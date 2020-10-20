package com.cii.bomse.crm.parttimer.dao.impl;

import com.cii.bomse.crm.parttimer.dao.IPartTimerDao;
import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class PartTimerDaoImpl extends AbstractMyBatisDao<PartTimerEntity,Long> implements IPartTimerDao {
}
