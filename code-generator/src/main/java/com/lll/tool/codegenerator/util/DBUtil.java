package com.lll.tool.codegenerator.util;


import com.lll.tool.codegenerator.ModifiedConstant;

import java.sql.*;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/1/14 15:34
 **/
public class DBUtil {

    private static Connection getPreparedStatement() throws ClassNotFoundException, SQLException {
        Class.forName(ModifiedConstant.JDBC_DIVER_CLASS_NAME);
        return DriverManager.getConnection(ModifiedConstant.JDBC_URL, ModifiedConstant.JDBC_USERNAME, ModifiedConstant.JDBC_PASSWORD);
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
