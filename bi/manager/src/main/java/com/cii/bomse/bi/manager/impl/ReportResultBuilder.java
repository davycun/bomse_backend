package com.cii.bomse.bi.manager.impl;

import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;
import com.cii.bomse.bi.entity.BaseReportEntity;
import com.cii.bomse.bi.entity.ReportResult;
import com.cii.bomse.bi.entity.ResultStatus;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.cii.bomse.hrm.emp.dao.IEmployeeDbDao;
import com.cii.bomse.hrm.emp.dao.IEmployeeQuitDao;
import com.cii.bomse.hrm.emp.dao.IEmployeeTransferDao;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeQuitEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeTransferEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-07 14:59
 * @since 1.0
 */
public abstract class ReportResultBuilder<T extends BaseReportEntity> extends AbstractManager<T> {

    @Autowired
    protected IDeptManager deptManager;
    @Autowired
    protected IEmployeeDbDao employeeDbDao;
    @Autowired
    protected IEmployeeTransferDao employeeTransferDao;
    @Autowired
    protected IEmployeeQuitDao employeeQuitDao;

    public ReportResult build(Long id, boolean reload) {
        return this.build(id, reload, null, null);
    }

    public ReportResult build(Long id, boolean reload, Date startTime, Date endTime) {

        Boolean isDept;
        //判断ID是部门还是人员
        if (ObjectUtils.isEmpty(id)) {
            List<DeptEntity> deptS = deptManager.findUserAuthDeptToTree(CurrentContext.getUserId());
            if (ObjectUtils.isNotEmpty(deptS)) {
                //查找第一个节点数据
                id = deptS.get(0).getId();
                isDept = Boolean.TRUE;
            } else {
                id = CurrentContext.getUserId();
                isDept = Boolean.FALSE;
            }
        } else {

            DeptEntity dept = deptManager.findById(id);
            if (ObjectUtils.isNotEmpty(dept)) {
                isDept = Boolean.TRUE;
            } else {
                isDept = Boolean.FALSE;
            }
        }

        ReportResult report = new ReportResult<T>(id, isDept, startTime, endTime);

        initDeptData(report);

        return report;
    }

    protected void initDeptData(ReportResult<T> report) {
        Map<String, Object> param = new HashMap<>();
        param.put("parentId", report.getId());
        List<DeptEntity> childrenDept = deptManager.findByMap(param);

        Map<Long, List<DeptEntity>> childrenDeptChildren = new HashMap<>();
        //表示有子部门
        if (ObjectUtils.isNotEmpty(childrenDept)) {
            for (DeptEntity tmp : childrenDept) {
                List<DeptEntity> l = deptManager.findByParentToList(tmp.getId());
                if (ObjectUtils.isNotEmpty(l)) {
                    childrenDeptChildren.put(tmp.getId(), l);
                }
            }
        }

        List<Long> list = new ArrayList<>();
        Map<Long, String> map = new HashMap<>();
        int j = 0;
        for (Map.Entry<Long, List<DeptEntity>> dp : childrenDeptChildren.entrySet()) {
            if (ObjectUtils.isNotEmpty(dp.getValue())) {
                String ids = "";
                for (int i = 0; i < dp.getValue().size(); i++) {
                    DeptEntity d = dp.getValue().get(i);

                    ids += d.getId().toString();

                    if (i < dp.getValue().size() - 1) {
                        ids += ",";
                    }
                    list.add(d.getId());
                }
                map.put(dp.getKey(), ids);
            }
        }
        report.setDeptIdList(list);
        report.setDeptIdString(map);

        initResult(report, childrenDept);
    }

    protected void initResult(ReportResult<T> report, List<DeptEntity> list) {
        if (report.getIsDept()) {
            addDeptResult(report, list);
        }
        addUserResult(report);
    }

    protected void addDeptResult(ReportResult<T> report, List<DeptEntity> deptS) {
        if (ObjectUtils.isNotEmpty(deptS)) {
            for (DeptEntity dept : deptS) {
                if (dept.getIsDeleted()) {
                    if (report.getStartTime().compareTo(dept.getDeleteDate()) < 1
                            && report.getEndTime().compareTo(dept.getDeleteDate()) > -1) {
                        addResult(report, dept.getId(), dept.getDeptName(), ResultStatus.HasDeleted);
                    }
                } else {

                    addResult(report, dept.getId(), dept.getDeptName(), ResultStatus.Normal);
                }
            }
        }
    }

    protected void addUserResult(ReportResult report) {

        Map<String, Object> param = new HashMap<>();

        if (report.getIsDept()) {

            //添加在时间范围内异动部门的人原
            param.clear();
            param.put("transferDateStart", report.getStartTime());
            param.put("transferDateEnd", report.getEndTime());
            param.put("fromDeptId", report.getId());
            List<EmployeeTransferEntity> tran = employeeTransferDao.selectByMap(param);

            if (ObjectUtils.isNotEmpty(tran)) {
                for (EmployeeTransferEntity emp : tran) {
                    addResult(report, emp.getEmpId(), emp.getEmpName(), ResultStatus.HasTransfer);
                }
            }

            //添加在时间范围内离职的人员
            param.clear();
            //此处不能添加时间查询，否则查询历史数据，非查询时间内离职的人就查询不到
//            param.put("quitDateStart", report.getStartTime());
//            param.put("quitDataEnd", report.getEndTime());
            param.put("empDeptId", report.getId());
            List<EmployeeQuitEntity> list = employeeQuitDao.selectByMap(param);

            if (ObjectUtils.isNotEmpty(list)) {
                for (EmployeeQuitEntity emp : list) {
                    addResult(report, emp.getId(), emp.getEmpName(), ResultStatus.HasQuit);
                }
            }

            //添加在职人员
            param.put("ownerDeptId", report.getId());
            param.put("isDeleted",Boolean.FALSE);
            List<EmployeeEntity> empS = employeeDbDao.selectByMapSimple(param,
                    "id", "emp_name", "has_quit", "enter_date");
            if (ObjectUtils.isNotEmpty(empS)) {
                for (EmployeeEntity emp : empS) {

                    addResult(report, emp.getId(), emp.getEmpName(), ResultStatus.Normal);

//                    if (ObjectUtils.isNotEmpty(emp.getHasQuit())
//                            && emp.getHasQuit()
//                            && report.getStartTime().compareTo(emp.getQuitDate()) < 1
//                            && report.getEndTime().compareTo(emp.getQuitDate()) > -1) {
//
//                        addResult(report, emp.getId(), emp.getEmpName(), ResultStatus.HasQuit);
//
//                    } else {
//
//                    }
                }
            }


        } else {
            EmployeeEntity emp = employeeDbDao.selectById(
                    report.getId(), "id", "emp_name", "has_quit", "enter_date");
            addResult(report, emp.getId(), emp.getEmpName(), ResultStatus.Normal);
        }


    }

    protected void addResult(ReportResult report, Long id, String name, String resultStatus) {
        T result = null;
        try {
            result = (T) Class.forName(GenericsUtils.getSuperClassGenricType(getClass()).getName()).newInstance();
            result.setId(id);
            result.setName(name);
            result.setResultStatus(resultStatus);
            report.getResult().put(id.toString(), result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
