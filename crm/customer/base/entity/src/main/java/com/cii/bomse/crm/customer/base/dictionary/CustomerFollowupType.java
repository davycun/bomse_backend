package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-20 17:04
 * @since 1.0
 */
@Component
public class CustomerFollowupType extends ClassKeyDictionaryProvider<CustomerFollowupType> {

    public static final String Phone = "Phone";
    public static final String Scene = "Scene";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"客户跟进类型"));
        list.add(new Dictionary(getKey(),Phone,"电话跟进",getParentCode()));
        list.add(new Dictionary(getKey(),Scene,"实地带看",getParentCode()));
        return list;
    }
}
