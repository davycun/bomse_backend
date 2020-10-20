package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description 客户状态
 * @auth david·cun
 * @date 2019-04-27 18:13
 * @since 1.0
 */
@Component
public class CustomerStatus extends ClassKeyDictionaryProvider<CustomerStatus> {

    public static final String WaitProcess = "WaitProcess";
    public static final String Followup = "Followup";
    public static final String HasDown = "HasDown";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),getParentCode(),"客户状态"));
        list.add(new Dictionary(getKey(),WaitProcess,"待处理",getParentCode()));
        list.add(new Dictionary(getKey(),Followup,"跟进中",getParentCode()));
        list.add(new Dictionary(getKey(),HasDown,"已租好",getParentCode()));
        return list;
    }

}
