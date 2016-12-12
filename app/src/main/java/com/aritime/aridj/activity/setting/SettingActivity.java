package com.aritime.aridj.activity.setting;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aritime.aridj.R;
import com.aritime.aridj.utils.StorageUtils;

/**
 * Created by jiajia on 2016/10/27.
 */

public class SettingActivity extends AppCompatActivity {
    private ImageButton imgBtn_setting_back;
    private TextView tv_all_space_numeric;
    private  TextView tv_free_space_numeric;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        initView();
        initEvent();
    }

    private void initView() {
        imgBtn_setting_back = (ImageButton) findViewById(R.id.imgBtn_setting_back);
        tv_all_space_numeric = (TextView) findViewById(R.id.tv_all_space_numeric);
        tv_free_space_numeric = (TextView)findViewById(R.id.tv_free_space_numeric);
    }

    private void initEvent() {
        imgBtn_setting_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        tv_all_space_numeric.setText(StorageUtils.getMemoryInfo(Environment.getDataDirectory()));
        tv_free_space_numeric.setText(StorageUtils.getMemoryFree(Environment.getDataDirectory()));

    }
}
