package com.sogou.contest.tongle.utils;

import android.util.Log;

public class Logger {
	private static final String NULL_STR = "msg is null!";

	// 是否显示日志
	public static boolean isLog = false;// false 不显示，true 显示

	public static void i(String tag, String msg) {
		if (isLog) {
			Log.i(tag, msg != null ? msg : NULL_STR);
		}
	}

	public static void e(String tag, String msg) {
		if (isLog) {
			Log.e(tag, msg != null ? msg : NULL_STR);
		}
	}

	public static void d(String tag, String msg) {
		if (isLog) {
			Log.d(tag, msg != null ? msg : NULL_STR);
		}
	}

	public static void w(String tag, String msg) {
		if (isLog) {
			Log.w(tag, msg != null ? msg : NULL_STR);
		}
	}

	public static void v(String tag, String msg) {
		if (isLog) {
			Log.v(tag, msg != null ? msg : NULL_STR);
		}
	}
}
