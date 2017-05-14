package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 展示登录人数的总次数
 */
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取全局管理者
		ServletContext context = this.getServletContext();
		
		//2.获取登录的次数
		Integer cishu=(Integer) context.getAttribute("count");
		
		//3.在页面上打印总次数
		response.getWriter().print("登录成功的总次数为:"+cishu);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
