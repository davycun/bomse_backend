package com.cii.bomse.house.base.dao;

import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;

import java.util.List;

public interface IHouseOwnerDao extends IMyBatisBaseDao<HouseOwnerEntity,Long> {

    /**
     * @description
     * 通过园区ID查询
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-06 09:21
     * @since 1.0
     */
    public List<HouseOwnerEntity> selectByParkId(Long parkId);

    /**
     * @description
     * 通过建筑ID查询业主
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-06 09:22
     * @since 1.0
     */
    public List<HouseOwnerEntity> selectByBuildingId(Long buildingId);
}
