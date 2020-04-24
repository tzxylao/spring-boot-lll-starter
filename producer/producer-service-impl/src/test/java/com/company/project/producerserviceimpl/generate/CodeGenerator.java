package com.company.project.producerserviceimpl.generate;

import com.company.project.producerserviceimpl.util.DBUtil;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.company.project.producerserviceimpl.ModifiedConstant.*;
import static com.company.project.producerserviceimpl.generate.ProjectConstant.*;

/**
 * 代码生成器，根据数据表名称生成对应的pojo、Mapper、Service、Controller、ServiceImpl简化开发。
 */
public class CodeGenerator {
    private static final String PROJECT_PATH_SERVICE_IMPL = System.getProperty("user.dir") + "/" + PROJECT_SERVICE_IMPL;//项目在硬盘上的基础路径
    private static final String PROJECT_PATH_SERVICE = System.getProperty("user.dir") + "/" + PROJECT_SERVICE;//项目在硬盘上的基础路径
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH_SERVICE_IMPL + "/src/test/resources/generator/template";//模板位置

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径
    private static final String PACKAGE_PATH_QUERY_VO = packageConvertPath(QUERY_VO_PACKAGE);//生成的queryVo存放路径
    private static final String PACKAGE_PATH_UPDATE_VO = packageConvertPath(UPDATE_VO_PACKAGE);//生成的queryVo存放路径
    private static final String PACKAGE_PATH_ADD_VO = packageConvertPath(ADD_VO_PACKAGE);//生成的queryVo存放路径
    private static final String PACKAGE_PATH_DELETE_VO = packageConvertPath(DELETE_VO_PACKAGE);//生成的queryVo存放路径
    private static final String PACKAGE_PATH_RESULT_VO = packageConvertPath(RESULT_VO_PACKAGE);//生成的resultVo存放路径

    private static final String DATE = cn.hutool.core.date.DateUtil.formatDateTime(new Date());//@date


    /**
     * 生成表对应的框架
     *
     * @param tableNames
     */
    public static void generateByTableNames(String... tableNames) {
        reGenerateByModelEnum(null, tableNames);
    }

    /**
     * 将数据库表取别名后生成实体类
     *
     * @param tableName
     * @param modelName
     */
    public static void generateByTableName(String tableName, String modelName) {
        List<CodeGenerator.GenCondition> genConditions = new ArrayList<>();
        CodeGenerator.GenCondition genCondition = new CodeGenerator.GenCondition(tableName, modelName);
        genConditions.add(genCondition);
        CodeGenerator.genCode(genConditions);
    }

    /**
     * 选择部分实体类重新生成
     *
     * @param modelEnums 可选实体类枚举
     * @param tableNames 需要更新的表名
     */
    public static void reGenerateByModelEnum(List<CodeGenerator.GenCondition.ModelEnum> modelEnums, String... tableNames) {
        List<CodeGenerator.GenCondition> genConditions = new ArrayList<>();
        for (String tableName : tableNames) {
            CodeGenerator.GenCondition genCondition = new CodeGenerator.GenCondition(tableName, true, modelEnums);
            genConditions.add(genCondition);
        }
        CodeGenerator.genCode(genConditions);
    }

    /**
     * 生成条件类
     */
    @Data
    @AllArgsConstructor
    public static class GenCondition {
        /**
         * 在选择性重新生成时可以配置
         */
        public enum ModelEnum {
            /**
             * add,update,delete,query,detail,detailResult,result实体类
             */
            ADD,
            UPDATE,
            DELETE,
            QUERY,
            DETAIL,
            DETAIL_RESULT,
            RESULT,
            /**
             * controller层
             */
            CONTROLLER,
            /**
             * 生成service
             */
            SERVICE,
            /**
             * 生成serviceimpl
             */
            SERVICE_IMP,
            /**
             * 基本，表示只生成model和mapper.xml
             */
            BASE,
            /**
             * 表示生成mapper.java，由于基于BASE，配置该项时必须配置BASE项，且mapper.xml只会生成一次
             */
            MAPPER;

        }

        private String tableName;
        private Boolean overwrite = true;
        private Boolean noDelete;
        private String modelName;
        private JavaBean javaBean = new JavaBean();
        /**
         * 配置该项通常用在重新生成实体类
         */
        private List<ModelEnum> model = Arrays.asList(ModelEnum.ADD, ModelEnum.QUERY, ModelEnum.UPDATE, ModelEnum.RESULT,
                ModelEnum.BASE, ModelEnum.MAPPER, ModelEnum.CONTROLLER, ModelEnum.DETAIL, ModelEnum.DETAIL_RESULT,
                ModelEnum.SERVICE, ModelEnum.SERVICE_IMP, ModelEnum.DELETE);

        public GenCondition(String tableName) {
            this.tableName = tableName;
        }

        public GenCondition(String tableName, Boolean overwrite) {
            this.tableName = tableName;
            this.overwrite = overwrite;
        }

        public GenCondition(String tableName, String modelName) {
            this.tableName = tableName;
            this.modelName = modelName;
        }

        public GenCondition(String tableName, Boolean overwrite, List<ModelEnum> model) {
            this.tableName = tableName;
            this.overwrite = overwrite;
            this.model = model;
        }

        public GenCondition(String tableName, Boolean overwrite, Boolean noDelete) {
            this.tableName = tableName;
            this.overwrite = overwrite;
            this.noDelete = noDelete;
            if (noDelete) {
                model.remove(ModelEnum.DELETE);
            }
        }
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    public static void genCode(List<GenCondition> tableNames) {
        for (GenCondition condition : tableNames) {
            genCodeByCustomModelName(condition);
        }
    }

    @Data
    public static class JavaBean {
        private String tableComment;
        private Integer hasDate;
        private Boolean hasDelete;
        private Integer hasBigDecimal;
        private List<Field> fields = new ArrayList<>();

        @Data
        public static class Field {
            private String columnName;
            private String columnComment;
            private String dataType;
        }
    }

    /**
     * 通过数据表名称，和自定义的 Model 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
     *
     * @param condition tableName 数据表名称
     * @param condition modelName 自定义的 Model 名称
     */
    private static void genCodeByCustomModelName(GenCondition condition) {
        wrapTableComment(condition);
        wrapTableField(condition);
        genModelAndMapper(condition);
        genService(condition);
        genController(condition);
        genQueryAndAddVo(condition);
        genDeleteVo(condition);
        genResultVo(condition);
    }

    private static void wrapTableField(GenCondition condition) {
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        DBUtil.getTableFiled("select COLUMN_NAME,COLUMN_COMMENT,DATA_TYPE from information_schema.`COLUMNS`\n" +
                "where TABLE_SCHEMA='" + TABLE_SCHEMA + "' and TABLE_NAME='" + tableName + "'", resultSet -> {
            while (resultSet.next()) {
                JavaBean.Field field = new JavaBean.Field();
                String columnName = resultSet.getString(1);
                String columnComment = resultSet.getString(2);
                String dataType = resultSet.getString(3);
                field.setColumnName(tableNameConvertLowerCamel(columnName));
                field.setColumnComment(columnComment);
                switch (dataType) {
                    case "int":
                    case "tinyint":
                        dataType = "Integer";
                        break;
                    case "bigint":
                        dataType = "Long";
                        break;
                    case "varchar":
                    case "text":
                    case "mediumtext":
                    case "blob":
                        dataType = "String";
                        break;
                    case "datetime":
                    case "date":
                    case "timestamp":
                        dataType = "Date";
                        javaBean.setHasDate(1);
                        break;
                    case "decimal":
                        dataType = "BigDecimal";
                        javaBean.setHasBigDecimal(1);
                        break;
                    case "double":
                        dataType = "Double";
                        break;
                    case "bit":
                        dataType = "Boolean";
                        break;
                    default:
                        dataType = "String";
                        break;
                }
                field.setDataType(dataType);
                javaBean.getFields().add(field);
            }
        });
    }

    private static void wrapTableComment(GenCondition condition) {
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        DBUtil.getTableFiled("select TABLE_COMMENT from information_schema.`TABLES`\n" +
                "where TABLE_SCHEMA='" + TABLE_SCHEMA + "' and TABLE_NAME='" + tableName + "'", resultSet -> {
            while (resultSet.next()) {
                String tableComment = resultSet.getString(1);
                javaBean.setTableComment(tableComment);
            }
        });
    }

    private static void genQueryAndAddVo(GenCondition condition) {
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        String modelName = condition.getModelName();
        String suffixQuery = "QueryVo";
        String suffixAdd = "AddVo";
        String suffixUpdate = "UpdateVo";
        String suffixDetail = "DetailVo";
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("coreExtend", CORE_EXTENDS);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
//            data.put("basePackage", QUERY_VO_PACKAGE);
            data.put("suffixQuery", suffixQuery);
            data.put("suffixAdd", suffixAdd);
            data.put("suffixUpdate", suffixUpdate);
            data.put("suffixDetail", suffixDetail);
            data.put("rootPackage", ROOT_PACKAGE);
            data.put("service", SERVICE);
            data.put("serviceImpl", SERVICE_IMPL);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);

            File file;
            if (condition.getModel().contains(GenCondition.ModelEnum.QUERY)) {
                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixQuery + ".java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                cfg.getTemplate("queryVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixQuery + ".java 生成成功");
            }
            if (condition.getModel().contains(GenCondition.ModelEnum.ADD)) {
                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_ADD_VO + modelNameUpperCamel + suffixAdd + ".java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists() || condition.getOverwrite()) {
                    cfg.getTemplate("addVo.ftl").process(data,
                            new FileWriter(file));
                    System.out.println(modelNameUpperCamel + suffixAdd + ".java 生成成功");
                }
            }
            if (condition.getModel().contains(GenCondition.ModelEnum.UPDATE)) {
                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_UPDATE_VO + modelNameUpperCamel + suffixUpdate + ".java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists() || condition.getOverwrite()) {
                    cfg.getTemplate("updateVo.ftl").process(data,
                            new FileWriter(file));
                    System.out.println(modelNameUpperCamel + suffixUpdate + ".java 生成成功");
                }
            }
            if (condition.getModel().contains(GenCondition.ModelEnum.DETAIL)) {
                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixDetail + ".java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists() || condition.getOverwrite()) {
                    cfg.getTemplate("detailVo.ftl").process(data,
                            new FileWriter(file));
                    System.out.println(modelNameUpperCamel + suffixDetail + ".java 生成成功");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("生成query，update和add失败", e);
        }
    }

    private static void genDeleteVo(GenCondition condition) {
        if (!condition.getModel().contains(GenCondition.ModelEnum.DELETE)) {
            return;
        }
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        String modelName = condition.getModelName();
        String suffixDelete = "DeleteVo";
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("coreExtend", CORE_EXTENDS);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", QUERY_VO_PACKAGE);
            data.put("suffixDelete", suffixDelete);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);

            data.put("rootPackage", ROOT_PACKAGE);
            data.put("service", SERVICE);
            data.put("serviceImpl", SERVICE_IMPL);

            File file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_DELETE_VO + modelNameUpperCamel + suffixDelete + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists() || condition.getOverwrite()) {
                cfg.getTemplate("deleteVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixDelete + ".java 生成成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成delete失败", e);
        }
    }

    private static void genResultVo(GenCondition condition) {
        if (!condition.getModel().contains(GenCondition.ModelEnum.RESULT)) {
            return;
        }
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        String modelName = condition.getModelName();
        String suffixResult = "ResultVo";
        String suffixDetailResult = "DetailResultVo";
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("coreExtend", CORE_EXTENDS);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", RESULT_VO_PACKAGE);
            data.put("suffixResult", suffixResult);
            data.put("suffixDetailResult", suffixDetailResult);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);
            data.put("rootPackage", ROOT_PACKAGE);
            data.put("service", SERVICE);
            data.put("serviceImpl", SERVICE_IMPL);

            File file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_RESULT_VO + modelNameUpperCamel + suffixResult + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists() || condition.getOverwrite()) {
                cfg.getTemplate("ResultVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixResult + ".java 生成成功");

                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_RESULT_VO + modelNameUpperCamel + suffixDetailResult + ".java");
                cfg.getTemplate("detailResultVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixDetailResult + ".java 生成成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成query和add失败", e);
        }
    }


    public static void genModelAndMapper(GenCondition condition) {
        if (!condition.getModel().contains(GenCondition.ModelEnum.BASE)) {
            return;
        }
        String tableName = condition.getTableName();
        String modelName = condition.getModelName();
        Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH_SERVICE + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH_SERVICE_IMPL + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        if (condition.getModel().contains(GenCondition.ModelEnum.MAPPER)) {
            JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
            javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH_SERVICE_IMPL + JAVA_PATH);
            javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
            javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
            context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        }

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (StringUtils.isNotEmpty(modelName)) tableConfiguration.setDomainObjectName(modelName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();


            DefaultShellCallback callback = new DefaultShellCallback(condition.getOverwrite());
            warnings = new ArrayList<>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(modelName)) modelName = tableNameConvertUpperCamel(tableName);
        System.out.println(modelName + ".java 生成成功");
        System.out.println(modelName + "Mapper.java 生成成功");
        System.out.println(modelName + "Mapper.xml 生成成功");
    }

    public static void genService(GenCondition condition) {
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        String modelName = condition.getModelName();
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("coreExtend", CORE_EXTENDS);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);
            data.put("rootPackage", ROOT_PACKAGE);
            data.put("service", SERVICE);
            data.put("serviceImpl", SERVICE_IMPL);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);
            javaBean.setHasDelete(condition.getModel().contains(GenCondition.ModelEnum.DELETE));

            File file;
            if (condition.getModel().contains(GenCondition.ModelEnum.SERVICE)) {
                file = new File(PROJECT_PATH_SERVICE + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                cfg.getTemplate("service.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + "Service.java 生成成功");
            }

            if (condition.getModel().contains(GenCondition.ModelEnum.SERVICE_IMP)) {
                file = new File(PROJECT_PATH_SERVICE_IMPL + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists() || condition.getOverwrite()) {
                    cfg.getTemplate("service-impl.ftl").process(data,
                            new FileWriter(file));
                    System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(GenCondition condition) {
        if (!condition.getModel().contains(GenCondition.ModelEnum.CONTROLLER)) {
            return;
        }
        String tableName = condition.getTableName();
        JavaBean javaBean = condition.getJavaBean();
        String modelName = condition.getModelName();
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", BASE_PACKAGE);
            data.put("rootPackage", ROOT_PACKAGE);
            data.put("service", SERVICE);
            data.put("serviceImpl", SERVICE_IMPL);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);
            javaBean.setHasDelete(condition.getModel().contains(GenCondition.ModelEnum.DELETE));

            File file = new File(PROJECT_PATH_SERVICE_IMPL + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists() || condition.getOverwrite()) {
                cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));
                System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase();//兼容使用大写的表名
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

}
