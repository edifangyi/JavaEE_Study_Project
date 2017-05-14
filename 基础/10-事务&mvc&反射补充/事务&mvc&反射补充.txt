回顾:
jsp:
	java服务器页面
	jsp的脚本
	jsp的注释
		html注释
		java注释
		jsp注释
			<%-- --%>
	jsp的指令
		page:声明页面一些属性
			重要的属性:
				import
				pageEncoding
				contentType
			了解属性
				isErrorPage:一旦他的值为true jsp页面就是可以使用exception内置对象
		include:静态包含,(内容)
		taglib:导入标签库
		
	jsp的内置对象 9个
		out 
		request
		response
		session
		
		exception
		page
		config
		application
		pageContext
	jsp的域对象
		pageContext
		request
		session
		application
	jsp的动作标签
		jsp:forward 请求转发
		jsp:include 动态包含(运行结果)
el:
	从jsp2.0使用的内置表达式语言
	替代<%=...%>
	作用:
		1.获取域中的数据
			简单
				${域.域中属性名}
				${域中属性名}:若找不到返回一个""
				注意:
					若属性名字中有"."等特殊符号的时候
						必须使用 ${域["域中属性名"]}
			复杂
				数组和list ${域中名称[index]}
				map 	${域中的名称.键}
			javabean导航
				javabean:
					1.必须公共的类
					2.私有字段
					3.提供公共的访问字段的方法  get|set|is
						一旦提供公共的方法之后,get|set|is后面的名称首字母小写,这个东西称之为bean属性
							例如:getName()  name就是一个bean属性
					4.提供一个无参构造器
					5.一般会实现序列化接口
					
				${域中的属性名.bean属性}
		2.执行运算
			注意:
				+
				empty
				三元运算符
	el的内置对象:
		cookie
			${cookie.cookie名称.value}
		pageContext
			在jsp页面动态的获取项目路径 /day11
				${pageContext.request.contextPath}
jstl:
	jsp 标准标签库
	apache组织
	使用步骤:
		1.导入jar包
		2.在页面上导入标签库
	core:核心包
		c:if 判断
		c:forEach 循环
//////////////////////////////////////////////////
分层和事务
案例-使用mvc思想完成转账操作
需求:
	在一个页面上有汇款人 收款人 转账金额.一旦转账之后,汇款人金额减少,收款人金额增多.使用事务控制起来.
技术分析:
	mvc思想
	事务
///////////////////////////////////
mvc思想
	servlet-->缺点:生成html内容太麻烦
		|
	jsp--->缺点:阅读起来不方便,维护比较困难
		|
	jsp+javabean:
			jsp的model1:
				jsp:接受请求,展示数据
				javabean:和数据打交道 
		|
	jsp+javabean+servlet
			jsp的model2:
				jsp:展示数据
				javabean:和数据打交道
				servlet:接受请求,处理业务逻辑
			就是MVC思想的体现
MVC:
	就是将业务逻辑,代码,显示相分离的一种思想
	M:model 模型 作用:主要是封装数据,封装对数据的访问
	V:view 	视图 作用:主要是用来展示数据 一般是jsp担任的
	C:ctrl	控制 作用:接受请求,找到相应的javabean完成业务逻辑
/////////////////////////
jsp设计模式1 model1:(了解)
	javabean+jsp
	javabean在model1使用(了解)
		<!-- 接受值 -->
		<jsp:useBean id="u" class="com.itheima.domain.User"></jsp:useBean><!--相当于  User u=new User()-->
		<jsp:setProperty property="name" name="u"/><!--相当于  u.setName(...)-->
		<jsp:setProperty property="password" name="u"/>

		<!-- 打印值-->
		<jsp:getProperty property="name" name="u"/>
//////////////////////////////////////
反射:
	1.获取class对象
		方式1:
			Class clazz=Class.forName("全限定名")
		方式2:
			Class clazz=类名.class;
		方式3:
			Class clazz=对象.getClass;
	2.可以获取对应类的构造方法(了解)
		Constructor con = clazz.getConstructor(Class .. paramClass);
		Person p = (Person) con.newInstance(参数);
	3.可以通过clazz创建一个对象(了解)
		clazz.newInstance();//相当于调用的无参构造器
	4.可以通过clazz获取所有的字段 getFiled()(了解中的了解)
	5.可以通过clazz获取所有的方法
		Method m = clazz.getMethod("sleep");//获取公共的方法
		Method m = clazz.getDeclaredMethod("sleep");//获取任意的方法
		
		注意:若是私有的方法 必须让该方法可以访问
			m.setAccessible(true);
	6.Method对象的invoke是有返回值,他的返回值就是目标方法执行的返回值
总结:
	有了class对象之后,无所不能.
////////////////
javabean在model2中使用
	BeanUtils:可以看作封装数据一个工具类
		使用步骤:
			1.导入jar包
			2.使用BeanUtils.populate(Object bean,Map map);
	
/////////////////////////////////////////////////////////
分层:javaee的三层架构
	web
		作用:
			展示数据 ----jsp
			
			
			-----servlet-------
			接受请求
			找到对应的service,调用方法 完成逻辑操作
			信息生成或者页面跳转
	service 业务层
		作用:
			完成业务操作
			调用dao
	dao(data access object 数据访问对象)
		作用:
			对数据库的curd操作
/////////////////////////////////////////////////
/////////////////////////////////////////////////
事务:
	就是一件完整的事情,包含多个操作单元,这些操作要么全部成功,要么全部失败.
	例如:转账
		包含转出操作和转入操作.
	mysql中的事务:
		mysql中事务默认是自动提交,一条sql语句就是一个事务.
		开启手动事务方式
			方式1:关闭自动事务.(了解)
				set autocommit = off;
			方式2:手动开启一个事务.(理解)
				start transaction;-- 开启一个事务
				commit;-- 事务提交
				rollback;-- 事务回滚
		扩展:
			oracle中事务默认是手动的,必须手动提交才可以.
		
		例如:创建数据库和表
			create database day13;
			use day13;
			create table account(
				name varchar(20),
				money int
			);
			
			insert into account values('aa','1000');
			insert into account values('bb','1000');
			
		完成 aa给bb转500;
			update account set money = money - 500 where name='aa';
			update account set money = money + 500 where name='bb';
		////////////////////
	java中的事务:
		Connection接口的api:★
			setAutoCommit(false);//手动开启事务
			commit():事务提交
			rollback():事务回滚
		
		扩展:了解 Savepoint还原点
			void rollback(Savepoint savepoint) :还原到那个还原点
			Savepoint setSavepoint() :设置还原点
 /////////////////////////////
 步骤分析:
	1.数据库和表
	2.新建一个项目 day1301
	3.导入jar包和工具类
		驱动 jdbcUtils
		c3p0及其配置文件和工具类
		dbutils
	4.新建一个account.jsp 表单
	5.accountservlet:
		接受三个参数
		调用accountservice.account方法完成转账操作
		打印信息
	6.account方法中:
		使用jdbc不考虑事务
		调用dao完成转出操作
		调用dao完成转入操作
	7.dao中
			
	一旦出现异常,钱飞了.
	要想避免这事情,必须添加事务,在service添加事务.
	为了保证所有的操作在一个事务中,必须保证使用的是同一个连接
	在service层我们获取了连接,开启了事务.如何dao层使用此连接呢????
		方法1:
			向下传递参数.注意连接应该在service释放
		方法2:
			可以将connection对象绑定当前线程上
			jdk中有一个ThreadLocal类,
			ThreadLocal 实例通常是类中的 private static 字段，
			它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。 
	ThreadLocal的方法:
		构造:
			new ThreadLocal()
		set(Object value):将内容和当前线程绑定
		Object get():获取和迪昂前线程绑定的内容
		remove():将当前线程和内容解绑
	内部维护了map集合
		map.put(当前线程,内容);
		map.get(当前线程)
		map.remove(当前线程)
/////////////////////////////////////////////
DButils:
	1.创建queryrunner
	2.编写sql
	3.执行sql
QueryRunner:
	构造:
		new QueryRunner(DataSource ds):自动事务
		new QueryRunner():手动事务
	常用方法:
		update(Connection conn,String sql,Object ... params):执行的cud操作
		query(Connection conn....):执行查询操作
	注意:
		一旦使用手动事务,调用方法的时候都需要手动传入connection,并且需要手动关闭连接
////////////////////////
事务总结:
	事务的特性:★★★
		ACID
		原子性:事务里面的操作单元不可切割,要么全部成功,要么全部失败
		一致性:事务执行前后,业务状态和其他业务状态保持一致.
		隔离性:一个事务执行的时候最好不要受到其他事务的影响
		持久性:一旦事务提交或者回滚.这个状态都要持久化到数据库中
	不考虑隔离性会出现的读问题★★
		脏读:在一个事务中读取到另一个事务没有提交的数据
		不可重复读:在一个事务中,两次查询的结果不一致(针对的update操作)
		虚读(幻读):在一个事务中,两次查询的结果不一致(针对的insert操作)
	通过设置数据库的隔离级别来避免上面的问题(理解)
		read uncommitted  	读未提交	上面的三个问题都会出现
		read committed  	读已提交	可以避免脏读的发生
		repeatable read		可重复读	可以避免脏读和不可重复读的发生
		serializable		串行化		可以避免所有的问题
	
	
	了解
		演示脏读的发生:
			将数据库的隔离级别设置成 读未提交
				set session transaction isolation level read uncommitted;
			查看数据库的隔离级别
				select @@tx_isolation;
		避免脏读的发生,将隔离级别设置成  读已提交
			set session transaction isolation level read committed;
			不可避免不可重复读的发生.
		
		避免不可重复读的发生 经隔离级别设置成 可重复读
			set session transaction isolation level  repeatable read;
			
		演示串行化 可以避免所有的问题
			set session transaction isolation level  serializable;
			锁表的操作.
		
	四种隔离级别的效率
		read uncommitted>read committed>repeatable read>serializable
	四种隔离级别的安全性
		read uncommitted<read committed<repeatable read<serializable
		
	开发中绝对不允许脏读发生.
		mysql中默认级别:repeatable read
		oracle中默认级别:read committed

	java中控制隔离级别:(了解)
		Connection的api
			void setTransactionIsolation(int level) 
				level是常量
 

///////////////////////////////////////
///////////////////////////////////////

///////////////////////////////////////
上午回顾:
jsp的设计模式
	model1:jsp+javabean(了解)
	model2:jsp+servlet+javabean
		jsp:展示数据
		servlet:接受请求,处理业务逻辑
		javabean:封装数据,封装对数据的访问
MVC:
	将业务逻辑 代码 显示相分离
	M:model 模型	封装数据,封装对数据的访问
	V:view	视图	展示数据,目前jsp担任
	C:ctrl	控制	接受请求
三层架构:
	web:
		作用:
			展示数据
			
			接受请求
			调用service
			页面跳转,信息的生成
	service
		作用:
			处理业务逻辑
			调用dao
	dao
		作用:
			对数据库的curd操作
///////////////////////
反射:
	1.获取class对象
	2.通过class获取构造器
	3.通过class获取字段
	4.通过class获取指定的方法
	5.可以执行方法
/////////////////////////
事务:
	就是一件完整的事情,可以包含多个操作单元,这些单元要么全部成功,要么全部失败
mysql中的事务(了解)
	默认自动提交. 
	控制事务:
		1.关闭自动事务
		2.手动打开一个事务
			start transaction;
			commit;
			rollback;
java中事务:(★)
	Connection的api
		setAutoCommit(false):手动开启事务
		commit():事务提交
		rollback():事务回滚
/////////////////////////////////
如何使用同一个connection
	1.向下传递
	2.将连接绑定到当前线程
		ThreadLocal
			set(Object value)
			Object get()
			remove()
//////////////////////////
DBUtils中事务控制
	QueryRunner:
		构造:
			new QueryRunner(Datasource ds)://自动事务.调用方法的不需要传入connection,资源不用我们释放.
			new QueryRunner()://手动事务.调用方法的必须传入connection,需要手动提交事务或者回滚事务.必须手动的释放资源
/////////////////////////
事务的特性 ★★★
	ACID
	原子性 一致性 隔离性 持久性
不考虑隔离性会出现的读问题★★
	脏读  不可重复度 虚读
数据库的隔离级别
	read uncommitted 读未提交 不能避免任何问题
	★read committed 	读已提交 避免脏读
	★repeatable read 可重复度 避免脏读和不可重复读的发生
	serializable 串行化 避免所有的问题
	
/////////////////////////
servlet
	会创建一个servlet
	会更改web.xml
	servletContext:
		全局管理者 上下文
			资源共享(域对象)
			获取资源文件
				getRealPath()
				getResourceAsStream()
			获取mimetype
				getMimeType()
	面试题:
		serlvet的生命周期
rr
	response:往浏览器写东西
		重定向:response.sendRedirect(绝对路径)
		定时刷新:refresh
			setHeader("refresh","秒数;url=跳转路径")
			meta
		getWriter():字符流
		getOutputStream():字节流
		文件下载:
			setContentType(mime类型)
			setHeader("content-disposition","attachment;filename="+文件名);
			
	request:获取浏览器发送过来的数据
		获取参数:3个
		中文乱码:
			通用的方式
				new String(名字.getBytes("iso-8859-1"),"utf-8");
			针对post请求
				request.setCharacterEncoding("utf-8");
		请求转发(域对象)
			request.getRequestDispatcher(内部路径).forward(..);
			
cookie和session
	cookie:浏览器端会话技术
		常用方法:
			new Cookie(String key,String value);
			写回浏览器
				response.addCookie(Cookie c)
			获取cookie
				request.getCookies()
			cookie的api
				getName()
				getValue()
				
				setMaxAge(int 秒)
				setPath(String path)
	session:服务器端的会话技术
		常用方法:
			获取session
				request.getSession
		域对象:私有的数据
			创建:
			销毁:
				服务器非正常关闭
				session超时
				手动删除:
					session.invalidate()
		
jsp el jstl
	jsp的指令 include taglib
	jsp的内置对象 面试题
	jsp:forward
	jsp:include
	
	el:全部
		获取数据
		执行运算
		
	jstl:
		if
		foreach
	
	
	
	
	






