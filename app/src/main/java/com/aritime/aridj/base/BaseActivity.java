package com.aritime.aridj.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aritime.aridj.receiver.NetworkConnectChangedReceiver;

public class BaseActivity extends AppCompatActivity {
    private NetworkConnectChangedReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }

    public void registerReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        myReceiver = new NetworkConnectChangedReceiver();
        this.registerReceiver(myReceiver, filter);
    }

    private void unregisterReceiver() {
        if (myReceiver != null) {
            this.unregisterReceiver(myReceiver);
        }
    }
}  