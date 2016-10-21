package com.aritime.aridj.main.router.bean;

/**
 * Created by jiajia on 2016/10/14.
 */

public class Routerbean {
    private String routerName;//路线名
    private String signCheckCounts;//路线已检标牌个数
    private String signCounts;//路线标牌总数

    public Routerbean(String routerName, String signCheckCounts, String signCounts) {
        this.routerName = routerName;
        this.signCheckCounts = signCheckCounts;
        this.signCounts = signCounts;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getSignCheckCounts() {
        return signCheckCounts;
    }

    public void setSignCheckCounts(String signCheckCounts) {
        this.signCheckCounts = signCheckCounts;
    }

    public String getSignCounts() {
        return signCounts;
    }

    public void setSignCounts(String signCounts) {
        this.signCounts = signCounts;
    }
}
