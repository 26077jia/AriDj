package com.aritime.aridj.login.contract;

/**
 * Created by jiajia on 2016/10/18.
 */

public interface LoginContract {

    interface View {
        String getAccount();

        String getPwd();

        boolean isRembPwd();

        void loginSuccess();

        void loginFailed(String msg);


    }

    interface Presenter {
        void accountLogin();

        void cardLogin();

        void noUserLogin();
    }
}
