package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.ICustomerChannelReportRedisDao;
import com.cii.bomse.bi.entity.CustomerChannelReportEntity;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-19 17:38
 * @since 1.0
 */
@Component
public class CustomerChannelReportRedisDaoImpl extends AbstractReportRedis<CustomerChannelReportEntity> implements ICustomerChannelReportRedisDao {
    @Override
    public String getKey(Long id) {
        return String.format("eia:report:customer:channel:%s", id.toString());
    }

    @Override
    public String getKey(Long id, String startTime, String endTime) {
        return String.format("eia:report:customer:channel:%s:%s", id.toString(), startTime + "-" + endTime);
    }
}
