package com.company.project.producerserviceimpl.util;

import com.company.project.producerserviceimpl.CodeGenerator;

import java.sql.*;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/1/14 15:34
 **/
public class DBUtil {

    private static Connection getPreparedStatement() throws ClassNotFoundException, SQLException {
        Class.forName(CodeGenerator.JDBC_DIVER_CLASS_NAME);
        return DriverManager.getConnection(CodeGenerator.JDBC_URL, CodeGenerator.JDBC_USERNAME, CodeGenerator.JDBC_PASSWORD);
    }

    public interface CallBack{
        void run(ResultSet resultSet) throws SQLException;
    }

    public static void getTableFiled(String sql,CallBack callBack) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = getPreparedStatement();
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            callBack.run(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
