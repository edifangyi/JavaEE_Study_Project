http:要求:掌握一些头信息
	超文本传输协议:
		规定数据的格式
	浏览器往服务器发送 ---- 请求
	服务器往浏览器回写 ---- 响应
	
请求:(request)
	组成部分:
		请求行 请求头 请求体
		

	请求行:请求信息的第一行
		格式:请求方式	访问的资源 协议/版本
		例如:GET /day0801/1.html HTTP/1.1
		请求方式:get和post
			get会把参数放在url的后面 post不会
			get参数大小有限制,post请求却没有限制
			get请求没有请求体;post请求有请求体 请求参数放在请求体中
	
	
	请求头:请求信息的第二行到空行结束
		格式:key/value (value可以是多个值)
		常见的请求头:
			Accept: text/html,image/bmp		--支持数据类型    text/html text/css text/javascript 大类型/小类型 mime类型
			Accept-Charset: ISO-8859-1	--字符集
			Accept-Encoding: gzip		--支持压缩
			Accept-Language:zh-cn 		--语言环境
			Host: www.itcast.cn:80		--访问主机
			If-Modified-Since: Tue, 11 Jul 2000 18:23:51 GMT	  --缓存文件的最后修改时间
			Referer: http://www.itcast.com/index.jsp	 --来自哪个页面、防盗链
			User-Agent: Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)
			Cookie
			Connection:Keep-Alive   	--链接状态
			
		掌握的头信息:
			Referer User-Agent Cookie If-Modified-Since
	请求体:空行以下的内容
		只有post才有请求体  get请求参数 http://xxxx?username=tom&password=123
		格式:username=tom&password=123


/**

 */

响应:(response)
	组成部分:
		响应行 响应头 响应体
	响应行:响应信息的第一行
		格式:协议/版本 状态码 状态码说明
		例如:HTTP/1.1 200 OK
		状态码:
			200 正常响应成功
			302 重定向
			304 读缓存
			404 用户操作资源不存在
			500 服务器内部异常
	响应头:从响应信息的第二行到空行结束
		格式:key/value(value可以是多个值)
		常见的头
			Location: http://www.it315.org/index.jsp 	--跳转方向 和302一起使用的
			Server:apache tomcat			--服务器型号
			Content-Encoding: gzip 			--数据压缩
			Content-Length: 80 			--数据长度
			Content-Language: zh-cn 		--语言环境
			Content-Type: text/html; charset=GB2312 		--数据类型
			Last-Modified: Tue, 11 Jul 2000 18:23:51 GMT	--最后修改时间
			Refresh: 1;url=http://www.it315.org		--定时刷新
			Content-Disposition: attachment; filename=aaa.zip	--下载
			Set-Cookie:SS=Q0=5Lb_nQ; path=/search
			Expires: -1					--缓存
			Cache-Control: no-cache  			--缓存
			Pragma: no-cache   				--缓存
			Connection: Keep-Alive   			--连接
		掌握的头信息
			Content-Type Location  Last-Modified Refresh Content-Disposition Set-Cookie
	响应体:空行以下的内容
		页面上展示的内容


/**

 */

案例1-完成登录案例.
需求:
	在页面上输入用户名和密码,提交到服务器上,服务器拿着用户名和密码去数据库中查找有无此用户
		若有用户,则提示登录成功
		若无此用户,则提示用户名密码不匹配
技术分析:
	表单
	servlet
	请求(request)
	响应(response)
////////////////////////////////////
表单:
	收集用户数据
	所有的字段要想提交到服务器必须 有name属性
	提交的地址 action
	请求方式:post
//////////////////////////////////////
servlet:
	动态的web开发技术,本质就是一个类,运行在服务器端的一个java小程序
	处理业务逻辑,生成动态web内容
编写一个servlet步骤:
	1.编写一个类
		a.继承HttpServlet
		b.重写doGet或者doPost方法
	2.编写配置文件(web-inf/web.xml)
		a.注册servlet
		b.绑定路径

		<servlet>
	        <servlet-name>httpServletRequest1</servlet-name>
	        <servlet-class>com.fangyi.HttpServletRequest1</servlet-class>
	    </servlet>

	    <servlet-mapping>
	        <servlet-name>httpServletRequest1</servlet-name>
	        <url-pattern>/httpServletRequest1</url-pattern>
	    </servlet-mapping>

	3.访问
		http://主机:端口号/项目名/路径

接受参数:  格式:key=value
	Sting value=request.getParameter("key")
	例如: http://localhost/day09/hello?username=tom
		request.getParameter("username")就可以获取tom值

回写内容:
	response
	response.getWriter().print("success");

	处理响应数据中文乱码:
		resp.setContentType("text/html;charset=utf-8"); //建议大家放在方法中的第一行

/**

 */


步骤分析:
	1.先有数据库和表
	
		create database day09;
		use day09;
		create table user(
			id int primary key auto_increment,
			username varchar(20),
			password varchar(20),
			email varchar(20),
			name varchar(20),
			sex varchar(10),
			birthday date,
			hobby varchar(50)
		);
		insert into user values (null,'tom','123','tom@126.com','tom','1','1988-01-01',null);
	2.创建工程
	3.复制页面
		修改login.html
			给用户名和密码添加name属性
			修改表单的action属性
				action="http://localhost/day0901/login"
			添加method属性
				method="post"
	4.导入jar包:
		驱动 dbutils c3p0
	5.导入工具类和配置文件
		datasourceUtils
		c3p0-config.xml(注意修改数据名称)
	6.创建servlet(LoginServlet: 路径 /login)
		接受用户名和密码
		调用service层(UserService)完成登录操作
		提示信息
	7.UserService
		login(username,password)
			调用dao
	8.dao
		通过用户名和密码查询数据库
		
/**

 */
serlvet总结:
servlet的体系结构:(了解)
	Servlet:接口
		|
	GenericServlet:抽象类
		|
	HttpServlet:抽象类
		|
	自定义servlet
	
	servlet常用方法:
		void init(ServletConfig config):初始化
		void service(ServletRequest request,ServletResponse response):服务 处理业务逻辑
		void destroy():销毁
		
		ServletConfig getServletConfig() :获取当前servlet的配置对象
	
	GenericServlet常用方法:	
		除了service方法没有显示,其他都实现了
		空参的Init() 若我们自己想对servlet进行初始化操作,重写这个init()方法即可
	
	HttpServlet常用方法：
		service做了实现，把参数强转，调用了重载的service方法
			重载的service方法获取请求的方式,根据请求方式的不同调用相应doXxx()方法
		doGet和doPost方法
	////////////////////////////////
servlet生命周期 ★★★
	void init(ServletConfig config):初始化
	 * 初始化方法
	 * 执行者:服务器
	 * 执行次数:一次
	 * 执行时机:默认第一次访问的时候
	void service(ServletRequest request,ServletResponse response):服务 处理业务逻辑
	 * 服务
	 * 执行者:服务器
	 * 执行次数:请求一次执行一次
	 * 执行时机:请求来的时候
	void destroy():销毁
	 * 销毁
	 * 执行者:服务器
	 * 执行次数:只执行一次
	 * 执行时机:当servlet被移除的时候或者服务器正常关闭的时候
	 
	 serlvet是单实例多线程
	 默认第一次访问的时候,服务器创建servlet,并调用init实现初始化操作.并调用一次service方法
	 每当请求来的时候,服务器创建一个线程,调用service方法执行自己的业务逻辑
	 当serlvet被移除的时候服务器正常关闭的时候,服务器调用servlet的destroy方法实现销毁操作.


/**

 */

url-pattern的配置:★
	方式1:完全匹配  必须以"/"开始 例如: /hello /a/b/c
	方式2:目录匹配  必须"/"开始  以"*"结束   例如: /a/*  /*
	方式3:后缀名匹配 以"*"开始 以字符结尾 例如: *.jsp  *.do  *.action
	
	优先级:
		完全匹配>目录匹配>后缀名匹配
 练习:
	有如下的一些映射关系：
		Servlet1 映射到 /abc/* 
		Servlet2 映射到 /*
		Servlet3 映射到 /abc 
		Servlet4 映射到 *.do 
	问题:
	当请求URL为“/abc/a.html”，“/abc/*”和“/*”都匹配，哪个servlet响应
		Servlet引擎将调用Servlet1。
	当请求URL为“/abc”时，“/*”和“/abc”都匹配，哪个servlet响应
		Servlet引擎将调用Servlet3。
	当请求URL为“/abc/a.do”时，“/abc/*”和“*.do”都匹配，哪个servlet响应
		Servlet引擎将调用Servlet1。
	当请求URL为“/a.do”时，“/*”和“*.do”都匹配，哪个servlet响应
		Servlet引擎将调用Servlet2.
	当请求URL为“/xxx/yyy/a.do”时，“/*”和“*.do”都匹配，哪个servlet响应
		Servlet引擎将调用Servlet2。												*/

///////////////////////////

    <!--<servlet-mapping>-->
    <!--<servlet-name>servletDemo4</servlet-name>-->
    <!--.do 结尾的都会访问servletDemo4-->
    <!--<url-pattern>*.do</url-pattern>-->
    <!--</servlet-mapping>-->

    <!--<servlet-mapping>-->
    <!--<servlet-name>servletDemo4</servlet-name>-->
    <!--/* 输入什么都访问 servletDemo4-->
    <!--<url-pattern>/*</url-pattern>-->
    <!--</servlet-mapping>-->

    <servlet-mapping>
        <servlet-name>servletDemo4</servlet-name>
        <!-- /action/* 输入什么都访问,多个/也没事 servletDemo4-->
        <url-pattern>/action/*</url-pattern>
    </servlet-mapping> 													*/

/**

 */

在servlet标签有一个子标签 load-on-startup
	作用:用来修改servlet的初始化时机
	取值:正整数  值越大优先级越低
///////////////////////
当我们的配置文件里面没有指定配置的话,会查找tomcat的web.xml,
	若请求我们自己的项目处理不了,tomcat的默认的servlet会帮我们处理信息



    <!--首次启动页面-->
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

/**
 
 */
路径的写法:
	相对路径:
		当前路径    ./ 或者 什么都不写
		上一级路径 ../
	绝对路径:(我们使用)
		带主机和协议的绝对路径(访问站外资源)
			http://www.itheima.com/xxxx
			http://localhost:80/day09/hello
		不带主机和协议的绝对路径
			/day09/hello(经常使用)

/**
 
 */

案例2-当我们登录失败,提示"用户名密码不匹配",3秒以后跳转到登录页面
技术分析:
	定时刷新
常见的响应头-refresh
	响应头格式:
		refresh:秒数;url=跳转的路径
	设置响应头:
		response.setHeader(String key,String value);设置字符串形式的响应头
		response.addHeader(String key,String value);追加响应头, 若之前设置设置过这个头,则追加;若没有设置过,则设置
	设置定时刷新:
		response.setHeader("refresh","3;url=/day0901/login.htm");
步骤分析:
	登录失败之后,修改业务逻辑
		打印之后添加一个头信息即可
		


		//3.判断user是否为空
		if(user==null){
			//3.1若为空 写"用户名和密码不匹配"
			response.getWriter().print("用户名和密码不匹配,3秒之后跳转");
			//案例2-定时跳转
			response.setHeader("refresh", "3;url=/day0901/login.htm");
			
		}else{
			//3.2若不为空 写"xxx:欢迎回来"
			response.getWriter().print(user.getUsername()+":欢迎回来");
			
		}

/**
 
 */

案例3-统计登录成功的总人次,
需求:
	在一个用户登录成功之后,获取之前登录成功总人次,将次数+1.在访问另一个servlet的时候,显示登录成功的总人次
技术分析:
	ServletContext

////////////////////////////////////////////////////////////

ServletContext:
	上下文(全局管理者)
	常用的方法:
		setAttribute(String key,Object value);//设置值
		Object getAttribute(String key);//获取值
		removeAttribute(String key)://移除值
获取全局管理者:
	getServletContext():

////////////////////////////////////////////////////////////

步骤分析:
	1.在项目启动的时候,初始化登录次数
		在loginservlet的init()方法中获取全局管理者,将值初始化为0,放入servletcontext上
	2.登录成功之后,在loginservlet中获取全局管理者,获取登录成功的总次数
	3.然后将次数+1,让后将值设置回去
	4.当访问showServlet的时候,获取全局管理者,获取登录成功的总次数,然后在页面上打印出来即可


/**
 * 写入次数
 */
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
		//3.判断user是否为空
		if(user==null){

		}else{
			
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


/**
 
 */

ServletConfig:(了解)
	servlet配置对象
	作用:
		1.获取当前servlet的名称
		2.获取当前servlet的初始化参数
		3.获取全局管理者
	方法:
		String getServletName():获取当前servlet的名称(web.xml配置的servlet-name)
		
		String  getInitParameter(String key):通过名称获取指定的参数值
		Enumeration getInitParameterNames() :获取所有的参数名称
			初始化参数是放在 web.xml文件 
				servlet标签下子标签 init-param
				
		★getServletContext():获取全局管理者


	servletconfig是由服务器创建的,在创建servlet的同时也创建了它,通过servlet的init(ServletConfig config)将config对象
	传递给servlet,由servlet的getServletConfig方法获取


/**
 * servletconfig 对象的常用方法
 */
public class SConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取servletconfig
		ServletConfig config = this.getServletConfig();
		
		//获取当前servlet的名称
		String servletName=config.getServletName();
		System.out.println("名称:"+servletName);
		
		//获取初始化参数
		String user=config.getInitParameter("user");
		System.out.println("获取单一的值user:"+user);
		
		
		System.out.println("===================");
		
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("参数名称:"+name);
		}
		
	}
}

 <servlet>
    <description></description>
    <display-name>SConfigServlet</display-name>
    <servlet-name>SConfigServlet</servlet-name>
    <servlet-class>com.itheima.d_config.SConfigServlet</servlet-class>
    <init-param>
      <param-name>user</param-name>
      <param-value>root</param-value>
    </init-param>
    <init-param>
      <param-name>password</param-name>
      <param-value>1234</param-value>
    </init-param>
 </servlet>




 <servlet-mapping>
    <servlet-name>SConfigServlet</servlet-name>
    <url-pattern>/sconfig</url-pattern>
 </servlet-mapping>

/**

 */

ServletContext:理解
	上下文(全局管理者)
	一个项目的引用.代表了当前项目.
	当项目启动的时候,服务器为每一个web项目创建一个servletcontext对象.
	当项目被移除的时候或者服务器关闭的时候servletcontext销毁
	作用:
		1.获取全局的初始化参数
		2.共享资源(xxxAttribute)
		3.获取文件资源
		4.其他操作
	获取servletcontext:
		方式1:了解 
			getServletConfig().getServletContext()
		方式2:
			getServletContext()
	常用方法:
		1.了解
			String  getInitParameter(String key):通过名称获取指定的参数值
			Enumeration getInitParameterNames() :获取所有的参数名称	
			 在根标签下有一个 context-param子标签 用来存放初始化参数
				<context-param>
					<param-name>encoding</param-name>
					<param-value>utf-8</param-value>
				</context-param>
		2.xxxAttribute
		3.
			String getRealPath(String path):获取文件部署到tomcat上的真实路径(带tomcat路径)
				getRealPath("/"):D:\javaTools\apache-tomcat-7.0.52\webapps\day09\
			InputStream getResourceAsStream(String path):以流的形式返回一个文件
		4.获取文件的mime类型  大类型/小类型
			String getMimeType(String 文件名称)



/**
 * servletcontext 的常用方法
 */
public class ScontextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取全局管理者
		ServletContext context = this.getServletContext();
		
		//获取初始化参数
		String encoding=context.getInitParameter("encoding");
		System.out.println("初始化参数:"+encoding);
		
		//获取文件的真实路径
		//String path = context.getRealPath("/");//项目目录下
		String path = context.getRealPath("/1.txt");//项目目录下
		System.out.println(path);
		
		//以流的形式返回一个文件
		InputStream is = context.getResourceAsStream("/1.txt");
		System.out.println(is);
		
		//获取文件的mime类型
		System.out.println("----------------");
		String mimeType = context.getMimeType("1.jpg");
		System.out.println(mimeType);
	}
}



/**

 */

域对象:★★★
	servletcontext
	当成map集合
		常用方法:
			xxxAttribute()
	servletcontext创建和销毁:
		当项目启动的时候,服务器为每一个web项目创建一个servletcontext对象.
		当项目被移除的时候或者服务器关闭的时候servletcontext销毁
	存放:
		共享的数据


/**

 */
获取文件的路径:
	通过类加载器获取文件:2.txt 放在classes目录下无论是java项目还是web项目都可以
		类.class.getClassLoader().getResource("2.txt").getPath()
		类.class.getClassLoader().getResourceAsStream("文件路径")
		



/**

 */
/**

 */
/**

 */
/**

 */
/**

 */
/**

 */




response:响应
	作用:
		往浏览器写东西
	组成部分:
		响应行 响应头 响应体
	操作响应行 
		格式:
			协议/版本 状态码 状态码说明
		状态码:
			1xx:已发送请求
			2xx:已完成响应
				200:正常响应
			3xx:还需浏览器进一步操作
				302:重定向 配合响应头:location
				304:读缓存
			4xx:用户操作错误
				404:用户操作错误.
				405:访问的方法不存在
			5xx:服务器错误
				500:内部异常
		常用方法:
			setStatus(int 状态码):针对于 1 2 3 
			了解 :
				sendError(int 状态码):针对于 4xx和5xx


	操作响应头 
		格式:key/value(value可以是多个值)
		

		常用的方法:
			setHeader(String key,String value):设置字符串形式的响应头
			了解:setIntHeader(String key,int value):设值整形的响应头
			了解:setDateHeader(String key,long value):设值时间的响应头
			
			addHeader(String key,String value):添加置字符串形式的响应头 之前设置过则追加,若没有设置过则设置
			了解:addIntHeader(String key,int value):添加整形的响应头
			了解:addDateHeader(String key,long value):添加时间的响应头
		

		常用的响应头:
			
			location:重定向
			refresh:定时刷新
			content-type:设置文件的mime类型,设置响应流的编码及告诉浏览器用什么编码打开
			content-disposition:文件下载
			
			重定向:	
				方式1:
				★   response.sendRedirect("/day10/loc2");
				方式2:
					response.setStatus(302);
					respooen.setHeader("location","/day10/loc2");
					
			定时刷新:
				方案1:设置头 refresh 昨天做过
					respooen.setHeader("refresh","秒数;url=跳转的路径");
				方案2:http的meta标签
					
					http-equiv : 响应头
					content    ：响应头的内容

					<meta http-equiv="refresh" content="3;url=/day10/refresh2.html">
					



		/////////////////////	
	操作响应体:
		页面上要展示的内容
		常用方法:
			Writer getWriter():字符流
			ServletOutputStream getOutputStream() :字节流
			
			自己写的东西用字符流,其他一概用字节流.
			
		处理响应中文乱码:
			方式1:★
				response.setContentType("text/html;charset=utf-8");
			方式2:理解
				response.setHeader("content-type", "text/html;charset=utf-8");
	
		注意:
			两个流互斥
			当响应完成之后,服务器会判断一下流是否已经关闭,若没有关闭,服务器会帮我们关闭.(底层使用的缓冲流)

/**

 */

文件下载:
	下载方式:
		1.超链接下载
			<a href="/day10/download/day10.txt">下载 day10.txt</a>
			若浏览器能解析该资源的mime类型,则打开;若不能接下则下载;
		2.编码下载 通过servlet完成
			<a href="/day10/download?name=day10.txt">下载 day10.txt</a>
			a.设置文件的mime类型
				String mimeType=context.getMimeType(文件名)
				response.setContentType(mimeType);
				
			b.设置下载头信息 content-disposition
				response.setHeader("content-disposition", "attachment;filename="+文件名称);
				
			c.提供流
				response.getOutputStream();
				
		扩展:使用commons-io工具类
			对拷流:
				IOUtils.copy(is,os);

////////////////////////////////////						

		<a href="/day10/download?name=1.gif">1.gif</a><br/>
		<a href="/day10/download?name=day10笔记.txt">day10笔记.txt</a><br/>
		<a href="/day10/download?name=day10.doc">day10.doc</a><br/>

////////////////////////////////////

		//获取下载文件的名称
		String filename = request.getParameter("name");
		
		//注意中文乱码:
		filename=new String(filename.getBytes("iso8859-1"),"utf-8");
		
		ServletContext context = this.getServletContext();
		//文件下载
		//1.设置文件的mimeType
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);
		
		//2.设置下载的头信息
		//上午的
		//response.setHeader("content-disposition", "attchment;filename="+filename);
		
		//常见的浏览器将文件名称使用utf-8 不推荐 不兼容火狐
		//response.setHeader("content-disposition", "attchment;filename="+URLEncoder.encode(filename, "utf-8"));
		
		//方式1:通过的方式 通过工具类编码
		//String _filename=DownLoadUtils.getName(request.getHeader("user-agent"), filename);
		//response.setHeader("content-disposition", "attachment;filename="+_filename);
		
		//方式2:网络上的方式 (8成好使)
		response.setHeader("content-disposition", "attachment;filename="+new String(filename.getBytes("gbk"),"iso8859-1"));
		
		//3.对拷流
		//获取输入流
		InputStream is = context.getResourceAsStream("/download/"+filename);
		
		//获取输出流
		ServletOutputStream os = response.getOutputStream();
		
		/*int len=-1;
		byte[] b=new byte[1024];
		
		while((len=is.read(b))!=-1){
			os.write(b, 0, len);
		}*/
		
		IOUtils.copy(is, os);
		
		os.close();
		is.close();

////////////////////////////////////////////

文件下载扩展:
	中文名称的文件名下载的时候名称会出现问题
	常见的浏览器需要提供文件名称的utf-8编码
	对于火狐来说需要提供文件名称的base64编码
		方案1:使用工具类
		方案2:网上的方式(8成好使)
			new String(filename.getByte("gbk"),"iso8859-1");



public class DownLoadUtils {
	public static String getName(String agent, String filename) throws UnsupportedEncodingException {
		if (agent.contains("MSIE")) {
			// IE浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			filename = URLEncoder.encode(filename, "utf-8");
		}
		return filename;
	}
}



/////////////////////////////
扩展:
	通过response生成验证码
	验证码:
		作用:防止暴力攻击
	点击换一张的js代码:
		function changeImg(obj){
			//操作src属性
			obj.src="/day10/code?i="+Math.random();
			//alert(1)
		}


/**

 */

案例2-完成用户注册操作
需求:
	在一个表单页面上填写用户数据,点击提交,将所有的数据提交的服务器上,通过java代码最终保存到数据库中.
技术分析:
	表单
	request
////////////////////////////////
request:请求
	作用:获取浏览器发送过来的数据
	组成部分:
		请求行 请求头 请求体
	操作请求行 
		格式:
			请求方式 请求资源 协议/版本
		常用方法:HttpServletRequest
			掌握
				String getMethod():获取请求方式
				String getRemoteAddr():获取ip地址
				String getContextPath() :在java中获取项目名称  (/day10)
 
			
			了解:
				getRequestURI():获取的是 从项目名到参数之前的内容  /day10/regist
				getRequestURL():获取的带协议的完整路径   http://localhost/day10/regist
				String getQueryString():get请求的所有参数   username=tom&password=123
				String getProtocol():获取协议和版本
				
		例如:请求行
			GET /day10/row?username=tom&password=123 HTTP/1.1
		//////////////////		
	操作请求头 
		格式:key/value(value可以是多个值)
		常用方法:
			★String getHeader(String key):通过key获取指定的value (一个)
			
			了解:
				Enumeration getHeaders(String name) :通过key获取指定的value(多个)
				Enumeration getHeaderNames() :获取所有的请求头的名称
				int getIntHeader(String key):获取整型的请求头
				long getDateHeader(String key):获取时间的请求头
		重要的请求头:
			user-agent:浏览器内核 msie firefox chrome
			referer:页面从那里来 防盗链



		//获取浏览器内核
		String agent = request.getHeader("user-agent");
		System.out.println(agent);
		
		//获取referer
		String referer = request.getHeader("referer");
		if(referer==null){
			System.out.println("直接在地址栏上输入的");
		}else if(referer.contains("localhost")){
			System.out.println("我自己点的..");
		}else if(referer.contains("192.168.")){
			System.out.println("哥们儿姐们儿点的");
		}else{
			System.out.println("盗链者可耻");
		}
 
		///////////////////
	操作请求参数 ★
		username=tom&password=123&hobby=drink&hobby=sleep
		常用方法:
			String getParameter(String key):获取一个值
			String[] getParameterValues(String key):通过一个key获取多个值
			Map<String,String[]> getParameterMap():获取所有的参数名称和值
			
			

		<form action="/day10/param_" method="get">
			用户名:<input name="username"><br/>
			密码:<input name="password"><br/>
			<input type="submit">
		</form>


		username:tom
		---------values---------
		hobby:[drink, sleep]
		=====map=======
		username::[tom]
		password::[123]
		hobby::[drink, sleep]
	//////////////////////
	请求的中文乱码:
		对于get请求:参数追加到地址栏,会使用utf-8编码,服务器(tomcat7)接受到请求之后,使用iso-8859-1解码,所以会出现乱码
		对于post请求,参数是放在请求体中,服务器获取请求体的时候使用iso-8859-1解码,也会出现乱码
		
		通用的方法:
			new String(参数.getBytes("iso-8859-1"),"utf-8");
		针对于post请求来说:只需要将请求流的编码设置成utf-8即可
			request.setCharacterEncoding("utf-8");

	扩展:
		URLEncoder.encode(s, "utf-8"); 指定编码
		URLDecoder.decode(s8, "iso8859-1");指定解码



		String s="黑马";
		String s8=URLEncoder.encode(s, "utf-8");//跟浏览器里post显示一样
		
		//System.out.println(s8);
		String so = URLDecoder.decode(s8, "iso8859-1");
		System.out.println(so);
		
		byte[] b = so.getBytes("iso-8859-1");
		String _s = new String(b, "utf-8");//解码
		System.out.println(_s);



/////////////////////////////////////////////////////////////

	<a href="/day10/row?username=tom&password=123">d_请求行</a><br>
	<a href="/day10/header">e_请求头</a><br>
	<a href="/day10/param?username=tom&password=123&hobby=drink&hobby=sleep">f_请求参数</a><br>
	<a href="/day10/form.html">请求参数</a><br>
	<a href="/day10/dis1?money=10">g_请求转发借钱</a><br>



		//获取 请求方式
		String m=request.getMethod();
		System.out.println("方式:"+m);
		
		//获取请求资源
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		System.out.println("uri:"+uri);
		System.out.println("url:"+url);
		
		//获取请求参数的字符串
		String s = request.getQueryString();
		System.out.println("get请求参数:"+s);
		
		//获取协议版本
		String p = request.getProtocol();
		System.out.println("协议:"+p);
		
		
		System.out.println("-------重要的----");
		
		//获取请求的ip
		String ip = request.getRemoteAddr();
		System.out.println("ip:"+ip);
		
		
		
		//获取项目名
		String path = request.getContextPath();
		System.out.println("项目路径:"+path);
/**

 */
案例2-步骤分析:
	1.数据库和表(day09)
	2.页面(表单)
		给每个字段添加name属性
		还需修改表单提交的路径 method=post
	3.表单提交到一个servlet(RegistServlet)
	4.RegistServlet:
		操作:
			接受数据,封装成一个user
			调用UserSerivce完成保存操作  int regist(User user)
			判断结果是否符合我们预期
				若int=1; 插入成功
				若int!=1; 插入失败
			相应的提示信息在当前的servlet不做处理,将信息转发给另一个servlet展示(MsgServlet);
	5.UserService
		调用dao
	6.userdao 通过dbutils在数据库中插入一条记录.
//////////////////
封装对象:
	apache提供的一个工具类
		BeanUtils
			封装数据
			使用步骤:
				1.导入jar包
				2.调用 BeanUtils.populate(Object bean,Map<> 参数);

/////////////////////////////////////////////////////////////
域对象:
	request:
		创建:一次请求来的时候
		销毁:响应生成的时候
		作用:
			一次请求里面的数据
		请求转发(请求链,请求串)
			request.getRequestDispatcher("内部路径").forward(request,response);


请求转发和重定向区别:
	重定向发送两次请求,请求转发一次请求
	
	重定向地址栏发生该表,请求转发不变
	
	重定向是从浏览器发送,请求转发是服务器内部
	
	重定向不存在request域对象,请求转发可以使用request域对象
	
	重定向是response的方法,请求转发是request的方法
	
	重定向可以请求站外资源,请求转发不可以




/**

 */




















































