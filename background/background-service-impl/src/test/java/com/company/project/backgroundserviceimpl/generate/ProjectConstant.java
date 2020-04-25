package com.company.project.backgroundserviceimpl.generate;

import static com.company.project.backgroundserviceimpl.ModifiedConstant.*;

/**
 * 项目常量
 */
public final class ProjectConstant {

    /**
     * 接口层后缀命名
     */
    public static final String SERVICE_SUFFIX = "service";

    /**
     * 接口实现层后缀命名
     */
    public static final String SERVICE_IMPL_SUFFIX = "serviceimpl";

    public static final String SERVICE = PROJECT + SERVICE_SUFFIX;
    public static final String SERVICE_IMPL = PROJECT + SERVICE_IMPL_SUFFIX;

    /**
     * 接口，实体类防止目录，默认为 项目/项目-service
     */
    public static final String PROJECT_SERVICE = PROJECT + "/" + PROJECT + "-service";
    /**
     * 实现类，controller，mapper，serviceimpl等目录，默认为 项目/项目-service-impl
     */
    public static final String PROJECT_SERVICE_IMPL = PROJECT + "/" + PROJECT + "-service-impl";
    public static final String BASE_PACKAGE = ROOT_PACKAGE + "." + PROJECT;

    /**
     * 核心文件所在目录
     */
    public static final String CORE_EXTENDS = ROOT_PACKAGE + ".base.mybatis";

    /**
     * 生成的Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.entity";

    /**
     * 生成的Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + SERVICE_IMPL_SUFFIX + ".mapper";

    /**
     * 生成的Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".service";

    /**
     * 生成Query UPDATE ADD参数所在包
     */
    public static final String QUERY_VO_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.query";
    public static final String UPDATE_VO_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.update";
    public static final String ADD_VO_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.add";
    public static final String DELETE_VO_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.delete";

    /**
     * 生成返回结果所在包
     */
    public static final String RESULT_VO_PACKAGE = BASE_PACKAGE + SERVICE_SUFFIX + ".pojo.result";

    /**
     * 生成的ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = BASE_PACKAGE + SERVICE_IMPL_SUFFIX + ".service";

    /**
     * 生成的Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + SERVICE_IMPL_SUFFIX + ".controller";

    /**
     * Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = CORE_EXTENDS + ".Mapper";
}
