package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-10-22 13:40
 * @since 1.0
 */
@Component
public class HouseUseType extends ClassKeyDictionaryProvider<HouseUseType> {

    public static final String Workshop = "生产";
    public static final String Warehouse = "仓储";
    public static final String Office = "办公";
    public static final String Live = "居住";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"租房用途"));
        list.add(new Dictionary(getKey(),"Workshop","生产",getParentCode()));
        list.add(new Dictionary(getKey(),"Warehouse","仓储",getParentCode()));
        list.add(new Dictionary(getKey(),"Office","办公",getParentCode()));
        list.add(new Dictionary(getKey(),"Live","居住",getParentCode()));
        return list;
    }
}
