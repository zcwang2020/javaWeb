package com.javaWeb.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wzc
 * @Date 2022/6/12
 */
@WebServlet("/demo05")
public class ApplicationScope01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示application保存作用域
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name", "wang");
        // session保存作用域，重定向后，二次请求,同一会话，依然有效
        response.sendRedirect("/demo06");
//        request.getRequestDispatcher("/demo06").forward(request, response);
    }
}
