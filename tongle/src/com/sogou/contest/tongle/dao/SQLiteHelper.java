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
			.append(Constant.Version_1.TB_NAME).append(" (")
			.append(Constant.Version_1.T_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
			.append(Constant.Version_1.T_NEWS_ID).append(" TEXT UNIQUE,")
			.append(Constant.Version_1.T_TYPE).append(" TEXT);");
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
	 * @param db
	 */
	protected void dropTable(SQLiteDatabase db) {
		if (db == null || db.isReadOnly()) {
			db = getWritableDatabase();
		}

		db.execSQL(getDropTableSql(Constant.Version_1.TB_NAME));
	}
	
	protected String getDropTableSql(String tableName) {
		return "DROP TABLE IF EXISTS " + tableName;
	}
}
