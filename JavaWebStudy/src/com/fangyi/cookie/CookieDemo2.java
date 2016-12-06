package com.fangyi.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除cookie
 *
 * Created by FANGYI on 2016/12/6.
 */
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个Cookie对象
        Cookie ck = new Cookie("lastAccessTime", "");
        ck.setPath("/");//要设置被删除Cookie的path，否则可能会删错对象
        ck.setMaxAge(0);//相当于删除
        resp.addCookie(ck);//将ck写回客户端缓存
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
