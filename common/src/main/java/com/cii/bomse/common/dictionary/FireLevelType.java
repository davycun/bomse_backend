package com.cii.bomse.common.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-10-22 11:54
 * @since 1.0
 */
@Component
public class FireLevelType extends ClassKeyDictionaryProvider<FireLevelType> {

    public static String JIA = "jia";
    public static String YI = "yi";
    public static String BING = "bing";
    public static String DING = "ding";
    public static String WU = "wu";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey() , getParentCode(),"消防等级"));
        list.add(new Dictionary(getKey(), JIA, "甲类", getParentCode()));
        list.add(new Dictionary(getKey(), YI, "乙类", getParentCode()));
        list.add(new Dictionary(getKey(), BING, "丙类(消防栓+喷淋)", getParentCode()));
        list.add(new Dictionary(getKey(), DING, "丁类(消防栓)", getParentCode()));
        list.add(new Dictionary(getKey(), WU, "戊类", getParentCode()));

        return list;
    }
}
