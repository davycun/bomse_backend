package gen;

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
public class UserGen {

    public static void main(String[] args) {

//        genUserEntity();
    }

    public static void genUserEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/ums/user";
        String tableName = "t_boms_ums_user";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_ums_user.sql";
        String basePackage = "com.cii.bomse.ums.user";

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

//        CodeGenerateUtils.generateModule(UserEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/ums/user/dao/src/main/resources/META-INF/mapper/UserEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_ums_user1.sql";
        CodeGenerateUtils.generate(UserEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
