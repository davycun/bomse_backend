package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-10-22 11:43
 * @since 1.0
 */
@Component
public class CustomerNeedLayerType extends ClassKeyDictionaryProvider<CustomerNeedLayerType> {

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),getParentCode(),"需求楼层"));
        list.add(new Dictionary(getKey(),"TOP","楼上",getParentCode()));
        list.add(new Dictionary(getKey(),"BOTTOM","底楼",getParentCode()));
        list.add(new Dictionary(getKey(),"ALL","无要求",getParentCode()));
        return list;
    }
}
