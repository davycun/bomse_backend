package com.cii.bomse.common.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-07 21:12
 * @since 1.0
 */
@Component
public class IndustryPriceUnitType extends ClassKeyDictionaryProvider<IndustryPriceUnitType> {

    public static final String Day="Day";
    public static final String Month="Month";
    public static final String Year="Year";
    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"价格单位"));
        list.add(new Dictionary(getKey(),Day,"元/㎡/天",getParentCode()));
        list.add(new Dictionary(getKey(),Month,"元/㎡/月",getParentCode()));
        list.add(new Dictionary(getKey(),Year,"元/㎡/年",getParentCode()));

        return list;
    }
}
