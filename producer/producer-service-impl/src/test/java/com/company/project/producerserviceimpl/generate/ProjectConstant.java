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
    public static final String ROOT_PACKAGE = "com.company.project";
    public static final String PROJECT = "producer";
    public static final String SERVICE = PROJECT + "service";
    public static final String SERVICE_IMPL = PROJECT + "serviceimpl";
    public static final String PROJECT_SERVICE = PROJECT + "/" + PROJECT + "-service";
    public static final String PROJECT_SERVICE_IMPL = PROJECT + "/" + PROJECT + "-service-impl";
    public static final String BASE_PACKAGE = ROOT_PACKAGE + "." + PROJECT;
//    public static final String BASE_PACKAGE = "com.onegene.platform.platformwork";

    /**
     * 核心文件所在目录
     */
    public static final String CORE_EXTENDS = ROOT_PACKAGE + ".base.mybatis";

    /**
     * 生成的Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + "service.pojo.entity";

    /**
     * 生成的Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + "serviceimpl.mapper";

    /**
     * 生成的Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + "service.service";

    /**
     * 生成Query UPDATE ADD参数所在包
     */
    public static final String QUERY_VO_PACKAGE = BASE_PACKAGE + "service.pojo.query";
    public static final String UPDATE_VO_PACKAGE = BASE_PACKAGE + "service.pojo.update";
    public static final String ADD_VO_PACKAGE = BASE_PACKAGE + "service.pojo.add";
    public static final String DELETE_VO_PACKAGE = BASE_PACKAGE + "service.pojo.delete";

    /**
     * 生成返回结果所在包
     */
    public static final String RESULT_VO_PACKAGE = BASE_PACKAGE + "service.pojo.result";

    /**
     * 生成的ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE + "serviceimpl.service";

    /**
     * 生成的Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + "serviceimpl.controller";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = CORE_EXTENDS + ".Mapper";
}
