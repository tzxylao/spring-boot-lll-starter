package com.lll.tool.codegenerator;


import com.lll.tool.codegenerator.generate.CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.lll.tool.codegenerator.ModifiedConstant.PROJECT;
import static com.lll.tool.codegenerator.generate.CodeGenerator.*;
import static com.lll.tool.codegenerator.generate.CodeGenerator.reGenerateByModelEnum;


/**
 * @author: laoliangliang
 * @description: 生成表的例子
 * @create: 2020/4/24 11:05
 **/
public class ExecuteGenerateApplication {

    /*
      注意修改配置
     */
    static {
        ModifiedConstant.PROJECT = "order";
        ModifiedConstant.MODE = 1;
    }
    public static void main(String[] args) {
        generateByTableName("order_order");
    }

    /**
     * 直接通过表名生成对应的实体类
     */
    public static void example1() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("user_user");
        generateByTableNames(tableNames);
    }

    /**
     * 直接通过表名生成对应的实体类
     */
    public static void example2() {
        generateByTableName("user_user","User");
    }

    /**
     * 已经生成的实体类重新选择生成
     */
    public static void example3() {
        List<CodeGenerator.GenCondition.ModelEnum> modelEnums = new ArrayList<>();
        // 重新生成XXXAddVo
//        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.ADD);

        // 重新生成XXXMapper.java 接口，需要依赖BASE，数据库对应实体类也会同步更新
        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.BASE);
        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.MAPPER);

        reGenerateByModelEnum(modelEnums, "Order","order_order");
    }

    public static void example4() {
        List<CodeGenerator.GenCondition.ModelEnum> modelEnums = new ArrayList<>();
        // 重新生成XXXAddVo
        modelEnums.add(GenCondition.ModelEnum.CONTROLLER);
        reGenerateByModelEnum(modelEnums, "user_role");
    }

}
