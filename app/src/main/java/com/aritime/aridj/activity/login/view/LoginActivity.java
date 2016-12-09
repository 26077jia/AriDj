package com.aritime.aridj.activity.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aritime.aridj.R;
import com.aritime.aridj.activity.login.contract.LoginContract;
import com.aritime.aridj.activity.login.presenter.LoginPresenter;
import com.aritime.aridj.activity.main.MainActivity;
import com.aritime.aridj.base.BaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by jiajia on 2016/10/18.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {
    private static final String TAG = "MainActivity";

    private MaterialEditText et_user_account, et_user_pwd;//账号与密码
    private CheckBox chk_remb_pwd;
    private Button mbtn_login;
    private LinearLayout mll_card_login, mll_nocheck_login;//刷卡登录、无账号登录

    private LoginContract.Presenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        initView();
        initEvent();
    }

    public void initView() {
        //控件初始化
        et_user_account = (MaterialEditText) findViewById(R.id.et_user_account);
        et_user_pwd = (MaterialEditText) findViewById(R.id.et_user_pwd);
        chk_remb_pwd = (CheckBox) findViewById(R.id.chk_remb_pwd);
        mbtn_login = (Button) findViewById(R.id.btn_login);
        mll_card_login = (LinearLayout) findViewById(R.id.ll_card_login);
        mll_nocheck_login = (LinearLayout) findViewById(R.id.ll_no_user_login);
    }

    private void initEvent() {
        mLoginPresenter = new LoginPresenter(this);
        mbtn_login.setOnClickListener(this);
        mll_card_login.setOnClickListener(this);
        mll_nocheck_login.setOnClickListener(this);
        mll_nocheck_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mLoginPresenter.accountLogin();
                break;
            case R.id.ll_card_login:
                mLoginPresenter.cardLogin();
                break;
            case R.id.ll_no_user_login:
                mLoginPresenter.noUserLogin();
                break;
        }
    }

    /**
     * 获取用户账号
     */
    @Override
    public String getAccount() {
        return et_user_account.getText().toString();
    }

    /**
     * 获取用户密码
     */
    @Override
    public String getPwd() {
        return et_user_pwd.getText().toString();
    }

    @Override
    public Context getActContext() {
        return getBaseContext();
    }


    /**
     * 记住用户密码是否选中
     */
    @Override
    public boolean isRembPwd() {
        return chk_remb_pwd.isChecked();
    }

    /**
     * 登录成功
     */
    @Override
    public void loginSuccess() {
        Log.d(TAG, "登录成功");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();


    }

    /**
     * 登录失败
     */
    @Override
    public void loginFailed(String msg) {
        Log.v(TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void registerReceiver() {
        super.registerReceiver();

    }
}
