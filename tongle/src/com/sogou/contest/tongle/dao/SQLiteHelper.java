package com.sogou.contest.tongle.dao;

import com.sogou.contest.tongle.Constant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static String SQL_TABLE_TB_COLLECT_CREATE = "";
    // 数据库版本号
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, "tongle.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        if (db == null || db.isReadOnly()) {
            db = getWritableDatabase();
        }
        createSqlLiteTable();// 创建表
        db.execSQL(SQL_TABLE_TB_COLLECT_CREATE); // 执行SQL语句
    }

    /**
     * 数据库结构表
     */
    private void createSqlLiteTable() {
        //下面是测试语句，根据项目特定
        StringBuffer sb = new StringBuffer();
        sb.append(Constant.CREATE_TABLE_HEAD)
                .append(Constant.TongleActivity.TB_NAME).append(" (")
                .append(Constant.TongleActivity.A_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")//主键
                .append(Constant.TongleActivity.A_UNAME).append(" TEXT,")//姓名
                .append(Constant.TongleActivity.A_AGE).append(" TEXT,")//年龄
                .append(Constant.TongleActivity.A_SEX).append(" TEXT,")//性别
                .append(Constant.TongleActivity.A_GOOD).append(" TEXT,")//赞
                .append(Constant.TongleActivity.A_ACTIVITY).append(" TEXT,")//活动
                .append(Constant.TongleActivity.A_TYPE).append(" TEXT,")//类型
                .append(Constant.TongleActivity.A_LBS).append(" TEXT,")//距离
                .append(Constant.TongleActivity.A_FATHER).append(" TEXT,")//父亲名称
                .append(Constant.TongleActivity.A_FATHER_PHONE).append(" TEXT,")//父亲名称
                .append(Constant.TongleActivity.A_INFO).append(" TEXT,")//详细信息描述
                .append(Constant.TongleActivity.A_TITLE).append(" TEXT);");//标题
        SQL_TABLE_TB_COLLECT_CREATE = sb.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 如果新版本号，大于旧版本号
        if (newVersion > oldVersion) {
            // 解除表关系
            dropTable(db);
            // 重新建表
            createTable(db);
        }
    }

    /**
     * 解除表的关系
     *
     * @param db
     */
    protected void dropTable(SQLiteDatabase db) {
        if (db == null || db.isReadOnly()) {
            db = getWritableDatabase();
        }

        db.execSQL(getDropTableSql(Constant.TongleActivity.TB_NAME));
    }

    protected String getDropTableSql(String tableName) {
        return "DROP TABLE IF EXISTS " + tableName;
    }
}
