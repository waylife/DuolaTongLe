package com.sogou.contest.tongle.task.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorManage {
	private static final String TAG = ExecutorManage.class.getSimpleName();

	private static class UserServiceHolder {
		private static ExecutorManage mExecutorService = new ExecutorManage();
	}

	public static ExecutorManage getInstance() {
		return UserServiceHolder.mExecutorService;
	}

	private ExecutorManage() {
		mExecutor = Executors.newCachedThreadPool();
	}

	private ExecutorService mExecutor;

	public void submitTask(Runnable runnable) {
		mExecutor.submit(runnable);
	}
}
