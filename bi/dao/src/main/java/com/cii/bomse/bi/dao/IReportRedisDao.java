package com.cii.bomse.bi.dao;

import com.cii.bomse.bi.entity.BaseReportEntity;
import com.cii.bomse.bi.entity.CustomerStatisticReportEntity;
import com.ciiframework.data.redis.IRedisDao;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 22:35
 * @since 1.0
 */
public interface IReportRedisDao<T extends BaseReportEntity> extends IRedisDao<T> {

    void saveReport(Long id, List<T> list);

    List<T> getReport(Long id);

    void saveReport(Long id, List<T> list,String startTime,String endTime);

    List<T> getReport(Long id,String startTime,String endTime);
}
