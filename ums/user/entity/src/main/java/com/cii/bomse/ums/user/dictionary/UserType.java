package com.cii.bomse.ums.user.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/1/4 18:02
 */
@Component
public class UserType extends ClassKeyDictionaryProvider<UserType> {

    public static String Employee = "Employee";
    public static String PartTimer = "PartTimer";
//    public static String Admin = "Admin";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(), getParentCode(), "用户类型"));
        list.add(new Dictionary(getKey(), Employee, "员工", getParentCode()));
        list.add(new Dictionary(getKey(), PartTimer, "兼职", getParentCode()));
//        list.add(new Dictionary(getKey(), Admin, "管理员", getParentCode()));

        return list;
    }
}
