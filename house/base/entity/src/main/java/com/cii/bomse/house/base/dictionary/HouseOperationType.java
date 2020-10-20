package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.Dictionary;
import com.ciiframework.log.dictionary.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2020-01-03 15:32
 * @since 1.0
 */
@Component
public class HouseOperationType extends OperationType {

    public static final String seeParkDetail="seeParkDetail";
    public static final String seeFloorDetail="seeFloorDetail";
    public static final String createPark="createPark";
    public static final String updatePark="updatePark";
    public static final String createBuilding="createBuilding";
    public static final String updateBuilding="updateBuilding";
    public static final String createFloor="createFloor";
    public static final String updateFloor="updateFloor";
    public static final String parkFollowupPhone="parkFollowupPhone";
    public static final String parkFollowupScene="parkFollowupScene";

    @Override
    public void addChildrenDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),seeParkDetail,"查看园区详情",getParentCode()));
        list.add(new Dictionary(getKey(),seeFloorDetail,"查看楼层详情",getParentCode()));
        list.add(new Dictionary(getKey(),createPark,"新增园区信息",getParentCode()));
        list.add(new Dictionary(getKey(),updatePark,"修改园区信息",getParentCode()));
        list.add(new Dictionary(getKey(),createBuilding,"新增楼栋信息",getParentCode()));
        list.add(new Dictionary(getKey(),updateBuilding,"修改楼栋信息",getParentCode()));
        list.add(new Dictionary(getKey(),createFloor,"新增楼层信息",getParentCode()));
        list.add(new Dictionary(getKey(),updateFloor,"修改楼层信息",getParentCode()));
        list.add(new Dictionary(getKey(),parkFollowupPhone,"电话跟进园区",getParentCode()));
        list.add(new Dictionary(getKey(),parkFollowupScene,"上门拜访园区",getParentCode()));
    }
}
