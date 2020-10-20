package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-01-03 14:05
 * @since 1.0
 */
@Component
public class HouseOwnerOperationType extends OperationType {

    public static final String updateOwnerPhone="updateOwnerPhone";
    public static final String callOwnerPhone="callOwnerPhone";
    @Override
    public void addChildrenDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(),updateOwnerPhone,"修改业主号码",getParentCode()));
        list.add(new Dictionary(getKey(),callOwnerPhone,"拨打业主号码",getParentCode()));
    }
}
