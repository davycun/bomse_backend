package com.cii.bomse.trade.order.industry.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-02 13:39
 * @since 1.0
 */
@Component
public class OrderExpensesType extends DatabaseDictionaryProvider<OrderExpensesType> {

    @Override
    public String getParentDictionaryName() {
        return "订单支出类型";
    }
}
