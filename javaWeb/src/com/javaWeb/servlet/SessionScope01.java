package com.javaWeb.servlet;

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
@WebServlet("/demo03")
public class SessionScope01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示session保存作用域
        request.getSession().setAttribute("name", "wang");
        // session保存作用域，重定向后，二次请求,同一会话，依然有效
//        response.sendRedirect("/demo04");
        request.getRequestDispatcher("/demo04").forward(request, response);
    }
}
