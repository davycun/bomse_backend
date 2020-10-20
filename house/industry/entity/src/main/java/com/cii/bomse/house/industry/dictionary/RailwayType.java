package com.cii.bomse.house.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * 月台类型，内置式/外置式
 * @auth david·cun
 * @date 2019-12-07 21:22
 * @since 1.0
 */
@Component
public class RailwayType extends ClassKeyDictionaryProvider<RailwayType> {

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"月台类型"));
        list.add(new Dictionary(getKey(),"Internal","内置式",getParentCode()));
        list.add(new Dictionary(getKey(),"External","外置式",getParentCode()));

        return list;
    }
}
