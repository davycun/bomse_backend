package gen;

import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupEntity;
import com.cii.bomse.crm.customer.industry.entity.CustomerIndustryFollowupHouseEntity;
import com.cii.bomse.ums.user.entity.UserEntity;
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

//        genCustomerIndustryEntity();
        genCustomerFollowupEntity();
//        genCustomerFollowupHouseEntity();

    }

    public static void genCustomerIndustryEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry";
        String tableName = "t_boms_crm_industry_customer";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer.sql";
        String basePackage = "com.cii.bomse.crm.customer.industry";

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

//        CodeGenerateUtils.generateModule(CustomerIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry/dao/src/main/resources/META-INF/mapper/CustomerIndustryEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer1.sql";
        CodeGenerateUtils.generate(CustomerIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genCustomerFollowupEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry";
        String tableName = "t_boms_crm_industry_customer_followup";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer_followup.sql";
        String basePackage = "com.cii.bomse.crm.customer.industry";

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

//        CodeGenerateUtils.generateModule(CustomerIndustryFollowupEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry/dao/src/main/resources/META-INF/mapper/CustomerIndustryFollowupEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer_followup1.sql";
        CodeGenerateUtils.generate(CustomerIndustryFollowupEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genCustomerFollowupHouseEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry";
        String tableName = "t_boms_crm_industry_customer_followup_house";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer_followup_house.sql";
        String basePackage = "com.cii.bomse.crm.customer.industry";

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

//        CodeGenerateUtils.generateModule(CustomerIndustryFollowupHouseEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/customer/industry/dao/src/main/resources/META-INF/mapper/CustomerIndustryFollowupHouseEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_industry_customer_followup_house1.sql";
        CodeGenerateUtils.generate(CustomerIndustryFollowupHouseEntity.class, mapperPath, sqlPath1, tableName, list);
    }


}
