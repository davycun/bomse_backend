package com.cii.bomse.base.news.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资讯类型
 */
@Component
public class NewsType extends ClassKeyDictionaryProvider<NewsType> {


    public static final String HangYeBaoGao = "HangYeBaoGao";
    public static final String HangYeYaoWen = "HangYeYaoWen";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {
        list.add(new Dictionary(getKey(), getParentCode(), "资讯类型"));
        list.add(new Dictionary(getKey(), HangYeBaoGao, "行业报告", getParentCode()));
        list.add(new Dictionary(getKey(), HangYeYaoWen, "行业要闻", getParentCode()));
        return list;
    }
}
