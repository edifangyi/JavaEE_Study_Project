sp/el/jstl
案例1-在页面中展示所有商品信息,不要使用jsp的脚本
技术分析:
	jsp/el/jstl
/**

 */
jsp:
	java 服务器页面
	作用:
		将内容的生成和信息的展示相分离
	运行在服务器端,本质上就是一个serlvet,产生的java文件和class保留在tomcat的word目录下.
jsp脚本:
	<%..%> java代码片段
	<%=..%> 输出表达式 相当于out.print();
	<%!...%> 声明成员
jsp的指令
	作用:声明jsp页面的一些属性和动作
	格式:
		<%@指令名称 属性="值" 属性="值"%>
	jsp指令的分类:
		page:主要声明jsp页面的一些属性
		include:静态包含.
		taglib:导入标签库
	注意:
		一个页面中可以出现多个指令
		指令可以放在任意位置,一般都放在jsp页面最上面.
///////////////////////////
	page指令:
		重要属性:3个
			contentType:设置响应流的编码,及通知浏览器用什么编码打开.设置文件的mimetype
			pageEncoding:设置页面的编码
			import:导入所需要的包
			contentType和pageEncoding联系:
				若两者都出现的时候,各自使用各自的编码
				若只出现一者,两个都使用出现的这个编码
				若两者都不出现,使用服务器默认的编码 tomcat7使用的iso-8859-1
		了解属性:
			language:当前jsp页面里面可以嵌套的语言
			buffer:设置jsp页面的流的缓冲区的大小
			autoFlush:是否自动刷新
			extends:声明当前jsp的页面继承于那个类.必须继承的是httpservlet 及其子类
			session:设置jsp页面是否可以使用session内置对象
			isELIgnored:是否忽略el表达式
			errorPage:当前jsp页面出现异常的时候要跳转到的jsp页面
			isErrorPage:当前jsp页面是否是一个错误页面
				若值为true,可以使用jsp页面的一个内置对象 exception
	

	include指令:
			静态包含,就是将其他页面或者servlet的内容包含进来,一起进行编译运行.生成一个java文件.
			格式:
				<%@include file="相对路径或者是内部路径" %>
			例如:
				<%@include file="/jsp/include/i1.jsp" %>
				
			路径:
				相对路径:
					./或者什么都不写 当前路径
					上一级路径  ../
				绝对路径:
					带协议和主机的绝对路径
					不带协议和主机的绝对路径
						/项目名/资源
						
				内部路径:
					不带协议和主机的绝对路径去掉项目名
						请求转发 静态包含 动态包含
				
	taglib指令:导入标签库	
		格式:
			 <%@taglib prefix="前缀名" uri="名称空间" %>
		若导入之后
			<前缀名:标签 .. >
		例如:
			<c:if test="">输出内容</c:if>

/**

 */

		
jsp的内置对象:★★★(9大内置对象)
	在jsp页面上可以直接使用的对象
		内置对象			类型
		out				JspWriter
		request			HttpServletRequest
		response		HttpServletResponse
		session			HttpSession
		
		exception		Throwable
		
		page			Servlet(this)
		config			ServletConfig
		application		ServletContext
		
		pageContext		PageContext
	jsp的域对象:理解
		application		整个项目
		session			一次会话
		request			一次请求
		pageContext		一个页面
	pagecontext作用:理解
		1.域对象
			xxxAttribute()
		2.操作其他域对象
			方法:
				xxxAttribute(...,int scope);
					scope取值:
						APPLICATION_SCOPE 
						SESSION_SCOPE 
						REQUEST_SCOPE 
						PAGE_SCOPE 
		3.获取其他的内置对象
			getXxx()
			注意:
				getRequest():获取request内置对象
		4.便捷查找,
			findAttribute(String key):
				依次从pagecontext,request,session,application四个域中,查找相应的属性,若查找到了返回值,且结束该次查找
				若查找不到,返回一个null


jsp的动作标签
	<jsp:forward>:请求转发  相当于java中  request.getRequestDispatcher(..).forward(..);
		<jsp:forward page="内部路径"></jsp:forward>
	<jsp:include>:动态包含
		就是将被包含页面或者servlet的运行结果包含到当前页面中.

		
/**
 
 */


el:
	jsp的内置表达式语言,从jsp2.0开始.
	用来替代<%=..%>
	作用:
		1.获取域中数据 ★
		2.执行运算 ★
		3.获取常见的web对象
		4.调用java的方法
	格式:
		${el表达式}
		
获取域中数据:★
	注意:★
		若属性名中出现了"."|"+"|"-"等特殊符号,需要使用scope获取
			例如:
				${requestScope["arr.age"] }
	获取简单数据
		${pageScope|requestScope|sessionScope|applicationScope.属性名}
		以后经常使用:
			${属性名}:依次从pageContext,request,session,application查找指定属性,若查找到返回值,结束该次查找
				若查找不到,返回""
	获取复杂数据
		获取数组中的数据
			${域中的名称[index]}
		获取list中的数据
			${域中的名称[index]}
		获取map中的数据
			${域中的名称.键名}
	javabean导航
		javabean:
			java语言编写的一个可重用的组件,
			狭义上来说就是我们编写的一个普通的java类 例如:User Person 
			javabean规范:
				1.必须是一个公共的具体的类  public class
				2.提供私有的字段  private String id;//id称之为字段
				3.提供公共访问字段的方法 get|set|is方法
					public String getId(){..}
					一旦有公共的方法之后,get|set|is之后的内容,将首字母小写,将这个东西称之为bean属性
						id就是一个bean属性
				4.提供一个无参的构造器
				5.一般实现序列化接口  serializable
		
		${域中javabean名称.bean属性}
//////////////////
执行运算:
	四则运算 关系(>..) 逻辑(&& ||)
	注意:
		+:只能进行加法运算,字符串形式数字可以进行加法运算.
		empty:判断一个容器的长度是否为0(array set list map),还可以判断一个对象是否为空
			${empty 域中的对象名称}
		三元运算符

/**

 */

el的内置对象(了解)
	11个
		pageScope
		requestScope
		sessionScope
		applicationScope
		
		param
		paramValues
		
		header
		haederValues
		
		initParam
		
		cookie★
		
		pageContext★
	注意:
		除了pagecontext其余对象获取的全是map集合
	
	了解:和参数相关的el内置对象
		param
		paramValues
		
	了解:和请求头相关的el内置对象
		header
		haederValues
	
	了解:和全局初始化参数相关的el内置对象
		initParam
		
	cookie内置对象:
		${cookie} 获取map{key=Cookie}
			例如:创建cookie
				Cookie c=new Cookie("username","tom");
			通过${cookie}获取相当于	
				{username=new Cookie("username","tom")}
			相当于map的key是cookie的键
			map的value是当前cookie
			
		若项获取名称username的cookie的value值(获取tom)
			${cookie.username.value}--javabean导航
		注意:
			java中Cookie的api
				getName():获取cookie的名称
				getValue():获取cookie的value值
			我们称name和value是cookie的bean属性
	
		使用cookie内置对象:
			${cookie.给cookie起名字.value}
			
		例如:
			获取jsession的值
			${cookie.JSESSIONID.value}
			
	pageContext:获取不是map集合,相当于jsp的pageContext内置对象
			在jsp页面中获取项目名
			${pageContext.request.contextPath}
/////////////////////////////////////////		
/////////////////////////////////////////		
jsp注释:
	html注释 <!--  -->
		注释的内容只在页面上看不到  java代码和html源代码都有
	java注释 
		只在java代码中存在
	jsp注释 <%--  --%>
		只在jsp页面中存在,翻译成java文件之后就没有了
///////////////////////
///////////////////////
jstl:
	jsp标准的标签库语言
	apache的
	用来替代java脚本
	使用步骤:
		1.导入jar包 (jstl.jar和standard.jar)
		2.在页面上导入标签库
			<%@taglib prefix="" uri=""%>
			
			例如:
				<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	jstl的分类:
		core:核心类库 ★
		fmt:格式化|国际化
		xml:过时了
		sql:过时了
		函数库:很少使用
	core:掌握
		★c:if
		★c:forEach
		
		c:set 往域中设置值
		c:choose c:when c:otherwise 分支
		
	★c:if 判断
		<c:if test="${el表达式}">满足的时候输出的内容</c:if>
		例如:
			<c:if test="${3>4 }">
				3大于4
			</c:if>
			<c:if test="${3<=4 }">
				3不大于4
			</c:if>
			//////////////
	★c:forEach 循环
		格式1:
			 <c:forEach begin="从那里开始" end="到那里结束" step="步长" var="给变量起个名字" varStatus="循环状态变量">
				${i }--${vs.count }--${vs.current }<br>
			 </c:forEach>
			 
			varStatus:用来记录循环的状态
				常用的属性:
					count:记录次数
					current:当前遍历的内容
		例如:
			<c:forEach begin="1" end="20" step="2" var="i" varStatus="vs">
				${i }--${vs.count }--${vs.current }<br>
			</c:forEach>
		
		格式2:
			<c:forEach items="${el获取域中的容器}" var="n">
				${n }
			</c:forEach>
			
			例如:
				//遍历list
				<c:forEach items="${list }" var="n">
					${n }
				</c:forEach>
				
				//遍历map
				 <c:forEach items="${map }" var="en">
					${en.key }-- ${en.value }<br/>
				  </c:forEach>
		
扩展:
	c:set 和 c:choose
	函数库:
//////////////////////////
案例1-步骤分析:
	1.数据库和表
		create database day12;
		use day12;
		create table product(
			id int primary key auto_increment,
			pname varchar(20),
			price double,
			pdesc varchar(20)
		);

		insert into product values (null,'电视机',3200,'液晶曲面大电视');
		insert into product values (null,'韭菜盒子',3,'味重请小心食用');
		insert into product values (null,'益达',10,'韭菜伴侣');
		insert into product values (null,'十三香',12,'守义牌');
		
		新建一个项目
			导入jar包:
				驱动 dbutils c3p0 jstl
			导入c3p0配置文件 和工具类
			实体类:
					private int id;
					private String pname;
					private double price;
					private String pdesc;
	2.index.jsp中添加一个连接
		<a href="/day1201/findAll">展示所有商品</a>
	3.FindAllServlet:
		调用ProductService.findAll() 返回一个集合 List<Product>
		将list放入request域中
		请求转发到product_list.jsp
	4.ProductService.findAll() 调用dao.findAll()
	5.dao.findAll()  使用beanListHandler()
	6.在product_list.jsp展示所有商品
		使用 c:forEach
		使用javabean导航获取里面的数据
/////////////////////////////
案例2-重写登录案例
需求:
	在页面上填写用户名和密码及验证码,点击提交,先校验验证码是否一致.若一致后再去找数据库.顺便记住用户名
技术:
	表单 
	验证码
	servlet
	request
	session
	cookie
步骤分析:
	1.数据库和表
		create table user(
			id int primary key auto_increment,
			username varchar(20),
			password varchar(20)
		);
	2.创建一个项目
		包结构
		jar包
		工具类和配置文件
	3.表单 login.jsp
	4.表单提交 loginServlet
		loginServlet:
			获取验证码(从前台传过来和session中)
				判断两个验证码是否一致
					若不一致:
						填写错误信息,请求转发到login.jsp
					若一致:获取用户名和密码
						调用userService的getuserbyusernameandpassword 返回值 User user
						判断user是否为空
							若为空:填写错误信息,请求转发到login.jsp
							若不为空:
								继续判断是否勾选了记住用户名
									若勾选:
										创建cookie 将用户名放入cookie写回浏览器
								将user对象放入session中
								页面重定向 index.jsp 展示 xxx:欢迎回来
						
		





		
		
		
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
上午回顾:
jsp:
	作用:
		将内容的生成和信息的展示相分离
	jsp脚本:
	jsp的指令:
		作用:声明jsp页面的一些属性或者动作
		格式:
			<%@指令名 属性=值 属性=值%>
		page:
			重要属性:
				import
				pageEncoding:
				contentType:
			
			了解:
				isErrorPage:一旦值为true 可以使用jsp的一个内置对象 exception
		include:静态包含,就是将被包含页面或者servlet的所有内容复制过来一起编译运行,只生成一个java文件
		taglib:导入标签库
	jsp的内置对象:
		out
		request
		response
		session
		
		exception
		
		page
		config
		application
		
		pageContext
	jsp的域对象:
		pageContext
		request
		session
		application
		
		pageContext的使用:
			1.域对象 xxxAttribute()
			2.操作其他域对象 xxxAttribute(..,int scope)
			3.获取其他的内置对象 getXxx()
			4.便捷查找  findAttribute(String key):依次从小到大
	jsp的动作标签
		jsp:forward 请求转发
		jsp:include 动态包含 是将被包含页面或者servlet运行的结果包含进来

el:	jsp内置的表达式语言
	用来替代 <%=...%>
	作用:
		注意:
			若属性名中出现一些特殊符号 "."等等
				必须使用:${域Scope["属性名"]}
		1.获取域中的数据
			获取简单数据
				${域Scope.属性名}
				${域中的属性名}:依次从小到大
				
			获取复杂数据
				数组和list
					${域中的容器名称[index]}
				map
					${域中的容器名称.键名}
			javabean导航
				${域中的bean名称.bean属性}
		2.执行运算
			注意:
				+:加法运算
				empty:判断一个容器的长度是否为0,还能判断一个对象是否为空
					${empty 域中的对象}
					${not empty 域中的对象}
				三元运算符
		3.获取常见的web对象
		4.调用java的方法
	///////////////////
	el内置对象(11个)
		cookie:
			${cookie.cookie的key.value}
		pageContext
			${pageContext.request.contextPath}://动态获取项目名
////////////////////////////////
		
		
		
		



























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
/**

 */
/**

 */
/**

 */
