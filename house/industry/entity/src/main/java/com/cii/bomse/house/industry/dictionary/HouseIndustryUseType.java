package com.cii.bomse.house.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-04 18:39
 * @since 1.0
 */
@Component
public class HouseIndustryUseType extends ClassKeyDictionaryProvider<HouseIndustryUseType> {

    public static final String Warehouse = "Warehouse";
    public static final String Workshop = "Workshop";
    public static final String Office = "Office";
    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"房源用途"));
        list.add(new Dictionary(getKey(),Warehouse,"仓储",getParentCode()));
        list.add(new Dictionary(getKey(),Workshop,"生产",getParentCode()));
        list.add(new Dictionary(getKey(),Office,"办公",getParentCode()));
        return list;
    }
}
