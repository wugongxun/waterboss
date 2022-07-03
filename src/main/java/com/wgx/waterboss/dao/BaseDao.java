package com.wgx.waterboss.dao;

import java.sql.*;

/**
 * author:wgx
 * version:1.0
 */
public class BaseDao {
    static {
        try {
            //加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "wateruser", "wgx");
    }
    //关闭资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
