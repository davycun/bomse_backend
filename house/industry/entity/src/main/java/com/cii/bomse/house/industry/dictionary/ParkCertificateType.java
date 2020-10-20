package com.cii.bomse.house.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-06 15:24
 * @since 1.0
 */
@Component
public class ParkCertificateType extends ClassKeyDictionaryProvider<ParkCertificateType> {

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(), getParentCode(), "园区证件类型"));
        list.add(new Dictionary(getKey(), "LandCert", "土地证", getParentCode()));
        list.add(new Dictionary(getKey(), "FireCert", "消防证", getParentCode()));
        list.add(new Dictionary(getKey(), "RecordCert", "竣工验收备案", getParentCode()));
        list.add(new Dictionary(getKey(), "HouseCert", "房产证", getParentCode()));
        return list;
    }
}
