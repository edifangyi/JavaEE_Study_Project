package com.fangyi.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现Servlet的转发
 * Created by FANGYI on 2016/12/5.
 */
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("A：我要办事");
        System.out.println("B：你的事我办不了，我找人帮你");
        ServletContext application = this.getServletContext();
        //将请求向下传递
//        RequestDispatcher rd = application.getRequestDispatcher("/servletContext/ServletContextDemo6");
//        rd.forward(req,resp);

        application.getRequestDispatcher("/servletContextDemo6").forward(req, resp);
        System.out.println("B：事办完了");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
