package test.com.fangyi;

import com.fangyi.jdbcdemo.Utils.DBUtils;
import com.fangyi.jdbcdemo.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 房一 on 2016/12/4.
 */
public class TestJDBC {
    @org.junit.Test
    public void testSelect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_dome", "root", "root");
        Statement statement = connection.createStatement();

//        statement.executeUpdate("INSERT INTO login (username,password,email,birthday ) VALUES('haha','666','haha@gmail.com','2016-03-26')");

        ResultSet rs = statement.executeQuery("SELECT * FROM login");

        List<User> userList = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBirthday(rs.getDate("birthday"));
            userList.add(user);
        }
        for (User user : userList) {
            System.out.println(user.toString());
        }


        rs.close();
        statement.close();
        connection.close();
    }


    @org.junit.Test
    public void testSelect2() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        connection = DBUtils.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM login");

        List<User> userList = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setBirthday(resultSet.getDate("birthday"));
            userList.add(user);
        }
        for (User user : userList) {
            System.out.println(user.toString());
        }

        DBUtils.closeAll(resultSet, statement, connection);
    }

    @org.junit.Test
    public void testSelect3() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBUtils.getConnection();

            statement = connection.createStatement();
            int i = statement.executeUpdate("INSERT INTO login (username,password,email,birthday ) VALUES('bendan','789','bendan@123.com','2016-12-12')");
            if (i > 0) {
                System.out.println("success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(statement, connection);
        }


    }

    @org.junit.Test
    public void testSelect4() {
        Connection conn = null;
        PreparedStatement stmt = null;//SQL注入
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtils.getConnection();//得到连接对象Connection

            //SQL注入
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);////SQL注入
            //给？赋值
            stmt.setString(1, "fangyi");
            stmt.setString(2, "123456");

            rs = stmt.executeQuery();//执行sql语句
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }

            System.out.println(u.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, conn);
        }

    }


}
