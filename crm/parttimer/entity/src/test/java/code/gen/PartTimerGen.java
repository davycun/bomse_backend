package code.gen;

import com.cii.bomse.crm.parttimer.entity.PartTimerEntity;
import com.ciiframework.common.generator.CodeGenerateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-29 21:53
 * @since 1.0
 */
public class PartTimerGen {

    public static void main(String[] args) {

        genPartTimer();
    }

    public static void genPartTimer() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/parttimer";
        String tableName = "t_boms_crm_parttimer";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_parttimer.sql";
        String basePackage = "com.cii.bomse.crm.parttimer";

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
        list.add("ptTypeName");
        list.add("fromTypeName");

//        CodeGenerateUtils.generateModule(PartTimerEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/crm/parttimer/dao/src/main/resources/META-INF/mapper/PartTimerEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_crm_parttimer1.sql";
        CodeGenerateUtils.generate(PartTimerEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
