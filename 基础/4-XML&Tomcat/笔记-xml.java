xml:
	可以编写简单的xml文件
	可以按照指定的约束文件编写xml文件
tomcat:★
///////////////////////
案例1-编写配置文件,编写一个服务器软件,按照指定的全限定名,根据路径,让服务器创建这个对象,调用指定的方法
需求:
	<a1>
		<c>hello</c>
		<d>com.itheima.HelloServlet</d>
	</a1>
	<b1>
		<c>hello</c>
		<e>/hello</e>
	</b1>
技术分析:
	xml
	解析xml
	根据全限定名创建一个对象,调用方法
/**
 
 */

xml:
	可扩展的标签语言
	标签自定义.
	作用:存储数据.(配置文件)
	
	书写规范:
		1.区分大小写
		2.应该有一个根标签
		3.标签必须关闭
			<xx></xx>
			<xx/>
		4.属性必须用引号引起来,
			<xx att="value"/>
		5.标签体中的空格或者换行或者制表符等内容都是作为数据内容存在的
			<xx>aa</xx>
			<xx>    aa   </xx>
		6.特殊字符必须转义
			< > & 
		
		满足上面规范的文件我们称之为是一个格式良好的xml文件.可以通过浏览器浏览
	
	后缀名:
		.xml


xml组成部分:
	声明:
		作用:告诉别人我是一个xml文件
		格式:	
			<?xml .....  ?>
		例如:
			<?xml version="1.0" encoding="UTF-8"?>
			<?xml version='1.0' encoding='utf-8' standalone="yes|no"?>
		要求:
			必须在xml文件的第一行
			必须顶格写
	元素(标签):
		格式:
			<xx></xx>
			<xx/>
		要求:
			1.必须关闭
			2.标签名不能 xml Xml XML 等等开头
			3.标签名中不能出现" "或者":"等特殊字符.
	属性:
		格式:
			<xx 属性名="属性值"/>
		要求:
			属性必须用引号引起来
	注释:
		和html一样
		<!-- 注释内容 -->
	CDATA:
		xml文件的特殊字符必须转义
		通过cdataky 保证数据原样输出
			格式:
				<![CDATA[
					原样输出的内容
				]]>

/**
 
 */

xml解析:
	解析方式:
		1.sax:特点:逐行解析,只能查询.
		2.dom:特点:一次性将文档加载到内容中,形成一个dom树.可以对dom树curd操作
	解析技术:
		JAXP：sun公司提供支持DOM和SAX开发包
		JDom：dom4j兄弟
		jsoup：一种处理HTML特定解析开发包
	★   dom4j：比较常用的解析开发包，hibernate底层采用。


	
	dom4j技术进行查询操作.
		使用步骤:
			1.导入jar包
			2.创建一个核心对象 SAXReader
				new SAXReader();
			3.将xml文档加载到内存中形成一棵树
				Document doc=reader.read(文件)
			4.获取根节点
				Element root=doc.getRootElement();
			5.通过根节点就可以获取其他节点(文本节点,属性节点,元素节点)
				获取所有的子元素
					List<Element> list=root.elements()
				获取元素的指定属性内容
					String value=root.attributeValue("属性名");
				获取子标签标签体:遍历list 获取到每一个子元素
					String text=ele.elementText("子标签名称")
					
	xpath解析技术:(扩展)
		依赖于dom4j
			使用步骤:
				1.导入jar包(dom4j和jaxen-1.1-beta-6.jar)
				2.加载xml文件到内存中
				3.使用api
					selectNode("表达式");
					selectSingleNode("表达式");
			表达式的写法:
				/ 从根节点选取 
				// 从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置 
				例如一个标签下有一个id属性且有值  id=2;
					//元素名[@属性名='属性值']
					//元素名[@id='2']
				
/**
 
 */


反射:
	1.获取对应的class对象
		方式1:★
			Class clazz=Class.forName("全限定名");
		方式2:
			Class clazz=类名.class;
		方式3:
			Class clazz==对象.getClass();
	2.通过class对象创建一个实例对象(相当于  new 类())
		Object clazz.newInstance();
	3.通过class对象获取一个方法(public修饰的)
		Method method=clazz.getMethod("方法名",Class .... paramType);
			paramType为参数的类型
	4.让方法执行:
		method.invoke(Object 实例对象,Object ... 参数);
			Object 实例对象:以前调用方法的对象 就是a
			Object ... 参数:该方法运行时需要的参数 就是 10和30
		执行这个方法 相当于
			a.add(10,30);
		例如:
			method.invoke(a,10,30)

//////////////////////////////


		public class HelloMyServlet {
			public void add(){
				System.out.println("空参add方法");
			}
			
			public void add(int i,int j){
				System.out.println("带有连个add方法");
				System.out.println(i+j);
			}
			
			public int add(int i){
				return i+10;
			}
		}

//////////////////////////////

		@Test
		public void f1(){
			//调用helloMyServlet中的方法
			HelloMyServlet a = new HelloMyServlet();
			a.add();
			a.add(10, 20);
		}
		
		@Test
		public void f2() throws Exception{
			Class clazz = Class.forName("com.itheima.HelloMyServlet");
			
			//通过字节码对象创建一个实例对象(相当于调用空参的构造器)
			HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
			
			a.add();
		}
		
		@Test
		//调用空参的add方法
		public void f3() throws Exception{
			Class clazz = Class.forName("com.itheima.HelloMyServlet");
			
			//通过字节码对象创建一个实例对象(相当于调用空参的构造器)
			HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
			
			//获取方法对象
			Method method = clazz.getMethod("add");
			
			//让方法对象执行   obj调用这个方法的实例,相当于a  ,args是该方法执行时候所需要的参数   a.add()
			method.invoke(a);//相当于 a.add()
		}
		
		@Test
		//调用有两个参数的add方法
		public void f4()throws Exception{
			//获取class对象
			//Class clazz = Class.forName("com.itheima.HelloMyServlet");
			Class clazz=HelloMyServlet.class;
			
			//通过clazz对象创建一个实例
			HelloMyServlet a =(HelloMyServlet) clazz.newInstance();
			
			//获取有两个参数的add方法
			Method m = clazz.getMethod("add",int.class,int.class);
			
			//执行方法
			m.invoke(a, 10,30);//相当于 a.add(10,30);
		}
/**
 
 */


		<?xml version="1.0" encoding="UTF-8"?>
		<web-app version="2.5">
			<servlet>
				<servlet-name>HelloMyServlet</servlet-name>
				<servlet-class>com.itheima.HelloMyServlet</servlet-class>
			</servlet>
			<servlet-mapping>
				<servlet-name>HelloMyServlet</servlet-name>
				<url-pattern>/hello</url-pattern>
			</servlet-mapping>
		</web-app>

///////////////////////////////////////////////////////////////////////////


		@Test
		public void f1() throws Exception{
			//定一个一个map
			Map<String, String> map=new HashMap<>();
			
			//往map中放入一个值    key:/hello   value:com.itheima.HelloMyServlet
			map.put("/hello", "com.itheima.HelloMyServlet");
			
			//通过key 获取 value
			String value = map.get("/hello");
			
			//通过全限定名 创建一个实例
			Class clazz = Class.forName(value);
			HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
			
			//调用空参的add方法
			Method method = clazz.getMethod("add");
			method.invoke(a);
		
		}
		
		@Test
		public void f2() throws Exception{
			//解析xml
			//创建docuemnt对象
			Document doc = new SAXReader().read("D:\\eclipsewk\\28\\day08\\xml\\web.xml");
			
			//通过xpath解析获取 servlet-class和url-pattern的标签体
			Element servletClass = (Element) doc.selectSingleNode("//servlet-class");
			Element urlPattern = (Element) doc.selectSingleNode("//url-pattern");
			
			
			String classText=servletClass.getText();
			String urlText=urlPattern.getText();
			//定一个一个map
			Map<String, String> map=new HashMap<>();
			
			//将两个值放入到map中
			map.put(urlText, classText);
			
			//通过key 获取 value
			String value = map.get("/hello");
			
			//通过全限定名 创建一个实例
			Class clazz = Class.forName(value);
			HelloMyServlet a=(HelloMyServlet) clazz.newInstance();
			
			//调用空参的add方法
			Method method = clazz.getMethod("add");
			method.invoke(a);
		
		}
				
/**
 
 */


xml约束:
	作用:规定xml中可以出现那些元素及那些属性,以及他们出现的顺序.
	约束的分类:
		DTD约束:struts hiebernate等等
		SCHEMA约束:tomcat spring等等


/////////////////////////


DTD约束:
	和xml的关联	(一般都会提供好,复制过来即可,有时候连复制都不需要.)
		方式1:内部关联
			格式:
				<!DOCTYPE 根元素名 [dtd语法]>
		方式2:外部关联-系统关联
			格式:
				<!DOCTYPE 根元素名 SYSTEM "约束文件的位置">
			例如:
				<!DOCTYPE web-app SYSTEM "web-app_2_3.dtd">
		方式3:外部关联-公共关联
			格式:
				<!DOCTYPE 根元素名 PUBLIC "约束文件的名称" "约束文件的位置">

dtd语法(了解)
	元素:
		<!Element 元素名称 数据类型|包含内容>
			数据类型:
				#PCDATA:普通文本 使用的时候一般用()引起来
			包含内容:
				该元素下可以出现那些元素 用()引起来
		符号:
			*	出现任意次
			?	出现1次或者0次
			+	出现至少1次
			|	或者
			()  分组
			,	顺序
				
	属性:
		格式:
			<!ATTLIST 元素名 属性名 属性类型 属性是否必须出现>
		属性类型:
			ID:唯一
			CDATA:普通文本
		属性是否必须出现
			REQUIRED:必须出现
			IMPLIED:可以不出现
	
	一个xml文档中只能添加一个DTD约束
xml的学习目标:
	编写一个简单的xml文件
	可以根据约束文件写出相应xml文件.
		按f2或者 alt+/提示写出内容即可


///////////////////////////



SCHEMA约束:
	一个xml文档中可以添加多个schema约束
	xml和schema的关联.
		格式:
			<根标签 xmlns="..." ...>
			<根标签 xmlns:别名="..." ...>
	名称空间:
		关联约束文件
		规定元素是来源于那个约束文件的
	例如:
		一个约束文件中规定 table(表格)  表格有属性 row和col
		还有一个约束文件规定 table(桌子) 桌子有属性 width和height
		
		在同一个xml中万一我把两个约束文件都导入了,
			在xml中我写一个table,这个table有什么属性????
		我们为了避免这种情况的发生,可以给其中的一个约束起个别名
		使用的时候若是没有加别名那就代表是来自于没有别名的约束文件
			例如 table(表格) 给他起个别名  xmlns:a="..."
			在案例中使用 a:table 代表的是表格
			若在案例中直接使用 table 代表的是桌子
		在一个xml文件中只能有一个不起别名;
注意:
	schema约束本身也是xml文件.


/**
 
 */
