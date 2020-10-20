package com.cii.bomse.hrm.dept.dao.impl;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.cii.bomse.hrm.dept.dao.IDeptConfigRedisDao;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.ciiframework.data.redis.AbstractRedisDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.logging.Logger;
import com.ciiframework.logging.LoggerFactory;
import com.ciiframework.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-30 20:34
 * @since 1.0
 */
@Repository
public class DeptConfigRedisDaoImpl extends AbstractRedisDao<DeptConfigEntity> implements IDeptConfigRedisDao {

    private static final Logger logger = LoggerFactory.getLogger(DeptConfigRedisDaoImpl.class);

    @Override
    public DeptConfigEntity getDeptConfigByDeptId(Long deptId) {
        try {
            return parseEntity(getKey(deptId.toString()));
        } catch (IOException e) {
            throw new BusinessException(String.format("parse DeptConfig error %d",deptId),e);
        }
    }

    @Override
    public void setDeptConfigByDeptId(Long deptId,DeptConfigEntity deptConfig) {
        try {
            saveEntity(getKey(deptId.toString()),deptConfig);
        } catch (JsonProcessingException e) {
            throw new BusinessException(String.format("save DeptConfig error %d",deptId),e);
        }
    }

    @Override
    public DeptConfigEntity getDefaultDeptConfig() {

        DeptConfigEntity deptConfig = null;
        try {

            deptConfig = parseEntity(getKey("default"));

        } catch (IOException e) {
            logger.error("parse DeptConfig default error",e);
        }

        if (ObjectUtils.isEmpty(deptConfig)){

            deptConfig = new DeptConfigEntity();
            deptConfig.setAreaType(AreaType.City);
            deptConfig.setDeptId(0L);
            deptConfig.setDeptName("默认");
            deptConfig.setSharePersonalCustomer(Boolean.FALSE);

            try {
                saveEntity(getKey("default"),deptConfig);
            } catch (JsonProcessingException e) {
                //ignore
                logger.error("save DeptConfig default error",e);
            }
        }
        return deptConfig;
    }

    @Override
    public void deleteDeptConfigByDeptId(Long deptId) {

    }

    private String getKey(String deptId){
        return String.format("boms:dept:config:%s",deptId);
    }
}
