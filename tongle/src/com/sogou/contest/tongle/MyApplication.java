package com.sogou.contest.tongle;

import com.sogou.contest.tongle.dao.ActivityDao;
import com.sogou.contest.tongle.db.DbMock;
import com.sogou.contest.tongle.db.entity.FrientEntity;
import com.sogou.contest.tongle.utils.Logger;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static MyApplication mContext;
	private boolean mDataInited=false;
	private FrientEntity mSelfEntity;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
		
		Logger.isLog=true;//发布正式环境打印改为false
		if(!mDataInited){//只会调用一次
			mDataInited=true;
			DbMock.mockDbData(this);

			new Thread(new Runnable() {
				@Override
				public void run() {
					ActivityDao dao=new ActivityDao(mContext);
					dao.insert_test();

					DbMock.mockDbData(MyApplication.this);
				}
			}).start();
		}
	}

	public static synchronized MyApplication getApp() {
		return mContext;
	}

	public void initSelfItem(FrientEntity entity){
		this.mSelfEntity=entity;
	}

	public FrientEntity getSelfEntity(){
		return this.mSelfEntity;
	}
}
