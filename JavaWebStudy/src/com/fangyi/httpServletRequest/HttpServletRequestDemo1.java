package com.fangyi.httpServletRequest;

import com.fangyi.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

/**
 * 获得请求消息头
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletRequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //告诉浏览器使用什么编码
        resp.setContentType("text/html;charset=UTF-8");




//        test1(req);
//        test2(req);
//        test3(req);
//        test4(req);

//        test5(req);
//        test6(req);
//        test7(req);
//        test8(req);
//        test9(req);
    }

    /**
     * 获取图片之类的流文件
     * @param req
     * @throws IOException
     */
    private void test9(HttpServletRequest req) throws IOException {
        ServletInputStream sis = req.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = sis.read(b)) != -1) {
            //System.out.println(new String(new String(b,0,len).getBytes(),"utf-8"));
            System.out.println(new String(b, 0, len, "UTF-8"));
        }

        sis.close();
    }

    /**
     * 使用BeanUtils
     * @param req
     */
    private void test8(HttpServletRequest req) {
        try {
            User u = new User();
            BeanUtils.populate(u, req.getParameterMap());
            System.out.println(u.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用PropertyDescriptor 和 Map
     * @param req
     */
    private void test7(HttpServletRequest req) {
        try {
            User u = new User();

            Map<String, String[]> map = req.getParameterMap();


            for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
                String name = stringEntry.getKey();
                String[] value = stringEntry.getValue();
                //创建一个属性描述器
                PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
                //得到setter属性
                Method setter = pd.getWriteMethod();
                if (value.length == 1) {
                    setter.invoke(u, value[0]);//给一个值得变量赋值
                } else {
                    setter.invoke(u, (Object) value);//相当于给复选框赋值
                }
            }

            System.out.println(u.toString());
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有表单的name名字
     *
     * @param req
     */

    private void test6(HttpServletRequest req) {
        Enumeration names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();//得到每一个name名

            String[] values = req.getParameterValues(name);
            for (String value : values) {
                System.out.println(name + "\t" + value);
            }
        }
    }

    /**
     * 与获取表单数据相关的方法
     *
     * @param req
     */
    private void test5(HttpServletRequest req) throws UnsupportedEncodingException {

        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String[] hobby = req.getParameterValues("hobby");
        String city = req.getParameter("city");

        //解决post方式编码
        req.setCharacterEncoding("UTF-8"); //告诉服务器客户端什么编码,只能处理post请求方式
        //解决get方式编码
        String name = new String(userName.getBytes("iso-8859-1"), "UTF-8");

        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);
        for (String s : hobby) {
            System.out.print(s + "  ");
        }
        System.out.println();
        System.out.println(city);
    }

    /**
     * 获得相关name的消息头
     *
     * @param req
     */
    private void test4(HttpServletRequest req) {
        Enumeration headers = req.getHeaders("accept-language");
        while (headers.hasMoreElements()) {
            String e = (String) headers.nextElement();
            System.out.println(e + ":" + req.getHeader(e));
        }
    }

    /**
     * 获取全部请求头
     *
     * @param req
     */
    private void test3(HttpServletRequest req) {
        Enumeration names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String e = (String) names.nextElement();
            System.out.println(e + ":" + req.getHeader(e));
        }
    }

    /**
     * 获得请求消息头 区分浏览器
     *
     * @param req
     */
    private void test2(HttpServletRequest req) {
        String header = req.getHeader("User-Agent");
        System.out.println(header);
        if (header.toLowerCase().contains("msie")) {
            System.out.println("IE浏览器");
        } else if (header.toLowerCase().contains("firefox")) {
            System.out.println("火狐");
        } else if (header.toLowerCase().contains("chrome")) {
            System.out.println("谷歌");
        } else {
            System.out.println("其他");
        }
    }

    private void test1(HttpServletRequest req) {
        //		getMethod(); 获得请求方式
//		getRequestURL();返回客户端发出请求时的完整URL。
//		getRequestURI(); 返回请求行中的资源名部分。
//		getContextPath(); 当前应用的虚拟目录
//		getQueryString() ; 返回请求行中的参数部分。


        System.out.println(req.getMethod());//  GET
        System.out.println(req.getRequestURL()); // http://localhost:8088/httpServletRequestDemo1
        System.out.println(req.getRequestURI()); //   /httpServletRequestDemo1
        System.out.println(req.getContextPath()); //
        System.out.println(req.getQueryString()); //  username=tom   http://localhost:8088/httpServletRequestDemo1?username=tom
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
