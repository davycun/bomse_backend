package com.cii.bomse.house.land.manager;

import com.cii.bomse.house.land.entity.BlankLandEntity;
import com.ciiframework.common.business.IManager;

public interface IBlankLandManager extends IManager<BlankLandEntity> {

    /**
     * @description
     * 拨打场地联系人电话
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-24 16:23
     * @since 1.0
     */
    String callPhone(Long blId);

    /**
     * @description
     * update the BlankLand Phone
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-24 18:21
     * @since 1.0
     */
    void updatePhone(Long blId,String oldPhone,String newPhone);

}
