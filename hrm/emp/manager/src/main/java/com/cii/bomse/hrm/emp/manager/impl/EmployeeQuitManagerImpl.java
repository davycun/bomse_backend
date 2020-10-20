package com.cii.bomse.hrm.emp.manager.impl;

import com.cii.bomse.hrm.emp.dao.IEmployeeDbDao;
import com.cii.bomse.hrm.emp.dao.IEmployeeQuitDao;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeQuitEntity;
import com.cii.bomse.hrm.emp.manager.IEmployeeQuitManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeQuitManagerImpl extends AbstractManager<EmployeeQuitEntity> implements IEmployeeQuitManager {

    @Autowired
    private IEmployeeQuitDao employeeQuitDao;
    @Autowired
    private IEmployeeDbDao employeeDbDao;

    @Override
    protected IMyBatisBaseDao<EmployeeQuitEntity, Long> getMyBatisDao() {
        return employeeQuitDao;
    }

    @Override
    protected void beforeBatchCreate(List<EmployeeQuitEntity> list) {

//        List<UserEntity> userList = new ArrayList<>();
        List<EmployeeEntity> empList = new ArrayList<>();

        for (EmployeeQuitEntity empQuit : list){

            ValidationResult vr = ValidationUtils.validateInclude(empQuit,"empId","quitDate");
            if (!vr.getSuccess()){
                throw new BusinessException(vr.getMessage());
            }

            EmployeeEntity emp = employeeDbDao.selectById(empQuit.getEmpId(),"id","emp_name","owner_dept_id","owner_dept_name","enter_date");
            if (ObjectUtils.isNotEmpty(emp)){

//                //更新用户
//                UserEntity user = new UserEntity();
//                user.setId(emp.getId());
//                user.setIsDeleted(Boolean.TRUE);
//                userList.add(user);

                //更新员工
                emp.setHasQuit(Boolean.TRUE);
                emp.setQuitDate(empQuit.getQuitDate());
                emp.setIsDeleted(Boolean.TRUE);
                emp.setCanLogin(Boolean.FALSE);
                empList.add(emp);

                //增加离职记录日期
//                empQuit.setEmpId(emp.getId());
//                empQuit.setQuitDate(quitTime);
                empQuit.setEmpName(emp.getEmpName());
                empQuit.setEmpDeptId(emp.getOwnerDeptId());
                empQuit.setEmpDeptName(emp.getOwnerDeptName());
                empQuit.setEnterDate(emp.getEnterDate());
            }
        }

//        if (ObjectUtils.isNotEmpty(userList)){
//            userManager.batchUpdate(userList);
//        }

        if (ObjectUtils.isNotEmpty(empList)){
            employeeDbDao.batchUpdate(empList);
        }
    }
}
