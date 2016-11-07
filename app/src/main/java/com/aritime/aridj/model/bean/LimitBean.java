package com.aritime.aridj.model.bean;

/**
 * Created by jiajia on 2016/11/7.
 */

public class LimitBean {
    private int Lv;
    private int TopLimit;
    private int LowerLimit;
    private String Color;

    public int getLv() {
        return Lv;
    }

    public void setLv(int Lv) {
        this.Lv = Lv;
    }

    public int getTopLimit() {
        return TopLimit;
    }

    public void setTopLimit(int TopLimit) {
        this.TopLimit = TopLimit;
    }

    public int getLowerLimit() {
        return LowerLimit;
    }

    public void setLowerLimit(int LowerLimit) {
        this.LowerLimit = LowerLimit;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
}
