package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-27 15:20
 * @since 1.0
 */
@Component
public class OrderBadBackReason extends DatabaseDictionaryProvider<OrderBadBackReason> {
    @Override
    public String getParentDictionaryName() {
        return "订单坏账原因";
    }

    @Override
    public Boolean getSupportAlone() {
        return false;
    }
}
