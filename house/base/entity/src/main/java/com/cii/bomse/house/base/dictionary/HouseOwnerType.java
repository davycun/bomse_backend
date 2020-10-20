package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-03 09:50
 * @since 1.0
 */
@Component
public class HouseOwnerType extends ClassKeyDictionaryProvider<HouseOwnerType> {

    public static final String Landlord = "Landlord";
    public static final String Investment = "Investment";
    public static final String Guard = "Guard";
    public static final String CusService = "CusService";
    public static final String Other = "Other";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"房东类型"));
        list.add(new Dictionary(getKey(),Landlord,"房东本人",getParentCode()));
        list.add(new Dictionary(getKey(),Investment,"招商人员",getParentCode()));
        list.add(new Dictionary(getKey(),Guard,"园区保安",getParentCode()));
        list.add(new Dictionary(getKey(),CusService,"园区客服",getParentCode()));
        list.add(new Dictionary(getKey(),Other,"其他",getParentCode()));

        return list;
    }
}
