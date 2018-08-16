package com.neusoft.servletTest.common;

import com.neusoft.servletTest.util.MyError;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/10.
 */
public interface IBaseService<T> {
    //针对业务
    //add
    int insertInfo(T t);

    //delete
    int deleteInfo(T t);

    //update
    int updateInfo(T t) throws SQLException, MyError;

    //select(all)
    List<Map> selectAll(T t);

    //select(One)
    T selectOne(T t);

}
