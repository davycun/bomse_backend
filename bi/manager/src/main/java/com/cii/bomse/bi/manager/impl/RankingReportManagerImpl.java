package com.cii.bomse.bi.manager.impl;

import com.cii.bomse.bi.dao.IRankingRedisDao;
import com.cii.bomse.bi.dao.IRankingReportDao;
import com.cii.bomse.bi.entity.RankingReportEntity;
import com.cii.bomse.bi.manager.IRankingReportManager;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class RankingReportManagerImpl extends AbstractManager<RankingReportEntity> implements IRankingReportManager {

    @Autowired
    private IRankingReportDao rankingReportDao;
    @Autowired
    private IRankingRedisDao rankingRedisDao;
    @Autowired
    private IDeptManager deptManager;

    @Override
    protected IMyBatisBaseDao<RankingReportEntity, Long> getMyBatisDao() {
        return rankingReportDao;
    }

    @Override
    public List<RankingReportEntity> monthAchievement() {

        Date endTime = DateUtils.truncate(new Date(), Calendar.MONTH);
        endTime = DateUtils.addMonths(endTime, 1);
        Date startTime = DateUtils.addMonths(endTime, -12);
        //查询近12个月的数据
        Map<String, Object> param = new HashMap<>();
        param.put("orderTimeStart", startTime);
        param.put("orderTimeEnd", endTime);
        param.put("orderCpyId",CurrentContext.getCpyId());


        //添加查询者的权限范围
        List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());
        if (ObjectUtils.isNotEmpty(deptIds)) {
            param.put("authOrderOwnerDeptIds", deptIds);
            param.put("authOrderOwnerId",CurrentContext.getUserId());
        } else {
            param.put("orderOwnerId", CurrentContext.getUserId());
        }


        List<RankingReportEntity> list = rankingReportDao.selectByStatement("selectMonthAchievement", param);

        return createResult(startTime, list, null);
    }

    public List<RankingReportEntity> rankingEmployeeAchievement() {
        Date startTime = DateUtils.truncate(new Date(), Calendar.MONTH);
        Date endTime = DateUtils.addMonths(startTime, 1);
        Map<String, Object> param = new HashMap<>();
        param.put("orderTimeStart", startTime);
        param.put("orderTimeEnd", endTime);
        param.put("orderCpyId",CurrentContext.getCpyId());
        List<RankingReportEntity> list = rankingReportDao.selectByStatement("selectEmployeeAchievement", param);
        return list;
    }

    @Override
    public List<RankingReportEntity> monthCustomerPersonal() {
        return montCustomer(CustomerOwnerType.Personal);
    }
    @Override
    public List<RankingReportEntity> monthCustomerCompany() {
        return montCustomer(CustomerOwnerType.Company);
    }
    @Override
    public List<RankingReportEntity> monthCustomerHide() {
        return montCustomer(CustomerOwnerType.Hide);
    }

    private List<RankingReportEntity> montCustomer(String cusOwnerType) {
        Date endTime = DateUtils.truncate(new Date(), Calendar.MONTH);
        endTime = DateUtils.addMonths(endTime, 1);
        Date startTime = DateUtils.addMonths(endTime, -12);

        //查询近12个月的数据
        Map<String, Object> param = new HashMap<>();
        param.put("createTimeStart", startTime);
        param.put("createTimeEnd", endTime);
        param.put("cpyId",CurrentContext.getCpyId());

        //添加查询者的权限范围
        List<Long> deptIds = deptManager.findUserAuthDeptId(CurrentContext.getUserId());
        String cusOwnerTypeName = "";
        if (ObjectUtils.isNotEmpty(cusOwnerType)){
            cusOwnerTypeName = DictionaryStorage.get(CustomerOwnerType.class.getName(), cusOwnerType).getName();;
        }

        switch (cusOwnerType) {
            case CustomerOwnerType.Personal:
                if (ObjectUtils.isNotEmpty(deptIds)) {
                    param.put("authCreateDeptIds", deptIds);
                    param.put("authCreateId", CurrentContext.getUserId());
                } else {
                    param.put("createId", CurrentContext.getUserId());
                }
                param.put("cusOwnerType", cusOwnerType);

                break;
            default:
                //这里处理部门获客或者部门获客之后被拉私的拉私客户
                if (ObjectUtils.isNotEmpty(deptIds)) {
                    param.put("authOwnerDeptIds", deptIds);
                    param.put("authOwnerId",CurrentContext.getUserId());
                } else {
                    param.put("ownerId", CurrentContext.getUserId());
                }
                param.put("cusOwnerType", cusOwnerType);
                break;
        }


        List<RankingReportEntity> list = rankingReportDao.selectByStatement("selectMonthCustomer", param);

        return createResult(startTime, list, cusOwnerTypeName);
    }

    public List<RankingReportEntity> rankingCustomerPersonal() {
        Map<String, Object> param = new HashMap<>();
        Date startTime = DateUtils.truncate(new Date(), Calendar.MONTH);
        Date endTime = DateUtils.addMonths(startTime, 1);
        param.put("createTimeStart",startTime);
        param.put("createTimeEnd",endTime);
        //个人客户
        param.put("cusOwnerType",CustomerOwnerType.Personal);
        param.put("cpyId",CurrentContext.getCpyId());

        List<RankingReportEntity> list = rankingReportDao.selectByStatement("selectCustomerPersonal", param);



        return list;
    }

    private List<RankingReportEntity> createResult(Date startTime, List<RankingReportEntity> list, String cusOwnerTypeName) {

        List<RankingReportEntity> result = new ArrayList<>();

        Map<String, RankingReportEntity> tmp = new HashMap<>();
        for (RankingReportEntity rr : list) {
            tmp.put(rr.getName(), rr);
        }

        Date timeKey = startTime;

        for (int i = 0; i < 12; i++) {
            String month = DateFormatUtils.format(timeKey, "yyyy-MM");

            RankingReportEntity rr = tmp.get(month);
            if (ObjectUtils.isEmpty(rr)) {
                rr = new RankingReportEntity();
                rr.setName(month);
            }

            if (ObjectUtils.isNotEmpty(cusOwnerTypeName)) {
                rr.setType(cusOwnerTypeName);
            }

            result.add(rr);
            timeKey = DateUtils.addMonths(timeKey, 1);
        }
        return result;
    }

}
