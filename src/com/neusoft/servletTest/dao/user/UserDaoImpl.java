package com.neusoft.servletTest.dao.user;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.dao.IBaseDao;
import com.neusoft.servletTest.util.MyError;
import com.neusoft.servletTest.util.c3p0.C3p0Utils;
import com.neusoft.servletTest.util.c3p0.DBUtil_BO;
import com.neusoft.servletTest.util.c3p0.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/10.
 */


public class UserDaoImpl implements IBaseDao<UserBean> {


    @Override
    public int insertData(UserBean userBean) throws MyError, SQLException {
        DBUtil_BO dbBo = new DBUtil_BO();
        dbBo.conn= C3p0Utils.getConnection();//取用一个连接
        String sql = "INSERT INTO admin(LoginName,LoginPwd) VALUES (?,?)";
        dbBo.st=dbBo.conn.prepareStatement(sql);//预处理sql语句
        dbBo.st.setString(1, userBean.getLoginName());
        dbBo.st.setString(2, userBean.getLoginPwd());
//此时dbBo对象已经封装了一个数据库连接以及要执行的操作
        DBUtils.executeUpdate(dbBo);//通过数据库操作类来执行这个操作封装类，结果封装回这个操作封装类
//手动释放连接回连接池
        DBUtils.realseSource(dbBo);
        return dbBo.rn;
    }


    @Override
    public int deleteData(UserBean userBean) {
        return 0;
    }

    @Override
    public List<Map> selectAll(UserBean userBean) throws MyError, SQLException {
        DBUtil_BO dbBo = new DBUtil_BO();
        dbBo.conn= C3p0Utils.getConnection();
        String sql = "SELECT * from admin";
        dbBo.st=dbBo.conn.prepareStatement(sql);

        DBUtils.executeQuery(dbBo);
        dbBo.rs.getMetaData();


        dbBo.rn = dbBo.rs.getMetaData().getColumnCount();

        // 因为要存储列的名字，所以要与列的个数相同
        String[] colNames = new String[dbBo.rn];

            /* 装上列的名字
             * getColumnLabel 别名
             * getColumnLabel()方法的索引是从1开始的。给最苦 写成从0开始，就抛了异常。
             */
        for (int i = 1; i <= dbBo.rn; i++) {
            colNames[i-1] = dbBo.rs.getMetaData().getColumnLabel(i);
        }

        // 这里的泛型声明也是有技巧的。
        HashMap data = null;
        List<Map> datas = new ArrayList<Map>();
        // 把查询到的结果装入datas中
        while(dbBo.rs.next()){
            data = new HashMap<String, Object>();
            for (int i = 0; i < dbBo.rn; i++) {
                //        key             value
                data.put(colNames[i], dbBo.rs.getObject(colNames[i]));
            }
            datas.add(data);
        }
        DBUtils.realseSource(dbBo);
        return datas;
    }

    @Override
    public UserBean selectOne(UserBean userBean) throws MyError, SQLException {
        DBUtil_BO dbBo = new DBUtil_BO();
        dbBo.conn= C3p0Utils.getConnection();
        String sql = "SELECT * from admin where LoginName=? and LoginPwd=?";
        dbBo.st=dbBo.conn.prepareStatement(sql);
        dbBo.st.setString(1, userBean.getLoginName());
        dbBo.st.setString(2, userBean.getLoginPwd());
        DBUtils.executeQuery(dbBo);
        Integer id = 0 ;
        if (dbBo.rs.next()) {
            id =dbBo.rs.getInt("id");
        }
        DBUtils.realseSource(dbBo);
        userBean.setId(id);
        return userBean;
    }

    @Override
    public int updateData(UserBean userBean) {
        return 0;
    }
}
