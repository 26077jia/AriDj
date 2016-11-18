package com.aritime.aridj.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetStateReceiver extends BroadcastReceiver {
    private Context context;
    Toast mToast;

  
    @Override  
    public void onReceive(Context context, Intent intent) {
        this.context = context;  
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {  
          //  SnackUtils.showToast((View)context.getWindow().getDecorView(),"网络不可以用");
            //处理网络的全局变量
        } else {  
         //   showToast("网络可以用");
            //处理网络的全局变量

        }  
    }  
  
}