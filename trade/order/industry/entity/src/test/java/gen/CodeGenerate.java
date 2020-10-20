package gen;

import com.cii.bomse.trade.order.industry.entity.*;
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

//        genOrderIndustryEntity();
//        genOrderIndustryHouseEntity();

//        genOrderIndustryDivideEntity();
//        genOrderIndustryExpensesEntity();
//        genOrderIndustryBack();
//        genOrderIndustryInvoiceEntity();
//        genOrderIndustryInvoiceRelationEntity();
    }

    public static void genOrderIndustryEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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

//        CodeGenerateUtils.generateModule(OrderIndustryEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order1.sql";
        CodeGenerateUtils.generate(OrderIndustryEntity.class, mapperPath, sqlPath1, tableName, list);
    }
    public static void genOrderIndustryHouseEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_house";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_house.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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
        list.add("createTime");
        list.add("lastUpdateTime");
//        list.add("isDeleted");
//        list.add("cpyId");
        list.add("cpyName");

//        CodeGenerateUtils.generateModule(OrderIndustryHouseEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryHouseEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_house1.sql";
        CodeGenerateUtils.generate(OrderIndustryHouseEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genOrderIndustryDivideEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_divide";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_divide.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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

//        CodeGenerateUtils.generateModule(OrderIndustryDivideEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryDivideEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_divide1.sql";
        CodeGenerateUtils.generate(OrderIndustryDivideEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genOrderIndustryExpensesEntity() {

        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_expenses";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_expenses.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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


//        CodeGenerateUtils.generateModule(OrderIndustryExpensesEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryExpensesEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_expenses1.sql";
        CodeGenerateUtils.generate(OrderIndustryExpensesEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genOrderIndustryBack() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_back";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_back.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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


//        CodeGenerateUtils.generateModule(OrderIndustryBackEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryBackEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_back1.sql";
        CodeGenerateUtils.generate(OrderIndustryBackEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genOrderIndustryInvoiceEntity() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_invoice";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_invoice.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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


//        CodeGenerateUtils.generateModule(OrderIndustryInvoiceEntity.class, modulePath, sqlPath, tableName, basePackage, list);

        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryInvoiceEntityMapper1.xml";
        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_invoice1.sql";
        CodeGenerateUtils.generate(OrderIndustryInvoiceEntity.class, mapperPath, sqlPath1, tableName, list);
    }

    public static void genOrderIndustryInvoiceRelationEntity() {
        String modulePath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry";
        String tableName = "t_boms_trade_industry_order_invoice_relation";
        String sqlPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_invoice_relation.sql";
        String basePackage = "com.cii.bomse.trade.order.industry";

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
//        list.add("cpyId");
        list.add("cpyName");


        CodeGenerateUtils.generateModule(OrderIndustryInvoiceRelationEntity.class, modulePath, sqlPath, tableName, basePackage, list);

//        String mapperPath = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/trade/order/industry/dao/src/main/resources/META-INF/mapper/OrderIndustryInvoiceRelationEntityMapper1.xml";
//        String sqlPath1 = "/Users/davidcun/Desktop/svn/gniuu/yihaoyuanqu/boms/server/bomse/sql/t_boms_trade_industry_order_invoice_relation1.sql";
//        CodeGenerateUtils.generate(OrderIndustryInvoiceRelationEntity.class, mapperPath, sqlPath1, tableName, list);
    }
}
