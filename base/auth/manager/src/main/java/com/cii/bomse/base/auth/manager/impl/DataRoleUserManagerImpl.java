package com.cii.bomse.base.auth.manager.impl;

import com.cii.bomse.base.auth.dao.IDataRoleUserDbDao;
import com.cii.bomse.base.auth.entity.DataRoleUserEntity;
import com.cii.bomse.base.auth.manager.IDataRoleUserManager;
import com.cii.bomse.common.observer.IDataAuthSubject;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-25 12:00
 * @since 1.0
 */
@Service
public class DataRoleUserManagerImpl extends AbstractManager<DataRoleUserEntity> implements IDataRoleUserManager {

    @Autowired
    private IDataRoleUserDbDao dataRoleUserDbDao;

    @Override
    protected IMyBatisBaseDao<DataRoleUserEntity, Long> getMyBatisDao() {
        return dataRoleUserDbDao;
    }

    @Autowired
    private IDataAuthSubject dataAuthSubject;

    @Override
    public void allotRoleUser(Long roleId, List<Long> userIds) {

        Map<String, Object> param = new HashMap<>();
        param.put("roleId", roleId);

        //针对已经分配过多的用户进行去重
        PageResult<DataRoleUserEntity> list = dataRoleUserDbDao.selectByMap(param, 0, 100);
        while (list.isHasNextPage()) {
            for (DataRoleUserEntity rue : list.getData()) {
                userIds.remove(rue.getUserId());
            }
            list = dataRoleUserDbDao.selectByMap(param, (list.getCurrentPageNo() - 1) * list.getPageSize(), 100);
        }
        if (list.hasData()) {
            for (DataRoleUserEntity rue : list.getData()) {
                userIds.remove(rue.getUserId());
            }
        }


        //剩余的插入数据库
        List<DataRoleUserEntity> l = new ArrayList<>();
        for (Long userId : userIds) {
            DataRoleUserEntity rue = new DataRoleUserEntity();
            rue.setRoleId(roleId);
            rue.setUserId(userId);
            l.add(rue);
        }
        this.batchCreate(l);

        //通知权限已经更新了更新
        dataAuthSubject.notifyAllObserver();
    }

    @Override
    public int deleteRoleUser(DataRoleUserEntity dataRoleUser) {

        ValidationResult vr = ValidationUtils.validateInclude(dataRoleUser,"userId","roleId");
        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userId", dataRoleUser.getUserId());
        param.put("roleId", dataRoleUser.getRoleId());

        //通知数据权限已经更新了
        dataAuthSubject.notifyAllObserver();

        return dataRoleUserDbDao.deleteByMap(param);
    }
}
