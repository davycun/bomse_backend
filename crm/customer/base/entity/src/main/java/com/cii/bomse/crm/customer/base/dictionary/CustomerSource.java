package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-06-19 16:26
 * @since 1.0
 */
@Component
public class CustomerSource extends DatabaseDictionaryProvider<CustomerSource> {
    @Override
    public String getParentDictionaryName() {
        return "客户来源";
    }
}
