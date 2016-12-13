package com.aritime.aridj.base;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.WindowManager;

import com.aritime.aridj.receiver.NetworkConnectChangedReceiver;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class BaseApp extends Application {

    private static AlertDialog mAlertDialog;
    private static AlertDialog mWifiDialog;

    private NetworkConnectChangedReceiver mNetworkConnectChangedReceiver;

    public boolean isConnected;// 是否连接
    public boolean isMobile;// 是否是移动网络
    public boolean isWifi;// 是否是WiFi网络
    public boolean isEnableWifi;// WiFi开关是否打开
    public boolean isEnableMobile;//移动网络数据是否打开

    @Override
    public void onCreate() {
        super.onCreate();
        initReceiver();
    }

    private void initReceiver() {

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        mNetworkConnectChangedReceiver = new NetworkConnectChangedReceiver();

        registerReceiver(mNetworkConnectChangedReceiver, filter);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 显示wifi设置提示对话框
     *
     * @param context
     */
    public static void showWifiDlg(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());
        if (mWifiDialog == null) {
            mWifiDialog = builder
                    // .setIcon(R.drawable.ic_launcher)//设置图标
                    .setTitle("wifi设置")
                    .setMessage("当前无网络")
                    .setPositiveButton("设置", new DialogInterface
                            .OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 跳转到系统的网络设置界面
                            Intent intent = null;
                            // 先判断当前系统版本
                            if (android.os.Build.VERSION.SDK_INT > 10) {//3.0以上
                                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                            } else {
                                intent = new Intent();
                                intent.setClassName("com.android.settings", Settings.ACTION_WIFI_SETTINGS);
                            }
                            if ((context instanceof Application)) {
                                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                            }
                            context.startActivity(intent);

                        }
                    }).setNegativeButton("知道了", null).create();
            // 设置为系统的Dialog，这样使用Application的时候不会 报错
            mWifiDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        }
        mWifiDialog.show();


    }

    /**
     * 当判断当前手机没有网络时选择是否打开网络设置
     *
     * @param context
     */
    public static void showNoNetWorkDlg(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());
        if (mAlertDialog == null) {
            mAlertDialog = builder
                    //.setIcon(R.drawable.ic_launcher)
                    .setTitle("网络设置")
                    .setMessage("当前无网络").setPositiveButton("设置", new DialogInterface
                            .OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = null;// 跳转到系统的网络设置界面
                            // 先判断当前系统版本
                            if (android.os.Build.VERSION.SDK_INT > 10) {// 3.0以上
                                intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                            } else {
                                intent = new Intent();
                                intent.setClassName("com.android.settings", Settings.ACTION_WIRELESS_SETTINGS);
                            }
                            if ((context instanceof Application)) {
                                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                            }
                            context.startActivity(intent);

                        }
                    }).setNegativeButton("知道了", null).create();
            // 设置为系统的Dialog，这样使用Application的时候不会 报错
            mAlertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        }
        mAlertDialog.show();


    }

    public boolean isConnected() {
        return isWifi || isMobile;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean isWifi() {
        return isWifi;
    }

    public void setWifi(boolean wifi) {
        isWifi = wifi;
    }

    public boolean isEnableWifi() {
        return isEnableWifi;
    }

    public void setEnableWifi(boolean enableWifi) {
        isEnableWifi = enableWifi;
    }

    public boolean isEnableMobile() {
        return isEnableMobile;
    }

    public void setEnableMobile(boolean enableMobile) {
        isEnableMobile = enableMobile;
    }
}
