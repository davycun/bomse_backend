package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.IRankingReportDao;
import com.cii.bomse.bi.entity.RankingReportEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class RankingReportDaoImpl extends AbstractMyBatisDao<RankingReportEntity,Long> implements IRankingReportDao {
}
