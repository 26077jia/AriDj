package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/12/9.
 */

public class MachineBean {

    private int machineId;//设备Id
    private String machineName;// 设备名称
    private List<CheckItemBean> checkItemList; // 检测项列表

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public List<CheckItemBean> getCheckItemList() {
        return checkItemList;
    }

    public void setCheckItemList(List<CheckItemBean> checkItemList) {
        this.checkItemList = checkItemList;
    }
}
