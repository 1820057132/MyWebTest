package com.neusoft.servletTest.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xhbg on 2018/8/13.
 */
@WebServlet("/Esc")
public class EscServLet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        String userName = session.getAttribute("loginName") + "";
        session.removeAttribute(userName);
        session.removeAttribute("loginName");
        resp.getWriter().print("<h1>退出成功</h1>");
    }
}
