package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-04-28 15:06
 * @since 1.0
 */
@Component
public class CustomerUpDownType extends ClassKeyDictionaryProvider<CustomerUpDownType> {

    public static final String Up = "Up";
    public static final String Down = "Down";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"上下架类型"));
        list.add(new Dictionary(getKey(),Up,"上架",getParentCode()));
        list.add(new Dictionary(getKey(),Down,"下架",getParentCode()));

        return list;
    }
}
