package com.cii.bomse.house.industry.manager.impl;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.cii.bomse.house.industry.dao.IHouseIndustryDao;
import com.cii.bomse.house.industry.entity.HouseIndustryEntity;
import com.cii.bomse.house.industry.manager.IHouseIndustryManager;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.manager.IDeptAreaManager;
import com.cii.bomse.hrm.dept.manager.IDeptConfigManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class HouseIndustryManagerImpl extends AbstractManager<HouseIndustryEntity> implements IHouseIndustryManager {

    @Autowired
    private IHouseIndustryDao houseIndustryDao;
    @Autowired
    private IDeptAreaManager deptAreaManager;
    @Autowired
    private IDeptConfigManager deptConfigManager;

    @Override
    protected IMyBatisBaseDao<HouseIndustryEntity, Long> getMyBatisDao() {
        return houseIndustryDao;
    }

    @Override
    protected void filterParam(Map<String, Object> param) {

        //如果没有传入区域条件，那么只能查询部门关联的城市房源
        if ((param.containsKey("cityId")
                || param.containsKey("regionId")
                || param.containsKey("streetId")
                || param.containsKey("communityId"))
                && ObjectUtils.isNotEmpty(CurrentContext.getOwnerDeptId())) {

            DeptConfigEntity config = deptConfigManager.findByDeptId(CurrentContext.getOwnerDeptId());
            List<Long> areaIds = deptAreaManager.findAreaIds(CurrentContext.getOwnerDeptId(),config.getAreaType());

            switch (config.getAreaType()){
                case AreaType.Community:
                    param.put("communityIds",areaIds);
                    break;
                case AreaType.Street:
                    param.put("streetIds",areaIds);
                    break;
                case AreaType.Region:
                    param.put("regionIds",areaIds);
                    break;
                case AreaType.City:
                    param.put("cityIds",areaIds);
            }
        }

    }
}
