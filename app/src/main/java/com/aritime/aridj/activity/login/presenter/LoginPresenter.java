package com.aritime.aridj.activity.login.presenter;


import android.text.TextUtils;

import com.aritime.aridj.activity.login.contract.LoginContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

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

        if (verified()) {// 账号信息不为空
            if (LoginVerified()) {//登录验证成功
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
        //TODO 读卡获取ID
//        if (!TextUtils.isEmpty(NfcCardReader.getNfcCardId())) {
//            getInfo();
//            mView.loginSuccess();
//        } else {
//            mView.loginFailed("请刷卡！");
//        }


    }

    /**
     * 无账号直接登录
     */
    @Override
    public void noUserLogin() {
        mView.loginSuccess();
    }

    /**
     * 验证账号密码输入框是否为空
     */
    public boolean verified() {
        if (TextUtils.isEmpty(mView.getAccount()) || TextUtils.isEmpty(mView.getPwd())) {
            mView.loginFailed("账号或密码不能为空！");
            return false;
        }
        return true;
    }

    /**
     * 本地验证登录信息并过滤出路线
     */
    public boolean LoginVerified() {
        //TODO 登录本地验证

        //获取规则包文件
        try {
            InputStreamReader inputReader = new InputStreamReader(mView.getActContext().getAssets().open("rule.txt"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String result = "";
            while ((line = bufReader.readLine()) != null)
                result += line;
            //遍历查找用户所在的路线
            Gson gson = new Gson();

            String[] strings = gson.fromJson(result, String[].class);
            List<String> stringList = gson.fromJson(result, new TypeToken<List<String>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 获取该账号相应的信息
     */
    public void getInfo() {
        //TODO 解析该账号的信息
    }

}
