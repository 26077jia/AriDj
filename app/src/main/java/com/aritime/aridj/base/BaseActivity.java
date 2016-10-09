package com.aritime.aridj.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.aritime.aridj.R;
import com.jaeger.library.StatusBarUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by jiajia on 2016/10/8.
 */

public class BaseActivity extends AppCompatActivity{
  /*  @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary));
    }*/
}
