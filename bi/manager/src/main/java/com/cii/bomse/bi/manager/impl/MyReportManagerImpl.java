package com.cii.bomse.bi.manager.impl;

import com.cii.bomse.bi.dao.IMyReportDao;
import com.cii.bomse.bi.manager.IMyReportManager;
import com.cii.bomse.bi.entity.MyReportEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class MyReportManagerImpl extends AbstractManager<MyReportEntity> implements IMyReportManager {

    @Autowired
    private IMyReportDao myReportDao;

    @Override
    protected IMyBatisBaseDao<MyReportEntity, Long> getMyBatisDao() {
        return myReportDao;
    }

    @Override
    public MyReportEntity myReport() {

        MyReportEntity report = new MyReportEntity();

        Map<String,Object> param = new HashMap<>();
        Calendar calendar = Calendar.getInstance();

        param.put("createTimeStart",DateUtils.truncate(calendar.getTime(),Calendar.MONTH));
        param.put("createId", CurrentContext.getUserId());
        int count = myReportDao.countByStatement("myReportCustomerCount",param);
        report.setCustomerCount(count);


        count = myReportDao.countByStatement("myReportParkCount",param);
        report.setParkCount(count);

        count = myReportDao.countByStatement("myReportFloorCount",param);
        report.setFloorCount(count);

        count = myReportDao.countByStatement("myReportOrderCount",param);
        report.setFloorCount(count);

        param.clear();
        param.put("orderTimeStart",DateUtils.truncate(calendar.getTime(),Calendar.MONTH));
        param.put("ownerId",CurrentContext.getUserId());
        List<MyReportEntity> list = myReportDao.selectByStatement("myReportDivideAmount",param);

        if (list.size()>0 && list.get(0)!=null){
            report.setDivideAmount(list.get(0).getDivideAmount());
        }

        return report;
    }

}
