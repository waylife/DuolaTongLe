package com.sogou.contest.tongle;

import com.sogou.contest.tongle.db.DbMock;
import com.sogou.contest.tongle.utils.Logger;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static Context mContext;
	private boolean mDataInited=false;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		
		Logger.isLog=true;//发布正式环境打印改为false
		if(!mDataInited){
			mDataInited=true;
			new Thread(new Runnable() {
				@Override
				public void run() {
					DbMock.mockDbData(MyApplication.this);
				}
			}).start();
		}
	}

	public static synchronized Context getApp() {
		return mContext;


	}
}
