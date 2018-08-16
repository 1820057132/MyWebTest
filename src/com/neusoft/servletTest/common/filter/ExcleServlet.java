package com.neusoft.servletTest.common.filter;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.service.user.impl.UserServiceImpl;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by xhbg on 2018/8/16.
 */
@WebServlet("/exportExcelServlet")
public class ExcleServlet extends HttpServlet {

    IUserSevice userSevice = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取出数据
        List<UserBean> users = userSevice.getUserList();
        try {
            getExcle(users, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getExcle(List<UserBean> list, HttpServletResponse resp) throws Exception {
        WritableSheet wsheet = null;//定义一个 空表
        //生成excle
        resp.setContentType("application/ms-excel");
        String sheetName = "用户信息列表";//文件夹名
        sheetName = new String(sheetName.getBytes(), "iso8859-1");//修改编码；
        resp.addHeader("Content-Disposition", "attachment;Filename=" + sheetName + ".xls");
        //开启前一个输出流
        OutputStream out = resp.getOutputStream();
        WritableWorkbook wwb = Workbook.createWorkbook(out);
        //创建一个sheet
        wsheet = wwb.createSheet("用户信息", 0);
        wwb.setProtected(false);
        //设置一个title

        String[] title = {"登录名", "名字", "性别", "手机", "身份证号"};
        Label label;//表示一个单元
        for (int i = 0; i < title.length; i++) {//为表格设置头部
            label = new Label(i, 0, title[i]);
            wsheet.addCell(label);
        }
        int t = 1;
        for (UserBean user : list) {//向表格加入数据
            wsheet.addCell(new Label(0, t, user.getLoginName()));
            wsheet.addCell(new Label(1, t, user.getNickName()));
            wsheet.addCell(new Label(2, t, user.getSex()));
            wsheet.addCell(new Label(3, t, user.getPhone()));
            wsheet.addCell(new Label(4, t, user.getIDCard()));
            t++;
        }

        wwb.write();
        wwb.close();


    }


}
