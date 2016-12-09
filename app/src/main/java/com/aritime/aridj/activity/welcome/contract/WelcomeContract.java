package com.aritime.aridj.activity.welcome.contract;

import android.content.Context;

/**
 * Created by jiajia on 2016/11/17.
 */

public class WelcomeContract {

    public interface View {
        Context getMyContext();
    }

    public interface Presenter {
        boolean firstLaunchVerify();

        boolean userVerify();
    }

    public interface Model {
        boolean isFirstLaunch();

        String getUserId();
        boolean staffVerify();


    }

}