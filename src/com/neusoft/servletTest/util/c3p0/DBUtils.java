package com.neusoft.servletTest.util.c3p0;

import com.neusoft.servletTest.util.MyError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xhbg on 2018/8/8.
 */
public class DBUtils {


    private static void realseSource(Connection _conn, PreparedStatement _st, ResultSet _rs) throws MyError {
        C3p0Utils.close(_conn,_st,_rs);
    }

    public static void realseSource(DBUtil_BO _vo) throws MyError {
        if(_vo!=null){
            realseSource(_vo.conn, _vo.st, _vo.rs);
        }
    }

    //注意：查询操作完成后，因为还需提取结果集中信息，所以仍保持连接，在结果集使用完后才通过DBUtils.realseSource()手动释放连接
    public static void executeQuery(DBUtil_BO vo) throws MyError {
        try{
            vo.rs = vo.st.executeQuery();
        }catch (SQLException e){
            realseSource(vo);
            throw new MyError("err.user.dao.jdbc",e);
        }
    }

    //而update操作完成后就可以直接释放连接了，所以在方法末尾直接调用了realseSourse()
    public static  void executeUpdate(DBUtil_BO vo) throws MyError {

        Connection conn = vo.conn;
        PreparedStatement st = vo.st;
        try {
            vo.rn = st.executeUpdate();
        } catch (SQLException e) {
            realseSource(conn, st, null);
            throw new MyError("err.user.dao.jdbc",e);
        }
        realseSource(conn, st,null );

    }
}
