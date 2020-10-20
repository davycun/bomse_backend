package com.cii.bomse.house.industry.manager;

import com.cii.bomse.house.industry.entity.ParkIndustryEntity;
import com.ciiframework.common.business.IManager;

public interface IParkIndustryManager extends IManager<ParkIndustryEntity> {

    /**/
    void updateParkStatistic(Long parkId);

}
