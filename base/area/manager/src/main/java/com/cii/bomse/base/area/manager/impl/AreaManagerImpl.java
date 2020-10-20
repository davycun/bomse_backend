package com.cii.bomse.base.area.manager.impl;

import com.cii.bomse.base.area.dao.IAreaDao;
import com.cii.bomse.base.area.manager.IAreaManager;
import com.cii.bomse.base.area.entity.AreaEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;


@Component
public class AreaManagerImpl extends AbstractAreaManager<AreaEntity> implements IAreaManager {

    @Autowired
    private IAreaDao areaDao;

    @Override
    protected IMyBatisBaseDao<AreaEntity, Long> getMyBatisDao() {
        return areaDao;
    }

    public List<AreaEntity> findByMapToTree(Map<String,Object> param){

        List<AreaEntity> areas = areaDao.selectByMap(param);

        return treeAndSort(areas);
    }

    @Override
    protected void beforeBatchCreate(List<AreaEntity> list) {
        for (AreaEntity area : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
            ValidationResult vr = ValidationUtils.validateInclude(area);

            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }

        }
    }
    @Override
    protected void beforeBatchUpdate(List<AreaEntity> list) {
         for (AreaEntity area : list){
            //在更新数据之前的动作，比如校验数据唯一键必填
         }
    }

    @Override
    protected boolean isNeedAddCpyId() {
        return false;
    }
}
