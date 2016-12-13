package com.aritime.aridj.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.aritime.aridj.receiver.NetworkConnectChangedReceiver;

public class NetworkStateService extends Service {

    private ConnectivityManager connectivityManager;// 系统网络连接相关的操作管理类.

    private NetworkInfo info;// 网络状态信息的实例

    /**
     * networkStatus 当前处于的网络
     * 0 ：null 
     * 1 ：2G/3G 
     * 2 ：wifi
     */
    public static int networkStatus; 

    public static final String NETWORKSTATE = "com.text.android.network.state"; // An action name
    private NetworkConnectChangedReceiver mNetReceiver = new NetworkConnectChangedReceiver();

    /**
     * 广播实例
     */
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction(); //当前接受到的广播的标识(行动/意图)
            Log.v("net",action);
            // 当当前接受到的广播的标识(意图)为网络状态的标识时做相应判断
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                // 获取网络连接管理器
                connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                // 获取当前网络状态信息
                info = connectivityManager.getActiveNetworkInfo();

                if (info != null && info.isAvailable()) {

                    //当NetworkInfo不为空且是可用的情况下，获取当前网络的Type状态
                    //根据NetworkInfo.getTypeName()判断当前网络
                    String name = info.getTypeName();
                    Log.v("net",name);
                    //更改NetworkStateService的静态变量，之后只要在Activity中进行判断就好了
                    if (name.equals("WIFI")) {
                        networkStatus = 2;
                        Toast.makeText(context, "WIFI", Toast.LENGTH_SHORT).show();
                    } else {
                        networkStatus = 1;
                        Toast.makeText(context, "mobile", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    // NetworkInfo为空或者是不可用的情况下
                    networkStatus = 0;

                    Toast.makeText(context, "没有可用网络!\n请连接网络后刷新本界面", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent();
                    it.putExtra("networkStatus", networkStatus);
                    it.setAction(NETWORKSTATE);
                    sendBroadcast(it); //发送无网络广播给注册了当前服务广播的Activity
                    /**
                     * 这里推荐使用本地广播的方式发送:
                     * LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                     */
                }
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //注册网络状态的广播，绑定到mNetReceiver
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetReceiver, mFilter);
        Log.v("netCreate","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销接收
        unregisterReceiver(mReceiver);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    /** 
     * 判断网络是否可用 
     */  
    public static boolean isNetworkAvailable(Context context) {  
        // 获取网络连接管理器
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);  

        // 获取当前网络状态信息
        NetworkInfo[] info = mgr.getAllNetworkInfo();  
        if (info != null) {  
            for (int i = 0; i < info.length; i++) {  
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {  
                    return true;  
                }  
            }  
        }

        return false;  
    }  
}