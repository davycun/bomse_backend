package gen;

import com.cii.bomse.bi.entity.*;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-12 20:45
 * @since 1.0
 */
public class AchievementGen {

    public static void main(String[] args) {
//        genAchievement();
//        genCustomerStatisticReportEntity();
//        genCustomerChannelReportEntity();

//        genRankingReportEntity();


        genMyReportEntity();

    }

    public static void genAchievement(){

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi";
        String tableName = "t_eia_report_achievement";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement.sql";
        String basePackage = "com.cii.bomse.bi";

        List<String> list = new ArrayList<>();
//        list.add("id");
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


        list.add("customerAcceptPercentage");
        list.add("newCustomerSurveyPercentage");
        list.add("newCustomerOrderPercentage");

//        CodeGenerateUtils.generateModule(AchievementReportEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi/dao/src/main/resources/META-INF/mapper/AchievementReportEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement1.sql";
        CodeGenerateUtils.generate(AchievementReportEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genCustomerStatisticReportEntity(){

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi";
        String tableName = "t_eia_report_achievement";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement.sql";
        String basePackage = "com.cii.bomse.bi";


        List<String> list = new ArrayList<>();
//        list.add("id");
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

//        CodeGenerateUtils.generateModule(CustomerStatisticReportEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi/dao/src/main/resources/META-INF/mapper/CustomerStatisticReportEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement1.sql";
        CodeGenerateUtils.generate(CustomerStatisticReportEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genCustomerChannelReportEntity(){

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi";
        String tableName = "t_eia_report_achievement";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement.sql";
        String basePackage = "com.cii.bomse.bi";


        List<String> list = new ArrayList<>();
//        list.add("id");
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

        list.add("customerAcceptPercentage");
        list.add("newCustomerSurveyPercentage");
        list.add("newCustomerOrderPercentage");

        CodeGenerateUtils.generateModule(CustomerChannelReportEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi/dao/src/main/resources/META-INF/mapper/CustomerChannelReportEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement1.sql";
//        CodeGenerateUtils.generate(CustomerChannelReportEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genRankingReportEntity(){

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi";
        String tableName = "t_eia_report_achievement";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement.sql";
        String basePackage = "com.cii.bomse.bi";

        List<String> list = new ArrayList<>();
//        list.add("id");
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

//        list.add("customerAcceptPercentage");
//        list.add("newCustomerSurveyPercentage");
//        list.add("newCustomerOrderPercentage");

//        CodeGenerateUtils.generateModule(RankingReportEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/bi/dao/src/main/resources/META-INF/mapper/RankingReportEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_report_achievement1.sql";
        CodeGenerateUtils.generate(RankingReportEntity.class, mapperPath, sqlPath1, tableName, list);

    }

    public static void genMyReportEntity(){

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/bi";
        String tableName = "t_eia_report_myreport";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_eia_report_myreport.sql";
        String basePackage = "com.cii.bomse.bi";

        List<String> list = new ArrayList<>();
//        list.add("id");
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

        CodeGenerateUtils.generateModule(MyReportEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/bi/dao/src/main/resources/META-INF/mapper/MyReportEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_eia_report_myreport1.sql";
//        CodeGenerateUtils.generate(MyReportEntity.class, mapperPath, sqlPath1, tableName, list);

    }
}
