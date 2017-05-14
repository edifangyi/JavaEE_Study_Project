案例1-记录用户上次访问时间
需求:
	当用户第一次登录的时候,提示:你是第一次访问,且记录该次访问时间,
	下一次访问的时候,获取上一次访问时间且展示出来
技术分析:
	会话技术
	cookie
	jsp
//////////////////////////////////
jsp:
	java server pages(java服务器页面)
	本质上jsp就是一个servlet,在html代码中嵌套java代码,
	运行在服务器端,处理请求,生成动态的内容.
	对应的java和class文件在tomcat目录下的work目录
	后缀名 .jsp
	
	执行流程:
		1.浏览器发送请求,访问jsp页面
		2.服务器接受请求,jspSerlvet会帮我们查找对应的jsp文件
		3.服务器将jsp页面翻译成java文件.
		4.jvm会将java编译成.class文件
		5.服务器运行class文件,生成动态的内容.
		6.将内容发送给服务器,
		7.服务器组成响应信息,发送给浏览器
		8.浏览器接受数据,解析展示
	
	jsp的脚本:	
		<%...%> java程序片段
			生成成jsp的service方法中
		<%=...%> 输出表达式
			生成成jsp的service方法中,相当于在java中调用out.print(..)
		<%!...%> 声明成员
			成员位置.
/**
 
 */


会话技术
	当用户打开浏览器的时候,访问不同的资源,知道用户将浏览器关闭,可以认为这是一次会话.		
	作用:
		因为http协议是一个无状态的协议,它记录不论上次访问的内容.用户在访问过程中难免会产生一些数据,
		通过会话技术就可以将起保存起来.
	例如:
		用户登录
		验证码
		购物车
		访问记录
		.....
分类:
	cookie:浏览器端会话技术
	session:服务器端会话技术
//////////////////////////
cookie:
	小饼干 小甜点
	cookie是由服务器生成,通过response将cookie写回浏览器(set-cookie),保留在浏览器上,
	下一次访问,浏览器根据一定的规则携带不同的cookie(通过request的头 cookie),我们服务器就可以接受cookie
	cookie的api:
		new Cookie(String key,String value)
	写回浏览器:
		response.addCookie(Cookie c)
	获取cookie:
		Cookie[] request.getCookies()
	cookie的常用方法:
		getName():获取cookie的key(名称)
		getValue:获取指定cookie的值



/**
 * 记录上次访问时间
 */
public class RemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		//1.获取指定名称的cookie
		Cookie c=getCookieByName("lastTime",request.getCookies());
		
		//2.判断cookie是否为空
		if(c == null){
			//cookie为空 提示 第一次访问
			w.print("您是第一次访问!");
		}else{
			//cookie不为空  获取value 展示 上一次访问的时间
			String value = c.getValue();// lastTime=12312324234
			long time = Long.parseLong(value);
			Date date = new Date(time);
			w.print("您上次访问时间:"+date.toLocaleString());
		}
		
		//3.将当前访问时间记录
		//3.1创建cookie
		c=new Cookie("lastTime",new Date().getTime()+"");
		
		//持久化cookie
		c.setMaxAge(3600);
		//设置路径
		c.setPath(request.getContextPath()+"/");//  /day11/
		
		//3.2写回浏览器
		response.addCookie(c);
	}

	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * @param name cookie名称
	 * @param cookies  cookie数组
	 * @return
	 */
	private Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies!=null){
			for (Cookie c : cookies) {
				//通过名称获取
				if(name.equals(c.getName())){
					//返回
					return c;
				}
			}
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



/**
 
 */


案例1-步骤分析:
	1.创建一个serlvet RemServlet 路径:/rem
	2.在servlet中:
		获取指定cookie 例如:名称为 lastTime
			request.getCookies()
		判断cookie是否为空
			若为空:提示信息 第一次访问
			若不为空:
				获取此cookie的value
				展示信息:你上次访问时间是....
		
		将这次访问时间记录,写会浏览器
////////////////////////
cookie-总结:
	常用方法:
		setMaxAge(int 秒):设置cookie在浏览器端存活时间  以秒为单位
			若设置成 0:删除该cookie(前提必须路径一致)
		setPath(String path):设置cookie的路径.
			当我们访问的路径中包含此cookie的path,则携带
			默认路径: 
				访问serlvet的路径,从"/项目名称"开始,到最后一个"/"结束
				例如:
					访问的serlvet路径:
						/day11/a/b/hello
					默认路径为:
						/day11/a/b
			手动设置路径:以"/项目名"开始,以"/"结尾;


/**
 
 */

	
案例2:记录用户浏览历史
需求:
	当用户访问一个商品的时候,需要将该商品保留在浏览记录中
技术分析:
	cookie
步骤分析:
	1.先将product_list.htm转成jsp
	2.点击一个商品,展示该商品的信息,将该商品id记录到cookie  (GetProductById)
		获取之前的浏览记录 例如名称:ids
		判断cookie是否为空
			若为空 将当前商品的id起个名称 ids 放入cookie中  ids=1
			若不为空,获取值 例如:ids=2-1  当前访问的id=1  使用"-"分割商品id
				判断之前记录中有无该商品
					若有:
						将当前的id放入前面  结果 ids=1-2
					若没有:
						继续判断长度是否>=3
							若>=3,移除最后一个,将当前的id放入最前面
							若<3,直接将当前的id放入最前面.
			
			若 ids=3-2-1 现在访问1 结果 ids=1-3-2
			若 ids=4-3-2 现在访问1 结果 ids=1-4-3

	3.再次回到product_list.jsp页面,需要将之前访问商品展示在浏览记录中
		获取ids  例如:ids=2-3-1
		切割


		//0.设置编码
		//0.1获取当前访问的商品id
		String id=request.getParameter("id");
		
		//1.获取指定的cookie ids
		Cookie c = CookUtils.getCookieByName("ids", request.getCookies());
		
		String ids="";
		//2.判断cookie是否为空
		if(c==null){
			//若cookie为空  需要将当前商品id放入ids中
			ids=id;
		}else{
			//若cookie不为空 继续判断ids中是否已经该id // ids=2-11-21
			//获取值
			ids=c.getValue();
			String[] arr = ids.split("-");
			//将数组转成集合  此list长度不可变
			List<String> asList = Arrays.asList(arr);
			//将aslist放入一个新list中
			LinkedList<String> list = new LinkedList<>(asList);
			
			if(list.contains(id)){
				//若ids中包含id  将id移除 放到最前面
				list.remove(id);
				list.addFirst(id);
			}else{
				//若ids中不包含id  继续判断长度是否大于2
				if(list.size()>2){
					//长度>=3 移除最后一个 将当前的放入最前面
					list.removeLast();
					list.addFirst(id);
				}else{
					//长度<3 将当前放入最前面
					list.addFirst(id);
				}
			}
			
			ids="";
			//将list转成字符串
			for (String s : list) {
				ids+=(s+"-");
			}
			ids=ids.substring(0, ids.length()-1);
		}
		
		//将ids写回去
		c=new  Cookie("ids",ids);
		//设置访问路径
		c.setPath(request.getContextPath()+"/");
		//设置存活时间
		c.setMaxAge(3600);
		
		//写会浏览器
		response.addCookie(c);
		
		
		//3.跳转到指定的商品页面上
		response.sendRedirect(request.getContextPath()+"/product_info"+id+".htm");

/**
 
 */


扩展:删除浏览记录
技术分析:
	cookie.setMaxAge(0)
步骤分析:
	1.在浏览器记录中添加一个超链接 
		<a href="/day1101/clearHistroy">清空</a>
	2.创建servlet clearHistroy
		创建一个cookie 
			名称路径保持一致
			setMaxAge(0)
		写回浏览器
	3.页面跳转
		重定向 product_list.jsp
		
/////////////
注意:
	cookie不能跨浏览器
	cookie中不支持中文

/**
 
 */
案例3-添加到购物车
需求:
	在商品详情页面有一个添加到购物车,点击则将该商品添加到购物车,点击购物车连接将里面的所有商品展示出来
技术分析:
	session
//////////////
session:
	服务器端会话技术.
	当我们第一次访问的服务器的时候,服务器获取id,
		能获取id
			要拿着这个id去服务器中查找有无此session
				若查找到了:直接拿过来时候,将数据保存,需要将当前sessin的id返回给浏览器
				若查找不到:创建一个session,将你的数据保存到这个session中,将当前session的id返回给浏览器
		不能获取id
			创建一个session,将你的数据保存到这个session中,将当前session的id返回给浏览器
	
	获取一个session:
		HttpSession  request.getSession()
	
	域对象:
		xxxAttribute
		生命周期:
			创建:第一次调用request.getsession()创建
			销毁:
				服务器非正常关闭
				session超时
					默认时间超时:30分钟  web.xml有配置 
					手动设置超时:setMaxInactiveInterval(int 秒) 了解
				手动干掉session
					★session.invalidate()
		存放的私有的数据.
////////////////////////////////
步骤分析:
	1.点击添加到购物车的时候,提交到一个servlet add2CartServlet
		需要将商品名称携带过去
	2.add2CartServlet中的操作
		获取商品的名称
		将商品添加到购物车 购物车的结构 Map<String 名称,Integer 购买数量>
			将购物车放入session中就可以了
		
		将商品添加到购物车分析:
			获取购物车
			判断购物车是否为空
				若为空:
					第一次添加
					创建一个购物车
					将当前商品put进去.数量:1
					将购物车放入session中
				若不为空:继续判断购物车中是否有该商品
					若有:
						取出count 将数量+1 
						将商品再次放入购物车中
					若没有:
						将当前商品put进去 数量:1
					
		提示信息:你的xx已添加到购物车中
	
	
	3.点击购物车连接的时候 cart.jsp
		从session获取购物车
			判断购物车是否为空
				若为空:提示信息
				若不为空:遍历购物车即可
			
//////////////////



/**
 
 */
案例2-扩展清空购物车:
	思路1:将购物车移除
	思路2:将session干掉
步骤分析:
	在cart.jsp上添加一个超链接 清空购物车
		<a href="/day1101/clearCart">清空购物车</a>
	在clearCart中需要调用session.invalidate()
	重定向到购物车页面
	
