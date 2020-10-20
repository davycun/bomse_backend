package gen;

import com.cii.bomse.crm.tenant.entity.TenantEntity;
import com.cii.bomse.crm.tenant.entity.TenantFollowupEntity;
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

        genTenantEntity();
//        genTenantFollowupEntity();
    }

    public static void genTenantEntity(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/tenant";
        String tableName = "t_boms_crm_tenant";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_tenant.sql";
        String basePackage = "com.cii.bomse.crm.tenant";

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

//        CodeGenerateUtils.generateModule(TenantEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/tenant/dao/src/main/resources/META-INF/mapper/TenantEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_tenant1.sql";
        CodeGenerateUtils.generate(TenantEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genTenantFollowupEntity(){
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/tenant";
        String tableName = "t_boms_crm_tenant_followup";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_tenant_followup.sql";
        String basePackage = "com.cii.bomse.crm.tenant";

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

//        CodeGenerateUtils.generateModule(TenantFollowupEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/tenant/dao/src/main/resources/META-INF/mapper/TenantFollowupEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_tenant_followup1.sql";
        CodeGenerateUtils.generate(TenantFollowupEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
