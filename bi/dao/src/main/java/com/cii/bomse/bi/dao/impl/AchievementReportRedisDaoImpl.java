package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.IAchievementReportRedisDao;
import com.cii.bomse.bi.entity.AchievementReportEntity;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-13 21:23
 * @since 1.0
 */
@Component
public class AchievementReportRedisDaoImpl extends AbstractReportRedis<AchievementReportEntity> implements IAchievementReportRedisDao {

    public String getKey(Long id, String startTime, String endTime){
        return String.format("boms:report:achievement:%s:%s",id.toString(),startTime+"-"+endTime);
    }

    @Override
    public String getKey(Long id) {
        return String.format("boms:report:achievement:%s",id.toString());
    }
}
