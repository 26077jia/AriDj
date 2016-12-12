package com.aritime.aridj.bean;

import java.util.List;

/**
 * 设备实体类
 * */
public class MachineBean {


    // 设备名
    public String name;
    // 检测项
    public List<String> checkItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(List<String> checkItems) {
        this.checkItems = checkItems;
    }
}