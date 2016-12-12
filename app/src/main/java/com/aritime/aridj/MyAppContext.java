package com.aritime.aridj;

import android.app.Application;

import com.aritime.aridj.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiajia on 2016/11/14.
 */

public class MyAppContext extends Application {
    private User mUser;//当前登录的在线用户
    private Map<String, Object> transferMap;//用于数据传递的集合
    private Map<String, Object> cacheMap;//用于缓存数据的集合

    @Override

    public void onCreate() {
        super.onCreate();
        mUser = new User();
        transferMap = new HashMap<String, Object>();
        cacheMap = new HashMap<String, Object>();
    }

    public User getUser() {
        return mUser;
    }

    /**
     * 获取数据传递 Map 集合
     *
     * @return 数据传递 Map 集合
     */
    public Map<String, Object> getTransferMap() {
        return transferMap;
    }

    /**
     * 获取数据缓存 Map 集合
     *
     * @return 数据缓存 Map 集合
     */
    public Map<String, Object> getCacheMap() {
        return cacheMap;
    }

    /**
     * 内存不足时回调该方法
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
