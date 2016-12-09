package com.aritime.aridj.model.bean;

/**
 * 操作
 * Created by jiajia on 2016/12/9.
 */

public class Operators {

    private int OId;// 操作人员Id
    private String OName;// 操作人员名称
    private String OPwd;// 操作人员密码
    private String OCardId;// 操作人员签到卡卡号

    public int getOId() {
        return OId;
    }

    public void setOId(int OId) {
        this.OId = OId;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getOPwd() {
        return OPwd;
    }

    public void setOPwd(String OPwd) {
        this.OPwd = OPwd;
    }

    public String getOCardId() {
        return OCardId;
    }

    public void setOCardId(String OCardId) {
        this.OCardId = OCardId;
    }
}
