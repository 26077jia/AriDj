package com.aritime.aridj.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aritime.aridj.R;
import com.aritime.aridj.base.BaseActivity;
import com.aritime.aridj.main.DrawerActivity;
import com.aritime.aridj.main.MainActivity;

/**
 * Created by jiajia on 2016/10/8.
 */

public class LoginActivity extends BaseActivity{
    private Button btn_login;
    private LinearLayout ll_card_login, ll_nocheck_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.act_login);

        initView();
        initEvent();
    }

    private void initView() {
        btn_login = (Button) findViewById(R.id.btn_login);
        ll_card_login = (LinearLayout) findViewById(R.id.ll_card_login);
        ll_nocheck_login = (LinearLayout) findViewById(R.id.ll_nocheck_login);
    }

    private void initEvent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accoutLogin();
            }
        });
        ll_card_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardLogin();

            }
        });
        ll_nocheck_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nocheckLogin();
            }
        });
        
    }
    public void accoutLogin() {
        //TODO 账号密码登录
        loginSucess();
    }

    public void cardLogin() {
        //TODO 刷卡登录


    }

    public void nocheckLogin() {
        //TODO 无验证直接登录
        loginSucess();
    }
    /*登录验证成功或无需验证直接登录*/
    public void loginSucess(){
        Intent intent = new Intent(LoginActivity.this,DrawerActivity.class);
        startActivity(intent);
    }
}
