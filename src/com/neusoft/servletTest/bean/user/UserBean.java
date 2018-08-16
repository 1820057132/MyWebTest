package com.neusoft.servletTest.bean.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/9.
 */
public class UserBean {
    private Integer id;
    private String loginName;
    private String loginPwd;
    private Integer sqlSex;
    private String sex;
    private String IDCard;
    private String phone;
    private String path;
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Integer getSqlSex() {
        return sqlSex;
    }

    public void setSqlSex(Integer sqlSex) {
        this.sqlSex = sqlSex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
