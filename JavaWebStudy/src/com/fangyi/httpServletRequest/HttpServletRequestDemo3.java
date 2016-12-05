package com.fangyi.httpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 操作非表单数据的方法&请求转发
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletRequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //告诉浏览器使用什么编码
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("这个事我能办");

        //将req对象中的移除
        //request.removeAttribute("s");

        String s = (String) req.getAttribute("s");
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
