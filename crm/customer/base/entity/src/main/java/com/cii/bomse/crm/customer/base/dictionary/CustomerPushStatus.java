package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-12 09:37
 * @since 1.0
 */
@Component
public class CustomerPushStatus extends ClassKeyDictionaryProvider<CustomerPushStatus> {

    public static final String WaitReceive = "WaitReceive";
    public static final String HasReceive = "HasReceive";
    public static final String HasRefuse = "HasRefuse";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"客户推送状态"));
        list.add(new Dictionary(getKey(),WaitReceive,"待接收",getParentCode()));
        list.add(new Dictionary(getKey(),HasReceive,"已接收",getParentCode()));
        list.add(new Dictionary(getKey(),HasRefuse,"已拒绝",getParentCode()));
        return list;
    }
}
