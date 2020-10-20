package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.ICustomerStatisticReportRedisDao;
import com.cii.bomse.bi.entity.CustomerStatisticReportEntity;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 18:17
 * @since 1.0
 */
@Component
public class CustomerStatisticReportRedisDaoImpl extends AbstractReportRedis<CustomerStatisticReportEntity> implements ICustomerStatisticReportRedisDao {

    public String getKey(Long id){
        return String.format("eia:report:customer:statistic:%s",id.toString());
    }

    public String getKey(Long id, String startTime, String endTime) {
        return String.format("eia:report:customer:statistic:%s:%s",id.toString(),startTime+"-"+endTime);
    }
}
