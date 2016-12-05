package com.fangyi.jdbcdemo;

import java.sql.*;

/**
 * Created by 房一 on 2016/12/4.
 */
public class JDBC_Dome {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //获取连接Connection
        Connection conn = null;
        //得到执行sql语句的对象Statement
        Statement stmt = null;
        //执行sql语句，并返回结果
        ResultSet rs = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_dome", "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id,name,password,email,birthday form users");
            //处理结果
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
                System.out.println(rs.getObject(4));
                System.out.println(rs.getObject(5));
                System.out.println("-----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                conn = null;
            }

        }
    }

}
