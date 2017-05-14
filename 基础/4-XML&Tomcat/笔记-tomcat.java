案例2-通过eclipse能发布自己的项目.
技术分析:
	eclipse:ide
	tomcat:服务器
	项目:web项目
//////////////////////////////
服务器:
	硬件服务器和软件服务器
web服务器:
	提供资源供别人访问
web:
	网页的意思,资源.
web资源分类:
	动态的web资源:内容有可能发生改变的
	静态的web资源:内容是一成不变的.(几乎看不到)
web开发技术:
	动态的web开发技术:servlet jsp php .net
	静态的web开发技术:html css ....
什么叫javaweb
	通过java语言编写的网页称之为javaweb
web通信机制:
	基于请求响应机制.
	一次请求一次响应,先有请求后有响应
常见的web服务器:
	服务器名称		厂商			特点
	weblogic 		oracle			大型的收费的支持javaee所有规范的服务器
	webspere		IBM				大型的收费的支持javaee所有规范的服务器
	tomcat			apache组织		中小型的免费的支持servlet和jsp规范的服务器
////////////////////////////
tomcat:
	下载:
		.tar .tar.gz: 提供给linux系统
		.zip .exe:提供给window系统
	安装:
		解压apache-tomcat-7.0.52.zip即可
		
	启动:
		tomcat/bin目录下
		双击 startup.bat
		打开浏览器:
			http://localhost:8080
	退出:
		方式1:点 x
		方式2:ctrl+c
		方式3:双击 shutdown.bat
			
	常见问题(配置):
		1.启动的时候一闪而过 	正确配置:JAVA_HOME
		2.端口冲突问题
			修改tomcat的端口号.
				打开tomcat/conf/server.xml
				大概70行左右 有如下代码:
					 <Connector port="8080" protocol="HTTP/1.1"
						   connectionTimeout="20000"
						   redirectPort="8443" />
				修改port后面的值就可以了.注意:1024以下的端口号留给系统用的
				80端口是留给http协议用的.我们可以使用这个端口号
		3.有可能出现的问题(在环境变量中配置CATALINA_HOME)
			删除
	/////////////////////
	tomcat目录结构:(了解)
		bin:存放的可执行程序
		conf:配置文件
		lib:存放的是tomcat和项目运行时需要的jar包
		logs:日志 注意:catalina
		temp:临时文件
		★★webapps:存放项目的目录
		★work:存放jsp文件在运行时产生的java和class文件
	////////////////////////
	web项目的目录结构:★★★
		myweb(项目名称)   web2.5版本标准的目录结构
			|
			|---- html css js image等目录或者文件
			|
			|---- WEB-INF(特点:通过浏览器直接访问不到 目录)
			|	 	|
			|	 	|--- lib(项目的第三方jar包)
			|	 	|--- classes(存放的是我们自定义的java文件生成的.class文件)
			|	 	|--- web.xml(当前项目的核心配置文件)
			|	 	|
	
	访问路径:
		http://主机:端口号/项目名称/资源路径
		例如:我的项目 myweb 
			资源 myweb有一个1.html
		http://localhost:80/myweb/1.html
	/////////////////////////////
	常用的项目发布方式:(虚拟目录映射)
		★方式1:将项目放到tomcat/webapps下
		(了解)方式2:修改 tomcat/conf/server.xml
			大概130行:
				在host标签下 添加如下代码
					<Context path="/项目名" docBase="项目的磁盘目录"/>
				例如:
					<Context path="/my" docBase="G:\myweb"/>
		(了解)方式3:
			在tomcat/conf/引擎目录/主机目录下 新建一个xml文件
				文件的名称就是项目名 文件的内容如下:
					<Context docBase="G:\myweb"/>
	////////////////////
	eclipse和tomcat的整合★ ★
		参考 day08.xls或者 day08.doc文档
	
	通过eclipse发布项目
		1.创建一个项目(动态的web项目)
		2.选择web项目的版本为 2.5( 若版本为3.0目录下没有web.xml)
		3.java文件在src目录下
		  网页或者图片放在webcontent
		4.发布项目
			
			参考