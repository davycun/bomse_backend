package com.cii.bomse.crm.customer.industry.dto;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-16 17:37
 * @since 1.0
 */
public class CustomerStatisticDto extends BaseEntity {

    /*待处理的客户*/
    private float waitProcessCount = 0;
    /*待联系的客户，下一次联系时间到的客户*/
    private float waitContactCount = 0;
    /*待上架，到期需要跟进的客户*/
    private float waitUpCount = 0;

    public float getWaitUpCount() {
        return waitUpCount;
    }

    public void setWaitUpCount(float waitUpCount) {
        this.waitUpCount = waitUpCount;
    }

    public float getWaitProcessCount() {
        return waitProcessCount;
    }

    public void setWaitProcessCount(float waitProcessCount) {
        this.waitProcessCount = waitProcessCount;
    }

    public float getWaitContactCount() {
        return waitContactCount;
    }

    public void setWaitContactCount(float waitContactCount) {
        this.waitContactCount = waitContactCount;
    }
}
