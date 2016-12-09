package com.aritime.aridj;

import android.app.Application;

import com.aritime.aridj.bean.User;

/**
 * Created by jiajia on 2016/11/14.
 */

public class MyAppContext extends Application {
    private User mUser;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
