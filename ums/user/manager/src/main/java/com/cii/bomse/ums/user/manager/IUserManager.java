package com.cii.bomse.ums.user.manager;

import com.cii.bomse.ums.user.entity.UserEntity;
import com.ciiframework.data.PageResult;
import com.ciiframework.user.business.IBaseUserManager;

import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/8 21:58
 */
public interface IUserManager extends IBaseUserManager<UserEntity> {


    /**
     * @description 用户登录
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-16 18:37
     * @since 1.0
     */
    UserEntity login(UserEntity user);

    /**
     * 查询用户，为了分配用户给某个角色
     * @param param
     * @param start
     * @param pageSize
     * @return
     */
    PageResult<UserEntity> selectUserSelector(Map<String, Object> param, int start, int pageSize);

    /**
     * 通过角色编码查询用户
     * @param param
     * @param start
     * @param pageSize
     * @return
     */
    PageResult<UserEntity> findRoleUser(Map<String, Object> param, int start, int pageSize);

    /**
     * @description 通过数据角色编码查看哪些用户被分配的权限
     * @author david·cun
     * @param
     * @return
     * @date 2019-06-25 13:57
     * @since 1.0
     */
    PageResult<UserEntity> findDataRoleUser(Map<String, Object> param, int start, int pageSize);

    /**
     * @description 修改密码
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-16 14:44
     * @since 1.0
     */
    void changePassword(Long userId, String oldPassword, String newPassword);

}
