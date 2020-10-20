package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-27 14:55
 * @since 1.0
 */
@Component
public class CustomerFileUse extends ClassKeyDictionaryProvider<CustomerFileUse> {

    public static final String SeeHouse = "SeeHouse";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),getParentCode(),"客户图片用途"));
        list.add(new Dictionary(getKey(),SeeHouse,"带看",getParentCode()));

        return list;
    }

}
