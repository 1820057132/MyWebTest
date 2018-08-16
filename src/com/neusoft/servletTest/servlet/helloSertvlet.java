package com.neusoft.servletTest.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xhbg on 2018/8/9.
 */

public class helloSertvlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<html><header><title>Include Test</title></header>");
        out.println("<body>");

        ServletContext context = getServletContext();
        RequestDispatcher headDispatcher = context.getRequestDispatcher("/head.jsp");
        RequestDispatcher bodyDispatcher = context.getRequestDispatcher("/index.jsp");
        RequestDispatcher footDispatcher = context.getRequestDispatcher("/foot.jsp");

        headDispatcher.include(req, resp);
        bodyDispatcher.include(req, resp);
        footDispatcher.include(req, resp);

        out.println("</body></html>");

        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
