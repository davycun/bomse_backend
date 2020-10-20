package com.cii.bomse.hrm.emp.dictionary;

import com.ciiframework.dictionary.ClassKeyDictionaryProvider;
import com.ciiframework.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/17 00:08
 */
@Component
public class EducationType extends ClassKeyDictionaryProvider<EducationType> {


    public static final String GaoZhong="GaoZhong";
    public static final String ZhongZhuan="ZhongZhuan";
    public static final String ZiKaoDaZhuan="ZiKaoDaZhuan";
    public static final String DaZhuan="DaZhuan";
    public static final String ZiKaoBenKe="ZiKaoBenKe";
    public static final String BenKe="BenKe";
    public static final String ShuoShi="ShuoShi";
    public static final String BoShi="BoShi";

    @Override
    public List<Dictionary> addDictionary(List<Dictionary> list) {

        list.add(new Dictionary(getKey(),getParentCode(),"学历"));
        list.add(new Dictionary(getKey(),GaoZhong,"高中",getParentCode()));
        list.add(new Dictionary(getKey(),ZhongZhuan,"中专",getParentCode()));
        list.add(new Dictionary(getKey(),ZiKaoDaZhuan,"自考大专",getParentCode()));
        list.add(new Dictionary(getKey(),DaZhuan,"大专",getParentCode()));
        list.add(new Dictionary(getKey(),ZiKaoBenKe,"自考本科",getParentCode()));
        list.add(new Dictionary(getKey(),BenKe,"本科",getParentCode()));
        list.add(new Dictionary(getKey(),ShuoShi,"硕士",getParentCode()));
        list.add(new Dictionary(getKey(),BoShi,"博士",getParentCode()));

        return list;
    }
}
