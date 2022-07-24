package com.javaWeb.servlet;

import com.javaWeb.dao.FruitDao;
import com.javaWeb.dao.FruitDaoImpl;
import com.javaWeb.myspringmvc.ViewBaseServlet;
import com.javaWeb.pojo.Fruit;
import util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

//@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    private final FruitDao fruitDAO = new FruitDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FruitDao fruitDAO = new FruitDaoImpl();
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            //1.设置编码
            request.setCharacterEncoding("utf-8");

            //2.获取参数
            String idStr = request.getParameter("id");
            Long id = Long.parseLong(idStr);
            String fname = request.getParameter("fname");
            String priceStr = request.getParameter("price");
            int price = Integer.parseInt(priceStr);
            String fcountStr = request.getParameter("fcount");
            Integer fcount = Integer.parseInt(fcountStr);
            String remark = request.getParameter("remark");

            //3.执行更新
            fruitDAO.updateFruit(new Fruit(id, fname, price, fcount, remark));

            //4.资源跳转
            //super.processTemplate("index",request,response);
            //request.getRequestDispatcher("index01.html").forward(request,response);
            //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
            response.sendRedirect("index");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }
}

// java.lang.NumberFormatException: For input string: ""