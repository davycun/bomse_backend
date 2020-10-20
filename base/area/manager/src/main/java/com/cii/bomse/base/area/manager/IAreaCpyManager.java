package com.cii.bomse.base.area.manager;

import com.cii.bomse.base.area.entity.AreaCpyEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;
import java.util.Map;

public interface IAreaCpyManager extends IManager<AreaCpyEntity> {

    List<AreaCpyEntity> findByMapToTree(Map<String,Object> param);

    List<AreaCpyEntity> findByMapToSort(Map<String,Object> param);

    void enableArea(Long parentId);

    void disableArea(Long parentId);

}
