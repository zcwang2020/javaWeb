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
@WebServlet("/demo01")
public class RequestScope01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示request保存作用域
        request.setAttribute("name", "wang");
        // request保存作用域，重定向后，二次请求，失效
//        response.sendRedirect("/demo02");
        request.getRequestDispatcher("/demo02").forward(request, response);

    }
}
