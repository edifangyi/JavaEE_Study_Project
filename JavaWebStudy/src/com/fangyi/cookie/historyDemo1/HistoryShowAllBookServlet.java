package com.fangyi.cookie.historyDemo1;

import com.fangyi.bean.Book;
import com.fangyi.session.historyDemo2.HistoryDBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 历史记录
 * Created by FANGYI on 2016/12/6.
 */
public class HistoryShowAllBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.write("本网站有以下好书：<br/>");
        Map<String, Book> books = HistoryDBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            out.write("<a href='" + req.getContextPath() + "/historyDemo1/historyShowBookDetail?id=" + book.getKey() + "' target='_blank'>" + book.getValue().getName() + "</a><br/>");
        }


        out.write("<hr/>您最近浏览过的书有：<br/>");
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("historyBookId".equals(cookies[i].getName())) {//判断是否有historyBookId的cookie
                String value = cookies[i].getValue(); // 1-2-3
                String[] ids = value.split("-");
                for (int j = 0; j < ids.length; j++) {
                    Book book = HistoryDBUtil.findBookById(ids[j]);//根据ID得到指定的书
                    out.print(book.getName() + "<br/>");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

