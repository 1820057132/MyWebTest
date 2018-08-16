package com.neusoft.servletTest.servlet.user;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.service.user.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.neusoft.servletTest.util.MapUtil.mapToObject;

/**
 * Created by xhbg on 2018/8/9.
 */
//String ss = "sssss"
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    IUserSevice userService =  new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean user = new UserBean();

        //user.setWeBSex(req.getParameter("sex"));

        Map param = new HashMap();
        Enumeration<String> keys = req.getParameterNames();//取出所有的key值
        while (keys.hasMoreElements()){//遍历所有的key
            String key = keys.nextElement();
            //req.getParameter("sex")
            param.put(key, req.getParameter(key));

        }
        try {
            user = (UserBean) mapToObject(param, UserBean.class);//map转换为bean对象，原理类反射

            //出参 = 方法名（入参，入参2）；

        } catch (Exception e) {
            e.printStackTrace();
        }

        Integer flg = userService.insertInfo(user);
        PrintWriter out = resp.getWriter();

        if("1".equals(flg.toString())){
            out.print("成功");
        }else{
            out.print("失败");
        }


    }

}
