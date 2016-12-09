package com.aritime.aridj.activity.welcome.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.aritime.aridj.MyAppContext;
import com.aritime.aridj.activity.welcome.contract.WelcomeContract;
import com.aritime.aridj.bean.User;

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
    public String getUserId() {
        MyAppContext myAppContext = (MyAppContext)mContext.getApplicationContext();
        User mUser = myAppContext.getUser();
        return mUser.userId;
    }

    @Override
    public boolean staffVerify() {
        //TODO 本地用户验证,根据userId来验证
        if (!TextUtils.isEmpty(getUserId())){
            //获取表，判断是否在表中
        }
        return false;
    }
}