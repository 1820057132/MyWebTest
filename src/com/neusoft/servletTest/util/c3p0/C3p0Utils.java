package com.neusoft.servletTest.util.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.neusoft.servletTest.util.MyError;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xhbg on 2018/8/8.
 */
public class C3p0Utils {

    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection() throws MyError {
        try {
            return dataSource.getConnection();

        } catch (Exception e) {
            throw new MyError("数据库连接出错!", e);
        }
    }
    //释放连接回连接池
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) throws MyError {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new MyError("数据库连接关闭出错!", e);
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                throw new MyError("数据库连接关闭出错!", e);
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new MyError("数据库连接关闭出错!", e);
            }
        }
    }
}

