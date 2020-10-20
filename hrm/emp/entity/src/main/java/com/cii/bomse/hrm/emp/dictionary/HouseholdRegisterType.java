package com.cii.bomse.hrm.emp.dictionary;

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
 * @date 2019/3/17 00:32
 */
@Component
public class HouseholdRegisterType extends ClassKeyDictionaryProvider<HouseholdRegisterType> {


    public static final String City="City";
    public static final String NoCity="NoCity";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"户籍"));
        list.add(new Dictionary(getKey(),City,"城镇",getParentCode()));
        list.add(new Dictionary(getKey(),NoCity,"非城镇",getParentCode()));

        return list;
    }

}
