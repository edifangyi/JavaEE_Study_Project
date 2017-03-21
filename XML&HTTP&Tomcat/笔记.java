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
		★dom4j：比较常用的解析开发包，hibernate底层采用。
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




























































































































































































































































































































































































































