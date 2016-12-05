package com.fangyi.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletResponseDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A:我要借钱");
        System.out.println("B:我不有，但是我可以告诉你谁有");
//        resp.setStatus(302);//告诉客户端要重新定向的资源
//        resp.setHeader("location","/httpServletResponseDemo5");//告诉浏览器要去访问哪个URL

        //请求重定向
        resp.sendRedirect("/httpServletResponseDemo5");//上面两句综合

        System.out.println("A:我去了");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************ServletDemo4 doPost**************");
    }
}
