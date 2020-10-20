package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-08 16:54
 * @since 1.0
 */
@Component
public class InvoiceStatus extends ClassKeyDictionaryProvider<InvoiceStatus> {

    public static final String Applying = "Applying";
    public static final String HasMail = "HasMail";
    public static final String HasSend = "HasSend";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"发票状态"));
        list.add(new Dictionary(getKey(),Applying,"申请中",getParentCode()));
        list.add(new Dictionary(getKey(),HasMail,"已邮寄",getParentCode()));
        list.add(new Dictionary(getKey(),HasSend,"已发送",getParentCode()));

        return list;
    }
}
