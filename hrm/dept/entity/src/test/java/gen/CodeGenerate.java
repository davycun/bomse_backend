package gen;

import com.cii.bomse.hrm.dept.entity.DeptAreaEntity;
import com.cii.bomse.hrm.dept.entity.DeptConfigEntity;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.cii.bomse.hrm.dept.entity.DeptShareEntity;
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
//        genDeptEntity();
//        genDeptAreaEntity();
//        genDeptConfigEntity();
        genDeptShareEntity();
    }


    public static void genDeptEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept";
        String tableName = "t_boms_hrm_dept_dept";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept.sql";
        String basePackage = "com.cii.bomse.hrm.dept";

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


        list.add("children");

//        CodeGenerateUtils.generateModule(StreetOfficeEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept/dao/src/main/resources/META-INF/mapper/DeptEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept1.sql";
        CodeGenerateUtils.generate(DeptEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genDeptAreaEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept";
        String tableName = "t_boms_hrm_dept_dept_area";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_area.sql";
        String basePackage = "com.cii.bomse.hrm.dept";

        List<String> list = new ArrayList<>();
//        list.add("id");
        list.add("remark");
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


//        list.add("children");

        CodeGenerateUtils.generateModule(DeptAreaEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept/dao/src/main/resources/META-INF/mapper/DeptAreaEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_area1.sql";
//        CodeGenerateUtils.generate(DeptAreaEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genDeptConfigEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept";
        String tableName = "t_boms_hrm_dept_dept_config";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_config.sql";
        String basePackage = "com.cii.bomse.hrm.dept";

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
        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");


//        list.add("children");

//        CodeGenerateUtils.generateModule(DeptConfigEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept/dao/src/main/resources/META-INF/mapper/DeptConfigEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_config1.sql";
        CodeGenerateUtils.generate(DeptConfigEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genDeptShareEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept";
        String tableName = "t_boms_hrm_dept_dept_share";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_share.sql";
        String basePackage = "com.cii.bomse.hrm.dept";

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
        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");


//        list.add("children");

//        CodeGenerateUtils.generateModule(DeptShareEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/hrm/dept/dao/src/main/resources/META-INF/mapper/DeptShareEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_hrm_dept_dept_share1.sql";
        CodeGenerateUtils.generate(DeptShareEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
