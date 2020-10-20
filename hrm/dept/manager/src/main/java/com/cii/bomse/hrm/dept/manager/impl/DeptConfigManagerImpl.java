package com.cii.bomse.hrm.dept.manager.impl;

import com.cii.bomse.hrm.dept.dao.IDeptConfigDao;
import com.cii.bomse.hrm.dept.dao.IDeptConfigRedisDao;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.manager.IDeptConfigManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.logging.Logger;
import com.ciiframework.logging.LoggerFactory;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class DeptConfigManagerImpl extends AbstractManager<DeptConfigEntity> implements IDeptConfigManager {

    private static Logger logger = LoggerFactory.getLogger(DeptConfigManagerImpl.class);
    @Autowired
    private IDeptConfigDao deptConfigDao;
    @Autowired
    private IDeptConfigRedisDao deptConfigRedisDao;

    @Override
    protected IMyBatisBaseDao<DeptConfigEntity, Long> getMyBatisDao() {
        return deptConfigDao;
    }

    @Override
    protected void afterBatchUpdate(List<DeptConfigEntity> list) {

        list.forEach((config)->deptConfigRedisDao.deleteDeptConfigByDeptId(config.getDeptId()));
    }

    @Override
    public DeptConfigEntity findByDeptId(Long deptId) {

        DeptConfigEntity config = deptConfigRedisDao.getDeptConfigByDeptId(deptId);

        if (ObjectUtils.isEmpty(config)){
            Map<String,Object> param = new HashMap<>();
            param.put("deptId",deptId);
            List<DeptConfigEntity> list = findByMap(param);
            if (ObjectUtils.isNotEmpty(list)){
                config = list.get(0);
                deptConfigRedisDao.setDeptConfigByDeptId(deptId,config);

                if (list.size()>1){
                    logger.error(String.format("Find more then one DepConfig [%d] which only allow one",deptId));
                }
            }else{
                config = new DeptConfigEntity();
            }
        }

        return wrapperDefault(config,deptConfigRedisDao.getDefaultDeptConfig());
    }

    private DeptConfigEntity wrapperDefault(DeptConfigEntity target,DeptConfigEntity defaultConfig){

        target.setDefaultConfig(defaultConfig);
        return target;
    }
}
