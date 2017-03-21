jdbc:
	java操作数据库.jdbc是oracle公司指定的一套规范(一套接口)
	驱动:jdbc的实现类.由数据库厂商提供.
	我们就可以通过一套规范操作不同的数据库了(多态)
	jdbc作用:
		连接数据库
		发送sql语句
		处理结果
	
jdbc操作步骤:★
	1.数据库和表
	2.创建一个项目
	3.导入驱动jar包
	4.编码:
		注册驱动
		获取连接
		编写sql
		创建预编译的语句执行者
		设置参数
		执行sql
		处理结果
		释放资源

/**

 */

使用junit单元测试
	要求:
		1.方法是public void xxx(){}
		2.在方法上添加 @Test
		3.在@Test 按下 ctrl+1(快速锁定错误)
		4.在方法上右键 run as  -->junit 就可以执行方法了.

/**

 */

jdbc-api详解:
	所有的包 都是 java.sql 或者 javax.sql
	
	DriverManager:管理了一组jdbc的操作 类
		常用方法:
			了解:注册驱动

				static void registerDriver(Driver driver) :

					通过查看 com.mysql.jdbc.Driver的源码 有如下代码
						
						static {
							try {
								java.sql.DriverManager.registerDriver(new Driver());//这段代码我们已经写过
							} catch (SQLException E) {
								throw new RuntimeException("Can't register driver!");
							}
						}

				驱动注册了两次.我们只需要将静态代码块执行一次,类被加载到内存中会执行静态代码块,并且只执行一次.
				现在只需要将类加载到内存中即可:
					
					方式1:
						★Class.forName("全限定名");//包名+类名   com.mysql.jdbc.Driver
					方式2:
						类名.class;
					方式3:
						对象.getClass();

			掌握:获取连接
				static Connection getConnection(String url, String user, String password) 
					
					参数1:告诉我们连接什么类型的数据库及连接那个数据库
								协议:数据库类型:子协议 参数
						mysql:	jdbc:mysql://localhost:3306/数据库名称
						oracle:	jdbc:oracle:thin@localhost:1521@实例
						
					参数2:账户名 root
					参数3:密码
	
///////////////////////////////////////


	(了解)Driver:java.sql 接口 驱动
	Connection:连接 接口
		常用方法:
			获取语句执行者:
				(了解)Statement createStatement() :获取普通的语句执行者  会出现sql注入问题
				★PreparedStatement prepareStatement(String sql) :获取预编译语句执行者
				(了解)CallableStatement prepareCall(String sql):获取调用存储过程的语句执行者

			了解:
				setAutoCommit(false) :手动开启事务
				commit():提交事务
				rollback():事务回滚
	
	Statement:语句执行者 接口
	PreparedStatement:预编译语句执行者 接口
		常用方法:
			设置参数:
				setXxx(int 第几个问号,Object 实际参数);
					常见的方法:
						 setInt
						 setString
						 setObject
			
			执行sql:
				 ResultSet executeQuery() :执行 r 语句 返回值:结果集
				 int executeUpdate() :执行cud 语句 返回值:影响的行数
 
	
	ResultSet:结果集 接口
		执行查询语句之后返回的结果
			常用方法:
				boolean next():判断是否有下一条记录,若有返回true且将光标移到下一行,若没有呢则返回false
					光标一开始处于第一条记录的上面
				
				获取具体内容
					getXxx(int|string)
						若参数为int :第几列
						若参数为string:列名(字段名)
					例如:
						获取cname的内容可以通过
							getString(2)
							getString("cname")
					常用方法:
						getInt
						getString 也可以获取int值
						getObject 可以获取任意

/**

 */

常见的配置文件格式:

	1.properties
		里面内容的格式 key=value

		//dbinfo.properties  放在src目录下
		
		若我们的配置文件为properties,并且放在src目录下.
		我们可以通过 ResourceBundle工具快速获取里面的配置信息

		使用步骤:
			1.获取ResourceBundle 对象:
				static ResourceBundle getBundle("文件名称不带后缀名") 
			2.通过ResourceBundle 对象获取配置信息 
				String getString(String key) :通过执行key获取指定的value
    




			private static String DRIVERCLASS;
			private static String URL;
			private static String USERNAME;
			private static String PASSWORD;

			static {
			    //此对象用于加载properties文件数据的
			    ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
			    DRIVERCLASS = bundle.getString("driverClass");
			    URL = bundle.getString("url");
			    USERNAME = bundle.getString("username");
			    PASSWORD = bundle.getString("password");

			    try {
			        Class.forName(DRIVERCLASS);
			    } catch (ClassNotFoundException e) {
			        e.printStackTrace();
			    }
			}

			//得到连接方法
			public static Connection getConnection() throws Exception {
			    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}

///////////////////////////////////////

	2.xml

/**

 */

案例2-通过连接池(数据源)优化我们的操作.
需求:
	使用jdbc的时候,没操作一次都需要获取连接(创建)用完之后把连接释放掉了(销毁),通过连接池来优化curd操作.
技术分析:
	连接池

连接池概述:
	管理数据库的连接,
	作用:
		提高项目的性能.
	就是在连接池初始化的时候存入一定数量的连接,用的时候通过方法获取,不用的时候归还连接即可.
	所有的连接池必须实现一个接口 javax.sql.DataSource接口
	
	获取连接方法:
		Connection getConnection() 
	归还连接的方法就是以前的释放资源的方法.调用connection.close();
自定义一个连接池(理解思想)
	
常用连接池:
	DBCP
	C3P0
///////////////////
增前方法
	1.继承
	2.装饰者模式(静态代理)
	3.动态代理
//////////////
装饰者模式:★★★
	使用步骤:
		1.装饰者和被装饰者实现同一个接口或者继承同一个类
		2.装饰者中要有被装饰者的引用
		3.对需要增强的方法进行加强
		4.对不需要加强的方法调用原来方法
 ////////////////////////////////////
 常用的连接池:
	DBCP:(理解)
		apache组织
		使用步骤:
			1.导入jar包(commons-dbcp-1.4.jar和commons-pool-1.5.6.jar)
			2.使用api
				a.硬编码
					//创建连接池
					BasicDataSource ds = new BasicDataSource();
					
					//配置信息
					ds.setDriverClassName("com.mysql.jdbc.Driver");
					ds.setUrl("jdbc:mysql:///day07");
					ds.setUsername("root");
					ds.setPassword("1234");
				b.配置文件
					实现编写一个properties文件
					//存放配置文件
					Properties prop = new Properties();
					prop.load(new FileInputStream("src/dbcp.properties"));
					//设置
					//prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
					
					//创建连接池
					DataSource ds = new BasicDataSourceFactory().createDataSource(prop);
	

	C3P0:(★)
		hibernate和spring使用
		有自动回收空闲连接的功能.
		使用步骤:
			1.导入jar包(c3p0-0.9.1.2.jar)
			2.使用api
				a.硬编码(不推荐)
					new ComboPooledDataSource()
				b.配置文件
					配置文件的名称:c3p0.properties 或者 c3p0-config.xml
					配置文件的路径:src下
				
					编码只需要一句话
						new ComboPooledDataSource()//使用默认的配置
						new ComboPooledDataSource(String configName)//使用命名的配置 若配置的名字找不到,使用默认的配置

/**


 */

案例3-使用dbutils完成curd操作
技术分析:
	dbutils
dbutils:
	是apache组织的一个工具类,jdbc的框架,更方便我们使用
	使用步骤:
		1.导入jar包(commons-dbutils-1.4.jar)
		2.创建一个queryrunner类
			queryrunner作用:操作sql语句
				构造方法:
					new QueryRunner(Datasource ds);
		3.编写sql
		4.执行sql
			query(..):执行r操作
			update(...):执行cud操作



	@Test
	public void insert() throws SQLException{
		//1.创建queryrunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.编写sql
		String sql="insert into category values(?,?)";
		
		
		//3.执行sql
		qr.update(sql, "c201","厨房电器");
		
	}
	
	@Test
	public void update() throws SQLException{
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="update category set cname = ? where cid = ?";
		
		qr.update(sql, "达电器","c000");
	}



////////////////////////////
核心类或接口
	QueryRunner:类名
		作用:操作sql语句
		构造器:
			new QueryRunner(Datasource ds);
		注意:
			底层帮我们创建连接,创建语句执行者 ,释放资源.
		常用方法:
			query(..):
			update(..):
	
	DbUtils:释放资源,控制事务 类
		closeQuietly(conn):内部处理了异常
		commitAndClose(Connection conn):提交事务并释放连接
		....
	
	ResultSetHandler:封装结果集 接口
		
		 ArrayHandler, ArrayListHandler, BeanHandler, BeanListHandler, ColumnListHandler, KeyedHandler, MapHandler, MapListHandler, ScalarHandler
		 
		 (了解)ArrayHandler, 将查询结果的第一条记录封装成数组,返回
		 (了解)ArrayListHandler, 将查询结果的每一条记录封装成数组,将每一个数组放入list中返回
		 
		 ★★BeanHandler, 将查询结果的第一条记录封装成指定的bean对象,返回
		 ★★BeanListHandler, 将查询结果的每一条记录封装成指定的bean对象,将每一个bean对象放入list中 返回.
		 
		 (了解)ColumnListHandler, 将查询结果的指定一列放入list中返回 
		 (了解)MapHandler, 将查询结果的第一条记录封装成map,字段名作为key,值为value 返回
		 
		 ★MapListHandler, 将查询结果的每一条记录封装map集合,将每一个map集合放入list中返回
		 ★ScalarHandler,针对于聚合函数 例如:count(*) 返回的是一个Long值
		
