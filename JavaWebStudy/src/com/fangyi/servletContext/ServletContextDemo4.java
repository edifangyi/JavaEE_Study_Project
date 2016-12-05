package com.fangyi.servletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 获取资源路径
 * Created by FANGYI on 2016/12/5.
 */
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test1();

        test2();

        test3();
    }

    /**
     * 获取com文件夹下的文件
     *
     * @throws IOException
     */
    private void test3() throws IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/com/fangyi/servletContext/c.properties");
        System.out.println(path);

        //创建一个Properties
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.println(pro.getProperty("key"));
    }

    /**
     * 获取src下的文件
     *
     * @throws IOException
     */
    private void test2() throws IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");
        System.out.println(path);

        //创建一个Properties
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.println(pro.getProperty("key"));
    }

    /**
     * 获取WEB-INF下的a.properties
     *
     * @throws IOException
     */
    private void test1() throws IOException {
        //任何路径任何资源
        String path = this.getServletContext().getRealPath("/WEB-INF/a.properties");//参数一定要以/开头
        System.out.println(path);

        //创建一个Properties
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.println(pro.getProperty("key"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
