package com.fangyi.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        //获取客户端保存的最后访问时间
        Cookie[] cookies = req.getCookies();//获得客户端的所有cookie
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccessTime".equals(cookies[i].getName())) {//判断当前的cookie是不是想要的
//                long l = Long.parseLong(cookies[i].getValue());
//                out.write("你的最后访问时间为" + new Date(l).toLocaleString());//yyyy-MM-dd
                out.write("你的最后访问时间为" + cookies[i].getValue());
            }
        }

        out.print("<a href='" + req.getContextPath() + "/servlet/clear'>clear</a>");


        //创建cookie
        Cookie ck = new Cookie("lastAccessTime", getTimeYYYY_MM_DD_HH_MM_SS(new Date()));
//        Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis() + "");

        //设置cookie的有效时间，单位是秒
        //默认是-1
        //负数：cookie的数据存在浏览器缓存中
        //0：删除，路径要保持一致，否则可能删错
        //正数：缓存（持久化到磁盘）的时间
        ck.setMaxAge(60 * 5);//保存时间为5分钟

        //设置cookie的path
//        ck.setPath(req.getContextPath());
        ck.setPath("/");

        //并把信息写回客户端
        resp.addCookie(ck);
    }

    /**
     * 日期格式化
     * * @return
     */
    public static String getTimeYYYY_MM_DD_HH_MM_SS(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        return format.format(date);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
