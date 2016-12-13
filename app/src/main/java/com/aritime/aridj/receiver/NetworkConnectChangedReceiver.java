package com.aritime.aridj.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.aritime.aridj.MyAppContext;

import static com.aritime.aridj.service.NetworkStateService.NETWORKSTATE;
import static com.aritime.aridj.service.NetworkStateService.networkStatus;

/**
 * 网络状态改变监听广播
 * <p>
 * 监听网络状态的改变，只有在用户操作网络开关（wifi，mobile）的时候接收广播，
 * 然后再相应的界面进行相应的操作，并将状态保存在MyApplication内
 */
public class NetworkConnectChangedReceiver extends BroadcastReceiver {
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 监听wifi的打开与关闭，与wifi的连接无关
         * */
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    MyAppContext.getInstance().setEnableWifi(false);// wifi不可用
                case WifiManager.WIFI_STATE_ENABLED:
                    MyAppContext.getInstance().setEnableWifi(true);// wifi可用
                default:
                    break;
            }
        }

        /**
         *  监听wifi状态是否连接上有效的无线路由
         * */
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            Parcelable parcelable = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (null != parcelable) {
                NetworkInfo networkInfo = (NetworkInfo) parcelable;
                NetworkInfo.State state = networkInfo.getState();// 网络状态
                boolean isConnected = state == NetworkInfo.State.CONNECTED;// wifi是否成功连接
                Log.e("net", "isConnected" + isConnected);
                if (isConnected) {
                    MyAppContext.getInstance().setWifi(true);
                } else {
                    MyAppContext.getInstance().setWifi(false);
                }
            }
        }
        /**
         * 监听网络连接的设置，包括wifi、移动网络的打开和关闭
         * */
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.isConnected()) {
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        // connected to wifi
                        MyAppContext.getInstance().setMobile(false);
                        MyAppContext.getInstance().setWifi(true);
                        Log.e("net", "当前WiFi连接可用 ");
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        // connected to the mobile provider's data plan
                        MyAppContext.getInstance().setMobile(true);
                        MyAppContext.getInstance().setWifi(false);
                        Log.e("net", "当前移动网络连接可用 ");
                    }
                } else {
                    Log.e("net", "当前没有网络连接，请确保你已经打开网络 ");
                    MyAppContext.getInstance().setWifi(false);
                    MyAppContext.getInstance().setMobile(false);
                }
            } else {   // not connected to the internet
                Log.e("net", "当前没有网络连接，请确保你已经打开网络 ");
                MyAppContext.getInstance().setWifi(false);
                MyAppContext.getInstance().setMobile(false);
                Intent it = new Intent();
                it.putExtra("networkStatus", networkStatus);
                it.setAction(NETWORKSTATE);
                LocalBroadcastManager.getInstance(MyAppContext.getInstance()).sendBroadcast(intent); //发送无网络广播给注册了当前服务广播的Activity

            }
        }

//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//
//        if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {
//            //  SnackUtils.showToast((View)context.getWindow().getDecorView(),"网络不可以用");
//            //处理网络的全局变量
//        } else {
//            //   showToast("网络可以用");
//            //处理网络的全局变量
//
//        }
    }

}