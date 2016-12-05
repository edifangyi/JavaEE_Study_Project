package com.fangyi.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by FANGYI on 2016/12/5.
 */
public class ServletDemo1 implements Servlet {

    /**
     * 实例化
     * 在servlet第一次被访问时被调用
     */
    public ServletDemo1() {
    }

    /**
     * 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取启动信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务
     * 每次访问都被调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("==========================");
        System.out.println("hello servlet");
        System.out.println("hello servlet");
        System.out.println("==========================");
    }

    /**
     * 获取设备信息版权什么的
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {

    }
}
