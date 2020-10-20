package com.cii.bomse.bi.manager;

import com.cii.bomse.bi.entity.RankingReportEntity;
import com.ciiframework.common.business.IManager;

import java.util.List;
import java.util.Map;

public interface IRankingReportManager extends IManager<RankingReportEntity> {

    /**
     * @description
     * 近十二个月的业绩走势
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-26 11:05
     * @since 1.0
     */
    List<RankingReportEntity> monthAchievement();

    /**
     * @description
     * 本月业绩排行榜
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-26 17:05
     * @since 1.0
     */
    List<RankingReportEntity> rankingEmployeeAchievement();

    /**
     * @description
     * 月度个人客户开发量统计
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 10:19
     * @since 1.0
     */
    List<RankingReportEntity> monthCustomerPersonal();

    /**
     * @description
     * 月度集中获客量
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 10:52
     * @since 1.0
     */
    List<RankingReportEntity> monthCustomerCompany();

    /**
     * @description
     * 月度勘查客户量
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 15:22
     * @since 1.0
     */
    public List<RankingReportEntity> monthCustomerHide();

    /**
     * @description
     * 个人获客量统计
     * @author david·cun
     * @param
     * @return
     * @date 2019-09-27 10:53
     * @since 1.0
     */
    List<RankingReportEntity> rankingCustomerPersonal();
}
