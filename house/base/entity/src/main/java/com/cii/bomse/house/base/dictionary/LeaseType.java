package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-03 10:05
 * @since 1.0
 */
@Component
public class LeaseType extends ClassKeyDictionaryProvider<LeaseType> {

    public static final String BigLandlord = "BigLandlord";
    public static final String SubLandlord = "SubLandlord";
    public static final String Sublet = "Sublet";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"租赁类型"));
        list.add(new Dictionary(getKey(),BigLandlord,"原房东直租",getParentCode()));
        list.add(new Dictionary(getKey(),SubLandlord,"二房东直租",getParentCode()));
        list.add(new Dictionary(getKey(),Sublet,"转租",getParentCode()));
        return list;
    }
}
