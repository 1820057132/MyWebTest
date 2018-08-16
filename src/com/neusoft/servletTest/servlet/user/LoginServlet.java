package com.neusoft.servletTest.servlet.user;


import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by xhbg on 2018/8/11.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String code2 = String.valueOf(req.getSession().getAttribute("code"));
        if (code2.equalsIgnoreCase(code)) {
            IUserSevice userService = new UserServiceImpl();
            HttpSession session = req.getSession();//获取session,位于HttpServletRequest

            String userName = req.getParameter("userName");
            String pass = req.getParameter("userPass");
            UserBean user = new UserBean();
            // user = userService.login(user);

            Object loginName = session.getAttribute("loginName");
            if ((loginName == null || "".equals(loginName)) || !loginName.equals(userName)) {
                session.setAttribute(userName, pass);//类似Map（键值对） map.put()
                session.setAttribute("loginName", userName);
                resp.sendRedirect("/user/loginSuccess.jsp");//重定向
                //req.getRequestDispatcher("/user/loginSuccess.jsp").forward(req, resp);//请求转发
            } else {
                resp.sendRedirect("/user/loginError.jsp");
                //req.getRequestDispatcher("/user/loginError.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("codeInfo","请输入正确的验证码");
            req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
        }

    }
}
