package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-07-20 09:55
 * @since 1.0
 */
@Component
public class OrderDivideType extends DatabaseDictionaryProvider<OrderDivideType> {

    @Override
    public String getParentDictionaryName() {
        return "订单分成类型";
    }
}
