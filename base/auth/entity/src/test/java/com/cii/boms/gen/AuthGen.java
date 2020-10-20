package gen;

import com.cii.bomse.base.auth.entity.*;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-29 19:47
 * @since 1.0
 */
public class AuthGen {

    public static void main(String[] args) {

//        genMenu();

//        genRole();
//        genRoleMenu();
//        genRoleUser();
//        genDataRole();
//        genDataRoleDept();
        genDataRoleUser();
    }

    public static void genMenu() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_menu";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_menu.sql";
        String basePackage = "com.cii.bomse.base.auth";


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

        list.add("menuTypeName");
        list.add("isMenu");
        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/MenuEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_menu1.sql";
        CodeGenerateUtils.generate(MenuEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genRole() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_role";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role.sql";
        String basePackage = "com.cii.bomse.base.auth";


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

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/RoleEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role1.sql";
        CodeGenerateUtils.generate(RoleEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genRoleMenu() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_role_menu";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role_menu.sql";
        String basePackage = "com.cii.bomse.base.auth";


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
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/RoleMenuEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role_menu1.sql";
        CodeGenerateUtils.generate(RoleMenuEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genRoleUser() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_role_user";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role_user.sql";
        String basePackage = "com.cii.bomse.base.auth";


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
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/RoleUserEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_role_user1.sql";
        CodeGenerateUtils.generate(RoleUserEntity.class, mapperPath, sqlPath1, tableName, list);

    }

    public static void genDataRole() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_data_role";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role.sql";
        String basePackage = "com.cii.bomse.base.auth";


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

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/DataRoleEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role1.sql";
        CodeGenerateUtils.generate(DataRoleEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genDataRoleDept() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_data_role_dept";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role_dept.sql";
        String basePackage = "com.cii.bomse.base.auth";


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
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/DataRoleDeptEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role_dept1.sql";
        CodeGenerateUtils.generate(DataRoleDeptEntity.class, mapperPath, sqlPath1, tableName, list);

    }
    public static void genDataRoleUser() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth";
        String tableName = "t_boms_auth_data_role_user";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role_user.sql";
        String basePackage = "com.cii.bomse.base.auth";


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
//        list.add("lastUpdateId");
//        list.add("lastUpdateName");
//        list.add("createTime");
//        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        list.add("menuTypeName");
//        list.add("isMenu");
//        list.add("children");

//        CodeGenerateUtils.generateModule(ContactEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/base/auth/dao/src/main/resources/META-INF/mapper/DataRoleUserEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_auth_data_role_user1.sql";
        CodeGenerateUtils.generate(DataRoleUserEntity.class, mapperPath, sqlPath1, tableName, list);

    }
}
