package com.neusoft.servletTest.util;

/**
 * Created by xhbg on 2018/8/8.
 */
public class MyError extends Exception {

    public MyError(String message,Exception e) {
        super(message);
    }

}
