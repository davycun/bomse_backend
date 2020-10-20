package com.cii.bomse.crm.parttimer.manager.impl;

import com.cii.bomse.crm.parttimer.dao.IPartTimerDao;
import com.cii.bomse.crm.parttimer.dictionary.FromType;
import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;
import com.cii.bomse.crm.parttimer.manager.IPartTimerManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class PartTimerManagerImpl extends AbstractManager<PartTimerEntity> implements IPartTimerManager {

    @Autowired
    private IPartTimerDao partTimerDao;

    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<PartTimerEntity, Long> getMyBatisDao() {
        return partTimerDao;
    }

    @Override
    protected void beforeBatchCreate(List<PartTimerEntity> list) {
        for (PartTimerEntity partTimer : list){

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
            ValidationResult vr = ValidationUtils.validateInclude(partTimer);
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }

            if (ObjectUtils.isEmpty(partTimer.getFromType())){
                partTimer.setFromType(FromType.OffLine);
            }
        }
    }
    @Override
    protected void beforeBatchUpdate(List<PartTimerEntity> list) {
        for (PartTimerEntity partTimer : list){

            //在更新数据之前的动作，比如校验数据唯一键必填
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

        if (ObjectUtils.isNotEmpty(deptIds)){
            param.put("authOwnerDeptIds",deptIds);
            param.put("authOwnerId",CurrentContext.getUserId());
        }else{
            param.put("ownerId",CurrentContext.getUserId());
        }

    }

}
