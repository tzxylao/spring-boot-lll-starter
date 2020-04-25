package com.company.project.backgroundserviceimpl;

import com.company.project.backgroundserviceimpl.generate.CodeGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.company.project.backgroundserviceimpl.generate.CodeGenerator.*;


/**
 * @author: laoliangliang
 * @description: 生成表的例子
 * @create: 2020/4/24 11:05
 **/
public class ExecuteGenerate {

    public static void main(String[] args) {
        example1();
    }

    /**
     * 直接通过表名生成对应的实体类
     */
    public static void example1() {
        generateByTableName("user_user","User");
    }

    /**
     * 直接通过表名生成对应的实体类
     */
    public static void example2() {
        generateByTableName("order_order","Order");
    }

    /**
     * 已经生成的实体类重新选择生成
     */
    public static void example3() {
        List<CodeGenerator.GenCondition.ModelEnum> modelEnums = new ArrayList<>();
        // 重新生成XXXAddVo
        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.ADD);

        // 重新生成XXXMapper.java 接口，需要依赖BASE，数据库对应实体类也会同步更新
        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.BASE);
        modelEnums.add(CodeGenerator.GenCondition.ModelEnum.MAPPER);

        reGenerateByModelEnum(modelEnums, "unlock_order");
    }


}
