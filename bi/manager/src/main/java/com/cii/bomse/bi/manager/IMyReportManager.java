package com.cii.bomse.bi.manager;

import com.cii.bomse.bi.entity.MyReportEntity;
import com.ciiframework.common.business.IManager;

public interface IMyReportManager extends IManager<MyReportEntity> {


    MyReportEntity myReport();

}
