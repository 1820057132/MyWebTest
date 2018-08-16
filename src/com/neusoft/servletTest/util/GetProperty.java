package com.neusoft.servletTest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by xhbg on 2018/8/8.
 */
public class GetProperty {
    public static final String JDBCuser;
    public static final String JDBCurl;
    public static final String JDBCpassWord;
    static {
        Properties pro = new Properties();

        InputStream in = GetProperty.class.getResourceAsStream("/properties");

        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBCuser = pro.getProperty("JDBCuser");
        JDBCurl = pro.getProperty("JDBCurl");
        JDBCpassWord = pro.getProperty("JDBCpassWord");
    }

}
