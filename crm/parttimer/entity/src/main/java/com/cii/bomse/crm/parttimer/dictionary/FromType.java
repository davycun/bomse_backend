package com.cii.bomse.crm.parttimer.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-04 15:35
 * @since 1.0
 */
@Component
public class FromType extends ClassKeyDictionaryProvider<FromType> {

    public static final String OnLine = "OnLine";
    public static final String OffLine = "OffLine";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"来源"));
        list.add(new Dictionary(getKey(),OnLine,"线上注册",getParentCode()));
        list.add(new Dictionary(getKey(),OffLine,"线下开发",getParentCode()));

        return list;
    }
}
