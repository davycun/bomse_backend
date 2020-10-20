package com.cii.bomse.crm.customer.base.manager.impl;

import com.cii.bomse.crm.customer.base.dao.ICustomerAreaDao;
import com.cii.bomse.crm.customer.base.entity.CustomerAreaEntity;
import com.cii.bomse.crm.customer.base.manager.ICustomerAreaManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerAreaManagerImpl extends AbstractManager<CustomerAreaEntity> implements ICustomerAreaManager {

    @Autowired
    private ICustomerAreaDao customerAreaDao;

    @Override
    protected IMyBatisBaseDao<CustomerAreaEntity, Long> getMyBatisDao() {
        return customerAreaDao;
    }

    @Override
    protected void beforeBatchCreate(List<CustomerAreaEntity> list) {
        for (CustomerAreaEntity customerArea : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<CustomerAreaEntity> list) {
         for (CustomerAreaEntity customerArea : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
