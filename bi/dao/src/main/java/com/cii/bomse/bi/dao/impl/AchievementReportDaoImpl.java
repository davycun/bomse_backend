package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.IAchievementReportDao;
import com.cii.bomse.bi.entity.AchievementReportEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class AchievementReportDaoImpl extends AbstractMyBatisDao<AchievementReportEntity,Long> implements IAchievementReportDao {
}
