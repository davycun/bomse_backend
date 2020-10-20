package com.cii.bomse.bi.manager.impl;

import com.cii.bomse.bi.dao.ICustomerChannelReportDao;
import com.cii.bomse.bi.dao.ICustomerChannelReportRedisDao;
import com.cii.bomse.bi.dao.IReportRedisDao;
import com.cii.bomse.bi.entity.CustomerChannelReportEntity;
import com.cii.bomse.bi.entity.ReportResult;
import com.cii.bomse.bi.manager.ICustomerChannelReportManager;
import com.cii.bomse.crm.customer.base.dictionary.CustomerSource;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CustomerChannelReportManagerImpl extends AbstractReportManager<CustomerChannelReportEntity> implements ICustomerChannelReportManager {

    @Autowired
    private ICustomerChannelReportDao customerChannelReportDao;
    @Autowired
    private ICustomerChannelReportRedisDao customerChannelReportRedisDao;

    @Override
    protected IMyBatisBaseDao<CustomerChannelReportEntity, Long> getMyBatisDao() {
        return customerChannelReportDao;
    }

    @Override
    public IReportRedisDao<CustomerChannelReportEntity> getReportRedisDao() {
        return customerChannelReportRedisDao;
    }

    @Override
    protected void initResult(ReportResult<CustomerChannelReportEntity> report, List<DeptEntity> list) {
        Map<String, CustomerChannelReportEntity> result = new HashMap<>();
        Dictionary dicS = DictionaryStorage.get(CustomerSource.class.getName());
        if (ObjectUtils.isNotEmpty(dicS.getChildren())) {
            for (Dictionary dic : dicS.getChildren()) {
                CustomerChannelReportEntity channel = new CustomerChannelReportEntity();
                channel.setCusSource(dic.getCode());
                channel.setName(dic.getName());
                result.put(dic.getCode(), channel);
            }
            report.setResult(result);
        }
    }

    private static final String selectCustomerCount="selectCustomerCount";
    private static final String selectOrderCount="selectOrderCount";

    @Override
    public void reportDeptEmployee(ReportResult report) {

        if (ObjectUtils.isEmpty(report.getResult())) {
            return;
        }

        Map<String, Object> param = new HashMap<>();
        List<CustomerChannelReportEntity> list = null;

        //部门员工个人获客
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
        param.put("createDeptId",report.getId());
//        param.put("cusType", CustomerType.Personal);
        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerPersonalCount", list,"cusSource");

        //部门员工集中获客
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
        param.put("ownerDeptId",report.getId());
//        param.put("cusType", CustomerType.Company);
        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerCompanyCount", list,"cusSource");


        //部门员工签单量
        param.clear();
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerDeptId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("orderCount", list,"cusSource");

        //部门员工新客签单量
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerDeptId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("newCustomerOrderCount", list,"cusSource");
    }

    @Override
    public void reportChildrenDept(ReportResult report) {

        if (ObjectUtils.isEmpty(report.getDeptIdList())) {
            return;
        }
        List<CustomerChannelReportEntity> list = null;
        Map<String,Object> param = new HashMap<>();


        //子部门个人获客
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
//        param.put("cusType",CustomerType.Personal);
        param.put("createDeptIds",report.getDeptIdList());

        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerPersonalCount", list,"cusSource");

        //子部门集中获客
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
//        param.put("cusType",CustomerType.Company);
        param.put("ownerDeptIds",report.getDeptIdList());
        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerCompanyCount", list,"cusSource");


        //子部门签单量
        param.clear();
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerDeptIds",report.getDeptIdList());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("orderCount", list,"cusSource");

        //子部门新客签单量
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerDeptIds",report.getDeptIdList());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("newCustomerOrderCount", list,"cusSource");

    }

    @Override
    public void reportEmployee(ReportResult report) {

        if (ObjectUtils.isEmpty(report.getResult())) {
            return;
        }

        List<CustomerChannelReportEntity> list = null;
        Map<String,Object> param = new HashMap<>();

        //员工个人获客
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
//        param.put("cusType",CustomerType.Personal);
        param.put("createId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerPersonalCount", list,"cusSource");

        //员工集中获客
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
//        param.put("cusType",CustomerType.Company);
        param.put("ownerId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectCustomerCount,param);
        report.addResult("customerCompanyCount", list,"cusSource");


        //员工签单量
        param.clear();
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("orderCount", list,"cusSource");

        //员工新客签单量
        param.clear();
        param.put("createTimeStart",report.getStartTime());
        param.put("createTimeEnd",report.getEndTime());
        param.put("orderTimeStart",report.getStartTime());
        param.put("orderTimeEnd",report.getEndTime());
        param.put("orderOwnerId",report.getId());
        list = customerChannelReportDao.selectByStatement(selectOrderCount,param);
        report.addResult("newCustomerOrderCount", list,"cusSource");

    }
}
