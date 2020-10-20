package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 14:44
 * @since 1.0
 */
@Component
public class CustomerOwnerType extends ClassKeyDictionaryProvider<CustomerOwnerType> {

    public static final String Personal = "Personal";
    public static final String Company = "Company";
    public static final String Hide = "Hide";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"客户类型"));
        list.add(new Dictionary(getKey(),Personal,"个人客户",getParentCode()));
        list.add(new Dictionary(getKey(),Company,"部门公盘",getParentCode()));
        list.add(new Dictionary(getKey(),Hide,"公盘拉私",getParentCode()));

        return list;
    }
}
