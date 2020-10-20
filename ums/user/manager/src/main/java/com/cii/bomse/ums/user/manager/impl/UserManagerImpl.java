package com.cii.bomse.ums.user.manager.impl;

import com.cii.bomse.base.auth.entity.MenuEntity;
import com.cii.bomse.base.auth.manager.IMenuManager;
import com.cii.bomse.base.cpy.dao.ICompanyDao;
import com.cii.bomse.base.cpy.entity.CompanyEntity;
import com.cii.bomse.common.observer.IMenuAuthObserver;
import com.cii.bomse.ums.user.dao.IUserDbDao;
import com.cii.bomse.ums.user.dao.IUserRedisDao;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.data.PageResult;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.exception.BusinessException;
import com.ciiframework.user.business.impl.AbstractBaseUserManager;
import com.ciiframework.user.dao.IBaseUserRedisDao;
import com.ciiframework.utils.BeanMapConvertUtils;
import com.ciiframework.utils.ObjectUtils;
import com.ciiframework.utils.ValidationResult;
import com.ciiframework.utils.ValidationUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/8 21:58
 */
@Service
public class UserManagerImpl extends AbstractBaseUserManager<UserEntity> implements IUserManager, IMenuAuthObserver {

    @Autowired
    private IUserDbDao userDbDao;
    @Autowired
    private IUserRedisDao userRedisDao;
    @Autowired
    private IMenuManager menuManager;

    @Autowired
    private ICompanyDao companyDao;

    private Map<Long,List<String>> userAuthUrlListMap;


    public UserManagerImpl(){
        userAuthUrlListMap = new HashMap<>();
    }

    @Override
    public IBaseUserRedisDao<UserEntity> getUserRedisDao() {
        return userRedisDao;
    }

    @Override
    protected IMyBatisBaseDao<UserEntity, Long> getMyBatisDao() {
        return userDbDao;
    }

    @Override
    protected void beforeBatchCreate(List<UserEntity> list) {

        for (UserEntity user : list) {

            if (ObjectUtils.isEmpty(user.getUserPhone()) || !user.getUserPhone().contains("admin")){
                ValidationResult vr = ValidationUtils.validateInclude(user,
                        "userName", "userPhone");
                if (!vr.getSuccess()) {
                    throw new BusinessException(vr.getMessage());
                }
            }

            Map<String, Object> param = new HashMap<>();
            param.put("userPhone", user.getUserPhone());
//            param.put("isDeleted",Boolean.FALSE);

            List<UserEntity> u = userDbDao.selectByMap(param);

            if (null != u && u.size() > 0) {
                throw new BusinessException("此手机号码已经被注册，不可重复注册");
            }

            String sec = user.getSecure();
            if (ObjectUtils.isEmpty(sec)){
                sec = user.getUserPhone().substring(5);
            }
            String psw = BCrypt.hashpw(sec, BCrypt.gensalt());

            user.setPassword(psw);
        }
    }

    @Override
    protected void afterBatchCreate(List<UserEntity> list) {
    }

    @Override
    protected void afterBatchUpdate(List<UserEntity> list) {

        for (UserEntity user : list){
            //清空缓存
            userRedisDao.deleteUserInfo(user.getId());
        }

    }

    @Override
    public UserEntity login(UserEntity user) {

        if (ObjectUtils.isEmpty(user) || ObjectUtils.isEmpty(user.getSecure())) {
            throw new BusinessException("登录密码不能为空!");
        }

        if (ObjectUtils.isEmpty(user.getUserPhone())
                && ObjectUtils.isEmpty(user.getWorkNumber())
                && ObjectUtils.isEmpty(user.getEmail())) {

            throw new BusinessException("用户登录，账号必填!");
        }

        Map<String, Object> param =
                BeanMapConvertUtils.convertInclude(user,
                        "userPhone", "workNumber", "email");
        param.put("isDeleted", Boolean.FALSE);

        UserEntity u = userDbDao.selectUniqueByMap(param);

        //判断企业是否正常

        CompanyEntity cpy = companyDao.selectById(u.getCpyId());

        if (ObjectUtils.isEmpty(cpy) || cpy.getIsDeleted()){
            throw new BusinessException("您的企业账号已经过期，请联系系统管理员");
        }


        if (ObjectUtils.isEmpty(u)) {
            throw new BusinessException("用户不存在");
        }

        Boolean psw = BCrypt.checkpw(user.getSecure(), u.getPassword());

        if (!psw) {
            throw new BusinessException("用户密码错误");
        }

        return u;
    }

    @Override
    public PageResult<UserEntity> selectUserSelector(Map<String, Object> param, int start, int pageSize) {

        if (!ciiProperty.getPlatformCpyId().equals(CurrentContext.getCpyId())){
            addCpyId(param);
        }

        return userDbDao.selectByStatement("selectUserSelector", param, start, pageSize);
    }

    @Override
    public PageResult<UserEntity> findRoleUser(Map<String, Object> param, int start, int pageSize) {

        if (!ciiProperty.getPlatformCpyId().equals(CurrentContext.getCpyId())){
            addCpyId(param);
        }

        return userDbDao.selectByStatement("selectRoleUser", param, start, pageSize);
    }
    @Override
    public PageResult<UserEntity> findDataRoleUser(Map<String, Object> param, int start, int pageSize) {
        addCpyId(param);
        return userDbDao.selectByStatement("selectDataRoleUser", param, start, pageSize);
    }

    /**
     * @description 修改密码
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-16 14:46
     * @since 1.0
     */
    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        UserEntity user = findById(userId);

        if (null != user){
            if(BCrypt.checkpw(oldPassword,user.getPassword())){

                UserEntity u = new UserEntity();
                u.setId(userId);
                u.setSecure(newPassword);
                u.setPassword(BCrypt.hashpw(newPassword,BCrypt.gensalt()));

                update(u);

            }else{
                throw new BusinessException("原密码错误!");
            }
        }
    }

    @Override
    public List<String> findUserAuthUrl(Long userId) {

        List<String> urlList = userAuthUrlListMap.get(userId);

        if (urlList == null){

            urlList = new ArrayList<>();

            List<MenuEntity> menuList = menuManager.findByUserNoTree(userId);
            if (ObjectUtils.isNotEmpty(menuList)){

                for (MenuEntity menu : menuList){
                    urlList.add(menu.getMenuUrl());
                }
            }
            userAuthUrlListMap.put(userId,urlList);
        }

        return urlList;
    }

    @Override
    public void update() {
        userAuthUrlListMap.clear();
    }
}
