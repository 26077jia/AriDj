package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/11/7.
 */

public class SignsBean {
    private String SID;
    private int SOrder;
    private String SName;
    private String CardID;
    private boolean IsNeedCard;


    private List<CheckItemsBean> CheckItems;

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public int getSOrder() {
        return SOrder;
    }

    public void setSOrder(int SOrder) {
        this.SOrder = SOrder;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String CardID) {
        this.CardID = CardID;
    }

    public boolean isIsNeedCard() {
        return IsNeedCard;
    }

    public void setIsNeedCard(boolean IsNeedCard) {
        this.IsNeedCard = IsNeedCard;
    }

    public List<CheckItemsBean> getCheckItems() {
        return CheckItems;
    }

    public void setCheckItems(List<CheckItemsBean> CheckItems) {
        this.CheckItems = CheckItems;
    }
}
