package com.neusoft.servletTest.service.user.impl;

import com.neusoft.servletTest.bean.user.UpdatePassBean;
import com.neusoft.servletTest.dao.IBaseDao;
import com.neusoft.servletTest.dao.user.PassWoedDaoImpl;
import com.neusoft.servletTest.common.IBaseService;
import com.neusoft.servletTest.util.MyError;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.neusoft.servletTest.util.MD5Util.getMD5;

/**
 * Created by xhbg on 2018/8/14.
 */
public class PassWordServiceImpl implements IBaseService<UpdatePassBean>{
   IBaseDao<UpdatePassBean> passDao = new PassWoedDaoImpl();

    @Override
    public int insertInfo(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int deleteInfo(UpdatePassBean updatePassBean) {
        return 0;
    }

    @Override
    public int updateInfo(UpdatePassBean updatePassBean) throws SQLException, MyError {
        updatePassBean.setOldPass(getMD5(updatePassBean.getOldPass()));//对老密码加密
        UpdatePassBean oldPass = passDao.selectOne(updatePassBean);//根据老密码查询是否存在用户
        if(oldPass.getId() != null && !"".equals(oldPass.getId())){
            updatePassBean.setId(oldPass.getId());
            updatePassBean.setNewPass(getMD5(updatePassBean.getNewPass()));
            int flag = passDao.updateData(updatePassBean);
            return flag;
        }
        return 0;
    }

    @Override
    public List<Map> selectAll(UpdatePassBean updatePassBean) {
        return null;
    }

    @Override
    public UpdatePassBean selectOne(UpdatePassBean updatePassBean) {
        return null;
    }
}
