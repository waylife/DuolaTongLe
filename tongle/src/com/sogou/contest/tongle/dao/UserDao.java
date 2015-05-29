package com.sogou.contest.tongle.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sogou.contest.tongle.bean.Person;

public class UserDao {
	private SQLiteHelper helper;

	public UserDao(Context context) {
		helper = new SQLiteHelper(context);
	}

	public long insert(Person p) {
		SQLiteDatabase db = helper.getReadableDatabase();
		ContentValues values = new ContentValues(); // 类似Map集合, 用来存储要插入的列名和数据
		values.put("name", p.getName()); // 向集合中插入数据
		values.put("balance", p.getBalance());
		long id = db.insert("person", "id", values); // 执行插入操作, 指定要插入的列名和数据.得到id
		db.close();
		return id;
	}

	public int delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		int count = db.delete("person", "id=?", new String[] { id + "" }); // 删除person表中符合条件的记录,返回删除的记录数
		db.close();
		return count;
	}

	public int update(Person p) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", p.getName());
		values.put("balance", p.getBalance());
		int count = db.update("person", values, "id=?", new String[] { p.getId() + "" }); // 向person表插入数据,得到修改的记录数
		db.close();
		return count;
	}

	public Person query(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor c = db.query("person", new String[] { "name", "balance" }, "id=?", new String[] { id + "" }, null, null, null);
		Person p = null;
		if (c.moveToNext()) { // 判断结果集中是否包含下一条记录, 如果包含则会把指针移动到下一条
			String name = c.getString(0); // 根据列的索引, 从结果集中获取数据
			int balance = c.getInt(c.getColumnIndex("balance")); // 先根据列名获取索引,再根据索引获取数据
			p = new Person(id, name, balance);
		}
		c.close();
		db.close();
		return p;
	}

	public List<Person> queryAll() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("person", null, "balance>? and balance<?", new String[] { "5000", "6000" }, null, null, "balance DESC");
		List<Person> list = new ArrayList<Person>();
		while (c.moveToNext()) {
			Person p = new Person();
			p.setId(c.getInt(c.getColumnIndex("id")));
			p.setName(c.getString(c.getColumnIndex("name")));
			p.setBalance(c.getInt(c.getColumnIndex("balance")));
			list.add(p);
		}
		c.close();
		db.close();
		return list;
	}

	public List<Person> queryPage(int pageSize, int pageNum) {
		String index = (pageNum - 1) * pageSize + ""; // 分页的起始索引
		String count = pageSize + ""; // 分页时取多少条记录

		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("person", null, null, null, null, null, null, index + "," + count);
		List<Person> list = new ArrayList<Person>();
		while (c.moveToNext()) {
			Person p = new Person();
			p.setId(c.getInt(0));
			p.setName(c.getString(1));
			p.setBalance(c.getInt(2));
			list.add(p);
		}
		c.close();
		db.close();
		return list;
	}

	public int queryCount() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("person", new String[] { "COUNT(*)" }, null, null, null, null, null);
		c.moveToNext();
		int count = c.getInt(0);
		c.close();
		db.close();
		return count;
	}
}
