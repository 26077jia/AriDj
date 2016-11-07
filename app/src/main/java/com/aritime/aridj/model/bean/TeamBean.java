package com.aritime.aridj.model.bean;

/**
 * Created by jiajia on 2016/11/7.
 */

public class TeamBean {
    private String StartTime;
    private String Endtime;
    private String Teamtype;

    /**
     * StartTime : 0:00
     * Endtime : 12:00
     * Teamtype : 早班
     */

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndtime() {
        return Endtime;
    }

    public void setEndtime(String Endtime) {
        this.Endtime = Endtime;
    }

    public String getTeamtype() {
        return Teamtype;
    }

    public void setTeamtype(String Teamtype) {
        this.Teamtype = Teamtype;
    }
}
