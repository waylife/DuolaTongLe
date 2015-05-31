package com.sogou.contest.tongle.bean;


public class User {

//	public static final String A_UNAME = "uname";
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


	public User() {
	}


	@Override
	public String toString() {
		return "User{" +
				"head='" + head + '\'' +
				", uname='" + uname + '\'' +
				", sex='" + sex + '\'' +
				", age='" + age + '\'' +
				", type='" + type + '\'' +
				", good='" + good + '\'' +
				", activity='" + activity + '\'' +
				", lbs='" + lbs + '\'' +
				", title='" + title + '\'' +
				", father='" + father + '\'' +
				", fatherphone='" + fatherphone + '\'' +
				", info='" + info + '\'' +
				'}';
	}

	/**
	 * 头像用的id
	 */
	public String head;
	/**
	 * 姓名
	 */
	public String uname;
	/**
	 * 性别
	 */
	public String sex;
	/**
	 * 年龄
	 */
	public String age;
	/**
	 * 活动类型
	 */
	public String type;
	/**
	 * 赞
	 */
	public String good;
	/**
	 * 活动标题
	 */
	public String activity;
	/**
	 * 距离
	 */
	public String lbs;
	/**
	 * 标签
	 */
	public String title;
	/**
	 * 父亲
	 */
	public String father;
	/**
	 * 家长电话
	 */
	public String fatherphone;
	/**
	 * 活动详细信息
	 */
	public String info;
}
