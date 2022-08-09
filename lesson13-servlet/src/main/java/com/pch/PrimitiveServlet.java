package com.pch;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/") //<--- it is need start "/" value
public class PrimitiveServlet implements Servlet {

//    @Override
//    protected void doGet(HttpServletRequest req,
//                         HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Hello from service");
//        PrintWriter writer = resp.getWriter();
//        writer.println("Hello my dear friend!");
//        writer.flush();
//    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request,
                        ServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from service");
        PrintWriter writer = response.getWriter();
        writer.println("Hello my dear friend!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
