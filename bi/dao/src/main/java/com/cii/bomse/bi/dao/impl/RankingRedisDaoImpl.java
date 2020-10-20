package com.cii.bomse.bi.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.cii.bomse.bi.dao.IRankingRedisDao;
import com.cii.bomse.bi.entity.RankingReportEntity;
import com.ciiframework.data.redis.AbstractRedisDao;
import com.ciiframework.exception.BusinessException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-23 17:55
 * @since 1.0
 */
@Repository
public class RankingRedisDaoImpl extends AbstractRedisDao<RankingReportEntity> implements IRankingRedisDao {


    public static final String rankingKey = "eia:report:order:ranking";

    @Override
    public void saveRanking(RankingReportEntity ranking) {
        try {
            Date now = Calendar.getInstance().getTime();
            now = DateUtils.truncate(now,Calendar.DAY_OF_MONTH);
            now = DateUtils.addDays(now,1);
            this.saveEntity(rankingKey,ranking);
            this.setTimeout(rankingKey,now);
        } catch (JsonProcessingException e) {
            throw new BusinessException("保存排名信息到redis失败！",e);
        }
    }

    @Override
    public RankingReportEntity readRanking() {
        RankingReportEntity ranking = null;

        try {
            ranking = this.parseEntity(rankingKey);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ranking;

    }
}
