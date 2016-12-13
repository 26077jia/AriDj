package com.aritime.aridj.activity.accountmanage.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.aritime.aridj.R;

/**
 * 账号管理类
 * Created by jiajia on 2016/10/26.
 */

public class AccountManageActivity extends AppCompatActivity {
    private ImageButton imgBtn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_account);
        initView();
        initEvent();
    }

    private void initView() {
        imgBtn_back = (ImageButton) findViewById(R.id.imgBtn_account_back);
    }

    private void initEvent() {
        imgBtn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }


}
