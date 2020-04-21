package com.company.project.producerserviceimpl;

import com.company.project.producerserviceimpl.util.DBUtil;
import com.google.common.base.CaseFormat;
import freemarker.template.TemplateExceptionHandler;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.company.project.producerserviceimpl.generate.ProjectConstant.*;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGenerator {
    //JDBC配置，请修改为你项目的实际配置
    public static final String TABLE_SCHEMA = "onegene_infowork";
    public static final String JDBC_URL = "jdbc:mysql://101.37.146.32:3306/" + TABLE_SCHEMA + "?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    public static final String JDBC_USERNAME = "geneuser";
    public static final String JDBC_PASSWORD = "it123456";
    public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String PROJECT_PATH = System.getProperty("user.dir");//项目在硬盘上的基础路径
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";//模板位置

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径
    private static final String PACKAGE_PATH_QUERY_VO = packageConvertPath(QUERY_VO_PACKAGE);//生成的queryVo存放路径
    private static final String PACKAGE_PATH_RESULT_VO = packageConvertPath(RESULT_VO_PACKAGE);//生成的resultVo存放路径

    private static final String DATE = cn.hutool.core.date.DateUtil.formatDateTime(new Date());//@date
    /**
     * 作者
     */
    private static final String AUTHOR = "laoliangliang";//@author

    /**
     * 是否覆盖
     */
    private static final boolean overwrite = true;

    public static void main(String[] args) {
        genCode("unlock_order");
//        genCodeByCustomModelName("输入表名","输入自定义Model名称");
    }

    /**
     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     *
     * @param tableNames 数据表名称...
     */
    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            genCodeByCustomModelName(tableName, null);
        }
    }

    @Data
    public static class JavaBean {
        private String tableComment;
        private Integer hasDate;
        private Integer hasBigDecimal;
        private List<Field> fields;

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
     * @param tableName 数据表名称
     * @param modelName 自定义的 Model 名称
     */
    public static void genCodeByCustomModelName(String tableName, String modelName) {
        JavaBean javaBean = new JavaBean();
        javaBean.setFields(new ArrayList<>());
        wrapTableComment(tableName, javaBean);
        wrapTableField(tableName, javaBean);
        genModelAndMapper(tableName, modelName);
        genService(tableName, modelName, javaBean);
        genController(tableName, modelName, javaBean);
        genQueryAndAddVo(tableName, modelName, javaBean);
        genResultVo(tableName, modelName, javaBean);
    }

    private static void wrapTableField(String tableName, JavaBean javaBean) {
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

    private static void wrapTableComment(String tableName, JavaBean javaBean) {
        DBUtil.getTableFiled("select TABLE_COMMENT from information_schema.`TABLES`\n" +
                "where TABLE_SCHEMA='" + TABLE_SCHEMA + "' and TABLE_NAME='" + tableName + "'", resultSet -> {
            while (resultSet.next()) {
                String tableComment = resultSet.getString(1);
                javaBean.setTableComment(tableComment);
            }
        });
    }

    private static void genQueryAndAddVo(String tableName, String modelName, JavaBean javaBean) {
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
            data.put("basePackage", QUERY_VO_PACKAGE);
            data.put("suffixQuery", suffixQuery);
            data.put("suffixAdd", suffixAdd);
            data.put("suffixUpdate", suffixUpdate);
            data.put("suffixDetail", suffixDetail);
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixQuery + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("queryVo.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + suffixQuery + ".java 生成成功");

            file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixAdd + ".java");
            if (!file.exists() || overwrite) {
                cfg.getTemplate("addVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixAdd + ".java 生成成功");
            }

            file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixUpdate + ".java");
            if (!file.exists() || overwrite) {
                cfg.getTemplate("updateVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixUpdate + ".java 生成成功");
            }

            file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_QUERY_VO + modelNameUpperCamel + suffixDetail + ".java");
            if (!file.exists() || overwrite) {
                cfg.getTemplate("detailVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixDetail + ".java 生成成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成query，update和add失败", e);
        }
    }

    private static void genResultVo(String tableName, String modelName, JavaBean javaBean) {
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

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_RESULT_VO + modelNameUpperCamel + suffixResult + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists() || overwrite) {
                cfg.getTemplate("ResultVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixResult + ".java 生成成功");

                file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_RESULT_VO + modelNameUpperCamel + suffixDetailResult + ".java");
                cfg.getTemplate("detailResultVo.ftl").process(data,
                        new FileWriter(file));
                System.out.println(modelNameUpperCamel + suffixDetailResult + ".java 生成成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成query和add失败", e);
        }
    }


    public static void genModelAndMapper(String tableName, String modelName) {
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
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

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


            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
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

    public static void genService(String tableName, String modelName, JavaBean javaBean) {
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
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            if (!file.exists() || overwrite) {
                cfg.getTemplate("service-impl.ftl").process(data,
                        new FileWriter(file1));
                System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
            }

        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName, String modelName, JavaBean javaBean) {
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
            data.put("tableComment", javaBean.getTableComment());
            data.put("fields", javaBean.getFields());
            data.put("hasDate", javaBean.getHasDate());
            data.put("javaBean", javaBean);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists() || overwrite) {
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
