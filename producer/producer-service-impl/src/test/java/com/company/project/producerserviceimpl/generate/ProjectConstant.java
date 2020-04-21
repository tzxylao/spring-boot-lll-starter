package com.company.project.producerserviceimpl.generate;

/**
 * 项目常量
 */
public final class ProjectConstant {
    /**
     * 生成代码所在的基础包名称
     */
//    public static final String BASE_PACKAGE = "com.onegene.platform.crmwork";
//    public static final String BASE_PACKAGE = "com.onegene.platform.biologywork";
    public static final String BASE_PACKAGE = "com.onegene.platform.businesswork";
//    public static final String BASE_PACKAGE = "com.onegene.platform.platformwork";

    /**
     * 核心文件所在目录
     */
    public static final String CORE_EXTENDS = "com.onegene.platform.system.mybatis";

    /**
     * 生成的Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".pojo.entity";

    /**
     * 生成的Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";

    /**
     * 生成的Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    /**
     * 生成Query UPDATE ADD参数所在包
     */
    public static final String QUERY_VO_PACKAGE = BASE_PACKAGE+".pojo.queryVo";

    /**
     * 生成返回结果所在包
     */
    public static final String RESULT_VO_PACKAGE = BASE_PACKAGE+".pojo.resultVo";

    /**
     * 生成的ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    /**
     * 生成的Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = CORE_EXTENDS+".Mapper";
}
