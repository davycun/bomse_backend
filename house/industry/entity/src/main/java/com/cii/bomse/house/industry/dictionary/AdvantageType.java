package com.cii.bomse.house.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-27 10:25
 * @since 1.0
 */
@Component
public class AdvantageType extends ClassKeyDictionaryProvider<AdvantageType> {

    public static final String noTax = "noTax";
    public static final String canRegistry = "canRegistry";
    public static final String hasMonitor = "hasMonitor";
    public static final String hasGuard = "hasGuard";
    public static final String hasCanteen = "hasCanteen";
    public static final String hasOffice = "hasOffice";
    public static final String hasParkingSpace = "hasParkingSpace";
    public static final String singlePark = "singlePark";
    public static final String singleFloor = "singleFloor";
    public static final String hasLift = "hasLift";
    public static final String hasRailway = "hasRailway";
    public static final String hasCanopy = "hasCanopy";
    public static final String hasBridgeCrane = "hasBridgeCrane";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(), getParentCode(), "房源特色"));
        list.add(new Dictionary(getKey(), noTax, "无税收", getParentCode()));
        list.add(new Dictionary(getKey(), canRegistry, "可注册", getParentCode()));
        list.add(new Dictionary(getKey(), hasMonitor, "有监控", getParentCode()));
        list.add(new Dictionary(getKey(), hasGuard, "有安保", getParentCode()));
        list.add(new Dictionary(getKey(), hasCanteen, "配食堂", getParentCode()));
        list.add(new Dictionary(getKey(), hasOffice, "配办公", getParentCode()));
        list.add(new Dictionary(getKey(), hasParkingSpace, "有停车位", getParentCode()));
        list.add(new Dictionary(getKey(), singlePark, "独门独院", getParentCode()));
        list.add(new Dictionary(getKey(), singleFloor, "单层", getParentCode()));
        list.add(new Dictionary(getKey(), hasLift, "有货梯", getParentCode()));
        list.add(new Dictionary(getKey(), hasRailway, "有月台", getParentCode()));
        list.add(new Dictionary(getKey(), hasCanopy, "有雨棚", getParentCode()));
        list.add(new Dictionary(getKey(), hasBridgeCrane, "有行车", getParentCode()));

        return list;
    }
}
