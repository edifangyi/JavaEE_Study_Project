package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet {
	@Override
	//初始化登录次数
	public void init() throws ServletException {
		//获取全局管理者
		ServletContext context=getServletContext();
		
		//初始化次数
		context.setAttribute("count", 0);
		
		System.out.println("初始化次数成功");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//1.接受用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//2.调用userservice 里的login(username,password) 返回值:User user
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络异常,请稍后再试!");
		}
		
		//3.判断user是否为空
		if(user==null){
			//3.1若为空 写"用户名和密码不匹配"
			response.getWriter().print("用户名和密码不匹配,3秒之后跳转");
			//案例2-定时跳转
			response.setHeader("refresh", "3;url=/day0902/login.htm");
			
		}else{
			//3.2若不为空 写"xxx:欢迎回来"
			response.getWriter().print(user.getUsername()+":欢迎回来");
			
			//4.获取全局管理者
			ServletContext context = this.getServletContext();
			
			//5.获取总次数
			Integer cishu = (Integer) context.getAttribute("count");
			
			//6.将次数+1
			cishu++;
			
			//7.将次数再次放入域对象中
			context.setAttribute("count", cishu);
			
		}
	}
}
