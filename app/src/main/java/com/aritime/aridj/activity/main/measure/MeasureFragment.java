package com.aritime.aridj.activity.main.measure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritime.aridj.R;

/**
 * Created by jiajia on 2016/10/12.
 */

public class MeasureFragment extends Fragment {
    public static final String MEAS_PAGE = "measure_page";
    private int mPage;

    private FloatingActionButton fab_measure;

    public static MeasureFragment newInstance() {

//        Bundle args = new Bundle();
//        args.putInt(MEAS_PAGE,page);
        MeasureFragment fragment = new MeasureFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(MEAS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_measure, container, false);
        fab_measure = (FloatingActionButton) view.findViewById(R.id.fab_measure);
        fab_measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindowBottom();
            }
        });
        //setUI(mpage)
        return view;
    }

    private void popWindowBottom() {
        BottomDialog bottomDialog = BottomDialog.newInstance();
        bottomDialog.show(getChildFragmentManager(),BottomDialog.class.getSimpleName());
//        SignDialog msd = SignDialog.newInstance();
//        msd.show(getChildFragmentManager(),SignDialog.class.getSimpleName());


    }

}
