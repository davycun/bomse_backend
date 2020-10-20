package com.cii.bomse.house.base.manager.impl;

import com.cii.bomse.house.base.dao.IParkOwnerRelationDao;
import com.cii.bomse.house.base.manager.IParkOwnerRelationManager;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ParkOwnerRelationManagerImpl extends AbstractManager<ParkOwnerRelationEntity> implements IParkOwnerRelationManager {

    @Autowired
    private IParkOwnerRelationDao parkOwnerRelationDao;

    @Override
    protected IMyBatisBaseDao<ParkOwnerRelationEntity, Long> getMyBatisDao() {
        return parkOwnerRelationDao;
    }

    @Override
    protected void beforeBatchCreate(List<ParkOwnerRelationEntity> list) {
        for (ParkOwnerRelationEntity parkOwnerRelation : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }
    @Override
    protected void beforeBatchUpdate(List<ParkOwnerRelationEntity> list) {
         for (ParkOwnerRelationEntity parkOwnerRelation : list){
            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

}
