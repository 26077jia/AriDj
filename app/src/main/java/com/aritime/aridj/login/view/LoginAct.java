package com.aritime.aridj.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.aritime.aridj.R;
import com.aritime.aridj.login.contract.LoginContract;
import com.aritime.aridj.login.presenter.LoginPresenter;
import com.aritime.aridj.main.MainActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by jiajia on 2016/10/18.
 */

public class LoginAct extends AppCompatActivity implements View.OnClickListener, LoginContract.View {
    private static final String TAG = "MainActivity";

    private MaterialEditText et_user_account, et_user_pwd;//账号与密码
    private CheckBox chk_remb_pwd;
    private Button mbtn_login;
    private LinearLayout mll_card_login, mll_nocheck_login;//刷卡登录、无账号登录

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        initView();
    }

    public void initView() {
        //控件初始化
        et_user_account = (MaterialEditText) findViewById(R.id.et_user_account);
        et_user_pwd = (MaterialEditText) findViewById(R.id.et_user_pwd);
        chk_remb_pwd = (CheckBox) findViewById(R.id.chk_remb_pwd);
        mbtn_login = (Button) findViewById(R.id.btn_login);
        mll_card_login = (LinearLayout) findViewById(R.id.ll_card_login);
        mll_nocheck_login = (LinearLayout) findViewById(R.id.ll_no_user_login);

        mLoginPresenter = new LoginPresenter(this);
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
        Intent intent = new Intent(LoginAct.this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * 登录失败
     */
    @Override
    public void loginFailed(String msg) {
        Log.d(TAG, msg);

    }


}
