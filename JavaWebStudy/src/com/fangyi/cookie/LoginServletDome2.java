package com.fangyi.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class LoginServletDome2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取表单数据
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        String remember = req.getParameter("remember");

        Cookie ck = new Cookie("userName", userName);
        ck.setPath("/");
        //处理业务逻辑
        //分发转向
        if ("tom".equals(userName) && "123".equals(pwd)) {
            if (remember != null) {
                ck.setMaxAge(Integer.MAX_VALUE);//设置Cookie的有效保存时间
            } else {
                ck.setMaxAge(0);//删除 Cookie
            }
            resp.addCookie(ck);//将Cookie写回到客户端
            out.write("登录成功！");
        } else {
            out.write("登录失败！");
            //设置2秒跳到重新登录
            resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/loginServletDome1");
//            resp.setHeader("refresh", "2;url=/loginServletDome1");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
