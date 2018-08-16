package com.neusoft.servletTest.servlet.user;

import com.neusoft.servletTest.bean.user.UpdatePassBean;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.service.user.impl.PassWordServiceImpl;
import com.neusoft.servletTest.util.MyError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by xhbg on 2018/8/14.
 */
@WebServlet("/updatePass")
public class UpdatePassServlet extends HttpServlet {

    IBaseService passService = new PassWordServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = String.valueOf(req.getSession().getAttribute("code"));
        String codeU = req.getParameter("code");
        if (code.equalsIgnoreCase(codeU)) {
            UpdatePassBean user = new UpdatePassBean();
            user.setUserName(req.getParameter("userName"));
            user.setOldPass(req.getParameter("oldPass"));
            user.setNewPass(req.getParameter("newPass"));
            int flag = 0;
            try {
                flag = passService.updateInfo(user);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (MyError myError) {
                myError.printStackTrace();
            }

            if (flag == 1) {
                resp.getWriter().print("<h1>成功</h1>");
            }
        } else {
            resp.getWriter().print("<script type=\"text/javascript\">\n" +
                    "    alert(\"验证码错误\")\n" +
                    "</script>");
        }
    }
}
