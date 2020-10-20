package com.cii.bomse.bi.dao;

import com.cii.bomse.bi.entity.RankingReportEntity;
import com.ciiframework.data.redis.IRedisDao;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-23 17:53
 * @since 1.0
 */
public interface IRankingRedisDao extends IRedisDao<RankingReportEntity> {

    void saveRanking(RankingReportEntity ranking);

    RankingReportEntity readRanking();
}
