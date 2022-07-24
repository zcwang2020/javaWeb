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
import java.io.IOException;
import java.sql.Connection;

//@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private final FruitDao fruitDAO = new FruitDaoImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getDruidConnection();
            String idStr = request.getParameter("id");
            if (StringUtils.isNotBlank(idStr)) {
                Long id = Long.parseLong(idStr);
                Fruit fruit = new Fruit();
                fruit.setId(id);
                fruitDAO.deleteFruit(fruit);

                //super.processTemplate("index",request,response);
                response.sendRedirect("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, null, null);
        }
    }
}
