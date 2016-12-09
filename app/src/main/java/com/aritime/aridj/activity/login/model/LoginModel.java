package com.aritime.aridj.activity.login.model;

import com.aritime.aridj.activity.login.contract.LoginContract;

/**
 * Created by jiajia on 2016/11/22.
 */

public class LoginModel implements LoginContract.Model{

    @Override
    public boolean staffVerify() {
        // TODO 用户登录验证，根据用户名，用户密码验证

        return false;
    }
}
