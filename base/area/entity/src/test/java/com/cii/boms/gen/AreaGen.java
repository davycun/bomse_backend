package gen;

import com.cii.bomse.base.area.entity.AreaCpyEntity;
import com.cii.bomse.base.area.entity.AreaEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-03 09:40
 * @since 1.0
 */
public class AreaGen {

    public static void main(String[] args) {

//        genArea();
        genCpyArea();
    }
    public static void genArea(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/area";
        String tableName = "t_cii_area_area";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_area_area.sql";
        String basePackage = "com.cii.bomse.base.area";

        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
//        list.add("createName");
        list.add("createDeptId");
        list.add("createDeptName");
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");


        list.add("areaTypeName");
        list.add("isLeaf");


        CodeGenerateUtils.generateModule(AreaEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/area/dao/src/main/resources/META-INF/mapper/AreaEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_area_area1.sql";
//        CodeGenerateUtils.generate(AreaEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genCpyArea(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/area";
        String tableName = "t_cii_area_company";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_area_company.sql";
        String basePackage = "com.cii.bomse.base.area";

        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
//        list.add("createName");
        list.add("createDeptId");
        list.add("createDeptName");
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");


        list.add("areaTypeName");
        list.add("isLeaf");


//        CodeGenerateUtils.generateModule(AreaCpyEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/area/dao/src/main/resources/META-INF/mapper/AreaCpyEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_area_company1.sql";
        CodeGenerateUtils.generate(AreaCpyEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
