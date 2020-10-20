package com.cii.bomse.hrm.dept.manager.impl;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.cii.bomse.hrm.dept.dao.IDeptAreaDao;
import com.cii.bomse.hrm.dept.entity.DeptAreaEntity;
import com.cii.bomse.hrm.dept.manager.IDeptAreaManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.logging.Logger;
import com.ciiframework.logging.LoggerFactory;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class DeptAreaManagerImpl extends AbstractManager<DeptAreaEntity> implements IDeptAreaManager {

    private static final Logger logger = LoggerFactory.getLogger(DeptAreaManagerImpl.class);
    @Autowired
    private IDeptAreaDao deptAreaDao;


    private Map<Long, List<DeptAreaEntity>> deptAreaCache;

    public DeptAreaManagerImpl() {
        deptAreaCache = new HashMap<>();
    }

    @Override
    protected IMyBatisBaseDao<DeptAreaEntity, Long> getMyBatisDao() {
        return deptAreaDao;
    }

    @Override
    protected void afterBatchUpdate(List<DeptAreaEntity> list) {
        //清除缓存
        removeCache(list);
    }

    @Override
    protected void afterBatchCreate(List<DeptAreaEntity> list) {
        //清除缓存
        removeCache(list);
    }

    @Override
    public List<DeptAreaEntity> findByDeptId(Long deptId) {

        if (ObjectUtils.isEmpty(deptId)) {
            logger.error("查询部门区域传入的deptId为空....");
            return new ArrayList<>();
        }

        List<DeptAreaEntity> list = deptAreaCache.get(deptId);
        if (ObjectUtils.isEmpty(list)) {
            Map<String, Object> param = new HashMap<>();
            param.put("deptId", deptId);
            list = findByMap(param);
            deptAreaCache.put(deptId, list);
        }

        return list;
    }

    @Override
    public List<Long> findDeptCityId(Long deptId) {
        return findAreaIds(deptId, AreaType.City);
    }

    @Override
    public List<Long> findDeptRegionId(Long deptId) {
        return findAreaIds(deptId,AreaType.Region);
    }

    @Override
    public List<Long> findDeptStreetId(Long deptId) {
        return findAreaIds(deptId,AreaType.Street);
    }

    @Override
    public List<Long> findDeptCommunityId(Long deptId) {
        return findAreaIds(deptId,AreaType.Community);
    }

    public List<Long> findAreaIds(Long deptId, String areaType) {
        List<Long> idList = new ArrayList<>();

        List<DeptAreaEntity> list = findByDeptId(deptId);
        if (ObjectUtils.isEmpty(list)) {
            return idList;
        }

        Set<Long> idSet = new HashSet<>();
        for (DeptAreaEntity area : list) {
            switch (areaType) {
                case AreaType.City:
                    if (ObjectUtils.isNotEmpty(area.getCityId())) {
                        idSet.add(area.getCityId());
                    }
                case AreaType.Region:
                    if (ObjectUtils.isNotEmpty(area.getRegionId())) {
                        idSet.add(area.getRegionId());
                    }
                case AreaType.Street:
                    if (ObjectUtils.isNotEmpty(area.getStreetId())) {
                        idSet.add(area.getStreetId());
                    }
                case AreaType.Community:
                    if (ObjectUtils.isNotEmpty(area.getCommunityId())) {
                        idSet.add(area.getCommunityId());
                    }
                default:
                    ;
            }
        }

        for (Long id : idSet) {
            idList.add(id);
        }

        return idList;
    }

    private void removeCache(List<DeptAreaEntity> list) {
        for (DeptAreaEntity area : list) {
            deptAreaCache.remove(area.getDeptId());
        }
    }
}
