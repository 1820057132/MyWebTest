package com.neusoft.servletTest;

import com.neusoft.servletTest.bean.user.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhbg on 2018/8/15.
 */
public class Main {
    public static void main(String[] args) {
        List<UserBean> list = new ArrayList<>();
        for (UserBean user : list){
            user.getSqlSex();
        }

    }

}
