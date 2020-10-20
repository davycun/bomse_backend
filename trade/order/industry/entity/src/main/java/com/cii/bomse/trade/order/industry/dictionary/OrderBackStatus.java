package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-07 14:06
 * @since 1.0
 */
@Component
public class OrderBackStatus extends ClassKeyDictionaryProvider<OrderBackStatus> {

    public static final String WaitConfirm = "WaitConfirm";
    public static final String HasConfirm = "HasConfirm";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"回款状态"));
        list.add(new Dictionary(getKey(),"WaitConfirm","待认领",getParentCode()));
        list.add(new Dictionary(getKey(),"HasConfirm","已认领",getParentCode()));

        return list;
    }
}
