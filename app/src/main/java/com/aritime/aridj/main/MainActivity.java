package com.aritime.aridj.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aritime.aridj.R;
import com.aritime.aridj.accountmanage.view.AccountManageActivity;
import com.aritime.aridj.base.BaseActivity;
import com.aritime.aridj.cardreader.CardReaderActivity;
import com.aritime.aridj.datamanage.view.DataManageActivity;
import com.aritime.aridj.dataupdate.view.DataUpdateActivity;
import com.aritime.aridj.main.adapter.MyFragmentPagerAdapter;
import com.aritime.aridj.setting.SettingActivity;
import com.aritime.aridj.spotcheck.SpotCheckActivity;
import com.jaeger.library.StatusBarUtil;

import java.lang.reflect.Field;

/**
 * Created by jiajia on 2016/10/8.
 */

public class MainActivity extends BaseActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private NavigationView mNavView;
    private ViewPager mViewPager;

    private TabLayout tabLayout;

    private int mStatusBarColor;// 状态栏颜色
    private boolean flag_drawer = false;// 抽屉打开状态标志位，true：打开，false：关闭

//    private NfcAdapter nfcAdapter = null;

//    private PendingIntent mpendingIntent;
//    private IntentFilter[] mInterFilter;
//    private String[][] mTechLists;
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            String s = (String )msg.obj;
//            Log.v("main",s);
//            Toast.makeText(MainActivity.this,s,200).show();
////            Intent intents = new Intent(MainActivity.this,LoginActivity.class);
////            startActivity(intents);
//            SignDialog msd = SignDialog.newInstance();
//            msd.show(getSupportFragmentManager(),SignDialog.class.getSimpleName());
//        }
//    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

//        nfcAdapter = nfcAdapter.getDefaultAdapter(this);
//        mpendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
//        isEnabled();


        initView();
        initEvent();


    }
//    /**
//     * 手机NFC功能是否可用
//     */
//    public void isEnabled() {
//
//        if (nfcAdapter == null) {
////            Snackbar.make(null,"该设备不支持NFC功能", Snackbar.LENGTH_SHORT).show();
//            finish();
//        } else if (!nfcAdapter.isEnabled()) {
//            //打开设置NFC开关
//            Intent setNfc = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
//            startActivity(setNfc);
//        }
//    }
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
//            byte[] myNFCId = intent.getByteArrayExtra(nfcAdapter.EXTRA_ID);
//            String m = ByteArrayToHexString(myNFCId);
//
//            Message msg = handler.obtainMessage();
//            msg.obj = m;
//            handler.sendMessage(msg);
//        }
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (nfcAdapter != null) {
//            nfcAdapter.enableForegroundDispatch(this, mpendingIntent, mInterFilter, mTechLists);
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (nfcAdapter != null)
//            nfcAdapter.disableForegroundDispatch(this);}

    private String ByteArrayToHexString(byte[] inarray) { // converts byte arrays to string
        int i, j, in;
        String[] hex = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
        };
        String out = "";

        for (j = 0; j < inarray.length; ++j) {
            in = inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
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
            case R.id.drawer_picture:
                Intent intent = new Intent(Intent.ACTION_PICK);
                startActivityForResult(intent, 0);
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
