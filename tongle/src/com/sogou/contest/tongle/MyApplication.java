package com.sogou.contest.tongle;

import com.sogou.contest.tongle.dao.ActivityDao;
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
		if(!mDataInited){//只会调用一次
			mDataInited=true;
			DbMock.mockDbData(this);
			ActivityDao dao=new ActivityDao(mContext);
			dao.insert_test();
		}
	}

	public static synchronized Context getApp() {
		return mContext;


	}
}
