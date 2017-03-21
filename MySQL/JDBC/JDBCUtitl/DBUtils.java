package com;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by 房一 on 2016/12/4.
 */
public class DBUtils {
    private static String DRIVERCLASS;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        //此对象用于加载properties文件数据的
        ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
        DRIVERCLASS = bundle.getString("driverClass");
        URL = bundle.getString("url");
        USERNAME = bundle.getString("username");
        PASSWORD = bundle.getString("password");

        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到连接方法
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //关闭资源方法
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    //关闭资源方法
    public static void closeAll(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
