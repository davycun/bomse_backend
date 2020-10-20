package com.cii.bomse.house.base.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * 综合用地，表示两种及以上的用地，比如商住两用
 * @auth david·cun
 * @date 2019-12-06 15:39
 * @since 1.0
 */
@Component
public class LandUseType extends ClassKeyDictionaryProvider<LandUseType> {


    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"土地性质"));
        list.add(new Dictionary(getKey(),"Live","居住用地",getParentCode()));
        list.add(new Dictionary(getKey(),"Business","商业用地",getParentCode()));
        list.add(new Dictionary(getKey(),"Industry","工业用地",getParentCode()));
        list.add(new Dictionary(getKey(),"Warehouse","物流仓储用地",getParentCode()));
        list.add(new Dictionary(getKey(),"Multiple","综合用地",getParentCode()));

        return list;
    }
}
