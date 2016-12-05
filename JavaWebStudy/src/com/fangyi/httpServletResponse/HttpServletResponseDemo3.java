package com.fangyi.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 定时刷新
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletResponseDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setIntHeader("refresh", 1);//设置1秒钟刷新一次
//        Random r = new Random();
//        resp.getWriter().write(r.nextInt()+"");


        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("注册成功！3秒钟跳到主页");
        resp.setHeader("refresh","3;url=/httpServletResponseDemo2");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************ServletDemo4 doPost**************");
    }
}
