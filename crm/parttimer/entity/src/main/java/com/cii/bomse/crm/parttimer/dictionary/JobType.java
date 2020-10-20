package com.cii.bomse.crm.parttimer.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-04 15:24
 * @since 1.0
 */
@Deprecated
//@Component
public class JobType extends DatabaseDictionaryProvider<JobType> {
    @Override
    public String getParentDictionaryName() {
        return "职业";
    }
}
