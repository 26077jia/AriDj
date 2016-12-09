package com.aritime.aridj.bean;

/**
 * Created by jiajia on 2016/11/21.
 */

public class User {

    public boolean isLogin = false;// 默认非登录状态
    public String userName;
    public String userId;
    public String userPwd;
    public String token;
    public boolean isRember = false;// 默认不记住密码

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isRember() {
        return isRember;
    }

    public void setRember(boolean rember) {
        isRember = rember;
    }
}
