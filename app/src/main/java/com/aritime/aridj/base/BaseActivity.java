package com.aritime.aridj.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.aritime.aridj.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by jiajia on 2016/10/8.
 */

public class BaseActivity extends AppCompatActivity{

    @TargetApi(19)
    public void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        }
    }
}
