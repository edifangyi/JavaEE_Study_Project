package com.fangyi.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletResponseDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCode(resp);

        setCode2(resp);

    }

    /**
     * 响应编码字节输出流
     *
     * @param resp
     * @throws IOException
     */
    private void setCode2(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        ServletOutputStream sos = resp.getOutputStream();
        sos.write("你好 123".getBytes());//字节流
//        sos.write("你好 123".getBytes("UTF-8"));//getBytes默认编码为本地编码
    }

    /**
     * 响应编码
     *
     * @param resp
     * @throws IOException
     */
    private void setCode(HttpServletResponse resp) throws IOException {
        //        //服务器中默认的编码ISO-8859-1，不支持中文 tomcat规定的
//        resp.setCharacterEncoding("UTF-8");//告诉服务器应用使用UTF-8解析文本
//        resp.setHeader("content-type", "text/html;charset=UTF-8");//告诉浏览器使用什么编码

        //告诉服务器应用使用utf-8解析文本，告诉客户端使用什么编码
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();//得到一个字符输出流
        out.write("abcdef 123456 你好");//向客户端响应文本内容
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************ServletDemo4 doPost**************");
    }
}
