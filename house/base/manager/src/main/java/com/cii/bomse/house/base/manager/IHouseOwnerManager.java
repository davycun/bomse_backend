package com.cii.bomse.house.base.manager;

import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;

public interface IHouseOwnerManager extends IManager<HouseOwnerEntity> {

    /**
     * @description
     * 更新业主号码
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-06 09:24
     * @since 1.0
     */
    public void updateHouseOwnerPhone(Long ownId,String oldPhone,String newPhone);

    /**
     * @description
     * 拨打业主电话
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-07 15:10
     * @since 1.0
     */
    public String callPhone(Long houseOwnerId);

    /**
     * @description
     * 通过园区ID查询
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-06 09:21
     * @since 1.0
     */
    public List<HouseOwnerEntity> findByParkId(Long parkId);

    /**
     * @description
     * 通过建筑ID查询业主
     * @author david·cun
     * @param
     * @return
     * @date 2020-01-06 09:22
     * @since 1.0
     */
    public List<HouseOwnerEntity> findByBuildingId(Long buildingId);

}
