package com.cii.bomse.base.auth.manager.impl;

import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.PageResult;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import com.cii.bomse.base.auth.dao.IRoleUserDbDao;
import com.cii.bomse.base.auth.entity.RoleUserEntity;
import com.cii.bomse.base.auth.manager.IRoleUserManager;
import com.cii.bomse.common.observer.IMenuAuthSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 用户角色管理
 * @auth david·cun
 * @date 2019-04-10 11:37
 * @since 1.0
 */
@Service
public class RoleUserManagerImpl extends AbstractManager<RoleUserEntity> implements IRoleUserManager {

    @Autowired
    private IRoleUserDbDao roleUserDbDao;

    @Autowired
    private IMenuAuthSubject menuAuthSubject;

    @Override
    protected IMyBatisBaseDao<RoleUserEntity, Long> getMyBatisDao() {
        return roleUserDbDao;
    }


    @Override
    public void allotRoleUser(Long roleId, List<Long> userIds) {

        Map<String, Object> param = new HashMap<>();
        param.put("roleId", roleId);


        //针对已经分配过多的用户进行去重
        PageResult<RoleUserEntity> list = roleUserDbDao.selectByMap(param, 0, 100);
        while (list.isHasNextPage()) {
            for (RoleUserEntity rue : list.getData()) {
                userIds.remove(rue.getUserId());
            }
            list = roleUserDbDao.selectByMap(param, (list.getCurrentPageNo() - 1) * list.getPageSize(), 100);
        }
        if (list.hasData()) {
            for (RoleUserEntity rue : list.getData()) {
                userIds.remove(rue.getUserId());
            }
        }


        //剩余的插入数据库
        List<RoleUserEntity> l = new ArrayList<>();
        for (Long userId : userIds) {
            RoleUserEntity rue = new RoleUserEntity();
            rue.setRoleId(roleId);
            rue.setUserId(userId);
            l.add(rue);
        }
        this.batchCreate(l);

        menuAuthSubject.notifyAllObserver();
    }

    @Override
    public int deleteRoleUser(RoleUserEntity roleUser) {

        ValidationResult vr = ValidationUtils.validateInclude(roleUser,"roleId","userId");

        if (!vr.getSuccess()){
            throw new BusinessException(vr.getMessage());
        }
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", roleUser.getRoleId());
        param.put("userId", roleUser.getUserId());

        menuAuthSubject.notifyAllObserver();

        return roleUserDbDao.deleteByMap(param);

    }

}
