package com.aritime.aridj.activity.main.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aritime.aridj.activity.main.measure.MeasureFragment;
import com.aritime.aridj.activity.main.router.ui.RouterFragment;

/**
 * Created by jiajia on 2016/10/13.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 2;
    private String[] titles = new String[]{"路  线", "临  检"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RouterFragment.newInstance();
            case 1:
                return MeasureFragment.newInstance();
        }
        return RouterFragment.newInstance();
    }
}

