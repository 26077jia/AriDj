package com.aritime.aridj.main;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.aritime.aridj.R;
import com.aritime.aridj.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Toolbar toolbar;
    private DrawerLayout dl_main;
    private NavigationView nav_main;
    private ActionBarDrawerToggle drawerToggle;// 标题栏菜单抽屉开关

    private boolean flag = false;// 抽屉是否打开标志位，默认false，抽屉关闭

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initWindow();
        initView();
        initEvent();
        
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        dl_main = (DrawerLayout) findViewById(R.id.dl_main);


        //TODO 设置toolbar logo 图标
        // toolbar.setNavigationIcon(R.mipmap.icon_nav);
        toolbar.setLogo(R.mipmap.mainlogo);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
       /* getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);*/
        toolbar.setNavigationIcon(R.mipmap.icon_nav);

        /* API19 状态栏遮罩toolbar */
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            toolbar.setPadding(0,24,0,0);
        }
    }

    private void initEvent() {
        drawerToggle = new ActionBarDrawerToggle(this, dl_main, toolbar, R.string.opendrawer, R.string.closedrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                //TODO 抽屉打开时事件处理

                flag = true;
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //TODO 抽屉关闭时事件处理
                flag = false;
            }
        };
        drawerToggle.syncState();
        dl_main.addDrawerListener(drawerToggle);
        dl_main.setFocusableInTouchMode(true);

        if (nav_main != null) {
            nav_main.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    //TODO 切换到相应的Fragment

                    dl_main.closeDrawers();
                    return false;
                }
            });
        }

    }
    /**
     * 模拟返回键关闭侧栏菜单
     * */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (flag) {
            dl_main.closeDrawers();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
