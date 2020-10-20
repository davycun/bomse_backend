package gen;

import com.cii.bomse.house.industry.entity.*;
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

//        genParkIndustryEntity();
//        genBuildingIndustryEntity();
//        genFloorIndustryEntity();
//        genHouseIndustryEntity();

//        genParkFollowupEntity();

    }

    public static void genParkIndustryEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry";
        String tableName = "t_boms_house_industry_park";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_park.sql";
        String basePackage = "com.cii.bomse.house.industry";

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

//        CodeGenerateUtils.generateModule(ParkIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/ParkIndustryEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_park1.sql";
        CodeGenerateUtils.generate(ParkIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genBuildingIndustryEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry";
        String tableName = "t_boms_house_industry_building";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_building.sql";
        String basePackage = "com.cii.bomse.house.industry";

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

//        CodeGenerateUtils.generateModule(BuildingIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/BuildingIndustryEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_building1.sql";
        CodeGenerateUtils.generate(BuildingIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genFloorIndustryEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry";
        String tableName = "t_boms_house_industry_floor";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_floor.sql";
        String basePackage = "com.cii.bomse.house.industry";

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

//        CodeGenerateUtils.generateModule(FloorIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/FloorIndustryEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_floor1.sql";
        CodeGenerateUtils.generate(FloorIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genHouseIndustryEntity(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry";
        String tableName = "t_boms_house_industry_house";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_house.sql";
        String basePackage = "com.cii.bomse.house.industry";

        List<String> list = new ArrayList<>();

        list.add("id");
        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
        list.add("createId");
        list.add("createName");
        list.add("createDeptId");
        list.add("createDeptName");
        list.add("lastUpdateId");
        list.add("lastUpdateName");
        list.add("createTime");
        list.add("lastUpdateTime");
        list.add("isDeleted");
        list.add("cpyId");
        list.add("cpyName");

        CodeGenerateUtils.generateModule(HouseIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);
//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/HouseIndustryEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_house1.sql";
//        CodeGenerateUtils.generate(HouseIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genParkFollowupEntity(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry";
        String tableName = "t_boms_house_industry_park_followup";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_park_followup.sql";
        String basePackage = "com.cii.bomse.house.industry";

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
        list.add("lastUpdateId");
        list.add("lastUpdateName");
//        list.add("createTime");
        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        CodeGenerateUtils.generateModule(ParkIndustryFollowupEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/house/industry/dao/src/main/resources/META-INF/mapper/ParkIndustryFollowupEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_house_industry_park_followup1.sql";
        CodeGenerateUtils.generate(ParkIndustryFollowupEntity.class, mapperPath, sqlPath1, tableName, list);
    }

}
