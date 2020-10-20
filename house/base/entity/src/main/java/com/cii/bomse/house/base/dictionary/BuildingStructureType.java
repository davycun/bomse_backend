package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-06 14:53
 * @since 1.0
 */
@Component
public class BuildingStructureType extends ClassKeyDictionaryProvider<BuildingStructureType> {
    public static final String GangJieGou="GangJieGou";
    public static final String GangHun="GangHun";
    public static final String ZhuanHun="ZhuanHun";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"房源结构"));
        list.add(new Dictionary(getKey(),GangJieGou,"钢结构",getParentCode()));
        list.add(new Dictionary(getKey(),GangHun,"钢混结构",getParentCode()));
        list.add(new Dictionary(getKey(),ZhuanHun,"砖混结构",getParentCode()));

        return list;
    }
}
