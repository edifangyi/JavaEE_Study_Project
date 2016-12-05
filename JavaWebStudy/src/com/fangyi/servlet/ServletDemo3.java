package com.fangyi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 继承HttpServlet（模板方法设计模式）
 *
 * Created by FANGYI on 2016/12/5.
 */
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************doGet**************");
        System.out.println(req.getRemoteAddr());//客户端IP地址
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************doPost**************");
    }
}
