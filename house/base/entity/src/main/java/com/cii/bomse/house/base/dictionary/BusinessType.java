package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-23 11:28
 * @since 1.0
 */
@Component
public class BusinessType extends ClassKeyDictionaryProvider<BusinessType> {

    public static String Lease = "Lease";
    public static String Sell = "Sell";
    public static String LeaseSell = "LeaseSell";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"交易类型"));
        list.add(new Dictionary(getKey(),Lease,"出租",getParentCode()));
        list.add(new Dictionary(getKey(),Sell,"出售",getParentCode()));
        list.add(new Dictionary(getKey(),LeaseSell,"可租可售",getParentCode()));

        return list;
    }
}
