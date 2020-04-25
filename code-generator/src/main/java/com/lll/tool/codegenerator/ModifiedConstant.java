package com.lll.tool.codegenerator;

/**
 * @author: laoliangliang
 * @description: 所有需要自定义修改的配置参数
 * @create: 2020/4/24 11:02
 **/
public class ModifiedConstant {
    //JDBC配置，请修改为你项目的实际配置
    public static final String TABLE_SCHEMA = "onegene_infowork";
    public static final String JDBC_URL = "jdbc:mysql://101.37.146.32:3306/" + TABLE_SCHEMA + "?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
    public static final String JDBC_USERNAME = "geneuser";
    public static final String JDBC_PASSWORD = "it123456";
    public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * 作者
     */
    public static final String AUTHOR = "laoliangliang";//@author

    /**
     * 基础包 com.公司.工程
     */
    public static final String ROOT_PACKAGE = "com.company.project";

    /**
     * 项目
     */
    public static final String PROJECT = "user";
}
