package com.cii.bomse.hrm.dept.manager.impl;

import com.cii.bomse.hrm.dept.dao.IDeptShareDao;
import com.cii.bomse.hrm.dept.dictionary.DeptShareState;
import com.cii.bomse.hrm.dept.manager.IDeptShareManager;
import com.cii.bomse.hrm.dept.entity.DeptShareEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class DeptShareManagerImpl extends AbstractManager<DeptShareEntity> implements IDeptShareManager {

    @Autowired
    private IDeptShareDao deptShareDao;

    @Override
    protected IMyBatisBaseDao<DeptShareEntity, Long> getMyBatisDao() {
        return deptShareDao;
    }

    @Override
    protected void beforeBatchCreate(List<DeptShareEntity> list) {
        for (DeptShareEntity deptShare : list){

            if (ObjectUtils.isEmpty(deptShare.getShareState())){
                //TODO 没有开发互相申请功能之前，此部分直接创建代表直接是配置功能，并非申请功能
                deptShare.setShareState(DeptShareState.Accept);
            }
        }
    }

    @Override
    public List<Long> findAllShareDeptByDeptId(Long deptId) {

        Map<String,Object> param = new HashMap<>();

        param.put("deptId",deptId);

        List<DeptShareEntity> list = findByMap(param);

        List<Long> result = new ArrayList<>();

        for (DeptShareEntity share : list){
            if (share.getDeptFromId().equals(deptId)){
                result.add(share.getDeptToId());
            }else if (share.getDeptToId().equals(deptId)){
                result.add(share.getDeptFromId());
            }
        }

        return result;
    }
}
