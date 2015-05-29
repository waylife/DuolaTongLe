package com.sogou.contest.tongle.dao;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;


public class TongLeProvider extends ContentProvider {
	private SQLiteHelper helper;
	private UriMatcher matcher;
	private static final int PERSON_ID = 0;
	private static final int PERSON = 1;

	public boolean onCreate() {
		try {
			System.out.println("onCreate");
			helper = new SQLiteHelper(getContext());
			matcher = new UriMatcher(UriMatcher.NO_MATCH);				// 创建Uri匹配器(用来识别Uri)
			matcher.addURI("ItheimaProvider", "person/#", PERSON_ID);
			matcher.addURI("ItheimaProvider", "person", PERSON);		// 给匹配器添加可以识别的路径, 如果匹配到person将会得到结果码1
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Uri insert(Uri uri, ContentValues values) {
		switch (matcher.match(uri)) {
			case PERSON:
				SQLiteDatabase db = helper.getWritableDatabase();
				long id = db.insert("person", null, values);	// 在values中没有数据的时候, 传null则不插入任何数据
				getContext().getContentResolver().notifyChange(uri, null);
				db.close();
				return ContentUris.withAppendedId(uri, id);		// 把id拼接在Uri后面返回
			default:
				throw new IllegalArgumentException("无法识别的Uri: " + uri);
		}
	}

	public int delete(Uri uri, String selection, String[] selectionArgs) {
		switch (matcher.match(uri)) {
			case PERSON_ID:
				long id = ContentUris.parseId(uri);			// 截取Uri后面的id
				selection = "id=?";							// 修改删除条件
				selectionArgs = new String[] { id + "" };	// 设置条件中的参数
			case PERSON:
				SQLiteDatabase db = helper.getWritableDatabase();
				int count = db.delete("person", selection, selectionArgs);
				getContext().getContentResolver().notifyChange(uri, null);
				db.close();
				return count;
			default:
				throw new IllegalArgumentException("无法识别的Uri: " + uri);
		}
	}

	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		switch (matcher.match(uri)) {
			case PERSON_ID:
				long id = ContentUris.parseId(uri);			// 截取Uri后面的id
				selection = "id=?";							// 修改删除条件
				selectionArgs = new String[] { id + "" };	// 设置条件中的参数
			case PERSON:
				SQLiteDatabase db = helper.getWritableDatabase();
				int count = db.update("person", values, selection, selectionArgs);
				getContext().getContentResolver().notifyChange(uri, null);	// 通知uri数据被修改了
				db.close();
				return count;
			default:
				throw new IllegalArgumentException("无法识别的Uri: " + uri);
		}
	}

	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		switch (matcher.match(uri)) {
			case PERSON_ID:
				long id = ContentUris.parseId(uri);			// 截取Uri后面的id
				selection = "id=?";							// 修改删除条件
				selectionArgs = new String[] { id + "" };	// 设置条件中的参数
			case PERSON:
				SQLiteDatabase db = helper.getReadableDatabase();
				Cursor c = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
				return c;
			default:
				throw new IllegalArgumentException("无法识别的Uri: " + uri);
		}
	}

	public String getType(Uri uri) {
		switch (matcher.match(uri)) {
			case PERSON_ID:
				return "vnd.android.cursor.item/person";
			case PERSON:
				return "vnd.android.cursor.dir/person";
			default:
				throw new IllegalArgumentException("无法识别的Uri: " + uri);
		}
	}
	
	
	//测试数据
	public void testProvider() {
		ContentResolver resolver = getContext().getContentResolver();	// 获取解析器(访问内容提供者的工具)
		Uri uri = Uri.parse("content://sogoutonele");				// 指定Uri, 明确要访问哪个内容提供者
		ContentValues values = new ContentValues();
		
		resolver.delete(uri, null, null);								// 执行Uri指向的内容提供者中的delete()方法
		resolver.query(uri, null, null, null, null);					// 
		resolver.update(uri, values, null, null);					// 
		resolver.insert(uri, values);					// 
		resolver.getType(uri);					// 
	}
}