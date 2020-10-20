package gen;

import com.cii.bomse.house.base.entity.HouseOwnerEntity;
import com.cii.bomse.house.base.entity.ParkOwnerRelationEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-30 09:21
 * @since 1.0
 */
public class CodeGenerate {

    public static void main(String[] args) {

//        genHouseOwnerEntity();

        genParkOwnerRelationEntity();
    }

    public static void genHouseOwnerEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/base";
        String tableName = "t_boms_house_owner";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_owner.sql";
        String basePackage = "com.cii.bomse.house.base";

        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
//        list.add("ownerId");
//        list.add("ownerName");
//        list.add("ownerDeptId");
//        list.add("ownerDeptName");
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


        list.add("sexName");
        list.add("ownTypeName");

        CodeGenerateUtils.generateModule(HouseOwnerEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/base/dao/src/main/resources/META-INF/mapper/HouseOwnerEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_owner1.sql";
//        CodeGenerateUtils.generate(HouseOwnerEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genParkOwnerRelationEntity(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/base";
        String tableName = "t_boms_house_industry_park_owner";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_park_owner.sql";
        String basePackage = "com.cii.bomse.house.base";

        List<String> list = new ArrayList<>();

//        list.add("id");
        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
//        list.add("createName");
//        list.add("createDeptId");
//        list.add("createDeptName");
        list.add("lastUpdateId");
        list.add("lastUpdateName");
//        list.add("createTime");
        list.add("lastUpdateTime");
        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

        CodeGenerateUtils.generateModule(ParkOwnerRelationEntity.class, modulePath, sqlPath, tableName, basePackage, list);
//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/HouseIndustryEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_house1.sql";
//        CodeGenerateUtils.generate(HouseIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
