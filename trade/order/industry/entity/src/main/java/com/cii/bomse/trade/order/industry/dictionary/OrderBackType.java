package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-07 14:03
 * @since 1.0
 */
@Component
public class OrderBackType extends ClassKeyDictionaryProvider<OrderBackType> {

    public static final String ReceiveMoney = "ReceiveMoney";
    public static final String BadMoney = "BadMoney";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"回款类型"));
        list.add(new Dictionary(getKey(),ReceiveMoney,"收款",getParentCode()));
        list.add(new Dictionary(getKey(),BadMoney,"坏账",getParentCode()));

        return list;
    }
}
