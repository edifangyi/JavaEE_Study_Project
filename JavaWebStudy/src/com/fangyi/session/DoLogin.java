package com.fangyi.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class DoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String code = request.getParameter("code");
        //从session中获取验证码
        String scode = (String) request.getSession().getAttribute("scode");
        //处理业务逻辑
        if ("tom".equals(userName) && "123".equals(pwd)) {
            //分发转向
            if (!code.equalsIgnoreCase(scode)) {
                request.setAttribute("msg", "验证码错误");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            out.print("登录成功！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}