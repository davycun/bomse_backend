package com.cii.bomse.crm.customer.base.manager;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerFollowupEntity;
import com.ciiframework.common.business.IManager;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 16:48
 * @since 1.0
 */
public interface IBaseCustomerFollowupManager<T extends BaseCustomerFollowupEntity> extends IManager<T> {

    /**
     * @description
     * 待处理的客户进行处理
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-20 16:48
     * @since 1.0
     */
    public void processCustomer(T followup);
}
