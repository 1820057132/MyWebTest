package com.neusoft.servletTest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.neusoft.servletTest.util.GetProperty.JDBCpassWord;
import static com.neusoft.servletTest.util.GetProperty.JDBCurl;
import static com.neusoft.servletTest.util.GetProperty.JDBCuser;

/**
 * Created by xhbg on 2018/8/8.
 */
public class JDBCUtil {
    private Connection conn = null;

    String url = JDBCurl;
    String user=JDBCuser;
    String password=JDBCpassWord;


    public Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
        System.out.println("成功加载MySQL驱动程序");
        // 一个Connection代表一个数据库连接
        conn= DriverManager.getConnection(url,user,password);
        return conn;
    }


    public void commint(PreparedStatement stmt) throws SQLException {
        int rs = stmt.executeUpdate();// executeQuery会返回结果的集合，否则返回空值
    }


   public void close(Connection conn) throws SQLException {
       conn.close();
   }


}
