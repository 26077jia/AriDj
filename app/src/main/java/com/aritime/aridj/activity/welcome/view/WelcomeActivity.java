package com.aritime.aridj.activity.welcome.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aritime.aridj.R;
import com.aritime.aridj.activity.login.view.LoginActivity;
import com.aritime.aridj.activity.main.MainActivity;
import com.aritime.aridj.activity.welcome.contract.WelcomeContract;
import com.aritime.aridj.activity.welcome.presenter.WelcomePresenter;

/**
 * Created by jiajia on 2016/11/17.
 */

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {

    private WelcomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new WelcomePresenter(this);
        init();
//        tv_show = (TextView) findViewById(R.id.tv_welcome_show);
//        tv_show.setText("内存总空间"+ StorageUtils.getMemoryInfo(Environment.getDataDirectory())+"  "+"剩余空间："+StorageUtils.getMemoryFree(Environment.getDataDirectory()));
    }

    @Override
    public Context getMyContext() {
        return getBaseContext();
    }

    /**
     * 判断是否是首次启动应用，加载欢迎页
     * 并根据有无用户信息，跳转至登录界面或直接进入首页
     */
    private void init() {

        if (mPresenter.firstLaunchVerify()) {
            // 首次启动，显示欢迎页
            setContentView(R.layout.act_welcome);
        }
        if (mPresenter.userVerify()) {
            // 缓存用户信息验证成功，进入主界面
            Intent intentLogin = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intentLogin);

        } else {
            // 缓存用户信息验证成功，进入登录界面
            Intent intentLogin = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intentLogin);
        }
    }
}




