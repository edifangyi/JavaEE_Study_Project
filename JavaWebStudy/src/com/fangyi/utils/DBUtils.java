package com.fangyi.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by FANGYI on 2016/12/4.
 */
public class DBUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        //此对象用于加载properties文件数据的
        ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
        driverClass = bundle.getString("driverClass");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到连接方法
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
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
