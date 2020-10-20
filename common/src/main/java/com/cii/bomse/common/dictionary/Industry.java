package com.cii.bomse.common.dictionary;

import com.ciiframework.dictionary.manager.DatabaseDictionaryProvider;
import org.springframework.stereotype.Component;

/**
 * @description 行业
 * @auth david·cun
 * @date 2019-04-28 22:23
 * @since 1.0
 */
@Component
public class Industry extends DatabaseDictionaryProvider<Industry> {

//    @Override
//    public List<Dictionary> produce() {
//        List<Dictionary> list = new ArrayList<>();
//        list.add(new Dictionary(getKey(),getParentCode(),"行业"));
//        list.add(new Dictionary(getKey(),"1","农副食品加工业",getParentCode()));
//        list.add(new Dictionary(getKey(),"2","食品加工业",getParentCode()));
//        list.add(new Dictionary(getKey(),"3","饮料制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"4","酒加工",getParentCode()));
//        list.add(new Dictionary(getKey(),"5","烟草制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"8","纺织业",getParentCode()));
//        list.add(new Dictionary(getKey(),"9","纺织服装、鞋、帽制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"10","皮革、毛皮、羽毛、绒制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"11","木材加工及木、竹、藤、棕、草制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"12","家具制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"13","造纸及纸制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"14","印刷业和记录媒介的复制",getParentCode()));
//        list.add(new Dictionary(getKey(),"15","文教体育用品制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"16","石油加工、炼焦及核燃料加工业",getParentCode()));
//        list.add(new Dictionary(getKey(),"17","化学原料及化学制品制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"18","医药制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"19","橡胶制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"20","塑料制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"21","金属制品业",getParentCode()));
//        list.add(new Dictionary(getKey(),"22","通用设备制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"23","专用设备制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"24","交通运输设备制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"25","电气机械及器材制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"26","通信设备、计算机及其他电子设备制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"27","仪器仪表及文化、办公用机械制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"28","工艺品制造业",getParentCode()));
//        list.add(new Dictionary(getKey(),"29","废弃资源和废旧材料回收加工业",getParentCode()));
//        list.add(new Dictionary(getKey(),"30","电力、热力的生产和供应业",getParentCode()));
//        list.add(new Dictionary(getKey(),"31","电商、零售",getParentCode()));
//        list.add(new Dictionary(getKey(),"32","物流",getParentCode()));
//        return list;
//    }



    @Override
    public String getParentDictionaryName() {
        return "行业类型";
    }
}
