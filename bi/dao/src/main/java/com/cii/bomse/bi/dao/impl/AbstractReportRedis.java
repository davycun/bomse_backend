package com.cii.bomse.bi.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.cii.bomse.bi.dao.IReportRedisDao;
import com.cii.bomse.bi.entity.BaseReportEntity;
import com.ciiframework.data.redis.AbstractRedisDao;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;

import java.util.Calendar;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 17:59
 * @since 1.0
 */
public abstract class AbstractReportRedis<T extends BaseReportEntity> extends AbstractRedisDao<T> implements IReportRedisDao<T> {

    public void saveReport(String key ,List<T> list) {
        try {
            String value = objectMapper.writeValueAsString(list);
            valueOps.set(key,value);
            //设置当天晚上失效
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,23);
            calendar.set(Calendar.MINUTE,59);
            template.expireAt(key,calendar.getTime());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<T> getReport(String key){
        String value = valueOps.get(key);
        List<T> list = null;
        try {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, GenericsUtils.getSuperClassGenricType(this.getClass()));
            if (ObjectUtils.isNotEmpty(value)){
                list = objectMapper.readValue(value,type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<T> getReport(Long id) {
        return getReport(getKey(id));
    }

    @Override
    public void saveReport(Long id, List<T> list) {
        saveReport(getKey(id),list);
    }

    @Override
    public List<T> getReport(Long id, String startTime, String endTime) {
        return getReport(getKey(id,startTime,endTime));
    }

    @Override
    public void saveReport(Long id, List<T> list, String startTime, String endTime) {
        saveReport(getKey(id,startTime,endTime),list);
    }

    public abstract String getKey(Long id);
    public abstract String getKey(Long id,String startTime,String endTime);
}
