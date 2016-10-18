package com.aritime.aridj.login.presenter;


import android.text.TextUtils;

import com.aritime.aridj.login.contract.LoginContract;
import com.aritime.aridj.utils.NfcCardReader;

/**
 * Created by jiajia on 2016/10/18.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
    }

    /**
     * 账号登录
     */
    @Override
    public void accountLogin() {

        if (verified()) {// 账号信息b不为空
            if (httpVerified()) {//登录验证成功
                if (mView.isRembPwd()) {// 登录的账号信息是否保存
                    //TODO 保存账号信息
                }
                mView.loginSuccess();
            } else {
                mView.loginFailed("登录验证失败");
            }

        }
    }

    /**
     * 打卡登录
     */
    @Override
    public void cardLogin() {

        if (!TextUtils.isEmpty(NfcCardReader.getNfcCardId())) {
            getInfo();
            mView.loginSuccess();
        } else {
            mView.loginFailed("请刷卡！");
        }

    }

    /**
     * 无账号直接登录
     */
    @Override
    public void noUserLogin() {
        mView.loginSuccess();
    }

    /**
     * 验证账号密码是否为空
     */
    public boolean verified() {
        if (TextUtils.isEmpty(mView.getAccount()) && TextUtils.isEmpty(mView.getPwd())) {
            mView.loginFailed("账号或密码不能为空！");
            return false;
        }
        return true;
    }

    /**
     * 网路请求验证扽那个路信息
     */
    public boolean httpVerified() {
        //TODO 网路请求登录验证
        return true;
    }

    /**
     * 获取该账号相应的信息
     */
    public void getInfo() {
        //TODO 解析该账号的信息
    }

}
