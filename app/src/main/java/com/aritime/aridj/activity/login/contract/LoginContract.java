package com.aritime.aridj.activity.login.contract;

import android.content.Context;

/**
 * Created by jiajia on 2016/10/18.
 */

public interface LoginContract {

    interface View {
        String getAccount();

        String getPwd();

        Context getActContext();

        boolean isRembPwd();

        void loginSuccess();

        void loginFailed(String msg);


    }

    interface Presenter {
        void accountLogin();

        void cardLogin();

        void noUserLogin();
    }

    public interface Model {

        String operators();
    }

}
