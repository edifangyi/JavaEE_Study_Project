package com.fangyi.session.historyDemo2;

import com.fangyi.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 购物车
 * Created by FANGYI on 2016/12/6.
 */
public class HistoryShowAllBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        req.getSession();
        out.print("本网站有以下好书：<br/>");

        Map<String, Book> books = HistoryDBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            String url = req.getContextPath() + "/historyDemo2/historyAddCart?id=" + book.getKey();
            out.print("<a href='" + resp.encodeURL(url) + "' >" + book.getValue().getName() + "</a><br/>");//客户端禁用Cookie后的会话数据保存问题
        }

        String url2 = req.getContextPath() + "/historyDemo2/historyShowCart";//客户端禁用Cookie后的会话数据保存问题
        out.print("<a href='" + resp.encodeURL(url2) + "'>查看购物车</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

