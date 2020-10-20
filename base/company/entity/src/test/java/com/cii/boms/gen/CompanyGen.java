package gen;

import com.cii.bomse.base.cpy.entity.CompanyEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-29 13:40
 * @since 1.0
 */
public class CompanyGen {
    public static void main(String[] args) {
        genCompanyEntity();
    }

    public static void genCompanyEntity() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/company";
        String tableName = "t_cii_cpy_company";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/table_approval_contact.sql";
        String basePackage = "com.cii.bomse.base.cpy";


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
//        list.add("cpyName");

//        CodeGenerateUtils.generateModule(CompanyEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/company/dao/src/main/resources/META-INF/mapper/CompanyEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_cii_cpy_company1.sql";
        CodeGenerateUtils.generate(CompanyEntity.class, mapperPath, sqlPath1, tableName, list);

    }
}
