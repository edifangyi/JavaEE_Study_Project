package com.fangyi.session.historyDemo2;

import com.fangyi.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 购物车
 * Created by FANGYI on 2016/12/6.
 */
public class HistoryShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("购物车有以下商品：<br/>");
        HttpSession session = req.getSession();
        //得到session对象
        List<Book> books = (List<Book>) session.getAttribute("cart");
        if (books == null) {
            out.print("你还什么都没买呢");
            resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/historyShowAllBookServlet");
            //response.sendRedirect(request.getContextPath()+"/servlet/showAllBooksServlet");
            return;
        }
        for (Book book : books) {
            out.write(book.getName() + "<br/>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
