package com.aritime.aridj.bean;

import java.util.List;

/**
 * 标牌实体类
 * */
public class SignBean {

    // 标牌名
    public String name;

    // 设备名
    public List<MachineBean> mMachineBeanList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MachineBean> getMachineBeanList() {
        return mMachineBeanList;
    }

    public void setMachineBeanList(List<MachineBean> machineBeanList) {
        mMachineBeanList = machineBeanList;
    }
}