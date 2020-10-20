package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-23 17:58
 * @since 1.0
 */
@Component
public class AcreageUnit extends ClassKeyDictionaryProvider<AcreageUnit> {

    public static String Square = "Square";
    public static String Mu = "Mu";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"面积单位"));
        list.add(new Dictionary(getKey(),Square,"平方",getParentCode()));
        list.add(new Dictionary(getKey(),Mu,"亩",getParentCode()));

        return list;
    }
}
