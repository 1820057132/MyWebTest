package com.neusoft.servletTest.service.user.impl;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.dao.IBaseDao;
import com.neusoft.servletTest.dao.user.UserDaoImpl;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.util.MyError;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.neusoft.servletTest.util.MD5Util.getMD5;

/**
 * Created by xhbg on 2018/8/10.
 */


//实例一个对象
//调用对象的方法
public class UserServiceImpl implements IUserSevice {
    //实例对象
    private IBaseDao<UserBean> user = new UserDaoImpl();

    @Override
    public UserBean login(UserBean userBean) throws SQLException, MyError {
        UserBean data = userBean;
        data.setLoginPwd(getMD5(data.getLoginPwd()));
        data = user.selectOne(userBean);
        if (data == null) {
            data = user.selectOne(userBean);
            if (data == null) {
                return null;
            } else {
                data.setLoginPwd(getMD5(data.getLoginPwd()));
                UserBean finalData = data;
                new Thread(() -> {
                    user.updateData(finalData);
                }).start();
                return data;
            }
        } else {
            return data;
        }


    }

    @Override
    public List<UserBean> getUserList() {
        List list = new ArrayList<>();
        for (int i = 0 ;i < 19 ;i++){
            UserBean user = new UserBean();
            user.setLoginName("张"+i);
            user.setNickName("张张" + i);
            user.setSex("男");
            user.setIDCard("121313121212"+i);
            user.setPhone("897987878"+i);
         list.add(user);
        }
        return list;
    }


    @Override
    public UserBean selectOne(UserBean userBean) {
        //获取用户Id
        //调用DAO的查询
        // select u.id, u.name, u.Idcard, u.phone ……………… p.path from user u, photo p where u.photoId = p.id and u.id = ?
        String phone = "18080808000";
        userBean.setLoginPwd(null);
        userBean.setPhone(phone.substring(0,3) + "****" + phone.substring(7));
        userBean.setIDCard("*********************1234");

        userBean.setLoginName("张三");
        userBean.setSex("男");
        return userBean;
    }

    @Override
    public int insertInfo(UserBean userBean) {
        return 0;
    }
}
