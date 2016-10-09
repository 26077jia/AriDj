package com.aritime.aridj.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.aritime.aridj.R;
import com.aritime.aridj.base.BaseActivity;
import com.jaeger.library.StatusBarUtil;

/**
 * Created by jiajia on 2016/10/8.
 */

public class MainActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavView;

    private int mStatusBarColor;//状态栏颜色

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initView();
        initEvent();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavView = (NavigationView) findViewById(R.id.main_nav);

        /* 设置toolbar不显示标题、显示背景色及logo */
        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setLogo(R.mipmap.mainlogo);

        //设置状态栏样式
        setStatusBar();

        // 设置menu图标显示原始颜色
        mNavView.setItemIconTintList(null);
    }

    private void initEvent() {

        /* 打开关闭侧滑菜单事件监听，及状态同步 */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.opendrawer,
                R.string.closedrawer);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();


    }

    protected void setStatusBar() {

        /* 设置DrawerLayout沉浸式菜单栏样式 */
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout, mStatusBarColor, 0);
    }
}
