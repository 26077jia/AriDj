package com.aritime.aridj.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aritime.aridj.R;
import com.aritime.aridj.base.BaseActivity;
import com.aritime.aridj.main.MainActivity;

/**
 * Created by jiajia on 2016/10/8.
 */

public class LoginActivity extends BaseActivity{
    private Button mbtn_login;
    private LinearLayout mll_card_login, mll_nocheck_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        initView();
        initEvent();
    }

    private void initView() {
        mbtn_login = (Button) findViewById(R.id.btn_login);
        mll_card_login = (LinearLayout) findViewById(R.id.ll_card_login);
        mll_nocheck_login = (LinearLayout) findViewById(R.id.ll_no_user_login);
    }

    private void initEvent() {
        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accoutLogin();
            }
        });
        mll_card_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardLogin();

            }
        });
        mll_nocheck_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noCheckLogin();
            }
        });
        
    }
    public void accoutLogin() {
        //TODO 账号密码登录
        loginSuccess();
    }

    public void cardLogin() {
        //TODO 刷卡登录

    }

    public void noCheckLogin() {
        //TODO 无验证直接登录
        loginSuccess();
    }
    /*登录验证成功或无需验证直接登录*/
    public void loginSuccess(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
