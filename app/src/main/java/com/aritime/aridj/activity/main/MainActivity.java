package com.aritime.aridj.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aritime.aridj.R;
import com.aritime.aridj.activity.accountmanage.view.AccountManageActivity;
import com.aritime.aridj.activity.cardreader.CardReaderActivity;
import com.aritime.aridj.activity.datamanage.view.DataManageActivity;
import com.aritime.aridj.activity.dataupdate.view.DataUpdateActivity;
import com.aritime.aridj.activity.main.adapter.MyFragmentPagerAdapter;
import com.aritime.aridj.activity.setting.SettingActivity;
import com.aritime.aridj.activity.spotcheck.SpotCheckActivity;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;

/**
 * Created by jiajia on 2016/10/8.
 */

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavView;
    private ViewPager mViewPager;

    private TabLayout tabLayout;

    private int mStatusBarColor;// 状态栏颜色
    private boolean flag_drawer = false;// 抽屉打开状态标志位，true：打开，false：关闭



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
        mViewPager = (ViewPager) findViewById(R.id.vp_mian);
        tabLayout = (TabLayout) findViewById(R.id.tabl_maian);

        /* 设置toolbar不显示标题、显示背景色及logo */
        setSupportActionBar(mToolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setLogo(R.mipmap.mainlogo);

        //设置状态栏样式
        setStatusBar();

        // 设置menu图标显示原始颜色
        mNavView.setItemIconTintList(null);

        //TODO 提示角标
        LinearLayout ll = (LinearLayout) mNavView.getMenu().findItem(R.id.drawer_data_manage).getActionView();
        TextView tv = (TextView) ll.findViewById(R.id.tv_tint_msg);
        tv.setText("67");


    }

    private void initEvent() {

        /* 打开关闭侧滑菜单事件监听，及状态同步 */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                flag_drawer = false;
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                flag_drawer = true;
            }

        };
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //标签页的设置
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        setIndicatorWidth();

        //菜单列表点击事件
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                return menuClick(item.getItemId());
            }
        });

        // 设置按钮点击事件
        mNavView.findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
                Intent intentSA = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intentSA);
            }
        });

        // 退出按钮点击事件
        mNavView.findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }


    /**
     * 菜单列表点击事件
     */
    public boolean menuClick(int id) {
        switch (id) {
            case R.id.drawer_data_manage:
                Intent intentDMA = new Intent(MainActivity.this, DataManageActivity.class);
                startActivity(intentDMA);
                break;
            case R.id.drawer_data_updating:
                Intent intentDUA = new Intent(MainActivity.this, DataUpdateActivity.class);
                startActivity(intentDUA);
                break;
            case R.id.drawer_data_query:
                //TODO 进入“数据查询”页面
//                Intent intent = new Intent(MainActivity.this,);
//                startActivity(intent);
                break;
            case R.id.drawer_card_reader:
                Intent intentCRA = new Intent(MainActivity.this, CardReaderActivity.class);
                startActivity(intentCRA);
                break;
            case R.id.drawer_spot_check:
                Intent intentSCA = new Intent(MainActivity.this, SpotCheckActivity.class);
                startActivity(intentSCA);
                break;
            case R.id.drawer_account_manage:
                Intent intentAMA = new Intent(MainActivity.this, AccountManageActivity.class);
                startActivity(intentAMA);
                break;
            case R.id.drawer_about:
                //TODO 进入“关于”页面
//                Intent intentAA = new Intent(MainActivity.this, AboutActivity.class);
//                startActivity(intentAA);
//                break;
        }
        mDrawerLayout.closeDrawers();
        return true;
    }

    /**
     * 自定义tab indicator的宽度
     */
    private void setIndicatorWidth() {
        Class<?> tablayout = tabLayout.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tablayout.getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tabLayout);
            int ii = ll_tab.getChildCount();
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                params.setMarginStart(170);
                params.setMarginEnd(170);
                child.setLayoutParams(params);
                child.invalidate();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置沉浸式状态栏的样式
     */
    protected void setStatusBar() {

        /* 设置DrawerLayout沉浸式菜单栏样式 */
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout, mStatusBarColor, 0);
    }

    /**
     * 模拟返回键
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        /*若侧滑菜单处于打开状态，关闭*/
        if (flag_drawer) {
            mDrawerLayout.closeDrawers();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
