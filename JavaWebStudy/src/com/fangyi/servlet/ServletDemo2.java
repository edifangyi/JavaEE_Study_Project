package com.fangyi.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 继承GenericServlet类(适配器模式)
 *
 * Created by FANGYI on 2016/12/5.
 */
public class ServletDemo2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("==========================");
        System.out.println("hello ServletDemo2");
        System.out.println("hello ServletDemo2");
        System.out.println("==========================");
    }
}
