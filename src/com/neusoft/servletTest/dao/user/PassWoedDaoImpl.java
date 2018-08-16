package com.neusoft.servletTest.dao.user;

import com.neusoft.servletTest.bean.user.UpdatePassBean;
import com.neusoft.servletTest.dao.IBaseDao;
import com.neusoft.servletTest.util.MyError;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/14.
 */
public class PassWoedDaoImpl implements IBaseDao<UpdatePassBean> {
    @Override
    public int insertData(UpdatePassBean updatePassBean) throws MyError, SQLException {
        return 0;
    }

    @Override
    public int deleteData(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public List<Map> selectAll(UpdatePassBean updatePassBean) throws MyError, SQLException {
        return null;
    }

    @Override
    public UpdatePassBean selectOne(UpdatePassBean updatePassBean) throws MyError, SQLException {
        updatePassBean.setId(1);
        return updatePassBean;
    }

    @Override
    public int updateData(UpdatePassBean updatePassBean) {
        return 1;
    }
}
