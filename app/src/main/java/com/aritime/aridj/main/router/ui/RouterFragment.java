package com.aritime.aridj.main.router.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritime.aridj.R;

/**
 * Created by jiajia on 2016/10/12.
 */

public class RouterFragment extends Fragment {


    public static RouterFragment newInstance() {

        Bundle args = new Bundle();
        RouterFragment fragment = new RouterFragment();
//        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route,container,false);
        return view;
    }
}
