package com.cii.bomse.base.area.manager.impl;

import com.cii.bomse.base.area.dao.IAreaCpyDbDao;
import com.cii.bomse.base.area.dao.IAreaDao;
import com.cii.bomse.base.area.entity.AreaCpyEntity;
import com.cii.bomse.base.area.entity.AreaEntity;
import com.cii.bomse.base.area.manager.IAreaCpyManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-05-29 19:03
 * @since 1.0
 */
@Service
public class AreaCpyManagerImpl extends AbstractAreaManager<AreaCpyEntity> implements IAreaCpyManager {

    @Autowired
    private IAreaCpyDbDao areaCpyDbDao;
    @Autowired
    private IAreaDao areaDao;

    @Override
    protected IMyBatisBaseDao<AreaCpyEntity, Long> getMyBatisDao() {
        return areaCpyDbDao;
    }


    public List<AreaCpyEntity> findByMapToTree(Map<String, Object> param) {

        addCpyId(param);
        List<AreaCpyEntity> areas = areaCpyDbDao.selectByMap(param);

        return treeAndSort(areas);
    }

    public List<AreaCpyEntity> findByMapToSort(Map<String, Object> param) {

        addCpyId(param);
        List<AreaCpyEntity> areas = areaCpyDbDao.selectByMap(param);

        sort(areas);

        return areas;
    }

    @Override
    public void enableArea(Long parentId) {

        Map<String, Object> param = new HashMap<>();
        param.put("parentId", parentId);
        int count = areaCpyDbDao.countByMap(param);

        if (count > 0){
            //如果已经存在先禁用，之后再启用
            disableArea(parentId);
        }

        AreaEntity area = areaDao.selectById(parentId);
        AreaCpyEntity ac = convertToCpyArea(area);

        create(ac);
        enableByParent(area);
    }


    private void enableByParent(AreaEntity area) {
        Map<String, Object> param = new HashMap<>();
        param.put("isDeleted", Boolean.FALSE);
        param.put("parentId", area.getId());
        List<AreaEntity> list = areaDao.selectByMap(param);
        //创建新的
        if (list.size() > 0) {
            for (AreaEntity a : list) {
                enableByParent(a);
            }
            createAreaCpy(list);
        }
    }

    private void createAreaCpy(List<AreaEntity> list) {

        List<AreaCpyEntity> cpyList = new ArrayList<>();

        for (AreaEntity area : list) {
            cpyList.add(convertToCpyArea(area));
        }

        if (cpyList.size() > 0) {
            areaCpyDbDao.batchInsert(cpyList);
        }
    }

    private AreaCpyEntity convertToCpyArea(AreaEntity area) {
        AreaCpyEntity areaCpy = new AreaCpyEntity();

        areaCpy.setId(area.getId());
        areaCpy.setParentId(area.getParentId());
        areaCpy.setCpyId(CurrentContext.getCpyId());

        return areaCpy;

    }


    @Override
    public void disableArea(Long parentId) {

        Map<String,Object> param = new HashMap<>();
        param.put("parentId",parentId);
        List<AreaEntity> list = areaDao.selectByMapSimple(param,"id","parent_id");

//        deleteById(parentId);

        param.put("id",parentId);
        param.put("cpyId",CurrentContext.getCpyId());
        deleteByMap(param);

        //创建新的
        if (list.size() > 0) {
            for (AreaEntity a : list) {
                deleteByParentId(a.getId());
                disableArea(a.getId());
            }
        }
    }

    private void deleteByParentId(Long parentId) {

        Map<String,Object> param = new HashMap<>();
        param.put("parentId",parentId);
        param.put("cpyId",CurrentContext.getCpyId());

        deleteByMap(param);
    }
}
