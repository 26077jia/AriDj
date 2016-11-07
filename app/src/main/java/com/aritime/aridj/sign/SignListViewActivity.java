package com.aritime.aridj.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import com.aritime.aridj.R;
import com.aritime.aridj.bean.Machine;
import com.aritime.aridj.bean.Sign;

import java.util.ArrayList;
import java.util.List;

public class SignListViewActivity extends AppCompatActivity {


    private ExpandableListView listview;
    private ImageButton imgbtn_back;
    private List<Sign> mSigns;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sign);
        initData();

        // 查找控件
        listview = ((ExpandableListView) findViewById(R.id.elv_sign));
        imgbtn_back = (ImageButton) findViewById(R.id.imgBtn_datam_back);
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        SignExpandLvAdapter adapter = new SignExpandLvAdapter(mSigns, this);
        listview.setAdapter(adapter);

        //遍历所有group,将所有项设置成默认展开
        int groupCount = listview.getCount();
        for (int i = 0; i < groupCount; i++) {
            listview.expandGroup(i);
        }
    }


    /**
     * 初始化数据
     */
    private void initData() {

        Sign signs = new Sign();
        signs.name = "电机房";
        List<Machine> machineList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Machine machine = new Machine();
            machine.name = "设备" + i;
            List<String> list = new ArrayList<>();
            list.add("【转速】");
            list.add("【温度】");
            machine.checkItems = list;
            machineList.add(machine);
        }
        signs.machineList = machineList;

        Sign signss = new Sign();
        signss.name = "仪表房";
        List<Machine> machineLists = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Machine machines = new Machine();
            machines.name = "设备" + i;
            List<String> lists = new ArrayList<>();
            lists.add("【转速】");
            lists.add("【温度】");
            machines.checkItems = lists;
            machineLists.add(machines);
        }
        signss.machineList = machineList;

        mSigns = new ArrayList<>();
        mSigns.add(signs);
        mSigns.add(signss);
    }
}