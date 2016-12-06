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
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //得到HttpSession
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        if (name != null) {
            System.out.println(name); //tom
            System.out.println(session.getId());
        } else {
            System.out.println("你不能直接访问此资源");
            System.out.println(session.getId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
