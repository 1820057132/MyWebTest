package com.neusoft.servletTest.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by xhbg on 2018/8/10.
 *
 * jsp 九大内置对象
 */
public class MyListener implements HttpSessionListener {

    private int sun = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sun++;
        System.out.println(sun);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
