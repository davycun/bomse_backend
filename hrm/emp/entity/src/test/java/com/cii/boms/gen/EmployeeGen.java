package gen;

import com.cii.bomse.hrm.emp.entity.EmployeeEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeQuitEntity;
import com.cii.bomse.hrm.emp.entity.EmployeeTransferEntity;
import com.cii.bomse.hrm.emp.entity.PostEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-08-30 09:21
 * @since 1.0
 */
public class EmployeeGen {

    public static void main(String[] args) {

//        genEmployeeEntity();
//        genPostEntity();

        genEmployeeQuitEntity();
        genEmployeeTransferEntity();
    }

    public static void genEmployeeEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp";
        String tableName = "t_eia_hrm_emp_employee";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_employee.sql";
        String basePackage = "com.cii.bomse.hrm.emp";

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
//        list.add("cpyName");


        list.add("sexName");
        list.add("educationTypeName");
        list.add("marryTypeName");
        list.add("householdRegisterTypeName");

//        CodeGenerateUtils.generateModule(StreetOfficeEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp/dao/src/main/resources/META-INF/mapper/EmployeeEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_employee1.sql";
        CodeGenerateUtils.generate(EmployeeEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genPostEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp";
        String tableName = "t_eia_hrm_emp_post";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_post.sql";
        String basePackage = "com.cii.bomse.hrm.emp";

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

//        CodeGenerateUtils.generateModule(StreetOfficeEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp/dao/src/main/resources/META-INF/mapper/PostEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_post1.sql";
        CodeGenerateUtils.generate(PostEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genEmployeeQuitEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp";
        String tableName = "t_eia_hrm_emp_quit";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_quit.sql";
        String basePackage = "com.cii.bomse.hrm.emp";

        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
        list.add("createName");
        list.add("createDeptId");
        list.add("createDeptName");
        list.add("lastUpdateId");
        list.add("lastUpdateName");
//        list.add("createTime");
        list.add("lastUpdateTime");
        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

        CodeGenerateUtils.generateModule(EmployeeQuitEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp/dao/src/main/resources/META-INF/mapper/EmployeeQuitEntity1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_quit1.sql";
//        CodeGenerateUtils.generate(EmployeeQuitEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genEmployeeTransferEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp";
        String tableName = "t_eia_hrm_emp_transfer";
        String sqlPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_transfer.sql";
        String basePackage = "com.cii.bomse.hrm.emp";

        List<String> list = new ArrayList<>();
//        list.add("id");
//        list.add("remark");
        list.add("ownerId");
        list.add("ownerName");
        list.add("ownerDeptId");
        list.add("ownerDeptName");
//        list.add("createId");
        list.add("createName");
        list.add("createDeptId");
        list.add("createDeptName");
        list.add("lastUpdateId");
        list.add("lastUpdateName");
//        list.add("createTime");
        list.add("lastUpdateTime");
        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

        CodeGenerateUtils.generateModule(EmployeeTransferEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/hrm/emp/dao/src/main/resources/META-INF/mapper/EmployeeTransferEntity1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/kufangwuyou/website/10Code/trunk/eia/sql/t_eia_hrm_emp_transfer1.sql";
//        CodeGenerateUtils.generate(EmployeeTransferEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
