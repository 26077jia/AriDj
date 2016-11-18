package com.aritime.aridj.activity.welcome.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.aritime.aridj.activity.welcome.contract.WelcomeContract;

/**
 * Created by jiajia on 2016/11/17
 */

public class WelcomeModel implements WelcomeContract.Model {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;
    private  Context mContext;

   public WelcomeModel(Context context) {
       mContext = context;
    }

    @Override
    public boolean isFirstLaunch() {
        mSharedPreferences = mContext.getSharedPreferences("preference", Context.MODE_PRIVATE);
        Boolean isFirst = mSharedPreferences.getBoolean("isFirst", true);
        editor = mSharedPreferences.edit();
        editor.putBoolean("isFirst", false);
        editor.commit();
        return isFirst;//默认初始值是true，首次登录
    }

    @Override
    public String userName() {
        return mSharedPreferences.getString("userName", "");
    }

    @Override
    public String userPwd() {
        return mSharedPreferences.getString("userPwd", "");
    }
}