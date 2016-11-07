package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/11/7.
 */

public class CycleBean {
    private String CName;
    private String CID;
    private String BenchmarkDay;
    private String CycleType;
    private int Extend;
    private int Span;


    private List<TeamBean> Team;

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getBenchmarkDay() {
        return BenchmarkDay;
    }

    public void setBenchmarkDay(String BenchmarkDay) {
        this.BenchmarkDay = BenchmarkDay;
    }

    public String getCycleType() {
        return CycleType;
    }

    public void setCycleType(String CycleType) {
        this.CycleType = CycleType;
    }

    public int getExtend() {
        return Extend;
    }

    public void setExtend(int Extend) {
        this.Extend = Extend;
    }

    public int getSpan() {
        return Span;
    }

    public void setSpan(int Span) {
        this.Span = Span;
    }

    public List<TeamBean> getTeam() {
        return Team;
    }

    public void setTeam(List<TeamBean> Team) {
        this.Team = Team;
    }
}
