package com.cii.bomse.hrm.dept.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-05-31 15:30
 * @since 1.0
 */
@Component
public class DeptShareState extends ClassKeyDictionaryProvider<DeptShareState> {

    public static final String Applying = "Applying";
    public static final String Accept = "Accept";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"共享配置状态"));
        list.add(new Dictionary(getKey(),Applying,"申请中",getParentCode()));
        list.add(new Dictionary(getKey(),Accept,"已同意",getParentCode()));

        return list;
    }
}
