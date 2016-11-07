package com.aritime.aridj.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by jiajia on 2016/11/7.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "dj_db";// 数据库名
    private static final int DB_VERSION = 1;// 数据库版本


    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建数据库
    }

    @Override
    public synchronized void close() {
        super.close();
    }

}
