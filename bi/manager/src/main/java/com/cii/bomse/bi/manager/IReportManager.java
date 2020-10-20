package com.cii.bomse.bi.manager;

import com.cii.bomse.bi.entity.BaseReportEntity;
import com.ciiframework.common.business.IManager;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 22:50
 * @since 1.0
 */
public interface IReportManager<T extends BaseReportEntity> extends IManager<T> {

    List<T> report(Long id, boolean reload);

    List<T> report(Long id, boolean reload, Date startTime, Date endTime);
}
