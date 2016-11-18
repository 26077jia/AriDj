package com.aritime.aridj.activity.welcome.presenter;
import com.aritime.aridj.activity.welcome.contract.WelcomeContract;
import com.aritime.aridj.activity.welcome.model.WelcomeModel;

/**
* Created by jiajia on 2016/11/17
*/

public class WelcomePresenter implements WelcomeContract.Presenter{
    private final WelcomeContract.View mView;
    private final WelcomeContract.Model mModel;


    public WelcomePresenter(WelcomeContract.View view) {
        mView = view;
        mModel  = new WelcomeModel(view.getMyContext());
    }

    @Override
    public boolean firstLaunchVerify() {
        return mModel.isFirstLaunch();
    }

    @Override
    public boolean userVerify() {
        //TODO 验证本地缓存的用户信息

        return false;
    }
}