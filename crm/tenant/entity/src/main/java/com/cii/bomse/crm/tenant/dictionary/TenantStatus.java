package com.cii.bomse.crm.tenant.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-25 21:14
 * @since 1.0
 */
@Component
public class TenantStatus extends ClassKeyDictionaryProvider<TenantStatus> {

    public static final String Leasing="Leasing";
    public static final String UnLease="UnLease";

    @Override
    public List<Dictionary> addDictionary(List list) {

        list.add(new Dictionary(getKey(),getParentCode(),"租户状态"));
        list.add(new Dictionary(getKey(),Leasing,"在租",getParentCode()));
        list.add(new Dictionary(getKey(),UnLease,"退租",getParentCode()));

        return list;
    }
}
