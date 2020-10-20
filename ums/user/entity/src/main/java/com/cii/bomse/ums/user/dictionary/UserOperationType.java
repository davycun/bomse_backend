package com.cii.bomse.ums.user.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-04-02 16:40
 * @since 1.0
 */
@Component
public class UserOperationType extends OperationType {

    public static final String Login="Login";
    public static final String UpdatePassword="UpdatePassword";

    @Override
    public void addChildrenDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),Login,"登录",getParentCode()));
        list.add(new Dictionary(getKey(),UpdatePassword,"更新密码",getParentCode()));
    }
}
