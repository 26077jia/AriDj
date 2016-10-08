package com.aritime.aridj.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aritime.aridj.R;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by jiajia on 2016/10/8.
 */

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavView;

    private int mStatusBarColor;//状态栏颜色
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_drawer);

        initView();
        initEvent();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavView= (NavigationView) findViewById(R.id.main_nav);
        setSupportActionBar(mToolbar);
        StatusBarUtil.setTranslucentForDrawerLayout(DrawerActivity.this, mDrawerLayout, 0);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mToolbar.setTitle(null);

        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(DrawerActivity.this, mDrawerLayout, mStatusBarColor, 0);
        mNavView.setItemIconTintList(null);// 设置menu图标显示原始颜色
    }

    private void initEvent() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.opendrawer,
                R.string.closedrawer);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();


    }


}
