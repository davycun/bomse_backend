package com.cii.bomse.house.industry.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-12-07 21:34
 * @since 1.0
 */
@Component
public class UploadType extends ClassKeyDictionaryProvider<UploadType> {
    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"卸货类型"));
        list.add(new Dictionary(getKey(),"one","单面卸货",getParentCode()));
        list.add(new Dictionary(getKey(),"two","双面卸货",getParentCode()));
        list.add(new Dictionary(getKey(),"three","三面卸货",getParentCode()));
        list.add(new Dictionary(getKey(),"four","四面卸货",getParentCode()));

        return list;
    }
}
