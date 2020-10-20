package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-07-15 12:46
 * @since 1.0
 */
@Component
public class OrderStatus extends ClassKeyDictionaryProvider<OrderStatus> {

    public static final String WaitBack = "WaitBack";
    public static final String PartBack = "PartBack";
    public static final String HasBack = "HasBack";
    public static final String BadBack = "BadBack";
    public static final String HasCancel = "HasCancel";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(), getParentCode(), "订单状态"));
        list.add(new Dictionary(getKey(), WaitBack, "待回款", getParentCode()));
        list.add(new Dictionary(getKey(), PartBack, "部分回款", getParentCode()));
        list.add(new Dictionary(getKey(), HasBack, "已回款", getParentCode()));
        list.add(new Dictionary(getKey(), BadBack, "已回款(有坏账)", getParentCode()));
        list.add(new Dictionary(getKey(), HasCancel, "已取消", getParentCode()));
        return list;
    }

}
