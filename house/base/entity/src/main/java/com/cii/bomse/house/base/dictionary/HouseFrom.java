package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * 房源来源
 * @auth david·cun
 * @date 2019-12-03 10:11
 * @since 1.0
 */
@Component
public class HouseFrom extends ClassKeyDictionaryProvider<HouseFrom> {


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"房源来源"));
        list.add(new Dictionary(getKey(),"","线下扫街",getParentCode()));

        return list;
    }
}
