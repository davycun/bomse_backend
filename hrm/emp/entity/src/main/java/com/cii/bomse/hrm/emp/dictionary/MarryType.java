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
 * @date 2019/3/17 00:23
 */
@Component
public class MarryType extends ClassKeyDictionaryProvider<MarryType> {


    public static final String HasMarry="HasMarry";
    public static final String NotMarry="NotMarry";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"婚姻状况"));
        list.add(new Dictionary(getKey(),HasMarry,"已婚",getParentCode()));
        list.add(new Dictionary(getKey(),NotMarry,"未婚",getParentCode()));

        return list;
    }
}
