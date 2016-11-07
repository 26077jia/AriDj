package com.aritime.aridj.model.bean;

import java.util.List;

/**
 * Created by jiajia on 2016/11/7.
 */

public class RuleBean {

    /**
     * ID : THISISAID12345111
     * RName : 车间一
     * RID : THISISAID12345
     * IsSignOrder : true
     * IsAllowOverTime : true
     * Signs : [{"SID":"THISISSIGNID1232","SOrder":1,"SName":"水泵房","CardID":"THISISCARDID121","IsNeedCard":true,"CheckItems":[{"CName":"上部温度","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测温度","EmissiveFrequency ":0.9,"Unit":"度","Order":0,"IsMust":true,"EState":"运行","CheckMode":"手摸，鼻闻","Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测加速度","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"EmissiveFrequency ":0.9,"Unit":"米/平方秒"},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测位移","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"EmissiveFrequency ":0.9,"Unit":"米"},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测速度","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"EmissiveFrequency ":0.9,"Unit":"米/秒"},{"CName":"电机转速","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测转速","EmissiveFrequency ":0.9,"Unit":"转/秒","Order":2,"IsMust":false,"EState":null,"CheckMode":null,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]},{"CName":"电表","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"抄表","Unit":"度","Order":3,"EState":null,"CheckMode":null,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"IsMust":false},{"CName":"是否漏油","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"观察项","EState":null,"CheckMode":null,"Select":["是","否"],"IsMultiterm":false,"Order":4,"IsMust":true},{"CName":"外观记录","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"记录","EState":null,"CheckMode":null,"Order":5,"IsMust":false}]},{"SID":"THISISSIGNID1232","SOrder":1,"SName":"水泵房","CardID":"THISISCARDID121","IsNeedCard":true,"CheckItems":[{"CName":"上部温度","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测温度","EmissiveFrequency ":0.9,"Unit":"度","Order":0,"IsMust":true,"EState":"运行","CheckMode":"手摸，鼻闻","Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测加速度","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"EmissiveFrequency ":0.9,"Unit":"米/平方秒","Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测位移","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"EmissiveFrequency ":0.9,"Unit":"米"},{"CName":"上部振动","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测速度","Order":1,"EState":null,"CheckMode":null,"IsMust":false,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"EmissiveFrequency ":0.9,"Unit":"米/秒"},{"CName":"电机转速","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"测转速","EmissiveFrequency ":0.9,"Unit":"转/秒","Order":2,"IsMust":false,"EState":null,"CheckMode":null,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}]},{"CName":"电表","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"抄表","Unit":"度","Order":3,"EState":null,"CheckMode":null,"Limit":[{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"},{"Lv":1,"TopLimit":100,"LowerLimit":10,"Color":"#FFFFF"}],"IsMust":false},{"CName":"是否漏油","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"观察项","EState":null,"CheckMode":null,"Select":["是","否"],"IsMultiterm":false,"Order":4,"IsMust":true},{"CName":"外观记录","CID":"THISISAID1231","EquipmentName":"反应桶","EId":"THISISAID123123","CheckType":"记录","EState":null,"CheckMode":null,"Order":5,"IsMust":false}]}]
     * Operators : [{"PersonName":"张三","PersonID":"zs","CardID":"THISISID123","PassWord":"value"},{"PersonName":"李三","PersonID":"LS","CardID":"THISISID1231","PassWord":"value"}]
     * Cycle : {"CName":"3天一次","CID":"THISISAID112233","BenchmarkDay":"2016-09-28","CycleType":"天","Extend":0,"Span":3,"Team":[{"StartTime":"0:00","Endtime":"12:00","Teamtype":"早班"},{"StartTime":"12:00","Endtime":"2:00","Teamtype":"中班"}]}
     */

    private List<RouterCycleBean> RouterCycle;

    public List<RouterCycleBean> getRouteCycle() {
        return RouterCycle;
    }

    public void setRouteCycle(List<RouterCycleBean> RouteCycle) {
        this.RouterCycle = RouteCycle;
    }

}
