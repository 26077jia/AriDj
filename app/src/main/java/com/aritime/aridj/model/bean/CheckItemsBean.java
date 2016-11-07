package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/11/7.
 */

public class CheckItemsBean {
    private String CName;
    private String CID;
    private String EquipmentName;
    private String EId;
    private String CheckType;
    private double EmissiveFrequency;
    private String Unit;
    private int Order;
    private boolean IsMust;
    private int EState;
    private String CheckMode;

    /**
     * CName : 上部温度
     * CID : THISISAID1231
     * EquipmentName : 反应桶
     * EId : THISISAID123123
     * CheckType : 测温度
     * EmissiveFrequency  : 0.9
     * Unit : 度
     * Order : 0
     * IsMust : true
     * EState : 运行
     * CheckMode : 手摸，鼻闻
     * Limit : [{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]
     */

    private List<LimitBean> Limit;

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

    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String EquipmentName) {
        this.EquipmentName = EquipmentName;
    }

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public String getCheckType() {
        return CheckType;
    }

    public void setCheckType(String CheckType) {
        this.CheckType = CheckType;
    }

    public double getEmissiveFrequency() {
        return EmissiveFrequency;
    }

    public void setEmissiveFrequency(double EmissiveFrequency) {
        this.EmissiveFrequency = EmissiveFrequency;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public boolean isIsMust() {
        return IsMust;
    }

    public void setIsMust(boolean IsMust) {
        this.IsMust = IsMust;
    }

    public int getEState() {
        return EState;
    }

    public void setEState(int EState) {
        this.EState = EState;
    }

    public String getCheckMode() {
        return CheckMode;
    }

    public void setCheckMode(String CheckMode) {
        this.CheckMode = CheckMode;
    }

    public List<LimitBean> getLimit() {
        return Limit;
    }

    public void setLimit(List<LimitBean> Limit) {
        this.Limit = Limit;
    }

}
