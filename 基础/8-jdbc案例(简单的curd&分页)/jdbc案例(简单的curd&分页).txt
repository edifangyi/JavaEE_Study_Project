回顾:
mvc
	jsp的设计模式1:
		jsp+javabean
	jsp的设计模式2:
		jsp+javabean+servlet
			jsp:展示数据
			javabean:封装数据 封装对数据的访问
			servlet:处理请求
	mvc:
		将业务逻辑 代码 显示相分离
		M:model 模型 封装数据 封装对数据的访问
		V:view 	视图 展示数据 目前由jsp担任
		C:controller 控制 处理请求
	三层架构:
		web:
			作用:
				展示数据 
				
				接受请求
				调用service
				页面的跳转,信息的生成
		service:
			作用:
				处理逻辑
				调用dao
				
		dao:
			作用:
				对数据库的curd操作
	/////////////////////////////
	反射:
		先获取class对象,无所不能
	////////////////////	
事务:
	一件完整的事情.可以包含多个操作,操作要么成功,要么全部失败
	mysql中的事务:
		默认是事务自动提交
		手动提交:
			1.关闭自动提交
			2.手动开启一个事务
				start transaction;
				commit;
				rollback;
	java中的事务:
		Connection接口的api
			setAutoCommit(false):手动的开启一个事务
			commit():提交
			rollback():回滚
	DBUitls使用事务:
		1.创建QueryRunner
			new QueryRunner():手动事务 调用他的方法的时候必须手动传入一个连接,连接得手动关闭,事务得手动控制.
			new QueryRunner(DataSource ds):自动事务 调用他的方法的时候不需要传入一个连接,连接自动关闭,事务自动控制.
		2.使用的方法 (手动事务)
			query(...)
			update(Connection conn .....)
	事务中要想保证在一个事务中,必须保证使用同一个连接
		方式1:向下传递连接
		方式2:将连接和当前线程绑定
			ThreadLocal
				常用的方法:
					set(Object value)
					Object get()
					remove()
	事务的特性:
		ACID
		原子性 一致性 隔离性 持久性
	若不考虑隔离性的时候会发生的问题
		脏读
		不可重复读
		虚读
	隔离级别:
		read uncommitted:读未提交 什么问题都避免不了
		read committed:读已提交 避免脏读
		repeatable read:可重复读 避免脏读和不可重复读
		serializable:串行化 避免所有的问题 锁表
	安全:
		serializable>repeatable read>read committed>read uncommitted
	效率
		serializable<repeatable read<read committed<read uncommitted
	
	mysql中默认隔离级别 repeatable read
	oracle中默认隔离级别 read committed
/////////////////////////////////////////////
案例1-展示所有商品
需求:
	点击首页上的超链接,在页面上展示所有的商品信息
步骤分析:
	1.数据库和表
		create database day14;
		use day14;
		create table `product` (
			`pid` varchar (96),
			`pname` varchar (150),
			`market_price` double ,
			`shop_price` double ,
			`pimage` varchar (600),
			`pdate` date ,
			`pdesc` varchar (765)
		); 
		INSERT INTO `product` VALUES('1','小米 4c 标准版','1399','1299','products/1/c_0001.jpg','2015-11-02','小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待');
		INSERT INTO `product` VALUES('10','华为 Ascend Mate7','2699','2599','products/1/c_0010.jpg','2015-11-02','华为 Ascend Mate7 月光银 移动4G手机 双卡双待双通6英寸高清大屏，纤薄机身，智能超八核，按压式指纹识别！!选择下方“移动老用户4G飞享合约”，无需换号，还有话费每月返还！');
		INSERT INTO `product`  VALUES('11','vivo X5Pro','2399','2298','products/1/c_0014.jpg','2015-11-02','移动联通双4G手机 3G运存版 极光白【购机送蓝牙耳机+蓝牙自拍杆】新升级3G运行内存·双2.5D弧面玻璃·眼球识别技术');
		INSERT INTO `product`  VALUES('12','努比亚（nubia）My 布拉格','1899','1799','products/1/c_0013.jpg','2015-11-02','努比亚（nubia）My 布拉格 银白 移动联通4G手机 双卡双待【嗨11，下单立减100】金属机身，快速充电！布拉格相机全新体验！');
		INSERT INTO `product`  VALUES('13','华为 麦芒4','2599','2499','products/1/c_0012.jpg','2015-11-02','华为 麦芒4 晨曦金 全网通版4G手机 双卡双待金属机身 2.5D弧面屏 指纹解锁 光学防抖');
		INSERT INTO `product`  VALUES('14','vivo X5M','1899','1799','products/1/c_0011.jpg','2015-11-02','vivo X5M 移动4G手机 双卡双待 香槟金【购机送蓝牙耳机+蓝牙自拍杆】5.0英寸大屏显示·八核双卡双待·Hi-Fi移动KTV');
		INSERT INTO `product`  VALUES('15','Apple iPhone 6 (A1586)','4399','4288','products/1/c_0015.jpg','2015-11-02','Apple iPhone 6 (A1586) 16GB 金色 移动联通电信4G手机长期省才是真的省！点击购机送费版，月月送话费，月月享优惠，畅享4G网络，就在联通4G！');
	2.新建一个项目
	3.导入jar包
		驱动 dbutils c3p0 jstl beanutils
	4.包结构
		utils工具类:datasourceutils
		导入c3p0配置文件
	5.新建一个首页index.jsp	
		添加一个超链接
	6.点击超链接 发送一个servlet上(FindAllServlet)
	7.FindAllServlet:
		调用service,查询所有的商品 返回值:list
		将list放入request域中,请求转发 prodouct_list.jsp
		
////////////////////////////
案例2-添加商品
需求:
	在index.jsp添加一个超链接,跳转到一个页面,用来填写商品信息,点击保存按钮,将商品保存到数据库中
步骤分析:
	1.在index.jsp添加一个超链接 
		跳转到add.jsp
	2.add.jsp放入一个表单
	3.表单提交到 AddProductServlet
		封装数据
		调用service完成保存操作
		跳转到FindAllServlet
		(请求转发和重定向)
有表单使用的时候若使用请求转发会出现重复提交
	方案1:重定向
	方案2:令牌机制
	扩展:令牌机制
		在添加页面上随机生成一个字符串,
			放入session中一份,放入表单中一份
			提交的时候在后台获取两个码
			然后移除session中码(只使用一次)
			然后判断两个码是否一致,
			若不一致就是重复提交了
		
/////////////////////////////////
案例3-修改商品信息:
需求:
	在product-list.jsp每一个商品后面都有修改操作.点击修改操作,到了一个edit.jsp(将原来的数据展示出来),最后保存就可以了
步骤分析
	先查询后修改
	查询步骤分析:
		点击修改连接的时候
			<a href="/day14/getProductById?pid=sss">修改</a>
		getProductById
			获取pid
			通过pid获取到商品 返回值product
			将product放入request域中 请求转发到edit.jsp
	//////////////
	修改步骤分析:
		edit.jsp已经将商品的所有信息展示出来
			需要将商品的id通过隐藏域放入表单中
			点击保存,跳转到editProductServlet
		editProductServlet:
			1.封装数据
			2.调用servcie完成修改更新操作
			3.页面跳转到 FindAllServlet(重定向)
		
/////////////////////////////
案例4-删除商品
需求:
	在列表页面上,点击一个商品的删除操作,弹出一个提示,点击确定的时候,商品当前商品
步骤分析:
	先给删除添加事件
		单击事件 弹出提示
			confirm()
		点击确定再去删除商品
			location.href="/day14/deleteProductById?pid=xxx" 相当于超链接
	deleteProductById
		1.获取商品id
		2.调用service完成删除操作
		3.页面重定向 FindAllServlet
////////////////////////////		
扩展:删除多个商品:
需求:
	在每个商品前面添加复选框,勾选需要删除的商品,添加一个按钮(删除选中),点击之后删除选中的商品
步骤分析:
	给每一个商品添加复选框(全选全不选),同时添加name属性 值为"pid",value为当前商品的pid
	点击删除选中,需要将勾选上的商品的id提交到后台
		request.getParameterValues("pid")
		必须把所有的商品的放入一个表单中,
			需要在按钮添加事件 
				需要先获取表单,
				调用表单的submit()
	
	delCheckedServlet
		1.获取所有要删除的商品的id      String[] ids
		2.调用servcie完成操作
		3.页面重定向 FindAllServlet
		
/////////////////////////////////////////////////
扩展:案例5-多条件查询 
需求:
	在product_list.jsp页面上添加一个表单,输入商品名称 和 关键词,点击确定,将符合条件的商品展示在当前页面上
步骤分析:
	在product_list.jsp页面上添加一个表单,添加一个查询按钮
	提交的路径 findProductByCondition
		1.获取两个条件
		2.调用service完成查询 返回值:list
		3.将list放入request域中,请求转发
	productDao
		基本sql:select * from product where 1=1
		若商品名称不为空 and pname like ...
		若商品名不为空 and pdesc like ...
		
//////////////////////////////////
案例6-分页展示商品
需求:
	将商品进行分页展示
技术分析:
	分页
///////////////////////////
分页:
	将数据按照页码划分,提高用户的体验度.
分类:
	物理分页:(开发中经常使用)
		一次只去数据库中查询当前页需要的数据.
	逻辑分页:
		一次性将所有数据查询出来,放入内存(集合),每次查询只需要去内存中截取
mysql中分页:
	limit 
	格式1:
		select ....  limit m,n;
		从索引为m条开始向后查找n条数据
		就是从第m+1条 到 第m+n条  []
	格式2:
		select .... limit n;
		等价于:select .... limit 0,n;
		
	每页显示3条数据 
		第一页 		limit 0,3
		第二页 		limit 3,3
		第三页 		limit 6,3
		第n页 		limit (n-1)*3,3
	
	扩展:
		oracle中 rownum
		sqlserver中 top
/////////////////////////////////
	每一页需要的数据有
		当前页内容	limit查询 
		当前页码    从前台传递过去
		每页显示的条数 固定
		总条数		count(*)
		总页数		总条数/每页显示的条数 Math.ceil(double)
	以后开发中一般会将这5个参数封装一个javabean(PageBean)
		private List<T> list;//当前页内容	 	查询
		private int currPage;//当前页码 	 	传递
		private int pageSize;//每页显示的条数	固定
		private int totalCount;//总条数			查询
		private int totalPage;//总页数			计算
		
/////////////////////////////////
步骤分析:
	最终结果:
		[首页][上一页][下一页][尾页]
		[首页][上一页]x x x[下一页][尾页]
		
	1.创建一个页面 product_page.jsp
		有上面的内容
		还需要有当前页的数据
	2.在首页上有一个超链接,点击超链接将第一页查询出来
		<a href="/day14/showProductsByPage?currPage=1">分页展示商品</a>
	3.showProductsByPage
		获取第几页
		调用service 完成查询操作,返回值:pagebean
		将pagebean放入request域中,请求转发product_page.jsp
		
	4.service.showProductsByPage
		返回值pagebean
		查询当前页的数据
		查询出总条数
	////////////////////////////////////
	在页面上展示
		1.展示当前也数据 
			通过<c:forEach items="${pb.list}">
		2.添加首页 上一页 ....的超链接
		3.判断是否是第一页.若是第一页 不展示首页和上一页
		4.判断是否是最后一页 若是最后一页 不展示尾页和下一页
		5.展示所有页码
			<c:forEach begin='1' end="${pb.totalPage}">
		6.判断是否是当前页
			若是当前页 不加超链接
			若不是当前页 添加超链接
			
	扩展:页面多的时候 采用前五后四的方式
		只需要控制begin和end
		begin 判断当前页-5>0?当前页-5:1
		end 判断 当前页+4>总页数?总页数:当前页+4
		
		
		
	