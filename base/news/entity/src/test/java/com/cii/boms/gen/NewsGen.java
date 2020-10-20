package gen;

import com.cii.bomse.base.news.entity.NewsEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-29 20:56
 * @since 1.0
 */
public class NewsGen {

    public static void main(String[] args) {

        genNews();
    }

    public static void genNews() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/news";
        String tableName = "t_cii_news_news";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_news_news.sql";
        String basePackage = "com.cii.bomse.base.news";


        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
//        list.add("createName");
//        list.add("createDeptId");
//        list.add("createDeptName");
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

        list.add("newsTypeName");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/news/dao/src/main/resources/META-INF/mapper/NewsEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_news_news1.sql";
        CodeGenerateUtils.generate(NewsEntity.class, mapperPath, sqlPath1, tableName, list);

    }
}
