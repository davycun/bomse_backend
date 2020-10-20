package com.cii.bomse.bi.manager.impl;

import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.bi.dao.IReportRedisDao;
import com.cii.bomse.bi.entity.BaseReportEntity;
import com.cii.bomse.bi.entity.ReportResult;

import java.util.Date;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 16:01
 * @since 1.0
 */
public abstract class AbstractReportManager<T extends BaseReportEntity> extends ReportResultBuilder<T> {


    //获取redis缓存信息
    public abstract IReportRedisDao<T> getReportRedisDao();

    public List<T> report(Long id, boolean reload) {

        return this.report(id,reload,null,null);
    }

    public List<T> report(Long id, boolean reload, Date startTime, Date endTime) {


        //创建报表，主要是处理ID
        ReportResult<T> report = null;

        if (ObjectUtils.isNotEmpty(startTime)){
            report = build(id,reload,startTime,endTime);
            if (!reload) {
                List<T> list = getReportRedisDao().getReport(report.getId(),
                        report.getStartTimeString(), report.getEndTimeString());
                if (ObjectUtils.isNotEmpty(list)) {
                    return list;
                }
            }
        }else{
            report = build(id,reload);
            if (!reload) {
                List<T> list = getReportRedisDao().getReport(report.getId());
                if (ObjectUtils.isNotEmpty(list)) {
                    return list;
                }
            }
        }

        if (report.getIsDept()) {
            //计算当前部门下面的员工的报表
            reportDeptEmployee(report);
            //计算当前部门下面子部门报表
            reportChildrenDept(report);
        } else {
            //计算个人
            reportEmployee(report);
        }



        //从Map转换成List
        List<T> list = report.getResultList();

        //计算完成之后需要特殊处理的
        afterReport(report,list);

        //进行缓存
        if (ObjectUtils.isNotEmpty(startTime)){
            getReportRedisDao().saveReport(report.getId(), list,
                    report.getStartTimeString(), report.getEndTimeString());
        }else{
            getReportRedisDao().saveReport(report.getId(), list);
        }

        return list;
    }

    public void reportDeptEmployee(ReportResult<T> report) {
    }

    public void reportChildrenDept(ReportResult<T> report) {
    }

    public void reportEmployee(ReportResult<T> report) {
    }

    protected void afterReport(ReportResult<T> report,List<T> list){}
}
