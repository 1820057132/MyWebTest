package com.neusoft.servletTest.util.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by xhbg on 2018/8/8.
 */
public class DBUtil_BO {
    public Connection conn = null;
    public PreparedStatement st = null;
    public ResultSet rs = null;
    public Integer rn = 0;
    public DBUtil_BO() {
        super();
    }
}