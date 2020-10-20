package com.cii.bomse.bi.manager.impl;

import com.cii.bomse.bi.dao.ICustomerStatisticReportDao;
import com.cii.bomse.bi.dao.ICustomerStatisticReportRedisDao;
import com.cii.bomse.bi.dao.IReportRedisDao;
import com.cii.bomse.bi.entity.CustomerStatisticReportEntity;
import com.cii.bomse.bi.entity.ReportResult;
import com.cii.bomse.bi.manager.ICustomerStatisticReportManager;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerStatus;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class CustomerStatisticReportManagerImpl extends AbstractReportManager<CustomerStatisticReportEntity> implements ICustomerStatisticReportManager {

    @Autowired
    private ICustomerStatisticReportDao customerStatisticReportDao;
    @Autowired
    private ICustomerStatisticReportRedisDao customerStatisticReportRedisDao;

    @Override
    protected IMyBatisBaseDao<CustomerStatisticReportEntity, Long> getMyBatisDao() {
        return customerStatisticReportDao;
    }

    @Override
    public IReportRedisDao<CustomerStatisticReportEntity> getReportRedisDao() {
        return customerStatisticReportRedisDao;
    }

    private static final String reportDeptEmployee = "reportDeptEmployee";
    private static final String reportDeptEmployeeHide = "reportDeptEmployeeHide";
    private static final String reportChildrenDept = "reportChildrenDept";
    private static final String reportChildrenDeptHide = "reportChildrenDeptHide";

    public void reportDeptEmployee(ReportResult report) {


        List<CustomerStatisticReportEntity> list = null;

        Map<String, Object> param = new HashMap<>();

        //部门员工正在跟进中的客户
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("ownerDeptId", report.getId());
        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
        report.addResult("followupCustomerCount", list);

        //部门员工隐藏的客户数
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        list = customerStatisticReportDao.selectByStatement(reportDeptEmployeeHide,param);
        report.addResult("hideCustomerCount", list);


//        //部门员工优质的客户
//        param.clear();
//        param.put("cusStatuses", cusStatuses);
//        param.put("intentionType", CustomerIntentionType.You);
//        param.put("ownerDeptId", report.getId());
//        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
//        report.addResult("customerIntentionYouCount", list);
//
//        //部门员工良质的客户
//        param.put("intentionType", CustomerIntentionType.Liang);
//        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
//
//        report.addResult("customerIntentionLiangCount", list);
//
//        //部门员工中质的客户
//        param.put("intentionType", CustomerIntentionType.Zhong);
//        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
//        report.addResult("customerIntentionZhongCount", list);
//
//        //部门员工差质的客户
//        param.put("intentionType", CustomerIntentionType.Cha);
//        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
//        report.addResult("customerIntentionChaCount", list);
//
//        //部门员工未知质的客户
//        param.put("intentionType", CustomerIntentionType.Unknown);
//        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
//        report.addResult("customerIntentionUnknownCount", list);

        //三天未跟进的客户
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 3);
        param.clear();
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("ownerDeptId", report.getId());
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
        report.addResult("customerNotFollowup3DayCount", list);

        //部门员工7天未跟进的客户
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 4);
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        list = customerStatisticReportDao.selectByStatement(reportDeptEmployee,param);
        report.addResult("customerNotFollowup7DayCount", list);

    }

    public void reportChildrenDept(ReportResult report) {
        //childrenDept存储的是result里面所有的部门对应的子部门集合
        if (ObjectUtils.isEmpty(report.getDeptIdList())) {
            return;
        }
        List<CustomerStatisticReportEntity> list = null;
        //计算跟进中的客户
        Map<String, Object> param = new HashMap<>();
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("ownerDeptIds", report.getDeptIdList());
        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
        report.addDeptResult("followupCustomerCount", list);

        //计算隐藏的客户
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        list = customerStatisticReportDao.selectByStatement(reportChildrenDeptHide,param);
        report.addDeptResult("hideCustomerCount", list);

//        //计算跟进中优质的客户
//        param.clear();
//        param.put("cusStatuses", cusStatuses);
//        param.put("intentionType", CustomerIntentionType.You);
//        param.put("ownerDeptIds", report.getDeptIdList());
//        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
//        report.addDeptResult("customerIntentionYouCount", list);
//
//
//        //计算跟进良优质的客户
//        param.put("intentionType", CustomerIntentionType.Liang);
//        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
//        report.addDeptResult("customerIntentionLiangCount", list);
//
//        //计算跟进中优质的客户
//        param.put("intentionType", CustomerIntentionType.Zhong);
//        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
//        report.addDeptResult("customerIntentionZhongCount", list);
//
//        //计算跟进差优质的客户
//        param.put("intentionType", CustomerIntentionType.Cha);
//        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
//        report.addDeptResult("customerIntentionChaCount", list);
//
//        //计算跟进中未知质的客户
//        param.put("intentionType", CustomerIntentionType.Unknown);
//        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
//        report.addDeptResult("customerIntentionUnknownCount", list);

        //计算3天未跟进的客户
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 3);
        param.clear();
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        param.put("ownerDeptIds", report.getDeptIdList());
        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
        report.addDeptResult("customerNotFollowup3DayCount", list);

        //计算7天未跟进的客户
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 4);
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        list = customerStatisticReportDao.selectByStatement(reportChildrenDept,param);
        report.addDeptResult("customerNotFollowup7DayCount", list);


    }

    public void reportEmployee(ReportResult<CustomerStatisticReportEntity> report) {

        CustomerStatisticReportEntity ar = report.getResult().get(report.getId().toString());

        if (ObjectUtils.isEmpty(ar)) {
            return;
        }

        //计算跟进中的客户数
        Map<String, Object> param = new HashMap<>();
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("ownerId", report.getId());
        float count = customerStatisticReportDao.countByMap(param);
        ar.setFollowupCustomerCount(count);

        //计算隐藏
        param.clear();
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        count = customerStatisticReportDao.countByMap(param);

        ar.setHideCustomerCount(count);

//        //计算跟进中优质的客户
//        param.clear();
//        param.put("cusStatuses", cusStatuses);
//        param.put("intentionType", CustomerIntentionType.You);
//        param.put("ownerId", report.getId());
//        count = customerStatisticReportDao.countByMap(param);
//        ar.setCustomerIntentionYouCount(count);
//
//        //计算跟进中良质的客户
//        param.put("intentionType", CustomerIntentionType.Liang);
//        count = customerStatisticReportDao.countByMap(param);
//        ar.setCustomerIntentionLiangCount(count);
//
//        //计算跟进中中质的客户
//        param.put("intentionType", CustomerIntentionType.Zhong);
//        count = customerStatisticReportDao.countByMap(param);
//        ar.setCustomerIntentionZhongCount(count);
//
//        //计算跟进中差质的客户
//        param.put("intentionType", CustomerIntentionType.Cha);
//        count = customerStatisticReportDao.countByMap(param);
//        ar.setCustomerIntentionChaCount(count);
//
//        //计算跟进中未知的客户
//        param.put("intentionType", CustomerIntentionType.Unknown);
//        count = customerStatisticReportDao.countByMap(param);
//        ar.setCustomerIntentionUnknownCount(count);


        //计算3天未跟进的客户
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 3);
        param.clear();
        param.put("cusStatus", CustomerStatus.Followup);
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        param.put("ownerId", report.getId());
        count = customerStatisticReportDao.countByMap(param);
        ar.setCustomerNotFollowup3DayCount(count);

        //计算7天未跟进的客户
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 4);
        param.put("lastFollowupTimeEnd", DateUtils.truncate(calendar.getTime(),Calendar.DAY_OF_MONTH));
        count = customerStatisticReportDao.countByMap(param);
        ar.setCustomerNotFollowup7DayCount(count);

    }


}
