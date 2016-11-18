package com.aritime.aridj.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by jiajia on 2016/11/15.
 */

public class SnackUtils {
     public  static Snackbar mSnackbar;

    /**
     * 显示提示，已有SnackBar直接更换文字
     */
    public static void showSnack(View view, String content) {
        if (mSnackbar == null) {
            mSnackbar.make(view, content, Snackbar.LENGTH_SHORT);
        } else {
            mSnackbar.setText(content);
            mSnackbar.setDuration(Snackbar.LENGTH_SHORT);
        }
        mSnackbar.show();
    }

    /**
     * 重写onBackProcess(),按下返回键不显示提示
     */
    public static void cancelSnack() {
        if (mSnackbar != null) {
            mSnackbar.dismiss();
        }
    }
}
