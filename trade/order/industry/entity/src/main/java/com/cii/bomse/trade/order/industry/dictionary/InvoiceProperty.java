package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-08 16:49
 * @since 1.0
 */
@Component
public class InvoiceProperty extends ClassKeyDictionaryProvider<InvoiceProperty> {

    public static final String Electronics = "Electronics";
    public static final String Paper = "Paper";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"发票性质"));
        list.add(new Dictionary(getKey(),Electronics,"电子发票",getParentCode()));
        list.add(new Dictionary(getKey(),Paper,"纸质发票",getParentCode()));

        return list;
    }
}
