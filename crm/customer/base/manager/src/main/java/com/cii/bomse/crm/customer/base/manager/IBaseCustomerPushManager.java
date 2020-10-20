package com.cii.bomse.crm.customer.base.manager;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerPushEntity;
import com.ciiframework.common.business.IManager;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 18:48
 * @since 1.0
 */
public interface IBaseCustomerPushManager<T extends BaseCustomerPushEntity> extends IManager<T> {

    /**
     * @description
     * 接受
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-25 21:13
     * @since 1.0
     */
    void receive(Long id);

    /**
     * @description
     * 拒绝
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-25 21:13
     * @since 1.0
     */
    void refuse(Long id, String refuseReason);

}
