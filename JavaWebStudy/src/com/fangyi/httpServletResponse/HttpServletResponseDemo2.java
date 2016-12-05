package com.fangyi.httpServletResponse;

import cn.dsna.util.images.ValidateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * 文件下载
 * 验证码
 * Created by FANGYI on 2016/12/5.
 */
public class HttpServletResponseDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        setDown(resp);


//        CAPTCHA(resp);

        //告诉客户端不使用缓存
        resp.setHeader("pragma", "no-cache");
        resp.setHeader("cache-control", "no-cache");
        resp.setIntHeader("expires", 0);

        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        String code = vc.getCode();//得到生成的字符
        System.out.println(code);
        vc.write(resp.getOutputStream());

    }

    /**
     * 验码证
     *
     * @param resp
     * @throws IOException
     */
    private void CAPTCHA(HttpServletResponse resp) throws IOException {
        int width = 200;
        int height = 50;
        //在内存中创建一个图形对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //创建一个画笔
        Graphics g = image.getGraphics();
        //图片添加背景色
        g.setColor(Color.PINK);
        g.fillRect(1, 1, width - 2, height - 2);//填充颜色
        //给边框一个颜色
        g.setColor(Color.RED);
        g.drawRect(0, 0, width - 1, height - 1);//设置边框的显示坐标
        //设置文本样式
        g.setFont(new Font("黑体", Font.BOLD | Font.ITALIC, 30));
        //给图片添加文本
        Random rand = new Random();
        int position = 40;
        for (int i = 0; i < 4; i++) {
            g.drawString(rand.nextInt(10) + "", position, 40);//给图片填充文本
            position += 40;
        }

        //添加9条干扰线
        for (int i = 0; i < 9; i++) {
            g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
        }

        //将图片对象以刘的形式输出到客户端
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }


    /**
     * 文件下载
     *
     * @param resp
     * @throws IOException
     */
    private void setDown(HttpServletResponse resp) throws IOException {
        //通过路径得到一个输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/123.jpg");
        FileInputStream fis = new FileInputStream(path);
        //创建字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        //得到文件名
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        //设置文件名的编码
        filename = URLEncoder.encode(filename, "UTF-8");//将不安全的文件名改为UTF-8格式
        //告知客户端要下载文件
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        resp.setHeader("content-type", "image/jpeg");


        //执行输出操作
        int len = 1;
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            sos.write(b, 0, len);
        }

        sos.close();
        fis.close();

        sos.close();
        fis.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("*************ServletDemo4 doPost**************");
    }
}
