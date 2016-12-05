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
public class HttpServletRequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //告诉浏览器使用什么编码
        resp.setContentType("text/html;charset=UTF-8");

//        test1(req, resp);


//        test2(req, resp);


    }

    private void test2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "aaaaa";
        //将非表单的数据添加到req域中
        req.setAttribute("s", str);
        //请求转发不能跳转到其他应用 - 地址栏不改变，转发可以传递数据
        req.getRequestDispatcher("/httpServletRequestDemo3").forward(req, resp);

//        //使用重定向 - 相当于重新输入一次地址栏，所有 s 的值 传递不过去
        //客户端发两次请求，地址栏会发生改变，不传递数据
        //重定向 可以跳转到其他应用 resp.sendRedirect("http://www.baidu.com");
//        resp.sendRedirect(req.getContextPath() + "/httpServletRequestDemo2");

        //请求包含 - 直接把httpServletRequestDemo3 中的代码执行了，
        req.getRequestDispatcher("/httpServletRequestDemo3").include(req, resp);
    }

    private void test1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("A:我想办事");
        System.out.println("B:我办不了，但我可以找人帮你办");
        //将请求转发到
        req.getRequestDispatcher("/httpServletRequestDemo3").forward(req, resp);
        System.out.println("B:事办完了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
