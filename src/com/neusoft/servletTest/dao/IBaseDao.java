package com.neusoft.servletTest.dao;

import com.neusoft.servletTest.util.MyError;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/10.
 */
public interface IBaseDao<T> {
    //针对数据库
    //增
    int insertData(T t) throws MyError, SQLException;
    //删
    int deleteData(T t);
    //查
    //select(all)
    List<Map> selectAll(T t) throws MyError, SQLException;

    //select(One)
    T selectOne(T t) throws MyError, SQLException;
    //改
    int updateData(T t);

}
