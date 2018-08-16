package com.neusoft.servletTest.service.user;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.util.MyError;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xhbg on 2018/8/14.
 */
public interface IUserSevice {

    UserBean login(UserBean user) throws SQLException, MyError;

    List<UserBean> getUserList();

    UserBean selectOne(UserBean userBean);

    int insertInfo(UserBean userBean);

}
