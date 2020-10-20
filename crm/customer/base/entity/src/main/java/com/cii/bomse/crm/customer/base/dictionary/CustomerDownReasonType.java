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
public class CustomerDownReasonType extends ClassKeyDictionaryProvider<CustomerDownReasonType> {

    public static final String waiBuChengJiao = "waiBuChengJiao";
    public static final String neiBuChengJiao = "neiBuChengJiao";
    public static final String keHuBuZhaoLe = "keHuBuZhaoLe";
    public static final String quYuBuFuGai = "quYuBuFuGai";
    public static final String haoMaKongHao = "haoMaKongHao";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"客户下架原因"));
        list.add(new Dictionary(getKey(),waiBuChengJiao,"外部成交",getParentCode()));
        list.add(new Dictionary(getKey(),neiBuChengJiao,"内部成交",getParentCode()));
        list.add(new Dictionary(getKey(),keHuBuZhaoLe,"客户不找了",getParentCode()));
        list.add(new Dictionary(getKey(),quYuBuFuGai,"区域不覆盖",getParentCode()));
        list.add(new Dictionary(getKey(),haoMaKongHao,"号码空号",getParentCode()));

        return list;
    }

}
