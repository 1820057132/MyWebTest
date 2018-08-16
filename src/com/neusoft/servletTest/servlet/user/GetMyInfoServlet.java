package com.neusoft.servletTest.servlet.user;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xhbg on 2018/8/15.
 */
@WebServlet("/needLogin/myInfo")
public class GetMyInfoServlet extends HttpServlet {

    IUserSevice userSevice = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean = new UserBean();
        //获取用户id传入 对象
        userBean = userSevice.selectOne(userBean);
        req.setAttribute("IDCard",userBean.getIDCard());
        req.setAttribute("name",userBean.getLoginName());
        req.setAttribute("phone",userBean.getPhone());
        req.setAttribute("sex",userBean.getSex());
        req.setAttribute("nickName","hello servlet");
        req.getRequestDispatcher("/user/myInfo.jsp").forward(req, resp);


    }
}
