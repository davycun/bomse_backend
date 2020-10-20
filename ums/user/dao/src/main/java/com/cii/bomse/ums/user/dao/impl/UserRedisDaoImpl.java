package com.cii.bomse.ums.user.dao.impl;

import com.cii.bomse.ums.user.dao.IUserRedisDao;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.ciiframework.common.auth.Token;
import com.ciiframework.user.dao.impl.AbstractBaseUserRedisDao;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @auth david·cun
 * @date 2019-04-16 18:30
 * @since 1.0
 */
@Repository
public class UserRedisDaoImpl extends AbstractBaseUserRedisDao<UserEntity> implements IUserRedisDao {

    /**
     * 此种实现方式表示在某个类型中只能有一个登录状态，比如一个APP登录了，那么另一个APP在登录就会被踢掉
     * @param token
     * @return
     */
    @Override
    public String createTokenKey(Token token) {
        return String.format("boms:user:token:%s:%d",token.getTokenType(),token.getUserId());
    }

    /**
     * 用户信息key
     * @param userId
     * @return
     */
    @Override
    public String createUserInfoKey(Long userId) {
        return String.format("boms:user:info:%d",userId);
    }

    /**
     * @description 用户超时设置，单位为秒
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-16 18:30
     * @since 1.0
     */
    @Override
    public long getUserInfoTimeout() {
        return 18000L;
    }
}
