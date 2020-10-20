package com.cii.bomse.crm.customer.base.manager;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.ciiframework.common.business.IManager;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 14:30
 * @since 1.0
 */
public interface IBaseCustomerManager<T extends BaseCustomerEntity> extends IManager<T> {

    /**
     * @description
     * 检查客户电话是否已经存在
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-11 10:19
     * @since 1.0
     */
    void validateCreateCustomer(String cusPhone);

    /**
     * @description
     * 查看客户号码的权限
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-12 13:50
     * @since 1.0
     */
    String callPhone(Long cusId);

    /**
     * @description
     * 拉私客户
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-20 11:17
     * @since 1.0
     */
    void hide(Long cusId);

    /**
     * @description
     * 公开客户
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-20 11:17
     * @since 1.0
     */
    void open(Long cusId);

    /**
     * @description
     * 更新客户电话
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-22 15:34
     * @since 1.0
     */
    void updateCustomerPhone(Long cusId, String oldPhone, String newPhone);
}
