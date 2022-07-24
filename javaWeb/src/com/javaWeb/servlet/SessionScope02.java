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
@WebServlet("/demo04")
public class SessionScope02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request.getSession().getAttribute(\"name\") = " + request.getSession().getAttribute("name"));
    }
}
