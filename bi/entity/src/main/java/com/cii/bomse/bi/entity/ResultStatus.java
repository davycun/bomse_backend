package com.cii.bomse.bi.entity;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-08 10:13
 * @since 1.0
 */
@Component
public class ResultStatus extends ClassKeyDictionaryProvider<ResultStatus> {

    public static final String Normal = "Normal";
    public static final String HasDeleted = "HasDeleted";
    public static final String HasQuit = "HasQuit";
    public static final String HasTransfer = "HasTransfer";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"部门或人员状态"));
        list.add(new Dictionary(getKey(),Normal,"正常",getParentCode()));
        list.add(new Dictionary(getKey(),HasDeleted,"已撤消",getParentCode()));
        list.add(new Dictionary(getKey(),HasQuit,"已离职",getParentCode()));
        list.add(new Dictionary(getKey(),HasTransfer,"已异动"));

        return list;
    }
}
