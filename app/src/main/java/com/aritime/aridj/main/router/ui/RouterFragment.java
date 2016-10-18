package com.aritime.aridj.main.router.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aritime.aridj.R;
import com.aritime.aridj.main.router.adapter.RouterFragmentAdapter;
import com.aritime.aridj.main.router.bean.Routerbean;

import java.util.ArrayList;

/**
 * Created by jiajia on 2016/10/12.
 */

public class RouterFragment extends Fragment {
    private RecyclerView rv_router;
    private RouterFragmentAdapter routerAdapter;
    private ArrayList<Routerbean> routerBeanList =new ArrayList<Routerbean>();

    public static RouterFragment newInstance() {

     //   Bundle args = new Bundle();
        RouterFragment fragment = new RouterFragment();
     //   fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_router,container,false);
        rv_router = (RecyclerView) view.findViewById(R.id.rv_router);
        rv_router.setLayoutManager(new LinearLayoutManager(getActivity()));

        routerBeanList.add(new Routerbean("车间一","2","4"));
        routerBeanList.add(new Routerbean("车间一","4","4"));
        routerBeanList.add(new Routerbean("车间一","3","4"));
        routerBeanList.add(new Routerbean("车间一","2","2"));

        routerAdapter = new RouterFragmentAdapter(getActivity(),routerBeanList);
        rv_router.setAdapter(routerAdapter);
        return view;
    }
}
