package com.cii.bomse.crm.parttimer.manager.impl;

import com.cii.bomse.crm.parttimer.dao.IPartTimerFollowupDao;
import com.cii.bomse.crm.parttimer.entity.PartTimerFollowupEntity;
import com.cii.bomse.crm.parttimer.manager.IPartTimerFollowupManager;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class PartTimerFollowupManagerImpl extends AbstractManager<PartTimerFollowupEntity> implements IPartTimerFollowupManager {

    @Autowired
    private IPartTimerFollowupDao partTimerFollowupDao;
    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<PartTimerFollowupEntity, Long> getMyBatisDao() {
        return partTimerFollowupDao;
    }

    @Override
    protected void beforeBatchCreate(List<PartTimerFollowupEntity> list) {
        for (PartTimerFollowupEntity partTimerFollowup : list) {

            //在插入数据之前的动作，比如生成编码，填充默认值等，或者其他业务逻辑
        }
    }

    @Override
    protected void beforeBatchUpdate(List<PartTimerFollowupEntity> list) {
        for (PartTimerFollowupEntity partTimerFollowup : list) {

            //在更新数据之前的动作，比如校验数据唯一键必填
        }
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());

        if (ObjectUtils.isNotEmpty(deptIds)) {
            param.put("authCreateDeptIds", deptIds);
            param.put("authCreateId", CurrentContext.getUserId());
        } else {
            param.put("createId", CurrentContext.getUserId());
        }
    }

}
