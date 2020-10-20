package com.cii.bomse.hrm.emp.manager.impl;

import com.cii.bomse.common.observer.IDataAuthSubject;
import com.cii.bomse.hrm.emp.dao.IEmployeeTransferDao;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.manager.IEmployeeManager;
import com.cii.bomse.hrm.emp.manager.IEmployeeTransferManager;
import com.cii.bomse.hrm.emp.entity.EmployeeTransferEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class EmployeeTransferManagerImpl extends AbstractManager<EmployeeTransferEntity> implements IEmployeeTransferManager {

    @Autowired
    private IEmployeeTransferDao employeeTransferDao;
    @Autowired
    private IEmployeeManager employeeManager;

    @Autowired
    private IDataAuthSubject dataAuthSubject;

    @Override
    protected IMyBatisBaseDao<EmployeeTransferEntity, Long> getMyBatisDao() {
        return employeeTransferDao;
    }

    @Override
    protected void beforeBatchCreate(List<EmployeeTransferEntity> list) {

        for (EmployeeTransferEntity employeeTransfer : list) {

            ValidationResult vr = ValidationUtils.validateInclude(employeeTransfer);
            ObjectUtils.ifFalseThrow(vr.getSuccess(),()->new BusinessException(vr.getMessage()));

            EmployeeEntity tmp = employeeManager.findById(employeeTransfer.getEmpId(), "id", "emp_name", "owner_dept_id", "owner_dept_name");
            Optional.ofNullable(tmp).orElseThrow(() -> new BusinessException("员工信息不存在"));

            employeeTransfer.setFromDeptId(tmp.getOwnerDeptId());
            employeeTransfer.setFromDeptName(tmp.getOwnerDeptName());


            ObjectUtils.ifTrueThrow(employeeTransfer.getFromDeptId().equals(employeeTransfer.getToDeptId())
                    ,()->new BusinessException("异动后部门和原部门一致，无需异动操作!"));

            //设置转移字段
            ObjectUtils.isEmpty(employeeTransfer.getTransferDate(),employeeTransfer,(t)->t.setTransferDate(new Date()));
        }
    }

    @Override
    protected void afterBatchCreate(List<EmployeeTransferEntity> list) {

        //更新员工信息
        List<EmployeeEntity> empList = list.stream().map((transfer)->{
            EmployeeEntity emp = new EmployeeEntity();
            emp.setId(transfer.getEmpId());
            emp.setOwnerDeptId(transfer.getToDeptId());
            emp.setOwnerDeptName(transfer.getToDeptName());
            return emp;
        }).collect(Collectors.toList());

        employeeManager.batchUpdate(empList);

        //人员发生部门异动的时候也需要通知数据权限变更
        dataAuthSubject.notifyAllObserver();
    }
}
