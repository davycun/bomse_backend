package com.cii.bomse.base.auth.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.dictionary.DictionaryProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 17:05
 */
@Component
public class MenuType extends ClassKeyDictionaryProvider<MenuType> {

    public static final String Function = "Function";
    public static final String Menu = "Menu";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"菜单类型"));
        list.add(new Dictionary(getKey(),Function,"功能",getParentCode()));
        list.add(new Dictionary(getKey(),Menu,"菜单",getParentCode()));

        return list;
    }

}
