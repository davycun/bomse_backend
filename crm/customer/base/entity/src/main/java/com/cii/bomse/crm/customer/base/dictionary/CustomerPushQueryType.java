package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-26 18:10
 * @since 1.0
 */
@Component
public class CustomerPushQueryType extends ClassKeyDictionaryProvider<CustomerPushQueryType> {

    public static final String push="push";
    public static final String receive="receive";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"客户推送查询类型"));
        list.add(new Dictionary(getKey(),push,"我推送的",getParentCode()));
        list.add(new Dictionary(getKey(),receive,"推送给我的",getParentCode()));

        return list;
    }
}
