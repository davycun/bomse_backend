package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-07 20:23
 * @since 1.0
 */
@Component
public class FloorBoardType extends ClassKeyDictionaryProvider<FloorBoardType> {
    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"地坪类型"));
        list.add(new Dictionary(getKey(),"Normal","一般硬化",getParentCode()));
        list.add(new Dictionary(getKey(),"Epoxy","环氧地坪",getParentCode()));
        list.add(new Dictionary(getKey(),"Emery","金钢砂硬化",getParentCode()));
        list.add(new Dictionary(getKey(),"WaterStone","水磨石",getParentCode()));

        return list;
    }
}
