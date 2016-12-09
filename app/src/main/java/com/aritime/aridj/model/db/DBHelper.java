package com.aritime.aridj.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库管理类
 * Created by jiajia on 2016/11/22.
 */

public class DBHelper extends SQLiteOpenHelper {
    private final static int DB_VERSION = 1;
    private final static String DB_NAME = "ais.db";
    private Context mContext;


    /**
     * 职员表创建语句 Operator
     */
    public static final String CREATE_STAFF = "create table Operator ("
            + "OId integer primary key"   //操作人Id
            + "OName text"                //操作人账号名
            + "OPwd text"                 //操作人密码
            + "OCardId text"              //操作人签到卡卡号
            + ")";

    /**
     * 点检任务表创建语句 Task
     */
    public static final String CREATE_TASK = "create table task("
            + "TId integer primary key"   //任务Id
            + "OId integer foreign key"   //操作人Id
            + "TaskSTime text"            //任务开始时间
            + "TaskETime text"            //任务结束时间
            + "IsAllowOverTime integer"   //是否允许超时
            + "IsUpLoad integer"          //是否已上传
            + ")";

    /**
     * 点检路线表创建语句 Router
     */
    public static final String CREATE_ROUTER = "create table router("
            + "RId integer primary key"   //路线Id
            + "RCId integer"              //路线规则包Id
            + "RName text"                //路线名称
            + "IsSignOrder integer"       //是否强制次序
            + ")";

    /**
     * 点检标牌表创建语句 Sign
     */
    public static final String CREATE_SIGN = "create table sign("
            + "SId integer primary key"   //标牌Id
            + "TId integer foreign key"   //任务Id
            + "SName text"                //标牌名称
            + "SCardId text"              //标牌卡号
            + "SOrder integer"            //标牌次序
            + "IsCheck integer"           //是否全部测完
            + "IsNeedCard integer"        //是否需要到位
            + ")";

    /**
     * 点检检测项表创建语句 checkItem
     */
    public static final String CREATE_CHECKITEM = "create table checkItem("
            + "CId integer primary key"   //检测项Id
            + "TId integer foreign key"   //任务Id
            + "CName text"                //检测项名称
            + "CType integer"             //检测类型
            + "EId integer"               //设备Id
            + "EName text"                //设备名称
            + "IsMust integer"            //是否必须检测
            + "CValue text"               //检测值
            + ""                     //TODO 检测值（可能多个）的处理
            + ")";

    /**
     * 点检检测类型表创建语句 checkType
     */
    public static final String CREATE_CHECKTYPE = "create table checkType("
            + "_id integer autoincrement" //id
            + "CTId integer primary key"   //检测类型Id
            + "CTName text"                //检测类型名称
            + "CTUnit text"                //检测类型单位
            + ")";

    /**
     * 任务、路线、标牌、检测项关联表创建语句 relation
     */
    public static final String CREATE_RELATION = "create table relation("
            + "_id integer"              //ID
            + "TId integer"              //任务Id
            + "RId integer"              //路线Id
            + "SId integer"              //标牌Id
            + "CId integer"              //检测项Id
            + ")";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STAFF);
        db.execSQL(CREATE_TASK);
        db.execSQL(CREATE_ROUTER);
        db.execSQL(CREATE_SIGN);
        db.execSQL(CREATE_CHECKITEM);
        db.execSQL(CREATE_RELATION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
