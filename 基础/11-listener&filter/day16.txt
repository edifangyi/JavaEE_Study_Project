回顾:
ajax:
	异步请求
原生的ajax(了解)
	1.创建一个核心对象 XMLHttpRequest
	2.编写回调函数
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				alert(xmlhttp.responseText);
			}
		}
	3.open操作
		xmlhttp.open("请求方式","请求路径");
	4.send操作
		xmlhttp.send([参数]);
			post请求的参数放在send里面
			注意:若请求方式为post且有参数 必须设置一个头
jquery中ajax
	掌握:
		$.get(url,params,function(data){},type);
			type:以后常用的是json
		$.post(url,params,function(data){},type);
	了解:
		jquery对象.load(...)
	理解:
		$.ajax(选项)
			选项:
				url
				type
				data
				success:fn
				error:fn
				dataType:"json"
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
listener(了解) 监听器
filter(★)	过滤器
//////////////////////////
listener:
	监听器
	作用:
		监听web中中的域对象 ServletContext ServletRequest HttpSession
	监听内容:
		监听三个对象的创建和销毁
		监听三个对象属性的变化
		监听session中javabean的状态
	
	注意:listener全部是接口
		
监听三个对象的创建和销毁
	ServletContextListener
	ServletRequestListener
	HttpSessionListener
监听三个对象属性的变化
	ServletContextAttributeListener
	ServletRequestAttributeListener
	HttpSessionAttributeListener
监听session中javabean的状态
	HttpSessionActivationListener(钝化和活化)
	HttpSessionBindingListener(绑定和解绑)

使用步骤:
	1.编写一个类 实现接口
	2.重写方法
	3.编写配置文件(大部分都是)
	
演示各个监听器
	监听三个对象的创建和销毁
		ServletContextListener
			创建:服务器启动的时候,会为每一个项目都创建一个servletContext
			销毁:服务器关闭的时候,或者项目被移除的时候
			以后用来加载配置文件
		ServletRequestListener
			创建:请求来的时候
			销毁:响应生成的时候
		HttpSessionListener
			创建:
				java中第一次调用request.getSession的时候
				jsp访问的时候创建
			销毁:
				三种情况:
					session超时
					手动销毁session
					服务器非正常关闭
	监听三个对象属性的变化(添加 替换 删除)
		ServletContextAttributeListener
		ServletRequestAttributeListener
		HttpSessionAttributeListener
	监听session中javabean的状态
		注意:这两个接口需要javabean实现.是让javabean感知到自己的状态
		
		HttpSessionBindingListener(绑定和解绑)
			检测java是否添加到session或者从session中移除
		HttpSessionActivationListener(钝化和活化)
			钝化:javabean从session中序列化到磁盘上
			活化:javabean从磁盘上加载到了session中
			可以通过配置文件修改javabean什么时候钝化
				修改一个项目
					只需要在项目下/meta-info创建一个context.xml
					内容如下:
						<Context>
							<!--
								maxIdleSwap	:1分钟 如果session不使用就会序列化到硬盘.
								directory	:itheima 序列化到硬盘的文件存放的位置.
							-->
							<Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
								<Store className="org.apache.catalina.session.FileStore" directory="itheima"/>
							</Manager>
						</Context>
		
//////////////////////////////////////////////////
案例1-自动登录
需求:
	登录的时候,勾选自动登录,登录成功之后,关闭浏览器,下一次访问网站的时候完成登录操作(自动登录).
技术分析:
	filter
	cookie
//////////////////////////////////
filter:过滤器
	过滤请求和响应
	作用:
		自动登录.
		统一编码.
		过滤关键字
		....
	Filter是一个接口
编写filter步骤:
	1.编写一个类
		a.实现filter接口
		b.重写方法
	2.编写配置文件
		a.注册filter
		b.绑定路径
	3.测试

Filter接口的方法:
	init(FilterConfig config):初始化操作
	doFilter(ServletRequest request, ServletResponse response, FilterChain chain):处理业务逻辑
	destroy() :销毁操作
filter的生命周期(了解)
	filter单实例多线程
	filter在服务器启动的时候 服务器创建filter 调用init方法 实现初始化操作
	请求来的时候,创建一个线程 根据路径调用dofilter 执行业务逻辑
	当filter被移除的时候或者服务器正常关闭的时候 调用destory方法 执行销毁操作.
FilterChain:过滤链
	通过chain的dofilter方法,可以将请求放行到下一个过滤器,直到最后一个过滤器放行才可以访问到servlet|jsp
	doFilter()放行方法
★url-pattern配置
	3种
	完全匹配	必须以"/" 开始  例如: /a/b
	目录匹配	必须以"/" 开始 以"*"结束  例如:/a/b/*
	后缀名匹配	以"*."开始 以字符结束   例如 :  *.jsp  *.do  *.action
例如:
	afilter  路径  /*
	bFilter  路径  /demo4
★一个资源有可能被多个过滤器匹配成功,多个过滤器的执行顺序是按照web.xml中filter-mapping的顺序执行的
	
///////////////////////////////
步骤分析:
	1.数据库和表
		create database day16;
		use day16;
		create table user(
			id int primary key auto_increment,
			username varchar(20),
			password varchar(20)
		);
		insert into user values(null,'tom','123');
	2.web项目
		jar包 工具类 配置文件
	3.新建一个登录页面 表单
	4.表单提交 loginservlet
		接受用户名和密码
		调用service完成登录操作,返回值User
		判断user是否为空
			若不为空,将user放入session中
				判断是否勾选了自动登录
					若勾选了:
						需要将用户名和密码写回浏览器
	5.下次访问网站的时候
		过滤器拦截任意请求
			判断有无指定的cookie
				有cookie,获取用户名和密码
				调用service完成登录操作,返回user
				当user不为空的时候将user放入session中.

当我们换用jack登录的时候发现登录不了
	自动登录只需要登录一次:当session中没有用户的时候
	访问有些资源是不需要自动登录的(和登录还有注册相关的资源)
	
	修改filter的逻辑:
		首先判断session中是否有user
			若没有 并且访问的路径不是和登录注册相关的时候
				才去获取指定的cookie
/////////////////////////////////////////////////////// 
///////////////////////////////////////////////////////
filter总结
	filterConfig:(了解)
		过滤器的配置对象
		作用:
			获取全局管理者
			获取当前filter的名称
			获取当前filter的初始化参数
	
	filter-mapping的子标签(理解)
		servlet-name:匹配那个servlet 值写的是serlvet标签中servlet-name的值
			建议:不要在一个filter中重复的匹配servlet
				例如: serlvet的url-pattern为  /a/b/hello   serlvetname:HelloServlet
					如果filter中的url-pattern  /*
					最好不要在写 servlet-name:HelloServlet
				
		dispatcher:
			匹配哪种请求
			默认的是REQUEST,一旦显式的写出来哪种请求,默认就不起作用了
				理解
					REQUEST:从浏览器发送过来的请求(默认) 理解
					FORWARD:转发过来的请求 理解
				
				了解
					ERROR:因服务器错误而发送过来的请求
					INCLUDE:包含过来的请求
//////////////////////////				
//////////////////////////
案例2-统一字符编码
需求:
	以前我们开发的时候若有参数,第一步都是设置编码,才不会出现乱码,通过过滤器设置,到servlet或者jsp上的时候已经没有乱码问题
技术分析:
	filter 配置路径/* 过滤器的第一个位置
	在filter中重写getParameter(加强)
步骤分析:
	我们只需要在filter中 对request进行加强(例如:只对request.getParameter()进行加强)

	方法加强:
		1.继承(获取构造器)
		2.装饰者模式(静态代理)
		3.动态代理
		
	装饰者书写步骤:
		1.要求装饰者和被装饰者实现同一个接口或者继承同一个类
		2.装饰者中要有被装饰者的引用
		3.对需要加强方法进行加强
		4.对不需要加强的方法调用原来的方法即可
		
	加强request.getParameter(String key)
		首先请求的方式不同,处理的方式也不同
			获取请求的方法
			若是get请求
				new String(value.getBytes("iso8859-1"),"utf-8");
			若是post请求
				只需要设置一句话
				request.setCharacterEncoding("utf-8");
				
	最后将包装过的request对象(MyRequest)传递给servlet即可
///////////////////////////////////////////////////				
///////////////////////////////////////////////////
 关于获取参数的方法
	String getParameter(String name);// arr[0]
	String[] getParameterValues(String name);// map.get(name)
	Map<String,String[]> getParameterMap();
			
			

//////////////////////////////////////////////
//////////////////////////////////////////////
listener 监听器
	监听javaweb中的三个域对象
	
	监听三个对象的创建和销毁
		ServletContextListener
		ServletRequestListener
		HttpSessionListener
	监听三个对象属性的变化
		ServletContextAttributeListener
		ServletRequestAttributeListener
		HttpSessionAttributeListener
	监听javabean在session中的状态
		注意:	javabean实现的接口 不需要在web.xml中配置
		HttpSessionActivationListener(javabean的活化和钝化)
		HttpSessionBindingListener(添加到session中还是从session中移除)
	
	编写步骤:
		1.编写一个类  实现接口
		2.编写配置文件 
			<listener>
				<listener-class>....
			</listener>
/////////////////////////////////////
filter 接口,过滤请求和响应
	编写步骤:
		1.编写一个类 
			实现filter 重写三个方法
		2.编写配置文件	
			注册filter 绑定路径
	filter的生命周期(了解)
	url-pattern配置(和servlet一样)
		一个路径匹配到多个filter的时候,执行顺序有有web.xml中filter-mapping的顺序来决定的
	FilterChain
		必须放行才有可能到下一个Filter或者资源上
//////////////////////
		
	















