package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-07 20:17
 * @since 1.0
 */
@Component
public class FireDeviceType extends ClassKeyDictionaryProvider<FireDeviceType> {

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),getParentCode(),"消防设施"));
        list.add(new Dictionary(getKey(),"XiaoFangShuan","消防拴系统",getParentCode()));
        list.add(new Dictionary(getKey(),"ESFR","ESFR喷淋系统",getParentCode()));
        list.add(new Dictionary(getKey(),"YanGan","烟感系统",getParentCode()));
        list.add(new Dictionary(getKey(),"BaoJing","消防报警系统",getParentCode()));
        return list;
    }
}
