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
public class OrderBackChannel extends ClassKeyDictionaryProvider<OrderBackChannel> {
    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"回款渠道"));
        list.add(new Dictionary(getKey(),"AliPay","支付宝",getParentCode()));
        list.add(new Dictionary(getKey(),"WxPay","微信",getParentCode()));
        list.add(new Dictionary(getKey(),"Cash","现金",getParentCode()));
        list.add(new Dictionary(getKey(),"Bank","银行",getParentCode()));
        list.add(new Dictionary(getKey(),"Other","其他",getParentCode()));

        return list;
    }
}
