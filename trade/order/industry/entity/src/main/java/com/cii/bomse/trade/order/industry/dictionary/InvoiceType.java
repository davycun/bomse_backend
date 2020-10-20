package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-08 16:44
 * @since 1.0
 */
@Component
public class InvoiceType extends ClassKeyDictionaryProvider<InvoiceType> {

    public static final String General = "General";
    public static final String Special = "Special";
    public static final String GovGeneral = "GovGeneral";
    public static final String Person = "Person";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"发票类型"));
        list.add(new Dictionary(getKey(),General,"企业增值税普通发票",getParentCode()));
        list.add(new Dictionary(getKey(),Special,"增值税专用发票",getParentCode()));
        list.add(new Dictionary(getKey(),GovGeneral,"组织（非企业）增值税普通发票",getParentCode()));
        list.add(new Dictionary(getKey(),Person,"个人",getParentCode()));
        return list;
    }
}
