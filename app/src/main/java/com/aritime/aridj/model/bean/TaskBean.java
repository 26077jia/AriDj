package com.aritime.aridj.model.bean;

import java.sql.Date;

/**
 * Created by jiajia on 2016/12/9.
 */

public class TaskBean {

    private int tId;// 任务Id
    private int oId;// 操作人Id
    //TODO 时间格式及数据库时间格式
    private Date taskSTime;// 任务开始时间
    private Date taskETime;// 任务结束时间
    private int isAllowOverTime;// 是否允许超时
    private int isUpload;// 是否已上传

    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
    }

    public int getOId() {
        return oId;
    }

    public void setOId(int oId) {
        this.oId = oId;
    }

    public Date getTaskSTime() {
        return taskSTime;
    }

    public void setTaskSTime(Date taskSTime) {
        this.taskSTime = taskSTime;
    }

    public Date getTaskETime() {
        return taskETime;
    }

    public void setTaskETime(Date taskETime) {
        this.taskETime = taskETime;
    }

    public int getIsAllowOverTime() {
        return isAllowOverTime;
    }

    public void setIsAllowOverTime(int isAllowOverTime) {
        this.isAllowOverTime = isAllowOverTime;
    }

    public int getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(int isUpload) {
        this.isUpload = isUpload;
    }
}
