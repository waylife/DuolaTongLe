package com.sogou.contest.tongle.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class LifeAdapter extends BaseAdapter {
	private List<?> list;
	private Context mContext;

	public LifeAdapter(List<?> list, Context ct) {
		this.list = list;
		this.mContext = ct;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
