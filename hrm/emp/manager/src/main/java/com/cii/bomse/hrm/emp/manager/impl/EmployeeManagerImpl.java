package com.cii.bomse.hrm.emp.manager.impl;

import com.cii.bomse.common.utils.Constants;
import com.cii.bomse.hrm.emp.dao.IEmployeeDbDao;
import com.cii.bomse.hrm.emp.dao.IEmployeeTransferDao;
import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeQuitEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeTransferEntity;
import com.cii.bomse.hrm.emp.manager.IEmployeeManager;
import com.cii.bomse.hrm.emp.manager.IEmployeeQuitManager;
import com.cii.bomse.hrm.emp.manager.IEmployeeTransferManager;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.cii.bomse.ums.user.dictionary.UserType;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.utils.CodeGenUtils;
import com.ciiframework.common.utils.OperateFillUtils;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/17 12:01
 */
@Service
public class EmployeeManagerImpl extends AbstractManager<EmployeeEntity> implements IEmployeeManager {

    @Autowired
    private IEmployeeDbDao employeeDbDao;
    @Autowired
    private IUserManager userManager;
    @Autowired
    private IEmployeeTransferDao employeeTransferDao;

    @Override
    protected IMyBatisBaseDao<EmployeeEntity, Long> getMyBatisDao() {
        return this.employeeDbDao;
    }


    @Override
    protected void beforeBatchCreate(List<EmployeeEntity> list) {
        for (EmployeeEntity emp : list) {
            ValidationResult vr = ValidationUtils.validateInclude(emp);

            if (!vr.getSuccess()) {
                throw new BusinessException(vr.getMessage());
            }

            if (checkEmpPhoneExists(emp.getEmpPhone())) {
                throw new BusinessException("手机号已经存在不能重复创建，如果是返聘员工请走返聘的操作");
            }

            if (ObjectUtils.isEmpty(emp.getHasQuit())) {
                emp.setHasQuit(Boolean.FALSE);
            }

            if (ObjectUtils.isEmpty(emp.getCanLogin())) {
                emp.setCanLogin(Boolean.FALSE);
            }
        }
    }

    @Override
    protected void afterBatchUpdate(List<EmployeeEntity> list) {

        List<UserEntity> userList = new ArrayList<>();
        for (EmployeeEntity emp : list) {
            UserEntity user = convert(emp);
            userList.add(user);
        }
        if (ObjectUtils.isNotEmpty(userList)) {
            userManager.batchUpdate(userList);
        }
    }

    /**
     * @param
     * @return
     * @description 打开当前员工的登录权限
     * @author david·cun
     * @ate 2019-04-15 18:52
     * @since 1.0
     */
    @Transactional
    @Override
    public void openLogin(Long id) {

        //参数必填，避免全部更新
        if (ObjectUtils.isEmpty(id)) {
            throw new BusinessException("开启员工登录权限，员工编码不能为空");
        }
        //检查是否允许开启登录
        EmployeeEntity tmp = findById(id);
        if (tmp.getHasQuit() || tmp.getIsDeleted()) {
            throw new BusinessException("人员已经离职或者，不能开启登录");
        }
        //开启登录
        EmployeeEntity emp = new EmployeeEntity();
        emp.setId(id);
        emp.setCanLogin(Boolean.TRUE);
        employeeDbDao.update(emp);

        //如果已经开启过就更新，如果没有开启过，就创建登录用户
        Map<String, Object> param = new HashMap<>();
        param.put("userPhone", tmp.getEmpPhone());
        int count = userManager.countByMap(param);

        if (count > 0) {
            UserEntity user = new UserEntity();
            user.setId(tmp.getId());
            user.setIsDeleted(Boolean.FALSE);
            userManager.update(user);
        } else {
            UserEntity user = convert(tmp);
            user.setSecure(user.getUserPhone().substring(5));
            userManager.create(user);
        }
    }

    /**
     * @param
     * @return
     * @description 关闭当前员工的登录权限
     * @author david·cun
     * @ate 2019-04-15 18:53
     * @since 1.0
     */
    @Transactional
    @Override
    public void closeLogin(Long id) {

        if (ObjectUtils.isEmpty(id)) {
            throw new BusinessException("关闭登录权限，员工编码不能为空！");
        }

        //更新
        EmployeeEntity emp = new EmployeeEntity();
        emp.setId(id);
        emp.setCanLogin(Boolean.FALSE);
        employeeDbDao.update(emp);

        //设置登录用户为删除状态
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setIsDeleted(Boolean.TRUE);
        userManager.update(user);
    }

    @Override
    @Transactional
    public void rehire(EmployeeEntity emp) {

        if (ObjectUtils.isEmpty(emp.getEnterDate())
                || ObjectUtils.isEmpty(emp.getOwnerDeptId())
                || ObjectUtils.isEmpty(emp.getOwnerDeptName())
                || ObjectUtils.isEmpty(emp.getId())) {
            throw new BusinessException("返聘，入职日期，返聘部门必填");
        }

        //如果返聘后的所属部门和原来部门不一致，那么需要添加异动记录，先查出来，否则会被下面的update覆盖
        EmployeeEntity old = findById(emp.getId(),"id","owner_dept_id","owner_dept_name");


        //只是跟新返聘需要的信息
        EmployeeEntity target = new EmployeeEntity();
        target.setId(emp.getId());
        target.setEmpName(old.getEmpName());
        target.setEnterDate(emp.getEnterDate());
        target.setOwnerDeptId(emp.getOwnerDeptId());
        target.setOwnerDeptName(emp.getOwnerDeptName());
        target.setHasQuit(Boolean.FALSE);
        target.setIsDeleted(Boolean.FALSE);
        update(target);

        if (!old.getOwnerDeptId().equals(target.getOwnerDeptId())){
            EmployeeTransferEntity transfer = new EmployeeTransferEntity();
            transfer.setId(idGenerate.generate());
            transfer.setEmpId(target.getId());
            transfer.setEmpName(target.getEmpName());
            transfer.setFromDeptId(old.getOwnerDeptId());
            transfer.setFromDeptName(old.getOwnerDeptName());
            transfer.setToDeptId(target.getOwnerDeptId());
            transfer.setToDeptName(target.getOwnerDeptName());
            transfer.setTransferDate(target.getEnterDate());

            OperateFillUtils.fill(transfer);

            employeeTransferDao.insert(transfer);
        }
    }

    @Override
    public void updatePhone(Long empId, String oldPhone, String newPhone) {

        EmployeeEntity emp = findById(empId, "id","emp_phone");

        if (!emp.getEmpPhone().equals(oldPhone)) {
            throw new BusinessException("旧手机号码不匹配");
        }

        if (Pattern.matches(Constants.phoneRegexp, oldPhone)
                && Pattern.matches(Constants.phoneRegexp, newPhone)) {

            emp.setId(empId);
            emp.setEmpPhone(newPhone);
            employeeDbDao.update(emp);

            //更新用户手机号，密码也同时修改
            UserEntity user = new UserEntity();
            user.setId(empId);
            user.setUserPhone(newPhone);
            user.setSecure(newPhone.substring(5));
            user.setPassword(BCrypt.hashpw(newPhone.substring(5), BCrypt.gensalt()));
            userManager.update(user);

        } else {
            throw new BusinessException("手机号码格式错误");
        }


    }

    /**
     * @param
     * @return
     * @description 员工信息转换到用户信息
     * @author david·cun
     * @ate 2019-04-13 17:22
     * @since 1.0
     */
    private UserEntity convert(EmployeeEntity emp) {

        UserEntity user = new UserEntity();

        user.setId(emp.getId());
        user.setUserName(emp.getEmpName());
        user.setWorkNumber(emp.getWorkNumber());
        user.setUserPhone(emp.getEmpPhone());
        user.setAvatar(emp.getAvatar());
        user.setEmail(emp.getEmail());
        user.setSex(emp.getSex());
        user.setUserType(UserType.Employee);

        user.setRemark(emp.getRemark());

        user.setCpyId(emp.getCpyId());
        user.setCpyName(emp.getCpyName());

        user.setCreateTime(emp.getCreateTime());
        user.setLastUpdateTime(emp.getLastUpdateTime());

        user.setCreateId(emp.getCreateId());
        user.setCreateName(emp.getCreateName());
        user.setCreateDeptId(emp.getCreateDeptId());
        user.setCreateDeptName(emp.getCreateDeptName());

        user.setLastUpdateId(emp.getLastUpdateId());
        user.setLastUpdateName(emp.getLastUpdateName());

        user.setOwnerId(emp.getOwnerId());
        user.setOwnerName(emp.getOwnerName());
        user.setOwnerDeptId(emp.getOwnerDeptId());
        user.setOwnerDeptName(emp.getOwnerDeptName());

        user.setIsDeleted(emp.getIsDeleted());

        return user;
    }

    public boolean checkEmpPhoneExists(String empPhone) {
        Map<String, Object> param = new HashMap<>();
        param.put("empPhone", empPhone);
        int count = employeeDbDao.countByMap(param);

        return count > 0;
    }

}
