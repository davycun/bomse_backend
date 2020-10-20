package com.cii.bomse.crm.customer.base.dao;

import com.cii.bomse.crm.customer.base.entity.BaseCustomerEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 16:21
 * @since 1.0
 */
public interface IBaseCustomerDao<T extends BaseCustomerEntity> extends IMyBatisBaseDao<T,Long> {
}
