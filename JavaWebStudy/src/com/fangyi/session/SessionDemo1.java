package com.fangyi.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");//http://localhost:8088/sessionDemo1?name=tom
        //得到HttpSession
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        System.out.println(session.getId());


        session.setMaxInactiveInterval(10);//设置有效时间
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
