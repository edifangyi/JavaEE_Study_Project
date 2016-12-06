package com.fangyi.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 记住用户名密码
 * Created by FANGYI on 2016/12/6.
 */
public class LoginServletDome1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String userName = "";
        String checked = "";

        //得到客户端保存的Cookie数据
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("userName".equals(cookies[i].getName())) {
                userName = cookies[i].getValue();
                checked = "checked='checked'";
            }
        }

        out.write("<form action='" + req.getContextPath() + "/loginServletDome2' method='post'>");
        out.write("用户名：<input type='text' name='userName' value='" + userName + "'/><br/>");
        out.write("密码：<input type='password' name='pwd'/><br/>");
        out.write("<input type='checkbox' name='remember' " + checked + " />记住用户名<br/>");
        out.write("<input type='submit' value='登录'/><br/>");
        out.write("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
