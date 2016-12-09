package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/12/9.
 */

public class RouterBean {

    private int rId;// 路线Id
    private String routerName;// 路线名称
    private int rcId;// 路线周期Id
    private int IsSignOrder;// 是否强制次序
    private List<SignBean> signBeanList;// 标牌列表

    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public int getRcId() {
        return rcId;
    }

    public void setRcId(int rcId) {
        this.rcId = rcId;
    }

    public int getIsSignOrder() {
        return IsSignOrder;
    }

    public void setIsSignOrder(int isSignOrder) {
        IsSignOrder = isSignOrder;
    }

    public List<SignBean> getSignBeanList() {
        return signBeanList;
    }

    public void setSignBeanList(List<SignBean> signBeanList) {
        this.signBeanList = signBeanList;
    }
}
