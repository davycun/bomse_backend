package com.cii.bomse.hrm.emp.manager;

import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.ciiframework.common.business.IManager;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/17 12:00
 */
public interface IEmployeeManager extends IManager<EmployeeEntity> {

    /**
     * @description 开通登录权限
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-15 18:31
     * @since 1.0
     */
    void openLogin(Long id);

    /**
     * @description 关闭登录权限
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-15 18:32
     * @since 1.0
     */
    void closeLogin(Long id);

    /**
     * @description
     * 返聘
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-08 15:33
     * @since 1.0
     */
    void rehire(EmployeeEntity emp);

    /**
     * @description
     * 检查员工手机号是否已经存在
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-17 17:37
     * @since 1.0
     */
    boolean checkEmpPhoneExists(String empPhone);

    /**
     * @description
     * 更新电话号码
     * @author david·cun
     * @param
     * @return
     * @date 2020-03-27 14:40
     * @since 1.0
     */
    void updatePhone(Long empId,String oldPhone,String newPhone);


}
