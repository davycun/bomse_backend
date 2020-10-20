package com.cii.bomse.crm.tenant.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-26 17:20
 * @since 1.0
 */
@Component
public class TenantOperationType extends OperationType {

    public static final String tenantCallPhone = "tenantCallPhone";
    public static final String tenantUpdatePhone = "tenantUpdatePhone";
    public static final String tenantFollowupPhone = "tenantFollowupPhone";
    public static final String tenantFollowupScene = "tenantFollowupScene";


    @Override
    public void addChildrenDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),tenantCallPhone,"租户拨好",getParentCode()));
        list.add(new Dictionary(getKey(),tenantUpdatePhone,"修改租户号码",getParentCode()));
        list.add(new Dictionary(getKey(),tenantFollowupPhone,"电话跟进租户",getParentCode()));
        list.add(new Dictionary(getKey(),tenantFollowupScene,"现场拜访租户",getParentCode()));
    }
}
