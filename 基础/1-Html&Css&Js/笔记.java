文件标签:
	html标签:
		声明当前网页为html页面
		子标签:
			<head></head>
			<body></body>
		head:用来存放当前页面的重要信息,一般不展示在html页面上
			常见的子标签:
				<title></title> 网页的标题
		body:
			要展示的数据放在body中

/////////////////////////////////////////////////////////////////////////////////////

标题标签:
	<hn></hn>

	n取值 :1~6
		h1最大  h6最小
		自动换行 且留白 默认加粗

	常用属性:
		align:对齐方式
		left: 左  
		right:右 
		center:居中
	格式:
		<h2 align="center"></h2>

/////////////////////////////////////////////////////////////////////////////////////


字体标签:(了解)规定文本的字体、字体尺寸、字体颜色。
	<font></font>			

	常用属性:
		face:字体 <font face="微软雅黑">微软雅黑</font>
		size:尺寸 <font size="6">哈哈哈哈哈</font>
		color:颜色

	颜色的取值:(RGB)
		方式1: #xxxxxx  x为16进制
		方式2: 英文单词

		<font color="#0065CF" size="6">哈哈哈哈哈</font>

		<font color="red">笨蛋</font>

/////////////////////////////////////////////////////////////////////////////////////


段落标签:
	<p></p>

其他标签:
	加粗: <b></b>  
	加粗: <strong></strong>
	斜体: <i></i> 

水平线
	<hr/>

换行
	<br/>

/////////////////////////////////////////////////////////////////////////////////////

图片标签:
	<img/>
		常用属性:
			src:图片的路径
			alt:替代文字
			title:移上去显示的文字
			width:宽
			height:高

	大小的写法:
		像素:123px
		百分比:20%

	路径的写法:
		相对路径:
			./ 或者 什么都不写  当前目录
			../  上一级目录

			<img src="img/img_1.jpg" />

		绝对路径:
			带协议的绝对路径:
				http://www.itheima.com


/////////////////////////////////////////////////////////////////////////////////////

需求:
	将友情连接的页面通过列表展示出来

技术分析:

	列表标签

列表标签:
	<ol></ol> 有序
	<ul></ul> 无序
	
	常用的标签
		<li></li> 列表项




		<ul type="circle"> 无序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
		</ul>

		<ul type="disc"> 无序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
		</ul>

		<ul type="square"> 无序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
		</ul>

		<ol type="I"> 有序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
		</ol>

		<ol type="a" start="2"> 有序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
			<li>列表项 3</li>
			<li>列表项 4</li>
		</ol>

		<ol type="1" start="2"> 有序列表
			<li>列表项 1</li>
			<li>列表项 2</li>
			<li>列表项 3</li>
			<li>列表项 4</li>
		</ol>

/////////////////////////////////////////////////////////////////////////////////////

超链接标记
	<a></a>
		常用属性:
			href:跳转路径
			target:在那里打开
				默认值:_self  _blank(在空白页面打开)

		<a href="img/img_3.jpg"> 点击我吧 </a><br />
		<a href="http://www.baidu.com"> 百度 </a><br />
		<a href="img/img_3.jpg" target="_blank"> 点击我吧_blank</a><br />
		<a href="img/img_3.jpg" target="_parent"> 点击我吧_parent</a><br />
		<a href="img/img_3.jpg" target="_search"> 点击我吧 _search</a><br />
		<a href="img/img_3.jpg" target="_self"> 点击我吧_self</a><br />
		<a href="img/img_3.jpg" target="_top"> 点击我吧_top</a><br /><br />

		<a href="#top">#name #是本页 top</a>
/////////////////////////////////////////////////////////////////////////////////////
///
表格标签
	<table></table>
		常用的子标签
			<tr>:行
	<tr></tr>
		常用子标签:
			<td>:列
			<th>:表头单元格 默认居中加粗
		注意:
			一行必须只有有一个单元格或者一列
	
	table 的常用属性:
		border:边框  像素值
		width:
		align:表格对齐方式
		bgcolor:背景

	tr 的常用属性:
		align:内容对齐

	td 的常用属性:
		align:内容对齐
		colspan:跨列合并 值:合并的列数
		rowspan:跨行合并

		<table border="1" width="50%" align="center" bgcolor="cornflowerblue">
			<tr align="center">
				<td>1--1</td>
				<td>1--2</td>
				<td>1--3</td>
			</tr>

			<tr align="right">
				<td>2--1</td>
				<td>2--2</td>
				<td>2--3</td>
			</tr>

			<tr>
				<td>3--1</td>
				<td>3--2</td>
				<td>3--3</td>
			</tr>
		</table>
		<br />

		<table border="1" width="50%" align="center">
			<caption>成绩表</caption>
			<tr align="center">
				<th>1--1</th>
				<th>1--2</th>
				<th>1--3</th>
			</tr>

			<tr align="right">
				<td rowspan="2" align="center">2--1</td>
				<td colspan="2" align="center">2--2</td>
			</tr>

			<tr>
				<td>3--2</td>
				<td>3--3</td>
			</tr>
		</table>

/////////////////////////////////////////////////////////////////////////////////////


表单标签★★★
	<form></form>
	作用:
		用来从浏览器端收集用户的信息.



		表单:
		常用属性:
			action:信息提交的路径 默认是当前页面
			method:表单提交的方式
				只需要掌握两种
					get(默认)和post
				get和post的区别:
					1.get请求会把所有的参数追加在地址栏上,post请求不会
					2.get请求参数大小有限制,post请求参数大小没有限制
					3.post相当于get安全些
		常见的子标签
			input
			select:下拉选
			textarea:文本域
		
		input标签
			常用的属性:
				type:
					text:文本框 默认
					password:密码框
					radio:单选框
					checkbox:多选框
					file:文件框
					
					submit:提交
					reset:重置
					button:普通按钮
					
					hidden:隐藏域 在页面上显示 提交的时候可以提交过去
					image:图片提交 替代submit 

				name:
					可以将几个单选框(复选框)设置为一组
					要想将信息保存到服务器上必须有name属性


				readonly:
					readonly="readonly" 只读
				disabled:
					disabled="disabled" 禁用


				value:
					text password  设置默认值
					radio checkbox 设置选中后提交的值
					submit reset button 给按钮起个显示的名字
					
		select :下拉选
			格式:
				<select name="pro">
					<option>黑龙江</option>
				</select>
		
		textarea:文本域
			常用的属性:
				cols:列
				rows:行
			
			
		提交到服务器的内容的格式:
			key=value&
		对于文本框 密码框 文本域 手写的内容传递过去了
		对于单选框和多选框来说,却没有把值传递过去
			要想把值传递过去 必须设置value属性
		若下拉选要想把选中内容的值传递过去,请加上value属性
		
		默认值:
			文本框 密码框:只需要添加value属性
			单选框 

			多选框:添加 checked="checked"
			下拉选:添加selected="selected"	
			文本域:标签体
				
	当我们提交的时候 发现地址栏变化
		?username=tom&password=123&sex=on&hobby=on&hobby=on&photo=&pro=黑龙江&city=哈尔滨&intr=good+girl




		<form action="#" method="get">
			<input type="hidden" name="id" value="007"/>
			姓名:<input name="username" value="xuduoduo"/><br>
			密码:<input type="password" name="password"  value="123" disabled="disabled"><br>
			性别:<input type="radio" name="sex" value="1" checked="checked">男
				<input type="radio" name="sex" value="0">女
				<br>
			爱好:<input type="checkbox" name="hobby" value="eat">吃
				<input type="checkbox" name="hobby" value="drink" checked="checked">喝
				<input type="checkbox" name="hobby" value="sleep" checked="checked">睡
				<br>
			头像:<input type="file" name="photo"><br>
			籍贯:
				<select name="pro">
					<option value="01">黑龙江</option>
					<option value="02">吉林</option>
					<option value="03" selected="selected">辽宁</option>
				</select>
				<select name="city">
					<option >-请选择-</option>
					<option value="0101">哈尔滨</option>
					<option value="0102">漠河</option>
					<option value="0201">长春</option>
					<option value="0202">吉林</option>
					<option>沈阳</option>
					<option>锦州</option>
				</select>
			<br>
			自我介绍:
				<textarea name="intr" cols="40" rows="4">good!</textarea>
			<br>
			<input type="submit" value="保存"/>
			<input type="reset" />
			<input type="button" value="普通按钮"/>
		</form>

/////////////////////////////////////////////////////////////////////////////////////

案例6-后台管理页面(了解)
需求:
	开发一个后台管理页面,通过frameset实现
技术分析:

	frameset:框架集
	frame:具体实现



frameset:框架集(了解)
	常用属性:
		cols:垂直切割
			例如: cols="40%,60%"
			例如: cols="40%,*,10%"
		rows:水平切割
	常见的子标签:
		frame
	注意:
		最好和body不要共存
frame:具体实现
	常用属性:
		src:展示的页面的url

	<frameset rows="18%,*,10%">
		<frame src="./head.html"/>
		<frameset cols="20%,*">
			<frame src="left.html"/>
			<frame src="main.html" name="mainFrame"/>
		</frameset>
		<frame src="foot.html"/>
	</frameset>


/////////////////////////////////////////////////////////////////////////////////////


div:
	块标签
	<div></div>
span:行内的块标签
	<span><span>

	<span style="font-size: 4cm;color: #ffff00;">天佑中华</span>

/////////////////////////////////////////////////////////////////////////////////////

css:渲染
	层叠样式表
	作用:
		渲染页面
		提高工作效率
	格式:
		选择器{属性:值;属性1:值1;}
	后缀名:
		.css 独立的css(样式)文件
	和html元素的整合★
		方式1:内联样式表 通过标签的style属性设置样式

				<div style="background-color: #FF4400;">内联</div>

		方式2:内部样式表 在当前页面中使用的样式
			通过head标签的style子标签导入
			例如:
				<style>
					#divId2{
						background-color: #0f0;
					}
				</style>

				<div id="divId2">内部</div>
				
		方式3:外部样式表 有独立的css文件
			通过head标签的link子标签导入
			例如:
				<link rel="stylesheet" href="css/1.css" type="text/css"/>




				<link rel="stylesheet" href="css/demo1.css" />


				#divId2 {
					color: bisque;
					font-size: 100px;
					background-color: #8A2BE2;
				}


				<div id="divId2">外部样式表</div>



	选择器:★

		id选择器
			要求:
				html元素必须有id属性且有值   <xxx id="id1"></xxx>
				css中通过"#"引入,后面加上id的值  #id1{...}


		class选择器
			要求:
				html元素必须有class属性且有值 <xxx class="cls1"/>
				css中通过"."引入,后面加上class的值  .cls1{...}
		元素选择器
			直接用元素(标签)名即可   xxx{...}

		<style>
			#divId1{
				background-color: #f00;
			}
			
			.divCls1{
				background-color:#0f0;
			}
			
			span{
				background-color: #00f;
			}
			
			span[att="val"]{
				background-color: #ff0;
			}
		</style>


		<div>天佑中华</div>
		<div id="divId1">天佑中华-id选择器</div>
		<div class="divCls1">天佑中华-class选择器</div>

		<span>天佑中华</span>
		<span att="val">天佑中华</span>



		
	派生的选择器
		属性选择器★
			要求:
				html元素必须有一个属性不论属性是什么且有值  <xxx nihao="wohenhao"/>
				css中通过下面的方式使用
					元素名[属性="属性值"]{....}
					例如:
						xxx[nihao="wohenhao"]{....}
		后代选择器
			选择器 后代选择器{...}   在满足第一个选择器的条件下找后代的选择器,给满足条件的元素添加样式


			<style>
				span{
					background-color: #f00;
				}
				
				div span{
					font-size: 1cm;
				}
			</style>

			<span>天佑中华</span>
			<span>天佑中华</span>
			<div>
				<span>div下的天佑中华</span>
			</div>



	了解的选择器
		锚伪类选择器
			a:link {color: #FF0000}		/* 未访问的链接 */
			a:visited {color: #00FF00}	/* 已访问的链接 */
			a:hover {color: #FF00FF}	/* 鼠标移动到链接上 */
			a:active {color: #0000FF}	/* 选定的链接 */

	
	选择器使用小结:
		id选择器:一个元素(标签)
		class选择器:一类元素 
		元素选择器:一种元素
		属性选择器:元素选择器的特殊用法

	使用的时候注意:(了解)
		若多个样式作用于一个元素的时候
			不同的样式,会叠加
			相同的样式,最近原则
		若多个选择器作用于一个元素的时候
			越特殊优先级越高 id优先级最高


/////////////////////////////////////////////////////////////////////////////////////



属性(了解)
	字体
		font-family:设置字体(隶书) 设置字体家族

		font-size:设置字体大小

		font-style:设置字体风格
			normal 默认值。浏览器显示一个标准的字体样式。 
			italic 浏览器会显示一个斜体的字体样式。 
			oblique 浏览器会显示一个倾斜的字体样式。 
			inherit 规定应该从父元素继承字体样式 


		<style>
			#div0{
				font-family: "黑体";
			}
			
			#div1{
				font-size: 1cm;
			}
			
			#div2{
				font-style: italic;
			}
			
			#div3{
				font-family: "黑体";
				font-size: 1cm;
				font-style: italic;
			}
		</style>


		

	文本:改变文本的颜色、字符间距，对齐文本，装饰文本，对文本进行缩进
		color:文本颜色

		direction:方向
			ltr 默认。文本方向从左到右。 
			rtl 文本方向从右到左。 
			inherit 规定应该从父元素继承 direction 属性的值。 

		line-height:设置行高

		text-decoration: 向文本添加修饰。 
			none 默认。定义标准的文本。 
			underline 定义文本下的一条线。 
			overline 定义文本上的一条线。 
			line-through 定义穿过文本下的一条线。 
			blink 定义闪烁的文本。 
			inherit 规定应该从父元素继承 text-decoration 属性的值。 

		text-align:对齐文本
			left 把文本排列到左边。默认值：由浏览器决定。 
			right 把文本排列到右边。 
			center 把文本排列到中间。 
			justify 实现两端对齐文本效果。 
			inherit 规定应该从父元素继承 text-align 属性的值。 


		<style>
			#div0{
				color: #BCD68D;
			}
			
			#div1{
				text-align: center;
			}
			
			#div2{
				line-height: 100px;
			}
			
			#div3{
			}
			
			a{
				text-decoration: none;
			}
		</style>



	列表:
		list-style-type:设置列表项的类型 
			none 无标记。 
			disc 默认。标记是实心圆。 
			circle 标记是空心圆。 
			square 标记是实心方块。 
			decimal 标记是数字。 
			decimal-leading-zero 0开头的数字标记。(01, 02, 03, 等。) 
			lower-roman 小写罗马数字(i, ii, iii, iv, v, 等。) 
			upper-roman 大写罗马数字(I, II, III, IV, V, 等。) 

		list-style-image:设置图片最为列表项类型 使用的时候使用 
			url函数  url("/i/arrow.gif");
			none 默认。无图形被显示。 

	背景:
		background 简写属性，作用是将背景属性设置在一个声明中。 
		background-attachment 背景图像是否固定或者随着页面的其余部分滚动。 
		background-color 设置元素的背景颜色。 
		background-image 把图像设置为背景。 url
		background-position 设置背景图像的起始位置。 
		background-repeat 设置背景图像是否及如何重复。 

	尺寸:
		height 		 设置元素的高度。 
		line-height  设置行高。 
		max-height	 设置元素的最大高度。 
		max-width	 设置元素的最大宽度。 
		min-height	 设置元素的最小高度。 
		min-width	 设置元素的最小宽度。 
		width 		 设置元素的宽度。 


/////////////////////////////////////////////////////////////////////////////////////

CSS 定位

	相对定位 

	绝对定位 


	浮动:
		float: 可选值

			left 元素向左浮动。 
			right 元素向右浮动。 


		<style>
			.divCls{
				background-color: #ff0;
				border: 1px solid red;
				height: 25px;
				width: 25px;
				float: left;
			}
			
			.cle{
				clear: both;
			}
		</style>
		
	分类:
		clear:设置元素的两边是否有其他的浮动元素
			值为:both 两边都不允许有浮动元素
		display:设置是否及如何显示元素。

			none 此元素不会被显示。 
			block 此元素将显示为块级元素，此元素前后会带有换行符。 
			inline 默认。此元素会被显示为内联元素，元素前后没有换行符。


			inline-block 行内块元素。（CSS2.1 新增的值） 
			list-item 此元素会作为列表显示。 
			run-in 此元素会根据上下文作为块级元素或内联元素显示。 
			compact CSS 中有值 compact，不过由于缺乏广泛支持，已经从 CSS2.1 中删除。 
			marker CSS 中有值 marker，不过由于缺乏广泛支持，已经从 CSS2.1 中删除。 
			table 此元素会作为块级表格来显示（类似 <table>），表格前后带有换行符。 
			inline-table 此元素会作为内联表格来显示（类似 <table>），表格前后没有换行符。 
			table-row-group 此元素会作为一个或多个行的分组来显示（类似 <tbody>）。 
			table-header-group 此元素会作为一个或多个行的分组来显示（类似 <thead>）。 
			table-footer-group 此元素会作为一个或多个行的分组来显示（类似 <tfoot>）。 
			table-row 此元素会作为一个表格行显示（类似 <tr>）。 
			table-column-group 此元素会作为一个或多个列的分组来显示（类似 <colgroup>）。 
			table-column  此元素会作为一个单元格列显示（类似 <col>） 
			table-cell 此元素会作为一个表格单元格显示（类似 <td> 和 <th>） 
			table-caption 此元素会作为一个表格标题显示（类似 <caption>） 
			
			<style>
				div{
					background-color: #ff0;
					border: 1px dashed red;
					height: 50px;
					width: 50px;
				}
				#div0{
					display: none;
				}
				
				#span0{
					display: block;
				}
				
				h1{
					display: inline;
				}
			</style>


			<div >1</div>
			<div id="div0">2</div>
			<div >3</div>
			<div >4</div>
			<span>天佑中华</span>
			<span id="span0">天佑中华</span>
			<span>天佑中华</span>
			<hr />
			<h1>热门商品</h1>你好啊

/////////////////////////////////////////////////////////////////////////////////////


框模型:(理解)
	一个元素外面有padding(内边距) border(边框) margin(外边距)
		padding:元素和边框的距离
		margin:元素最外层的空白
	上面这三个属性都有简写的属性
		若设置大小的时候 四个值:顺序 上右下左
			padding:10px 10px 10px 10px
			若只写一个的话 代表四个边使用同一个值  padding:10px
			若只写两个个的话 代表四个边使用同一个值 padding:10px 20px
			若只写三个个的话 代表四个边使用同一个值 padding:10px 20px 30px
	border(边框)
		还可以设置颜色 风格
		简写属性:
			border:宽度	风格 颜色;

			border:5px solid red;
			
			solid:实线
			dashed:虚线
			double:双实线

		<style>
			body{
				margin: 0px;
			}
			div{
				background-color: #ff0;
				width: 150px;
				height: 150px;
				float: left;
				
				border: 10px solid red;
				margin: 50px 25px;
				padding: 10px 20px 30px;
			}
		</style>


		<div>123</div>
		<div>123</div>
/////////////////////////////////////////////////////////////////////////////////////



JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，
	内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言
组成部分:
	ECMAScript:js基础语法(规定 关键字 运算符 语句 函数等等...)
	BOM:浏览器对象模型
	DOM:文档对象模型
作用:
	修改html页面的内容
	修改html的样式
	完成表单的验证
注意:
	js可以在页面上直接写,也可以单独出去
	js的文件的后缀名 .js
js和html整合
	方式1:在页面上直接写
		将js代码放在 <script></script>标签中,一般放在head标签中
	方式2:独立的js文件
		通过script标签的src属性导入
js中变量声明:
	var 变量名=初始化值;
	var 变量名;
		变量名=初始化值;
	注意:
		var可以省略 建议不要省略
		一行要以分号结尾,最后一个分号可以省略,建议不要省略



js的数据类型:
	原始类型:(5种)
		Null
		String
		Number
		Boolean
		Undefined

		通过 typeof运算符可以判断一个值或者变量是否属于原始类型,若属于原始类型,他还可以判断出属于那种原始类型
			typeof 变量|值;

			alert(typeof bisdfa);

		若变量为null,使用typeof弹出的值 object
		
		使用typeof的返回值
			undefined - 如果变量是 Undefined 类型的 
			boolean - 如果变量是 Boolean 类型的 
			number - 如果变量是 Number 类型的 
			string - 如果变量是 String 类型的 
			object - 如果变量是一种引用类型或 Null 类型的 



/////////////////////////////////////////////////////////////////////////////////////


js:事件驱动函数
	函数定义格式:
		方式1:
			function 函数名(参数){
				函数体;
			}
		注意:函数不用声明返回值类型 
			参数不需要加类型
			函数调用的时候
				函数名(参数)
js中的事件:
	常见的事件:
		单击:  	  onclick
		表单提交: onsubmit 加在form表单上的 onsubmit="return 函数名()"  注意函数返回值为boolean类型
		页面加载: onload

		onabort 	图像的加载被中断。
		onblur 		元素失去焦点。
		onchange 	域的内容被改变。

	*	onclick 	当用户点击某个对象时调用的事件句柄。
	*	ondblclick 	当用户双击某个对象时调用的事件句柄。

		onerror 	在加载文档或图像时发生错误。
		onfocus 	元素获得焦点。
		onkeydown 	某个键盘按键被按下。
		onkeypress	某个键盘按键被按下并松开。
		onkeyup 	某个键盘按键被松开。

	*	onload 		一张页面或一幅图像完成加载。

		onmousedown 鼠标按钮被按下。
		onmousemove 鼠标被移动。
		onmouseout 	鼠标从某元素移开。
		onmouseover 鼠标移到某元素之上。
		onmouseup 	鼠标按键被松开。 
		onreset 	重置按钮被点击。
		onresize 	窗口或框架被重新调整大小。
		onselect 	文本被选中。

	*	onsubmit 	确认按钮被点击。加在form表单上的 onsubmit="return 函数名()"   注意函数返回值为boolean类型

		onunload 	用户退出页面。 

		
js事件和函数的绑定:
	方式1:
		通过标签的事件属性   <xxx onclick="函数名(参数)"></xxx>


	方式2:派发事件
		document.getElementById("id值").onxxx=function(){...};
		document.getElementById("id值").onxxx=函数名;



		<script>
			function btnCli(){
				alert(44944);
			}
			
			
			function init(){
				//alert("页面加载成功");
				document.getElementById("btn2").onclick=btn2cli;
			}
			
			var  btn2cli=function(){
				alert("244944");
			}
			
		</script>


		<body onload="init()">
			<input type="button" value="点击我试试" onclick="btnCli()">
			
			<input type="button" value="点击试试2" id="btn2">
		</body>

/////////////////////////////////////////////////////////////////////////////////////


js获取元素:


	方式1:
		var obj=documnet.getElementById("id值");

	获取元素的value值

		obj.value;

	获取元素的标签体中的内容

		obj.innerHTML;


	设置元素的标签体

		obj.innerHTML = "sss";

		<script>
			function btnCli(){
				//获取id为btn的元素
				var obj=document.getElementById("btn");
				
				//获取value属性
				alert(obj.value)
			}
		</script>


		<input value="确定" id="btn" type="button" onclick="btnCli()"/>




	alert()向页面中弹出一个提示框！！

	innerHTML:向页面的某个元素中写一段内容，将原有的东西覆盖

	document.write();向页面中写内容



/////////////////////////////////////////////////////////////////////////////////////



函数的定义:
	方式1:
		function 函数名(参数){
			函数体;
		}	
	
	方式2:
		var 函数名=function(参数){
			函数体;
		}
		
js事件和函数的绑定:
	方式1:
		通过标签的事件属性   <xxx onclick="函数名(参数)"></xxx>
	方式2:
		给元素派发事件
			document.getElementById("id值").onclick=function(参数){....}
			document.getElementById("id值").onclick=函数名
		注意:
			内存中应该存在该元素才可以派发事件

		a.将方式2的js代码放在html页面的最下面
		b.在页面加载成功之后在运行方式2的js代码  onload事件.



		<script>
			function checkForm(){
				
				//获取用户名及其内容
				var usernameObj=document.getElementById("username");
				var username=usernameObj.value;
				//判断value是否为空 若为空不能提交表单,
				if(username==null || username == ""){
					alert("用户名不能为空");
					return false;
				}
				
				//获取密码及其内容
				//1.获取密码元素
				var pwdObj=document.getElementById("password");
				
				//2.获取密码的值
				var pwdValue=pwdObj.value;
				
				//3.判断
				if(pwdValue==null || pwdValue==""){
					alert("密码不能为空");
					return false;
				}
				
				return true;
			}
		</script>



		<form action="#" method="get" onsubmit="return checkForm()">
			姓名:<input name="username" id="username"/><br>
			密码:<input type="password" name="password" id="password"><br>
			<input type="submit" value="保存"/>
			<input type="reset" />
		</form>

/////////////////////////////////////////////////////////////////////////////////////


技术分析:
	bom中window对象的定时器方法
定时器:
	var id=setInterVal(code,毫秒数):每隔指定的毫秒数执行一次函数 周期
	var id=setTimeout(code,毫秒数):延迟指定的毫秒数之后 只执行一次函数
	
	清除定时器:
		clearInterval(id);
		claerTimeout(id);
String对象
	原始类型的String是一个为对象可以直接调用String类对象的方法
	substring(0,endIndex);



		<script>
			var s="我们的明天更加美好!";
			var i=0;
			var divObj;
			
			function init(){
				divObj=document.getElementById("divId");
				setInterval(show,200);
			}
			
			//往div中写内容
			function show(){
				i++;
				var s_=s.substring(0,i);
				//往div中设置内容
				divObj.innerHTML=s_;
				
				//当字符串写完的时候 重新开始
				if(i==s.length){
					i=0;
				}
			}
		</script>

		<body onload="init()">
			<div id="divId"></div>
		</body>

/////////////////////////////////////////////////////////////////////////////////////

	<script>
		
		var i=1;
		
		function init(){
			//创建一个定时器
			setInterval(changeImage,1000);
			
		}
		
		//更改图片
		//<img id="luboid" src="../img/1.jpg"/>
		function changeImage(){
			//获取图片元素
			var imgObj=document.getElementById("luboid");
			i++;
			//修改图片元素的src属性
			imgObj.src="../img/"+i+".jpg";
			
			//当i>3的时候 重置i
			if(i>=3){
				i=0;
			}
			
		}
	</script>

/////////////////////////////////////////////////////////////////////////////////////

补充:
	运算符:
		比较运算符: > >= < <=
		若两边都是数字 和java一样
		若一般为数字,另一边为字符串形式的数字,将字符串形式的数字转换成数字在进行比较   3>"2"
		若一般为数字,另一边为字符串,返回一个false   3>"hello"
		两边都是字符串的时候,比较ascii
	等性运算符 == ===
		== :只判断值是否相同
		===:不仅判断是否相同,还要判断类型是否相同
语句:
	if语句 和java一样
	for while 语句和java一样
	switch 和java一样(区别,switch 后面跟字符串. 还可以跟变量)



/////////////////////////////////////////////////////////////////////////////////////

案例1-定时弹出广告
需求:
	打开页面后4秒,展示广告,2秒之后,该广告隐藏.再停2秒,继续展示.

技术分析:
	定时器

定时器(BOM-window对象)
	setInterval(code,毫秒数):周期执行
	setTimeout(code,毫秒数):延迟多长事件后 只执行一次.
	
	清除定时器
		clearInterval(id):
		clearTimeout(id):

步骤分析:
	1.确定事件
	2.编写函数
		a.获取元素
		b.操作元素
////////////////////////
///
///
	1.html页面,先把广告隐藏
	2.页面加载成功事件 onload
	3.编写函数
		定时器:
		操作元素:
			document.getElementById("")
		操作css属性
			document.getElementById("id").style.属性="值"
			属性:就是css中属性 css属性有"-" 例如:backgroud-color
				若有"-" 只需要将"-"删除,后面第一个字母变大写即可
	注意:
		只要是window对象的属性和方法,可以把window省略
			window.onload 等价于 onload
			window.setInterval() 等价于 setInterval()


/////////////////////////////////////////////////////////////////////////////////////


	<script>
		//点击按钮之后,给id为divid0的元素添加 边框 背景色 宽高
		function btnCli(){
			//1.获取元素
			var obj=document.getElementById("divid0");
			//alert(obj)
			
			//2.操作元素
			//添加背景色
			obj.style.backgroundColor="#ff0";
			
			//添加边框
			obj.style.border="1px solid red";
			
			//添加宽和高
			obj.style.width="100px";
			obj.style.height="100px";
		}



		//body加载成功
		function init(){
			alert(1)
		}

	</script>

	<body id="bid" onload="init()">
		<input type="button" value="将div加上样式" onclick="btnCli()"/>


		<div id="divid0"></div>
		
	</body>


	//window加载成功
	<script>

		//window.onload == onload
		//window.setInterval()== setInterval()
		/*window.onload=function(){
			alert(1)
		}*/

		//window可以省略
		onload=function(){
			alert(1)
		}
	</script>


/////////////////////////////////////////////////////////////////////////////////////
案例1-弹出广告


	<script>
		//记录次数
		var i=0;
		
		//定时器id
		var timer;
		
		onload=function(){
			//设置定时器 间隔4秒后展示图片
			timer=setInterval(showAd,4000);
		}
		
		//展示广告方法 展示2秒之后隐藏
		function showAd(){
			//展示的次数加1
			i++;
			
			//若i=3 清空由setinterval设置的定时器
			if(i==3){
				clearInterval(timer);
			}
			
			//1.获取广告
			var divObj=document.getElementById("ad");
			
			//2.修改广告的样式 将其显示
			divObj.style.display="block";
			
			//3.2秒之后隐藏 只执行一次
			setTimeout(hideAd,2000);
			
		}
		
		//隐藏广告
		function hideAd(){
			//1.获取广告
			var divObj=document.getElementById("ad");
			
			//2.修改样式 将其隐藏
			divObj.style.display="none";
		}

	</script>


/////////////////////////////////////////////////////////////////////////////////////



bom(浏览器对象模型)总结
	所有的浏览器都有5个对象
		window:窗口
		location:定位信息 (地址栏)
		history:历史
window对象详解:
	如果文档包含框架（frame 或 iframe 标签），浏览器会为 HTML 文档创建一个 window 对象，
	并为每个框架创建一个额外的 window 对象。
	常用的属性:
		通过window可以获取其他的四个对象
			window.location 等价域 location
			window.history 等价于 history
			...
	常用的方法
		消息框
			alert("...."):警告框
			confirm("你确定要删除吗?"):确定框 返回值:boolean
			prompt("请输入您的姓名"):输入框 返回值:你输入的内容
		定时器
			设置定时器
				setInterval(code,毫秒数):周期执行
				setTimeout(code,毫秒数):延迟多长事件后 只执行一次.
				
				例如:
					setInterval(showAd,4000);
					serInterval("showAd()",4000);
			
			清除定时器
				clearInterval(id):
				clearTimeout(id):
		打开和关闭
			open(url):打开
			close():关闭



	*	alert() 显示带有一段消息和一个确认按钮的警告框

		blur() 把键盘焦点从顶层窗口移开
		clearInterval() 取消由 setInterval() 设置的 timeout
		clearTimeout() 取消由 setTimeout() 方法设置的 timeout

	*	close() 关闭浏览器窗口

	*	confirm() 显示带有一段消息以及确认按钮和取消按钮的对话框

		createPopup() 创建一个 pop-up 窗口
		focus() 把键盘焦点给予一个窗口
		moveBy() 可相对窗口的当前坐标把它移动指定的像素
		moveTo() 把窗口的左上角移动到一个指定的坐标

	*	open() 打开一个新的浏览器窗口或查找一个已命名的窗口

		print() 打印当前窗口的内容

	*	prompt() 显示可提示用户输入的对话框

		resizeBy() 按照指定的像素调整窗口的大小
		resizeTo() 把窗口的大小调整到指定的宽度和高度
		scrollBy() 按照指定的像素值来滚动内容
		scrollTo() 把内容滚动到指定的坐标
		setInterval() 按照指定的周期（以毫秒计）来调用函数或计算表达式
		setTimeout() 在指定的毫秒数后调用函数或计算表达式



/////////////////////////////////////////////////////////////////////////////////////


		href:获取或者设置当前页面的url(定位信息)
		
		location.href; 获取url
		location.href="...";设置url 相当于 a标签


/////////////////////////////////////////////////////////////////////////////////////


		history:历史
			.back();后退
			.forward():向前
		★	.go(int)
			.go(-1) 相当于 back()
			.go(1) 相当于 forward()


/////////////////////////////////////////////////////////////////////////////////////


案例2-表单校验plus
需求:
	提示信息不用弹出框,将信息追加在文本框后面

技术分析:

	确定事件 表单提交的时候 onsubmit
			文本框失去焦点的时候 onblur
	编写函数
	获取元素
		document.getElementById("id值");
	操作元素(获取元素的值,操作标签体,操作标签value属性)
/////////////////
步骤分析:
	1.表单
	2.表单提交的时候 确定事件 onsubmit()
	3.校验用户名和密码
	4.获取用户名和密码的对象及值
	5.判断内容,当为空的时候,获取响应的span元素
		往span元素中显示错误信息


	<body>
		用户名:<input name=""  value="tom" onfocus="getFocus()" onblur="loseFocus()" id="username"/><br />
		<span id="spanid"></span>
	</body>
	<script>
	
		//得到焦点
		function getFocus(){
			//获取元素
			var user=document.getElementById("username");
			//alert(user.value);
			
			//给span填写内容 文本框的内容
			document.getElementById("spanid").innerHTML=user.value;
		}
		
		//失去焦点的时候将他的内容弹出来
		function loseFocus(){
			//获取元素
			var user=document.getElementById("username");
			
			alert(user.value);
		}
	</script>


/////////////////////////////////////////////////////////////////////////////////////



注意:

	在方法中(function()) this指代的是当前的元素(当前dom对象)
例如:
	<input type="text" name="username" id="username" onblur="loseFocus(this.value)">
	方法:
		function loseFocus(obj){
			alert(obj);
		}



/////////////////////////////////////////////////////////////////////////////////////


事件总结:
	常见的事件:

		焦点事件:★
			onfocus
			onblur

		表单事件:★
			onsubmit
			onchange 改变

		页面加载事件:★
			onload
		
		鼠标事件(掌握)
			onclick

		鼠标事件(了解)
			ondblclick:双击
			onmousedown:按下
			onmouserup:弹起
			onmousemove:移动
			onmouserover:悬停
			onmouserout:移出

		键盘事件(理解)
			onkeydown:按下
			onkeyup:弹起
			onkeypress:按住

/////////////////////////////////////////////////////////////////////////////////////


了解
	阻止默认事件的发生
	阻止事件传播

		<a href="http://www.itheima.com" onclick="one()">黑马程序员</a><br/>
		<a href="http://www.itcast.cn" onclick="two()">传智播客</a><br/>
		<script type="text/javascript">
			function one(){
				alert("我之后，黑马官网继续访问");
			}
			
			function two(event){
				alert("我之后，传智官网不再访问");
				var event = event || window.event;//IE中event为空，保证event有值

				//阻止默认事件的发生
				event.preventDefault();
			}
		</script>

/////////////////////////////////////////////////////////////////////////////////////

			alert( true || false);	//true
			alert(true||"abc")		//true
			alert(false||"abc")		//"abc"
			alert(true&&false)		//false
			alert(true&&"abc")		//"abc"
			alert(false&&"abc")		//false
			alert(null&&"abc");		//null
			alert(Boolean(null))    //false	


/////////////////////////////////////////////////////////////////////////////////////



案例3-隔行换色
需求:
	一个表格,隔一行换一个色
技术分析:
	事件:onload 
	获取元素:dom操作


///////////////


获取元素:
	document.getElementById("id"):通过id获取一个元素
	document.getElementsByTagName("标签名"):通过标签名获取一种元素(多个)返回一个数组

Array:
	常用属性:
		length:数组的长度


////////////////////////

步骤分析:
	1.html表格一加载的时候 确定事件 onload
	2.编写函数
		a.获取元素(所有的tr元素)
		b.操作(若当前行是偶数的话加一个样式,若是奇数的话,加另一个样式)

	//页面加载成功
			onload=function(){
				//1.获取所有的tr
				var arr=document.getElementsByTagName("tr");
				//alert(arr);
				//alert(arr.length);
				
				//2.判断奇偶数 添加不同的样式 遍历数组
				for(var i=1;i<arr.length;i++){
					if(i%2==0){
						arr[i].style.backgroundColor="#FFFFCC";
					}else{
						arr[i].style.backgroundColor="#BCD68D";
					}
				}
				
			}


/////////////////////////////////////////////////////////////////////////////////////


案例4:全选或者全不选
步骤分析:
	1.确定事件 最上面那个复选框的单击事件 onclick
	2.编写函数:让所有的复选框和最上面的复选框状态保持一致
		a.获取最上面这个复选框选中状态 通过checkbox的checked属性即可
		b.获取其他的复选框,设置他们的checked属性即可
			可以通过以下两种方案获取元素
				document.getElementsByClassName():需要给下面所有的复选框添加class属性
				document.getElementsByName():需要给下面所有的复选框添加name属性





		<script>
			function selectAll(obj){
				//获取当前复选框的选中状态
				var flag=obj.checked;
				
				//获取所有的复选框
				var arr=document.getElementsByClassName("itemSelect");
				
				//遍历数组,将所有的复选框和flag相同
				for(var i=0;i<arr.length;i++){
					arr[i].checked=flag;
				}
			}
		</script>



		<table id="tab1" border="1" width="800" align="center" >
			<tr>
				<td colspan="5"><input type="button" value="添加"/> <input type="button" value="删除"></td>
			</tr>
			<tr>
				<th><input type="checkbox" onclick="selectAll(this)" ></th>
				<th>分类ID</th>
				<th>操作</th>
			</tr>
			<tr>
				<td><input type="checkbox" class="itemSelect"></td>
				<td>1</td>
				<td><a href="">修改</a>|<a href="">删除</a></td>
			</tr>
			<tr>
				<td><input type="checkbox" class="itemSelect"></td>
				<td>2</td>
				<td><a href="">修改</a>|<a href="">删除</a></td>
			</tr>
		</table>


/////////////////////////////////////////////////////////////////////////////////////


dom(文档对象模型)
	当浏览器接受到html代码的时候,浏览器会将所有的代码装载到内存中,形成一棵树(document树)
	节点(Node)
		文档节点 document
		元素节点 element
		属性节点 attribute
		文本节点 text
	
	获取节点:
		通过document可以获取其他节点:
			常用方法:
				document.getElementById("id值"):获取一个特定的元素
				document.getElementsByTagName("标签名"):通过标签名获取一种元素(多个)
				document.getElementsByClassName("class属性的值"):通过class属性获取一类元素(多个)
				document.getElementsByName("name属性的值"):通过name属性获取一类元素(多个)
		
		设置获取获取节点的value属性
			dom对象.value;获取
			dom对象.value="";设置
		
		设置或者获取节点的标签体
			dom对象.innerHTML;获取
			dom对象.innerHTML="";设置
		
		获取或者设置style属性
			dom对象.style.属性;获取
			dom对象.style.属性="";设置
		
		获取或者设置属性
			dom对象.属性


/////////////////////////////////////////////////////////////////////////////////////


对于htmldom的操作若在js或者htmldom 查找不到 去查找xml dom
	关于文档的操作 在 xml dom 的document中
	关于元素的操作 在 xml dom 的element中
		appendChild(dom对象):在一个元素下添加孩子


/////////////////////////////////////////////////////////////////////////////////////


案例5-左右选中.
需求:
技术分析:
	1.确定事件,按钮的单击事件
	2.编写函数:
		点击移动单|多个的:
			a.获取左边选中的选项  select对象.options--数组
				遍历数组 判断是否选中 option对象.selected
			b.将其追加到右边的下拉选中
				rightSelect对象.appendChild(option);
		点击移动所有的
			a.获取左边的所有的选项
			b.一个个的追加过去



	<script>
	 		onload=function(){
		 			//给单移按钮派发事件
		 			document.getElementById("toRight1").onclick=function(){
		 					//获取左边所有的option
		 					var arr=document.getElementById("left").options;
		 					//alert(arr);
		 					//alert(arr.length);
		 					
		 					//遍历数组 判断是否选中
		 					for(var i=0;i<arr.length;i++){
		 							//判断是否选中 若选中 则追加(移动)到右边的select中
		 							if(arr[i].selected){
		 								document.getElementById("right").appendChild(arr[i]);
		 								break;
		 							}
		 					}
		 			}
		 			
		 			//给多移动按钮派发事件
		 			document.getElementById("toRight2").onclick=function(){
		 					//获取左边所有的option
		 					var arr=document.getElementById("left").options;
		 					//alert(arr);
		 					//alert(arr.length);
		 					
		 					//遍历数组 判断是否选中 
		 					for(var i=0;i<arr.length;i++){
		 							//判断是否选中 若选中 则追加(移动)到右边的select中
		 							if(arr[i].selected){
		 								document.getElementById("right").appendChild(arr[i]);
		 								//注意:长度变化
		 								i--;
		 							}
		 					}
		 			}
		 			
		 			
		 				//给全部移动按钮派发事件
		 			document.getElementById("toRight3").onclick=function(){
		 					//获取左边所有的option
		 					var arr=document.getElementById("left").options;
		 				
		 					
		 					//遍历数组 判断是否选中 
		 					for(var i=0;i<arr.length;){
		 							//相当于永远把第一个选项移动过去
		 								document.getElementById("right").appendChild(arr[i]);
		 								//注意:长度变化
		 								
		 					}
		 			}
		 			
	 		}
	 </script>
	<body>
		<table>
			<tr>
				<td>
				<!-- multiple 多选 -->
					<select id="left" multiple="true" style="width:100px" size="10">
						<option>環</option>
						<option>芈</option>
						<option>琅</option>
						<option>琊</option>
						<option>爨</option>
						<option>甄</option>
						<option>槑</option>
						<option>夔</option>
					</select>
				</td>
				<td>
					<input type="button" value=">" id="toRight1"><br>
					<input type="button" value=">>" id="toRight2"><br>
					<input type="button" value=">>>" id="toRight3"><br><br>
					<input type="button" value="<" id="toLeft1"><br>
					<input type="button" value="<<" id="toLeft2"><br>
					<input type="button" value="<<<" id="toLeft3">
				</td>
				<td>
					<select id="right" multiple="true" style="width:100px" size="10">
						
					</select>
				</td>
			</tr>
		</table>
	</body>




/////////////////////////////////////////////////////////////////////////////////////


案例6-省市联动
需求:
	选中省的时候,动态的查询当前省下的所有市,然后展示在市的下拉选中
技术分析:
	数组:

////////////////////////

数组:
	语法:
		new Array();//长度为0
		new Array(size);//指定长度的
		new Array(e1,e2..);//指定元素
		非官方
			var arr4=["aa","bb"];
	常用属性:
		length
	注意:
		数组是可变的
		数组可以存放任意值
	常用方法:(了解)
		存放值:对内容的操作
			pop():弹	最后一个
			push():插入 到最后
			
			shift():删除第一个
			unshift():插入到首位
		打印数组:
			join(分隔符):将数组里的元素按照指定的分隔符打印
		拼接数组:
			concat():连接两个或更多的数组，并返回结果。
		对结构的操作:
			sort();排序
			reverse();反转

////////////////////////

步骤分析:
	1.省的下拉选 的选项中添加value属性 当成数组的索引
	2.初始化市
	3.选择省的时候,onchange事件
	4.编写函数,
		通过获取的索引获取对象的市的数组 this.value
		遍历数组,将数组里面的每个值组装option 添加到select中即可
			



	<head>
		<meta charset="UTF-8">
		<title></title>
		<script>
			// 定义二维数组:
			var arr = new Array(4);
			arr[0] = new Array("哈尔滨","齐齐哈尔","大庆","佳木斯");
			arr[1] = new Array("长春市","吉林市","四平市","通化市");
			arr[2] = new Array("沈阳市","锦州市","大连市","铁岭市");
			arr[3] = new Array("郑州市","洛阳市","安阳市","南阳市");
		</script>
	</head>
	<body>
		<form action="#" method="get">
			<input type="hidden" name="id" value="007"/>
			姓名:<input name="username" value="xuduoduo"/><br>
			密码:<input type="password" name="password"  value="123" disabled="disabled"><br>
			性别:<input type="radio" name="sex" value="1" checked="checked">男
				<input type="radio" name="sex" value="0">女
				<br>
			爱好:<input type="checkbox" name="hobby" value="eat">吃
				<input type="checkbox" name="hobby" value="drink" checked="checked">喝
				<input type="checkbox" name="hobby" value="sleep" checked="checked">睡
				<br>
			头像:<input type="file" name="photo"><br>
			籍贯:
				<select name="pro" onchange="selCity(this.value)">
					<option >-请选择-</option> 
					<option value="0">黑龙江</option>
					<option value="1">吉林</option>
					<option value="2">辽宁</option>
					<option value="3">河南</option>
				</select>
				<select name="city">
					<option >-请选择-</option> 	
				</select>
			<br>
			自我介绍:
				<textarea name="intr" cols="40" rows="4">good!</textarea>
			<br>
			<input type="submit" value="保存"/>
			<input type="reset" />
			<input type="button" value="普通按钮"/>
		</form>
	</body>


	<script>
		function selCity(index){
			//alert(index);
			var cities=arr[index];
			
			//获取市的下拉选
			var citySelObj=document.getElementsByName("city")[0];
			
			//先初始化
			citySelObj.innerHTML="<option >-请选择-</option>";
			
			//遍历数组 组装成option 追加到select
			for(var i=0;i<cities.length;i++){
				citySelObj.innerHTML+=("<option>"+cities[i]+"</option>");
			}
		}
	</script>


/////////////////////////////////////////////////////////////////////////////////////



引用类型总结:
	原始类型中的String Number Boolean都是伪对象,可以调用相应的方法
	Array:数组
	String:
		语法:
			new String(值|变量);//返回一个对象
			String(值|变量);//返回原始类型
		常用方法:
			substring(start,end):[start,end)
			substr(start,size):从索引为指定的值开始向后截取几个
			
			charAt(index):返回在指定位置的字符。
			indexOf(""):返回字符串所在索引
			
			replace():替换
			split():切割
			
		常用属性:length	
	Boolean:
		语法:
			new Boolean(值|变量);
			Boolean(值|变量);
			非0数字 非空字符串 非空对象 转成true
	Number
		语法:
			new Number(值|变量);
			Number(值|变量);
		注意:
		
			null====>0 
			fale====>0 true====>1
			字符串的数字=====>对应的数字
			其他的NaN
	Date:
		new Date();
		常用方法:
			toLocalString()
	RegExp:正则表达式
		语法:
			直接量语法  /正则表达式/参数
			直接量语法  /正则表达式/
			
			new RegExp("正则表达式")
			new RegExp("正则表达式","参数") 
			参数:
				i:忽略大小写
				g:全局
			常用方法:
				test() :返回值为boolean
	Math:
		Math.常量|方法
		Math.PI
		Math.random()  [0,1)
		
	全局:
		★
		decodeURI() 解码某个编码的 URI。 
		encodeURI() 把字符串编码为 URI。

		Number():强制转换成数字
		String():转成字符串
		
		parseInt():尝试转换成整数
		parseFloat():尝试转换成小数
		
		eval() 计算 JavaScript 字符串，并把它作为脚本代码来执行。



/////////////////////////////////////////////////////////////////////////////////////
/**




 */
/////////////////////////////////////////////////////////////////////////////////////




jquery和html的整合
	jquery是单独的js文件
		通过script标签的src属性导入即可



获取一个jquery对象
	$("选择器")  或者 jQuery("选择器")




dom对象和jquery对象之间的转换
	dom对象===>jquery对象	
		$(dom对象)

	<input type="text" id="username" value="jack"/>

	<script>

		var obj = document.getElementById("username")
		var $user=$(obj);
		alert($user.val());




	jquery对象===>dom对象

		方式1:
			jquery对象[index]
		方式2:
			jquery对象.get(index)

		var $u = $("#username");

		var obj = $u.get(0);
		var obj = $u[0];


页面加载:
	
	js:
		window.onload=function(){}//在一个页面中只能使用一次
	


	jquery 在一个页面中可以使用多次
		方式1:
			$(function(){...})
		方式2:
			$(document).ready(function(){});



派发事件:
	$("选择器").click(function(){...});



	等价于 原生js中
		dom对象.onclick=function(){....}



	掌握事件:
		focus
		blur
		submit
		change
		click



			$(document).ready(function(){
				$("#e01").blur(function(){
					$("#textMsg").html("文本框失去焦点：blur");
				})

				.focus(function(){
					$("#textMsg").html("文本框获得焦点：focus");
				})

				.keydown(function(){
					$("#textMsg").append("键盘按下：keydown");
				})

				.keypress(function(event){
					$("#textMsg").append("键盘按：keypress");
				})

				.keyup(function(){
					$("#textMsg").append("键盘弹起：keyup");
				});
				
				var i = 0;
				$("#e02").mouseover(function(){
					$("#divMsg").html("鼠标移上：mouseover");
				})




				.mousemove(function(){
					//$("#divMsg").html("鼠标移动：mousemove , " + i++ );
				})

				.mouseout(function(){
					$("#divMsg").html("鼠标移出：mouseout");
				})

				.mousedown(function(){
					$("#divMsg").html("鼠标按下：mousedown");
				})

				.mouseup(function(){
					$("#divMsg").html("鼠标弹起：mouseup");
				});



				
				$("#e03")

				.click(function(){
					$("#buttonMsg").html("单击：click");
				})

				.dblclick(function(){
					$("#buttonMsg").html("双击：dblclick");
				});
				
			});
			


jquery中效果:
	隐藏或展示
		show(毫秒数) hide(毫秒数)
	滑入或滑出
		slideDown(毫秒数):向下滑入
		slideUp(毫秒数):向上滑出
	淡入或淡出
		fadeIn(int):淡入
		fadeOut(int):淡出




		基本
		show([s,[e],[fn]]) 		展示
		hide([s,[e],[fn]]) 		隐藏
		toggle([s],[e],[fn])	切换

		滑动
		slideDown([s],[e],[fn]) 
		slideUp([s,[e],[fn]]) 
		slideToggle([s],[e],[fn])

		淡入淡出
		fadeIn([s],[e],[fn]) 
		fadeOut([s],[e],[fn]) 
		fadeTo([[s],o,[e],[fn]]) 
		fadeToggle([s,[e],[fn]]) 

		自定义
		animate(p,[s],[e],[fn])1.8* 
		stop([c],[j])1.7* 
		delay(d,[q]) 

		设置
		jQuery.fx.off 
		jQuery.fx.interval 

/////////////////////////////////////////////////////////////////////////////////////


选择器总结:


	基本选择器★
		$("#id值")  $(".class值")  $("标签名")  多有元素${"*"}


			$("#btn1").click(function() {
				$("#ine").css("background-color","#ff0");
			})

			$("#btn2").click(function() {
				$(".mini").css("background-color","#ff0");
			})

			$("#btn2").click(function() {
				$("div").css("background-color","#ff0");
			})

			$("#btn2").click(function() {
				$("*").css("background-color","#ff0");
			})


			$("#btn2").click(function() {
				$("span,#two").css("background-color","#ff0");
			})
		
		
		了解:$("*")
		理解:获取多个选择器 用逗号隔开
			$("#id值,.class值")

//////////////////////////////////


	层次选择器 ★
		a b  :a的所有b后代
		a>b  :a的所有b孩子
		a+b  :a的下一个兄弟(大弟弟)
		a~b  :a的所有弟弟

		// 选择 body内的所有div元素
			$("#btn2").click(function() {
				$("body div").css("background-color","#ff0");
			})
		// 在body内,选择子元素是div的

			$("#btn2").click(function(){
				$("body>div").css("background-color","#f0f");
			});
		// 选择 id为one 的下一个div元素 就是 two的div元素.
			$("#btn3").click(function(){
				$("#one+div").css("background-color","#f0f");
			});

		// 选择 id为two的元素后面的所有div兄弟元素.
			$("#btn4").click(function(){
				$("#two~div").css("background-color","#f0f");
			});


//////////////////////////////////


	基本过滤选择器:★
		:frist 第一个
		:last 最后一个
		:odd  索引奇数
		:even 索引偶数
		:eq(index) 指定索引
		:gt(index) >
		:lt(index) <


		//选择第一个div元素
			$("#btn1").click(function(){
				$("div:first").css("background-color","#0f0");
			});

		//选择最后一个div元素
			$("#btn2").click(function(){
				$("div:last").css("background-color","#0f0");
			});

		//选择索引值为偶数 的div元素
			$("#btn3").click(function(){
				$("div:even").css("background-color","#0f0");
			});

		//选择索引值为奇数 的div元素
			$("#btn4").click(function(){
				$("div:odd").css("background-color","#0f0");
			});

		//选择索引值等于3的div元素
			$("#btn5").click(function(){
				$("div:eq(3)").css("background-color","#0f0");
			});

		//选择索引值大于3的div元素	
			$("#btn6").click(function(){
				$("div:gt(3)").css("background-color","#0f0");
			});

//////////////////////////////////


	内容过滤:
		:has("选择器"):包含指定选择器的元素

		//选取含有class为mini元素 的div元素
	 		$("#btn1").click(function(){
	 			$("div:has('.mini')").css("background-color","#0ff");
	 		});

//////////////////////////////////	


	可见过滤:
		:hidden   在页面不展示元素 一般指 input type="hidden" 和 样式中display:none
		:visible 


		//选取所有可见的div元素
			$("#b1").click(function(){
				$("div:visible").css("background-color","#f0f");
			});

		//选取所有不可见的div元素, 利用 jQuery 中的 show() 方法将它们显示出来
	 		$("#b2").click(function(){
				$("div:hidden").css("background-color","#f0f").show(1000);
			});


//////////////////////////////////

	属性过滤器:★
		[属性名]
		[属性名="值"]


		属性
			[attribute] 
			[attribute=value] 
			[attribute!=value] 
			[attribute^=value] 
			[attribute$=value] 以某些值结尾的元素
			[attribute*=value] 包含某些值的元素
			[attrSel1][attrSel2][attrSelN] 


		//选取含有 属性title 的div元素
			$("#btn1").click(function(){
				$("div[title]").css("background-color","#ff0");
			});

		//选取 属性title值等于“test”的div元素
			$("#btn2").click(function(){
				$("div[title='test']").css("background-color","#ff0");
			});

//////////////////////////////////

	表单过滤:
		:input  所有的表单子标签  input select textarea button
		//input

			$(function(){
			 		$("#btn1").click(function(){
			 			//alert($("#form1 :input").size());//层次选择器
			 			//alert($("#form1 :input").length);
			 			alert($("#form1 input").size());
			 		});
			 });

		表单
		:input 
		:text 
		:password 
		:radio 
		:checkbox 
		:submit 
		:image 
		:reset 
		:button 
		:file 
		:hidden 


/////////////////////////////////////////////////////////////////////////////////////

案例2-隔行换色

			$(function(){
				/*$("tr:odd").css("background-color","#BCD68D");
				$("tr:even").css("background-color","#FFFFCC");*/
				
				/*$("tr:gt(0):odd").css("background-color","#BCD68D");
				$("tr:gt(0):even").css("background-color","#FFFFCC");*/
				
				$("tr:gt(0):odd").addClass("odd");
				$("tr:gt(0):even").addClass("even");
			})


技术分析:
	1.页面加载成功
	2.获取所有的奇数行 添加一个css
	3.获取所有的偶数行 添加一个css

属性和css操作总结:

	CSS
		css(name|pro|[,val|fn])1.8* 
	位置
		offset([coordinates]) 
		position() 
		scrollTop([val]) 
		scrollLeft([val]) 
	尺寸
		heigh([val|fn]) 
		width([val|fn]) 
		innerHeight() 
		innerWidth() 
		outerHeight([soptions]) 
		outerWidth([options]) 



	对属性的操作:
		attr():设置或者获取元素的属性

			方式1:获取
				attr("属性名称")

			方式2:设置一个属性
				attr("属性名称","值");

			方式3:设置多个属性  json
				attr({
					"属性1":"值1",
					"属性2":"值2"
				})

		removeAttr("属性名称"):移除指定属性
	//添加class属性的时候 
	//	attr("class","值");
	addClass("指定的样式值"); 相当于 attr("class","指定的样式值");
	removeClass("指定的样式值");

	对css操作:操作元素的style属性
		css():获取或者设置css样式
			方式1:获取	
				css("属性名")
			方式2:设置一个属性
				css("属性名","值")
			方式3:设置多个
				css({
					"属性1":"值1",
					"属性2":"值2"
				});
	获取元素的尺寸:
		width()
		height()


		$(document).ready(function(){
			//1.1给username添加title属性
			var $username=$("[name='username']");
			$username.attr("title","姓名");
			//1.2获取username的title属性
			//alert($username.attr("title"));
			
			//1.3给username添加value和class属性
			$username.attr({
				"value":"许多多",
				"class":"textClass"
			});
			
			//1.4删除username的class属性
			$username.removeAttr("class");
			
			//2.1给username添加一个名为textClass的样式
			$username.addClass("textClass");
			
			//2.2删除username的名为textClass的样式
			$username.removeClass("textClass");
			
			
			//4.1 给div添加边框样式
			var $div=$("div");
			$div.css("border","1px solid red");
			
			//4.2 获取div的表框样式
			//alert($div.css("border"));
			
			//4.3 给div添加多种样式
			$div.css({
				"width":"100px",
				"height":"100px",
				"background-color":"#ff0"
			});
			
			//5 获取div的位置
			//alert($div.offset().left)
			
			//6 获取div的高和宽
			alert($div.width());
			});	

/////////////////////////////////////////////////////////////////////////////////////


案例3-全选或者全不选
需求:
	就是将内容中复选框的选中状态和最上面的复选框状态保持一致
步骤分析:
	1.确定事件 复选框的单击事件
	2.函数中
		a.获取该复选框的选中状态  attr(获取不了checked属性)|prop
		b.获取所有的复选框修改他们的状态
注意:
	若jquery版本>1.6 统一使用 prop操作元素的属性



		$(function(){
	 		$("#selectAll").click(function(){
	 			//1.获取当前元素的选中状态 this在funcation中代表的是当前dom对象
	 			//alert(this.checked);
	 			//alert($(this).attr("checked"));//获取undefined
	 			//alert($(this).prop("checked"));
	 			
	 			//2.获取所有的复选框 让其状态和 当前元素的选中状态保持一致
	 			$(".itemSelect").prop("checked",$(this).prop("checked"));
	 		});
	 		
	 		
	 	});


/////////////////////////////////////////////////////////////////////////////////////


案例4-省市联动
步骤分析:
	1.确定事件 省份的下拉选变化的时候  change
	2.编写函数
		a.获取当前省份的value值
		b.通过数组获取该省下的所有市 返回值:数组
		c.遍历数组,拼装成option元素 追加到市下拉选即可
		注意:每次改变的时候初始化市的值.


技术:
	遍历数组
		数组.each(function(){});
		$.each(遍历数组,function(){});
		
	注意:
		each的function中可以加两个参数 index和dom
			index是当前遍历的索引值
			dom指代的是当前遍历的dom对象(开发中一般使用this即可)



		$("#b1").click(function(){
 			//1.获取文本隐藏
 			//alert($("input:hidden").size())
 			$("input:hidden").each(function(index,dom){
 				//alert(this.value)
 				//alert($(this).val());
 				//alert(index)//索引
 				//alert(dom.value)
 			});
 		});
 		
 		$("#b2").click(function(){
 			$.each($("input:hidden"), function() {
 				alert($(this).val());
 			});
 		});



	//////////////////////////////
	设置或者获取value属性
		jquery对象.val():获取
		jquery对象.val("...."):设置




/////////////////////////////////////////


	设置获取获取标签体的内容 
		html()
		text()
		
		xxxxx():获取标签体的内容
		xxxxx("....."):设置标签体的内容
			
			设置的区别:
				html:会把字符串解析
				text:只做为普通的字符串
			获取的区别:
				html:获取的html源码
				text:获取只是页面展示的内容

		<td><input type="text" name="username"/></td>


		<script type="text/javascript">
			$(document).ready(function(){
			
			var $username=$("[name='username']");
			$username.prop("value","许木木");

			//3.1 获取 username的value属性的值
			//alert($username.val());
			
			//3.2 设置 username的默认值为"许多多"
			$username.val("许多多")
			
			//3.3通过html获取div标签体的内容
			var $div=$("div");
			//alert($div.html());
			
			//3.4通过html设置div标签体的内容
			//$div.html("已满18,请带墨镜");
			
			//3.5通过text获取div标签体的内容
			//alert($div.text());
				
			//3.6通过text设置div标签体的内容
			//$div.text("已满18,请带墨镜");
			
			
			//3.7 两者设置值的区别
			//$div.html("<a href='#'>我是一个连接</a>");//就是一个超链接
			//$div.html($("<a href='#'>").html("我"))
			//$div.text("<a href='#'>我是一个连接</a>");//表括号里面的内容作为普通的字符串
			
			//3.8 两者获取值的区别
			//alert($("#sp").html());//获取源码
			//alert($("#sp").text());//获取只是展示的内容
			$div.html($("<a href='#'>").html("我"));
			});	
		</script>


/////////////////////////////////////////


		<script>
			// 定义二维数组:
			var arr = new Array(4);
			arr[0] = new Array("哈尔滨","齐齐哈尔","大庆","佳木斯");
			arr[1] = new Array("长春市","吉林市","四平市","通化市");
			arr[2] = new Array("沈阳市","锦州市","大连市","铁岭市");
			arr[3] = new Array("郑州市","洛阳市","安阳市","南阳市");
		</script>



		$(function(){
	 		$("[name='pro']").change(function(){
	 			//获取市下拉选
	 			var $city=$("[name='city']");
	 			//初始化
	 			$city.html($("<option>").html("-请选择-"));
	 			
	 			var pro=$(this).val();
	 			//获取所有的市数组
	 			var cities=$(arr[pro]);
	 			//alert(cities);
	 			
	 			//遍历数组,拼装成option 追加到市下拉选中
	 			cities.each(function(){
	 				$city.append("<option>"+this+"</option>");
	 				//$city.html($(""));
	 			});
	 		});
	 	});

/////////////////////////////////////////////////////////////////////////////////////



创建一个元素: $("<标签></标签>")
///////////////////////
文档操作:
	内部插入
		a.append(c):将c插入到a的内部(标签体)后面
		a.prepend(c):将c插入到a的内部的前面
		
		appendTo
		prependTo


	$(document).ready(function(){
		//0.获取两个元素
		var $city=$("#city");
		var $fk=$("#fk");
		
		//1.在city的后面内部追加 反恐
		// $city.append($fk);
		
		//2.在city的前面内部插入 反恐
		$city.prepend($fk)
		
	});


///////////////////////
	外部插入
		a.after(c):将c放到a的后面
		a.before(c):将c放到a的前面
		
		a.insertAfter(c)
		a.insertBefore(c)



		$(document).ready(function(){
			//获取两个元素
			var $city=$("#city");
			var $p2=$("#p2");
				
			//1.在 p2 的后面插入 city
			//	$p2.after($city);
			
			//2.在 p2 的前面插入 city
		$p2.before($city);
		
		});


///////////////////////
	删除
		empty() 清空元素
		remove() 删除元素

		$(document).ready(function(){
		//1.清空ul
		//$("#city").empty();
		
		//2.移除天津 remove
		$("#tj").remove();
					
		});

/////////////////////////////////////////////////////////////////////////////////////


案例5-左右移动
步骤分析:
	1.确定事件 单击事件
	2.编写函数:
		移动一个:
			右边的下拉选追加一个 左边的选中的第一个
		移动多个:
			左边选中的 追加到右边的下拉选中
		移动全部:
			将左边的所有option追加到右边的下拉选中
		
技术分析:
	表单对象属性过滤选择器
		:enabled   可用的
		:disabled  不可用
		:checked 	选中的(针对于单选框和复选框的)
		:selected 	选中的(针对于下拉选)


	////对表单内 可用input 赋值操作
		$("#btn1").click(function(){
			$("input:enabled").val("我们来自黑马");
		});
	//对表单内 不可用input 赋值操作
		$("#btn2").click(function(){
			$("input:disabled").val("我们是最棒的");
		});
	////获取多选框选中的个数
		$("#btn3").click(function(){
			alert($("input[ name='newsletter']:checked").size());
		});
	////获取下拉框选中的个数
		$("#btn4").click(function(){
			alert($(":selected").size());
		});

///////////////////////////////////

	$(function(){
		//移动一个
		$("#toRight1").click(function(){
				$("#left>option:selected:first").appendTo($("#right"));
		});
		
		//移动多个
		$("#toRight2").click(function(){
				$("#right").append($("#left option:selected"));
		});
		
		//移动全部
		$("#toRight3").click(function(){
				$("#right").append($("#left option"));
		});
	})


/////////////////////////////////////////////////////////////////////////////////////
/**








 */

/////////////////////////////////////////////////////////////////////////////////////


案例1-表单校验
需求:
	通过validate插件来校验表单
技术分析:
	jqery validate
validate使用步骤:
	validate是别人封装好的第三方工具
	1.导入jquery.js
	2.导入validate.js
	3.在页面加载成功之后 对表单进行校验  $("选择器").validate()
	4.在validate中编写校验规则
		$("选择器").validate({
			rules:{},
			messages:{}
		});



			$(function(){
				$("#formId").validate({
					rules:{
						// 字段的name属性:"校验器"
						
						//字段的name属性:{校验器:值,校验器:值}
						username:"required",
						password:{
							required:true,
							digits:true
						},
						repassword:{
							equalTo:"[name='password']"
						},
						zuixiaozhi:{
							min:5
						},
						shuzhiqujian:{
							range:[5,10]
						}
					},
					messages:{
						//字段的name属性:"提示信息"
						//字段的name属性:{校验器:"提示信息",校验器:提示信息"}
						username:"用户名不能为空",
						password:{
							required:"密码不能为空",
							digits:"密码只能是数字"
						},
						repassword:{
							equalTo:"两次输入的内容不一致"
						},
						zuixiaozhi:{
							min:"最小值应该大于{0}"
						},
						shuzhiqujian:{
							range:"输入的范围在{0}~{1}之间"
						}
					}
				});
			})




			<script type="text/javascript" src="../js/jquery-1.11.0.js" ></script>
			<script type="text/javascript" src="../js/jquery.validate.js" ></script>
			<script type="text/javascript" src="../js/messages_zh.js" ></script>
			<script>
				$(function(){
					$("#formid").validate({
						rules:{
							username:"required",
							password:{
								rangelength:[3,6],
								required:true
							},
							repassword:{
								equalTo:"#password"
							},
							email:"email",
							sex:"required"
						},
						messages:{
							username:"用户名不能为空",
							password:{
								rangelength:"密码长度在{0}~{1}之间",
								required:"密码不能为空"
							}
						}
					});
				})
			</script>


			<body>
				<form action="#" method="get" id="formid">
					<table width="60%" height="60%"  align="center" bgcolor="#ffffff">
						<tr>
							<td colspan="3">会员注册USER REGISTER</td>
						</tr>
						<tr>
							<td width="20%">用户名:</td>
							<td width="80%"><input type="text" name="username" id="username"></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input type="password" name="password" id="password"></td>
						</tr>
						<tr>
							<td>确认密码:</td>
							<td><input type="password" name="repassword" id="repassword"></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="text" name="email" id="email"></td>
						</tr>
						<tr>
							<td>姓名:</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>性别:</td>
							<td>
								<input type="radio" name="sex" value="男" checked="checked"> 男
								<input type="radio" name="sex" value="女" />女
								<!--<label for="sex" class="error"></label>-->
								<label for="sex" class="error"></label>
							</td>
						
						</tr>
						<tr>
							<td>出生日期</td>
							<td>
								<input type="text" name="birthday">

							</td>
						</tr>
						<tr>
							<td>验证码</td>
							<td>
								<input type="text" name="checkcode">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="注册" />
							</td>
						</tr>
					</table>
				</form>
			</body>


/////////////////////////////////////////////////////////////////////////////////////


/**








 */

/////////////////////////////////////////////////////////////////////////////////////


案例2-创建一个响应式的页面
需求:
	创建一套页面,可以根据上网设备的不同自动调节显示的效果.
技术分析:
	bootstrap
bootstrap:
	webcss框架,
	集合了html/css/jquery为一家
	创建响应式的页面
	响应式:适配不同的上网设备
bootstarp的入门
	1.下载bootstarp
		网站:http://www.bootcss.com/
		下载:用于生产环境的 Bootstrap
	2.导入bootstarp.css
	3.导入jquery.js
	4.导入bootstrap.js
	5.添加一个meta标签 支持移动设备
		<meta name="viewport" content="width=device-width, initial-scale=1">
	6.将所有的内容放入到布局容器中.
		Bootstrap 需要为页面内容和栅格系统包裹一个 .container 容器。我们提供了两个作此用处的类
		方式1:
			<div class="container"></div>
		方式1:
			<div class="container-fluid"></div>
注意:
	bootstrap将每一行分成12份
媒体查询:
	假如大屏幕,每行显示6个
		超大电脑,屏幕分辨率>1200		使用: col-lg-2
		
	假如屏幕小点,每行显示4个
		992<屏幕分辨率<1200			使用: col-md-3
			
	再小点,每行显示2个
		768<屏幕分辨率<992			使用: col-sm-6
	
	继续小,每行显示1个	
		屏幕分辨率<768				使用:col-xs-12

































































































































































































































































































































































































