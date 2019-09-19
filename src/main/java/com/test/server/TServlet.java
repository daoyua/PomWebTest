package com.test.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TServlet",urlPatterns = "/t")
public class TServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name1 = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("POST请求成功了"+name1+age);
//        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html ; charset =UTF-8");

        String name1 = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("get请求成功了"+name1+age);
    }
}
