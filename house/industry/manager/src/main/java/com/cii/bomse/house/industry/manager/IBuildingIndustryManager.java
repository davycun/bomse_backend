package com.cii.bomse.house.industry.manager;

import com.cii.bomse.house.industry.entity.BuildingIndustryEntity;
import com.ciiframework.common.business.IManager;

public interface IBuildingIndustryManager extends IManager<BuildingIndustryEntity> {

    /**
     * @description
     * 更新建筑总楼层数
     * @author david·cun
     * @param
     * @return
     * @date 2020-05-14 15:24
     * @since 1.0
     */
    void updateBuildingFloorCount(Long buildingId);

}
