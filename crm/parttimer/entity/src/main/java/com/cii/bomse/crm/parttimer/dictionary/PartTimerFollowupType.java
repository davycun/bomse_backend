package com.cii.bomse.crm.parttimer.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-04 15:43
 * @since 1.0
 */
@Component
public class PartTimerFollowupType extends ClassKeyDictionaryProvider<PartTimerFollowupType> {


    public static final String Phone = "Phone";
    public static final String Scene = "Scene";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"兼职跟进类型"));
        list.add(new Dictionary(getKey(),Phone,"电话跟进",getParentCode()));
        list.add(new Dictionary(getKey(),Scene,"上门拜访",getParentCode()));

        return list;
    }
}
