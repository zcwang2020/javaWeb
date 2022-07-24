package com.javaWeb.servlet;

import com.javaWeb.dao.FruitDao;
import com.javaWeb.dao.FruitDaoImpl;
import com.javaWeb.myspringmvc.ViewBaseServlet;
import com.javaWeb.pojo.Fruit;
import org.apache.commons.lang.StringUtils;
import util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
//@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        this.doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            HttpSession session = request.getSession() ;
            Integer pageNo = 1 ;

            String oper = request.getParameter("oper");
            //如果oper!=null 说明 通过表单的查询按钮点击过来的
            //如果oper是空的，说明 不是通过表单的查询按钮点击过来的

            String keyword = null ;
            if(StringUtils.isNotEmpty(oper) && "search".equals(oper)){
                //说明是点击表单查询发送过来的请求
                //此时，pageNo应该还原为1 ， keyword应该从请求参数中获取
                pageNo = 1 ;
                keyword = request.getParameter("keyword");
                if(StringUtils.isEmpty(keyword)){
                    keyword = "" ;
                }
                session.setAttribute("keyword",keyword);
            }else{
                //说明此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
                //此时keyword应该从session作用域获取
                String pageNoStr = request.getParameter("pageNo");
                if(StringUtils.isNotEmpty(pageNoStr)){
                    pageNo = Integer.parseInt(pageNoStr);
                }
                Object keywordObj = session.getAttribute("keyword");
                if(keywordObj!=null){
                    keyword = (String)keywordObj ;
                }else{
                    keyword = "" ;
                }
            }
            session.setAttribute("pageNo", pageNo);
            FruitDao fruitDAO = new FruitDaoImpl();
            List<Fruit> fruitList = fruitDAO.getFruitBykey(keyword, pageNo);
            //保存到session作用域
            session.setAttribute("fruitList", fruitList);
            connection = JDBCUtils.getDruidConnection();
            //总记录条数
            Long fruitCount = fruitDAO.getTotalByKey(keyword);
            //总页数
            long pageCount = (fruitCount + 5 - 1) / 5;
        /*
        总记录条数       总页数
        1               1
        5               1
        6               2
        10              2
        11              3
        fruitCount      (fruitCount+5-1)/5
         */
            session.setAttribute("pageCount", pageCount);
            //此处的视图名称是 index
            //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
            //逻辑视图名称 ：   index
            //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
            //所以真实的视图名称是：      /       index       .html
            super.processTemplate("index", request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }

    }
}
