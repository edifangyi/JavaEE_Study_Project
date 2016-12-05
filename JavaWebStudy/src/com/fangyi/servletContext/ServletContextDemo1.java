package com.fangyi.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext作为域对象
 * Created by FANGYI on 2016/12/5.
 */
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过调用 GenericServlet的getServletContext方法得到ServletContext对象

        ServletContext application=this.getServletContext();
        //向ServletContext添加一个键值对
        application.setAttribute("name","tom");

        System.out.println(application.getClass().getName());//获取类名
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
