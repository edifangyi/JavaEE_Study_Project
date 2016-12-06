package com.fangyi.session;


import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by FANGYI on 2016/12/6.
 */
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        //向session中保存验证码
        request.getSession().setAttribute("scode", vc.getCode());
        vc.write(response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=============================");

        doPost(request,response);
    }
}
