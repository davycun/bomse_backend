package com.cii.bomse.house.land.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-24 16:26
 * @since 1.0
 */
@Component
public class BlankLandOperationType extends OperationType {

    public static final String blankCallPhone = "blankCallPhone";
    @Override
    public void addChildrenDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),blankCallPhone,"联系场地业主",getParentCode()));

    }
}
