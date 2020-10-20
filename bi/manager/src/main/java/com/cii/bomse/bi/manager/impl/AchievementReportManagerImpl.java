package com.cii.bomse.bi.manager.impl;

import com.cii.bomse.crm.customer.base.dictionary.CustomerFollowupType;
import com.cii.bomse.crm.customer.base.dictionary.CustomerOwnerType;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.bi.dao.IAchievementReportDao;
import com.cii.bomse.bi.dao.IAchievementReportRedisDao;
import com.cii.bomse.bi.dao.IReportRedisDao;
import com.cii.bomse.bi.entity.AchievementReportEntity;
import com.cii.bomse.bi.entity.ReportResult;
import com.cii.bomse.bi.manager.IAchievementReportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class AchievementReportManagerImpl extends AbstractReportManager<AchievementReportEntity> implements IAchievementReportManager {

    @Autowired
    private IAchievementReportDao achievementReportDao;
    @Autowired
    private IAchievementReportRedisDao achievementReportRedisDao;
    @Autowired
    private IUserManager userManager;

    @Override
    protected IMyBatisBaseDao<AchievementReportEntity, Long> getMyBatisDao() {
        return achievementReportDao;
    }

    @Override
    public IReportRedisDao<AchievementReportEntity> getReportRedisDao() {
        return achievementReportRedisDao;
    }


    /**
     * 处理当前部门挂着的员工的报表
     */
    public void reportDeptEmployee(ReportResult<AchievementReportEntity> report) {

        Map<String, Object> param = new HashMap<>();
        List<AchievementReportEntity> list = null;

        //计算个人获客量获客量
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("cusOwnerType", CustomerOwnerType.Personal);
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectCustomerCount", param);
        report.addResult("customerPersonalCount", list);

        //获客拉私量
        //TODO 此处如果是非本部门拉私，可能会出现统计错误
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "owner_id");
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        list = achievementReportDao.selectByStatement("selectCustomerCount", param);
        report.addResult("customerHideCount", list);

        //部门公盘客户量
        //此处不需要处理

        //计算电话跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Phone);
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectCustomerFollowupCount", param);
        report.addResult("customerFollowupCount", list);

        //计算带看量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Scene);
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectCustomerFollowupCount", param);
        report.addResult("customerSeeHouseCount", list);

        //计算兼职开发量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectPartTimerCount", param);
        report.addResult("partTimerCount", list);


        //计算下架的房源面积
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseEditDownAcreageCount", param);
        report.addResult("houseDownAcreageCount", list);

        /*这里只能记录当前查询时间指定的时间段内的最后可租面积*/
        //新增剩余可租面积1
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseEditUpAcreageCount", param);
        report.addResult("houseUpAcreageCount", list);

        //新增剩余可租面积2
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseFloorUpAcreageCount", param);
        report.addResult("houseUpAcreageCount", list);

        //房源跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseFollowupCount", param);
        report.addResult("houseFollowupCount", list);

        //计算总签约量
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderCount", param);
        report.addResult("orderCount", list);

        //计算新客户签约量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderCount", param);
        report.addResult("newCustomerOrderCount", list);


        //计算合同佣金、营业收入、回款
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderAmountCount", param);

//        if (ObjectUtils.isNotEmpty(list)) {
//            for (AchievementReportEntity ar : list) {
//                AchievementReportEntity tmp = report.getResult().get(ar.getId().toString());
//                if (ObjectUtils.isNotEmpty(tmp)) {
//                    tmp.setContractAmountCount(ar.getContractAmountCount());
//                    tmp.setAchievementAmountCount(ar.getAchievementAmountCount());
////                    tmp.setDivideAmountCount(ar.getDivideAmountCount());
//                    tmp.setOrderBackAmountCount(ar.getOrderBackAmountCount());
//                }
//            }
//        }
        ObjectUtils.forEach(list,report,(ar,item)->{
            AchievementReportEntity tmp = item.getResult().get(ar.getId().toString());
            ObjectUtils.isNotEmpty(tmp,ar,tmp,(s,t)->{
                t.setContractAmountCount(s.getContractAmountCount());
                t.setAchievementAmountCount(s.getAchievementAmountCount());
                t.setOrderBackAmountCount(s.getOrderBackAmountCount());
            });
        });

        //计算分成金额
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderDivideCount", param);

        ObjectUtils.forEach(list,report,(ar,item)->{
            AchievementReportEntity tmp = item.getResult().get(ar.getId().toString());
            ObjectUtils.isNotEmpty(tmp,ar,tmp,(s,t)->{
                t.setDivideAmountCount(s.getDivideAmountCount());
            });
        });

    }

    /**
     * 处理当前部门下面的子部门的报表
     */
    public void reportChildrenDept(ReportResult<AchievementReportEntity> report) {

        if (ObjectUtils.isEmpty(report.getDeptIdList())) {
            return;
        }

        List<AchievementReportEntity> list = null;
        Map<String, Object> param = new HashMap<>();

        //子部门个人获客量
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("cusOwnerType", CustomerOwnerType.Personal);
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectCustomerCount", param);
        report.addDeptResult("customerPersonalCount", list);

        //拉私客户
        //TODO 此处如果是非本部门拉私，可能会出现统计错误
        param.clear();
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("ownerDeptIds", report.getDeptIdList());
        param.put("groupBy", "owner_dept_id");
        list = achievementReportDao.selectByStatement("selectCustomerCount", param);
        report.addDeptResult("customerHideCount", list);

        //部门公盘客户
        param.clear();
        param.put("cusOwnerType", CustomerOwnerType.Company);
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("ownerDeptIds", report.getDeptIdList());
        param.put("groupBy", "owner_dept_id");
        list = achievementReportDao.selectByStatement("selectCustomerCount", param);
        report.addDeptResult("customerCompanyCount", list);

        //计算跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Phone);
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectCustomerFollowupCount", param);
        report.addDeptResult("customerFollowupCount", list);

        //计算带看量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Scene);
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectCustomerFollowupCount", param);
        report.addDeptResult("customerSeeHouseCount", list);

        //计算兼职开发
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectPartTimerCount", param);
        report.addDeptResult("partTimerCount", list);

        //计算下架的房源面积
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectHouseEditDownAcreageCount", param);
        report.addDeptResult("houseDownAcreageCount", list);

        /*这里只能记录当前查询时间指定的时间段内的最后可租面积*/
        //新增剩余可租面积1
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectHouseEditUpAcreageCount", param);
        report.addDeptResult("houseUpAcreageCount", list);

        //新增剩余可租面积2
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectHouseFloorUpAcreageCount", param);
        report.addDeptResult("houseUpAcreageCount", list);

        //房源跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createDeptIds", report.getDeptIdList());
        param.put("groupBy", "create_dept_id");
        list = achievementReportDao.selectByStatement("selectHouseFollowupCount", param);
        report.addDeptResult("houseFollowupCount", list);


        //计算签约量
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerDeptIds", report.getDeptIdList());
        param.put("groupBy", "o.owner_dept_id");
        list = achievementReportDao.selectByStatement("selectOrderCount", param);
        report.addDeptResult("orderCount", list);

        //计算新客户签约量
        param.clear();
        param.put("createTimeEnd", report.getEndTime());
        param.put("createTimeStart", report.getStartTime());
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerDeptIds", report.getDeptIdList());
        param.put("groupBy", "o.owner_dept_id");
        list = achievementReportDao.selectByStatement("selectOrderCount", param);
        report.addDeptResult("newCustomerOrderCount", list);

        //计算合同佣金、营业收入、回款
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerDeptIds", report.getDeptIdList());
        param.put("groupBy", "o.owner_dept_id");
        list = achievementReportDao.selectByStatement("selectOrderAmountCount", param);

        if (ObjectUtils.isNotEmpty(list)) {
            for (AchievementReportEntity ar : list) {
                for (Map.Entry<Long, String> ds : report.getDeptIdString().entrySet()) {
                    if (ds.getValue().contains(ar.getId().toString())) {
                        AchievementReportEntity are = report.getResult().get(ds.getKey().toString());
                        if (ObjectUtils.isNotEmpty(are)) {
                            are.setContractAmountCount(are.getContractAmountCount() + ar.getContractAmountCount());
                            are.setAchievementAmountCount(are.getAchievementAmountCount() + ar.getAchievementAmountCount());
//                            are.setDivideAmountCount(are.getDivideAmountCount() + ar.getDivideAmountCount());
                            are.setOrderBackAmountCount(are.getOrderBackAmountCount() + ar.getOrderBackAmountCount());
                        }
                    }
                }
            }
        }
        //计算分成金额
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerDeptIds", report.getDeptIdList());
        param.put("groupBy", "o.owner_dept_id");
        list = achievementReportDao.selectByStatement("selectOrderDivideCount", param);

        if (ObjectUtils.isNotEmpty(list)) {
            for (AchievementReportEntity ar : list) {
                for (Map.Entry<Long, String> ds : report.getDeptIdString().entrySet()) {
                    if (ds.getValue().contains(ar.getId().toString())) {
                        AchievementReportEntity are = report.getResult().get(ds.getKey().toString());
                        if (ObjectUtils.isNotEmpty(are)) {
                            are.setDivideAmountCount(are.getDivideAmountCount() + ar.getDivideAmountCount());
                        }
                    }
                }
            }
        }

    }

    /**
     * 单个员工报表
     */
    @Override
    public void reportEmployee(ReportResult<AchievementReportEntity> report) {

        AchievementReportEntity ar = report.getResult().get(report.getId().toString());

        if (ObjectUtils.isEmpty(ar)) {
            return;
        }

        Map<String, Object> param = new HashMap<>();
        float count = 0f;

        //计算个人获客量
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("cusOwnerType", CustomerOwnerType.Personal);
        param.put("create_id", report.getId());
        count = achievementReportDao.countByStatement("countCustomer", param);
        ar.setCustomerPersonalCount(count);

        //公盘客户拉私量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("cusOwnerType", CustomerOwnerType.Hide);
        param.put("ownerId", report.getId());
        count = achievementReportDao.countByStatement("countCustomer", param);
        ar.setCustomerPersonalCount(count);

        //公盘客户
        // 此处不需要处理

        //计算跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Phone);
        param.put("createId", report.getId());
        count = achievementReportDao.countByStatement("countCustomerFollowup", param);
        ar.setCustomerFollowupCount(count);

        //计算带看量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("followupType", CustomerFollowupType.Scene);
        param.put("createId", report.getId());
        count = achievementReportDao.countByStatement("countCustomerFollowup", param);
        ar.setCustomerSeeHouseCount(count);

        //计算兼职开发量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createId", report.getId());
        count = achievementReportDao.countByStatement("countPartTimer", param);
        ar.setPartTimerCount(count);

        //计算下架的房源面积
        List<AchievementReportEntity> list = null;
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createId", report.getId());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseEditDownAcreageCount", param);
        if (ObjectUtils.isNotEmpty(list)) {
            ar.setHouseDownAcreageCount(list.get(0).getCount());
        }

        /*这里只能记录当前查询时间指定的时间段内的最后可租面积*/
        //新增剩余可租面积1
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createId", report.getId());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseEditUpAcreageCount", param);
        if (ObjectUtils.isNotEmpty(list)) {
            ar.setHouseUpAcreageCount(list.get(0).getCount());
        }

        //新增剩余可租面积2
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createId", report.getId());
        param.put("groupBy", "create_id");
        list = achievementReportDao.selectByStatement("selectHouseFloorUpAcreageCount", param);
        if (ObjectUtils.isNotEmpty(list)) {
            ar.setHouseUpAcreageCount(ar.getHouseUpAcreageCount() + list.get(0).getCount());
        }

        //房源跟进量
        param.clear();
        param.put("createTimeStart", report.getStartTime());
        param.put("createTimeEnd", report.getEndTime());
        param.put("createId", report.getId());
        count = achievementReportDao.countByStatement("countPartTimer", param);
        ar.setHouseFollowupCount(count);


        //计算签约量
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerId", report.getId());
        count = achievementReportDao.countByStatement("countOrder", param);
        ar.setOrderCount(count);

        //计算新客户签约量
        param.clear();
        param.put("createTimeEnd", report.getEndTime());
        param.put("createTimeStart", report.getStartTime());
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerId", report.getId());
        count = achievementReportDao.countByStatement("countOrder", param);
        ar.setNewCustomerOrderCount(count);

        //计算合同佣金、营业收入、回款
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerId", report.getId());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderAmountCount", param);
        if (ObjectUtils.isNotEmpty(list)) {
            ar.setContractAmountCount(list.get(0).getContractAmountCount());
            ar.setAchievementAmountCount(list.get(0).getAchievementAmountCount());
            ar.setOrderBackAmountCount(list.get(0).getOrderBackAmountCount());
        }

        //计算分成佣金
        param.clear();
        param.put("orderTimeStart", report.getStartTime());
        param.put("orderTimeEnd", report.getEndTime());
        param.put("orderOwnerId", report.getId());
        param.put("groupBy", "o.owner_id");
        list = achievementReportDao.selectByStatement("selectOrderDivideCount", param);
        if (ObjectUtils.isNotEmpty(list)) {
            ar.setDivideAmountCount(list.get(0).getDivideAmountCount());
        }
    }


    @Override
    protected void afterReport(ReportResult<AchievementReportEntity> report, List<AchievementReportEntity> list) {

        if (ObjectUtils.isNotEmpty(list) && list.size() > 1) {
            AchievementReportEntity sum = new AchievementReportEntity();
            sum.setName("合计");

            for (AchievementReportEntity tmp : list) {
                sum.setCustomerPersonalCount(sum.getCustomerPersonalCount() + tmp.getCustomerPersonalCount());
                sum.setCustomerHideCount(sum.getCustomerHideCount() + tmp.getCustomerHideCount());
                sum.setCustomerCompanyCount(sum.getCustomerCompanyCount() + tmp.getCustomerCompanyCount());
                sum.setCustomerFollowupCount(sum.getCustomerFollowupCount() + tmp.getCustomerFollowupCount());
                sum.setPartTimerCount(sum.getPartTimerCount() + tmp.getPartTimerCount());
                sum.setOrderCount(sum.getOrderCount() + tmp.getOrderCount());
                sum.setNewCustomerOrderCount(sum.getNewCustomerOrderCount() + tmp.getNewCustomerOrderCount());
                sum.setContractAmountCount(sum.getContractAmountCount() + tmp.getContractAmountCount());
                sum.setAchievementAmountCount(sum.getAchievementAmountCount() + tmp.getAchievementAmountCount());
                sum.setDivideAmountCount(sum.getDivideAmountCount() + tmp.getDivideAmountCount());
            }

            Integer ct = 0;
            Map<String, Object> param = new HashMap<>();
            param.put("cusOwnerType", CustomerOwnerType.Company);
            param.put("createTimeStart", report.getStartTime());
            param.put("createTimeEnd", report.getEndTime());
            if (report.getIsDept()) {

                param.put("ownerDeptId", report.getId());
            }else{
                UserEntity user = userManager.findById(report.getId(),"id","owner_dept_id");
                param.put("ownerDeptId",user.getOwnerDeptId());
            }

            ct = achievementReportDao.countByStatement("countCustomer", param);
            sum.setCustomerCompanyCount(sum.getCustomerCompanyCount() + ct);

            list.add(0, sum);
        }

    }
}
