package test.com.fangyi;

import com.fangyi.utils.DBUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by FANGYI on 2016/12/4.
 */
public class Test {
    @org.junit.Test
    public void test() {
        Connection conn = null;
        PreparedStatement stmt = null;//SQL注入
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();//得到连接对象Connection

            //SQL注入
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            stmt = conn.prepareStatement(sql);////SQL注入
            //给？赋值
            stmt.setString(1, "fangyi");
            stmt.setString(2, "123456");

            rs = stmt.executeQuery();//执行sql语句


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs, stmt, conn);
        }

    }

    @org.junit.Test
    public void testDom4J() throws Exception {
        SAXReader reader = new SAXReader();//创建一个xml解析对象
        Document document = reader.read("src/Book.xml");//把xm文档加载到document对象
        Element root = document.getRootElement();
//        Element bookNode = root.element("书");
//        System.out.println(bookNode.getName());

        List list = root.elements();//得到当前界面的所有子节点
        Element secondBook = (Element) list.get(1);//得到第二本书对象
        String name = secondBook.element("书名").getText();//得到当前节点的文本内容
        System.out.println("---" + name);
    }

    @org.junit.Test
    public void testDom4J2() throws Exception {
        SAXReader reader = new SAXReader();//创建一个xml解析对象
        Document document = reader.read("src/Book.xml");//把xm文档加载到document对象
        Element root = document.getRootElement();
        treeWalk(root);

    }

    private void treeWalk(Element root) {
        System.out.println(root.getName());//输出当前界面的名字
        for (int i = 0; i < root.nodeCount(); i++) {
            Node node = root.node(i);//取出下标为i的节点
            if (node instanceof Element) {//判断当前节点是否为标签
                treeWalk((Element) node);
            }
        }
    }

    @org.junit.Test
    public void testDom4J3() throws Exception{
        SAXReader read = new SAXReader();
        Document document = read.read("src/Book.xml");
        Node node = document.selectSingleNode("/书架/书[2]/书名");//jaxen-1.1-beta-6.jar
        System.out.println(node.getText());
    }

    @org.junit.Test
    public void testDom4J4() throws Exception{
        SAXReader read = new SAXReader();
        Document document = read.read("src/Book.xml");
        List list = document.selectNodes("//*");
        for (int i = 0; i < list.size(); i++) {
            Node node = (Node)list.get(i);
            System.out.println(node.getName()+"\t"+node.getText());
        }
    }

}
