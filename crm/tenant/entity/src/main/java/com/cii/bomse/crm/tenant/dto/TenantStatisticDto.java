package com.cii.bomse.crm.tenant.dto;

import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * @auth david·cun
 * @date 2020-04-02 13:47
 * @since 1.0
 */
public class TenantStatisticDto extends BaseEntity {

    /**待联系的租户*/
    private float waitContactCount;
    /**到期客户*/
    private float expireCount;

    public float getWaitContactCount() {
        return waitContactCount;
    }

    public void setWaitContactCount(float waitContactCount) {
        this.waitContactCount = waitContactCount;
    }

    public float getExpireCount() {
        return expireCount;
    }

    public void setExpireCount(float expireCount) {
        this.expireCount = expireCount;
    }
}
