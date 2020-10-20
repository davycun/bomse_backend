package com.cii.bomse.crm.tenant.manager;

import com.cii.bomse.crm.tenant.dto.TenantStatisticDto;
import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.ciiframework.common.business.IManager;

public interface ITenantManager extends IManager<TenantEntity> {

    /**
     * @description
     * 拨打租户电话
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-26 16:51
     * @since 1.0
     */
    String callPhone(Long tntId);

    /**
     * @description
     * 修改租户号码
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-26 17:30
     * @since 1.0
     */
    void updatePhone(Long tntId,String oldPhone,String newPhone);

    /**
     * @description
     * 统计租户待办
     * @author david·cun
     * @param
     * @return
     * @date 2020-04-02 13:48
     * @since 1.0
     */
    TenantStatisticDto statistic();
}
