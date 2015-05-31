package com.sogou.contest.tongle.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;

import com.sogou.contest.tongle.Constant;
import com.sogou.contest.tongle.bean.User;
import com.sogou.contest.tongle.db.entity.RandomValue;
import com.sogou.contest.tongle.listener.NotfiyListener;
import com.sogou.contest.tongle.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityDao {
    String TAG = "ActivityDao";
    private SQLiteHelper helper;

    public ActivityDao(Context context) {
        helper = new SQLiteHelper(context);
    }

    private static String[] POSITION_TAGS = "五道口#天通苑#回龙观#西单#鸟巢#北京西站#国贸#苹果园#五棵松#宛城#大望路#圆明园西#香山#周口店#慕田峪#白河峡谷#天安门".split("#");
    private static String[] INTEREST_TAGS = "游泳#读书#乒乓球#滑冰#画画#下棋#看书#唱歌".split("#");
    private static String[] ACTIVITY_TAGS = "亲子少儿军事活动#幼儿钢琴启蒙体验#野外拓展培训#吉尼斯7日游#宝贝拔河大赛#".split("#");
    private static String[] SEX = "男#女".split("#");
    private static String[] TYPE = "个人#商家".split("#");
    private static String[] GOOD = "0#1".split("#");

    /**
     * 3 到9岁的孩子
     *
     * @param p
     * @return
     */
    public long insert(User p) {
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues(); // 类似Map集合, 用来存储要插入的列名和数据

        values.put("uname", p.uname); // 向集合中插入数据
        values.put("sex", p.sex);
        values.put("age", p.age);
        values.put("type", p.type);//个人或者商家{1 个人,2 商家}
        values.put("good", p.good);//赞
        values.put("activity", p.activity);//标签
        values.put("lbs", p.lbs);//距离
        values.put("title", p.title);
        values.put("father", p.father);
        values.put("fatherphone", p.fatherphone);
        values.put("info", p.info);

//		public static final String A_UNAME = "uname";
//		public static final String A_SEX = "sex";
//		public static final String A_AGE = "age";
//		public static final String A_TYPE = "type";//个人或者商家{1 个人,2 商家}
//		public static final String A_GOOD = "good";//赞
//		public static final String A_ACTIVITY = "activity";//活动
//		public static final String A_LBS = "lbs";//距离
//		public static final String A_TITLE = "title";//标签
//		public static final String A_FATHER = "father";//父亲
//		public static final String A_FATHER_PHONE = "fatherphone";//父亲
//		public static final String A_INFO = "info";//详细信息
        long id = db.insert(Constant.TongleActivity.TB_NAME, Constant.TongleActivity.A_ID, values); // 执行插入操作, 指定要插入的列名和数据.得到id
        db.close();
        return id;
    }

    /**
     * 测试数据
     *
     * @return
     */
    public void insert_test() {
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues(); // 类似Map集合, 用来存储要插入的列名和数据
        for (int i = 0; i < 10; i++) {
            String name = RandomValue.getChineseName();
            values.put("uname", name); // 向集合中插入数据
            values.put("sex", SEX[new Random().nextInt(SEX.length)]);
            values.put("age", new Random().nextInt(7) + 3);
            values.put("type", TYPE[new Random().nextInt(TYPE.length)]);//个人或者商家{1 个人,2 商家}
            values.put("good", GOOD[new Random().nextInt(GOOD.length)]);//赞
            values.put("activity", ACTIVITY_TAGS[new Random().nextInt(ACTIVITY_TAGS.length)]);//标签
            values.put("lbs", POSITION_TAGS[new Random().nextInt(POSITION_TAGS.length)]);//距离
            values.put("title", INTEREST_TAGS[new Random().nextInt(INTEREST_TAGS.length)]);
            values.put("father", name + "F");
            values.put("fatherphone", "13" + i + "164" + i + "812" + i);
            values.put("info", "今天天气很好,我们一起去颐和园玩耍,很多一起的小伙伴,隔壁老王也来了,我们划船,唱歌,跳舞.....");
            db.insert(Constant.TongleActivity.TB_NAME, Constant.TongleActivity.A_ID, values); // 执行插入操作, 指定要插入的列名和数据.得到id
        }

        db.close();
    }

    /**
     * 删除 字段
     *
     * @param uname
     * @return
     */
    public int delete(String uname) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = db.delete(Constant.TongleActivity.TB_NAME, "uname=?", new String[]{uname + ""}); // 删除person表中符合条件的记录,返回删除的记录数
        db.close();
        return count;
    }

    /**
     * 删除 全部
     *
     * @return
     */
    public int deleteAll() {
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = db.delete(Constant.TongleActivity.TB_NAME, null, null); // 删除person表中符合条件的记录,返回删除的记录数
        db.close();
        return count;
    }

    /**
     * 更新
     *
     * @param p
     * @return
     */
    public int update(User p) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uname", p.uname); // 向集合中插入数据
        values.put("sex", p.sex);
        values.put("age", p.age);
        values.put("type", p.type);//个人或者商家{1 个人,2 商家}
        values.put("good", p.good);//赞
        values.put("activity", p.activity);
        values.put("lbs", p.lbs);//距离
        values.put("title", p.title);
        values.put("father", p.father);
        values.put("fatherphone", p.fatherphone);
        values.put("info", p.info);
        int count = db.update(Constant.TongleActivity.TB_NAME, values, "uname=?", new String[]{p.uname + ""}); // 向person表插入数据,得到修改的记录数
        db.close();
        return count;
    }

    /**
     * 条件查询
     *
     * @return
     */
    public List<User> query(String zhiduan, String str) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(Constant.TongleActivity.TB_NAME, null, zhiduan + "=?", new String[]{str}, null, null, "age DESC");

        List<User> list = new ArrayList<User>();
        while (c.moveToNext()) {
            User p = new User();

            p.uname = (c.getString(c.getColumnIndex("uname")));
            p.sex = (c.getString(c.getColumnIndex("sex")));
            p.age = (c.getString(c.getColumnIndex("age")));
            p.type = (c.getString(c.getColumnIndex("type")));
            p.good = (c.getString(c.getColumnIndex("good")));
            p.activity = (c.getString(c.getColumnIndex("activity")));
            p.lbs = (c.getString(c.getColumnIndex("lbs")));
            p.title = (c.getString(c.getColumnIndex("title")));
            p.father = (c.getString(c.getColumnIndex("father")));
            p.fatherphone = (c.getString(c.getColumnIndex("fatherphone")));
            p.info = (c.getString(c.getColumnIndex("info")));
            list.add(p);
        }
        c.close();
        db.close();
        return list;
    }

    /**
     * 条件查询
     *
     * @return
     */
    public List<User> query(String zd1, String zd2, String str1, String str2) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(Constant.TongleActivity.TB_NAME, null, zd1 + "=? and " + zd2 + "=?", new String[]{str1, str2}, null, null, "age DESC");

        List<User> list = new ArrayList<User>();
        while (c.moveToNext()) {
            User p = new User();
            p.uname = (c.getString(c.getColumnIndex("uname")));
            p.sex = (c.getString(c.getColumnIndex("sex")));
            p.age = (c.getString(c.getColumnIndex("age")));
            p.type = (c.getString(c.getColumnIndex("type")));
            p.good = (c.getString(c.getColumnIndex("good")));
            p.activity = (c.getString(c.getColumnIndex("activity")));
            p.lbs = (c.getString(c.getColumnIndex("lbs")));
            p.title = (c.getString(c.getColumnIndex("title")));
            p.father = (c.getString(c.getColumnIndex("father")));
            p.fatherphone = (c.getString(c.getColumnIndex("fatherphone")));
            p.info = (c.getString(c.getColumnIndex("info")));
            list.add(p);
        }
        c.close();
        db.close();
        return list;
    }

//	public Person query(int id) {
//		SQLiteDatabase db = helper.getWritableDatabase();
//		Cursor c = db.query("person", new String[] { "name", "balance" }, "id=?", new String[] { id + "" }, null, null, null);
//		Person p = null;
//		if (c.moveToNext()) { // 判断结果集中是否包含下一条记录, 如果包含则会把指针移动到下一条
//			String name = c.getString(0); // 根据列的索引, 从结果集中获取数据
//			int balance = c.getInt(c.getColumnIndex("balance")); // 先根据列名获取索引,再根据索引获取数据
//			p = new Person(id, name, balance);
//		}
//		c.close();
//		db.close();
//		return p;
//	}

    /**
     * 全部查询
     *
     * @return
     */
    public List<User> queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(Constant.TongleActivity.TB_NAME, null, null, null, null, null, "age DESC");
        List<User> list = new ArrayList<User>();
        while (c.moveToNext()) {
            User p = new User();
            p.uname = (c.getString(c.getColumnIndex("uname")));
            p.sex = (c.getString(c.getColumnIndex("sex")));
            p.age = (c.getString(c.getColumnIndex("age")));
            p.type = (c.getString(c.getColumnIndex("type")));
            p.good = (c.getString(c.getColumnIndex("good")));
            p.activity = (c.getString(c.getColumnIndex("activity")));
            p.lbs = (c.getString(c.getColumnIndex("lbs")));
            p.title = (c.getString(c.getColumnIndex("title")));
            p.father = (c.getString(c.getColumnIndex("father")));
            p.fatherphone = (c.getString(c.getColumnIndex("fatherphone")));
            p.info = (c.getString(c.getColumnIndex("info")));
            list.add(p);
        }
        c.close();
        db.close();
        return list;
    }

    /**
     * 分页查询
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    public List<User> queryPage(int pageSize, int pageNum) {
        String index = (pageNum - 1) * pageSize + ""; // 分页的起始索引
        String count = pageSize + ""; // 分页时取多少条记录

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(Constant.TongleActivity.TB_NAME, null, null, null, null, null, null, index + "," + count);
        List<User> list = new ArrayList<User>();
        while (c.moveToNext()) {
            User p = new User();
            p.uname = (c.getString(c.getColumnIndex("uname")));
            p.sex = (c.getString(c.getColumnIndex("sex")));
            p.age = (c.getString(c.getColumnIndex("age")));
            p.type = (c.getString(c.getColumnIndex("type")));
            p.good = (c.getString(c.getColumnIndex("good")));
            p.activity = (c.getString(c.getColumnIndex("activity")));
            p.lbs = (c.getString(c.getColumnIndex("lbs")));
            p.title = (c.getString(c.getColumnIndex("title")));
            p.father = (c.getString(c.getColumnIndex("father")));
            p.fatherphone = (c.getString(c.getColumnIndex("fatherphone")));
            p.info = (c.getString(c.getColumnIndex("info")));
            list.add(p);
        }
        c.close();
        db.close();
        return list;
    }

    /**
     * 总数查询
     *
     * @return
     */
    public int queryCount() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query(Constant.TongleActivity.TB_NAME, new String[]{"COUNT(*)"}, null, null, null, null, null);
        c.moveToNext();
        int count = c.getInt(0);
        c.close();
        db.close();
        return count;
    }
}
