package com.cii.bomse.base.area.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-04-29 12:35
 * @since 1.0
 */
@Component
public class AreaType extends ClassKeyDictionaryProvider<AreaType> {

    public static final String Province = "Province";
    public static final String City = "City";
    public static final String Region = "Region";
    public static final String Street = "Street";
    public static final String Community = "Community";


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(), getParentCode(), "行政区类型"));
        list.add(new Dictionary(getKey(), Province, "省", getParentCode()));
        list.add(new Dictionary(getKey(), City, "市", getParentCode()));
        list.add(new Dictionary(getKey(), Region, "区", getParentCode()));
        list.add(new Dictionary(getKey(), Street, "街道", getParentCode()));
        list.add(new Dictionary(getKey(), Community, "社区", getParentCode()));
        return list;
    }
}
