package com.cii.bomse.crm.customer.base.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-20 09:13
 * @since 1.0
 */
@Component
public class CustomerOperationType extends OperationType {

    public static String cusSeePhone ="customerSeePhone";
    public static String cusFollowupPhone="cusFollowupPhone";
    public static String cusFollowupScene="cusFollowupScene";
    public static String cusUp ="cusUp";
    public static String cusDown ="cusDown";
    public static String cusHide ="cusHide";
    public static String cusOpen ="cusOpen";
    public static String cusPhoneUpdate ="cusPhoneUpdate";
    public static String cusPush = "cusPush";
    public static String cusPushReceive = "cusPushReceive";
    public static String cusPushRefuse = "cusPushRefuse";

    @Override
    public void addChildrenDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),cusSeePhone,"查看客户号码",getParentCode()));
        list.add(new Dictionary(getKey(),cusFollowupPhone,"电话跟进客户",getParentCode()));
        list.add(new Dictionary(getKey(),cusFollowupScene,"客户带看",getParentCode()));
        list.add(new Dictionary(getKey(),cusUp,"上架客户",getParentCode()));
        list.add(new Dictionary(getKey(),cusDown,"下架客户",getParentCode()));
        list.add(new Dictionary(getKey(),cusHide,"拉私客户",getParentCode()));
        list.add(new Dictionary(getKey(),cusOpen,"公开客户",getParentCode()));
        list.add(new Dictionary(getKey(),cusPhoneUpdate,"更新客户号码",getParentCode()));
        list.add(new Dictionary(getKey(),cusPush,"客户推送",getParentCode()));
        list.add(new Dictionary(getKey(),cusPushReceive,"接受客户推送",getParentCode()));
        list.add(new Dictionary(getKey(),cusPushRefuse,"拒绝客户推送",getParentCode()));
    }
}
