package com.cii.bomse.ums.user.dao.mapper;

import com.cii.bomse.ums.user.entity.UserEntity;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/15 11:29
 */
public interface IUserMapper {

    @ResultMap("com.cii.bomse.ums.user.entity.UserEntity.BaseResultMap")
    @Select("select u.user_name,u.user_phone,u.sex,u.owner_dept_name from t_boms_ums_user u " +
            "inner join t_boms_auth_role_user r " +
            "on r.user_code=u.user_code " +
            "where role_code=#{roleCode} ")
//    +
//            "and (user_name like '%' || #{keyword} || '%'" +
//            "     or user_phone like  '%' || #{keyword} || '%'" +
//            "     or owner_dept_name like '%' || #{keyword} || '%')")
    public List<UserEntity> queryUserRole(Map<String,Object> param);
}
