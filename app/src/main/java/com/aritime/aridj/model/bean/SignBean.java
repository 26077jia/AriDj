package com.aritime.aridj.model.bean;

/**
 * Created by jiajia on 2016/12/8.
 */

public class SignBean {

    private int sId ;// 标牌Id
    private int tId;// 任务Id
    private String sName;// 标牌名称
    private String sCardId;// 标牌卡号
    private int sOrder;// 标牌次序
    private int isCheck;// 是否全部测完
    private int isNeedCard;// 是否需要到位

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getsCardId() {
        return sCardId;
    }

    public void setsCardId(String sCardId) {
        this.sCardId = sCardId;
    }

    public int getsOrder() {
        return sOrder;
    }

    public void setsOrder(int sOrder) {
        this.sOrder = sOrder;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public int getIsNeedCard() {
        return isNeedCard;
    }

    public void setIsNeedCard(int isNeedCard) {
        this.isNeedCard = isNeedCard;
    }
}

