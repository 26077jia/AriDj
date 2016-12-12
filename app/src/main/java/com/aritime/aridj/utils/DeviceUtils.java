package com.aritime.aridj.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * Created by jiajia on 2016/11/17.
 */

public class DeviceUtils {

    /**
     * 获取设备MAC地址
     * @param context 上下文
     * @return MAC地址
     */
    @SuppressLint("HardwareIds")
    public static String getMacAddressByWifiInfo(Context context) {
        try {
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (wifi != null) {
                WifiInfo info = wifi.getConnectionInfo();
                if (info != null)
                    return info.getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }
}
