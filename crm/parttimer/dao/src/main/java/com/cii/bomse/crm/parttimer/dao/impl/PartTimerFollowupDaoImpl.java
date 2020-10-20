package com.cii.bomse.crm.parttimer.dao.impl;

import com.cii.bomse.crm.parttimer.dao.IPartTimerFollowupDao;
import com.cii.bomse.crm.parttimer.entity.PartTimerFollowupEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class PartTimerFollowupDaoImpl extends AbstractMyBatisDao<PartTimerFollowupEntity,Long> implements IPartTimerFollowupDao {
}
