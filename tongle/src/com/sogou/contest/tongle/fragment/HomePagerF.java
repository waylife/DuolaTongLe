package com.sogou.contest.tongle.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.HomeAdapter;

public class HomePagerF extends Fragment implements OnRefreshListener {

	private View view;
	private ListView xListView;
	private List<String> list;
	private HomeAdapter adapter;
	private SwipeRefreshLayout swipeRefreshLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.homepager, null);
		xListView = (ListView) view.findViewById(R.id.mListView);
		swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
		list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i+"");
		}
		adapter = new HomeAdapter(list, getActivity());
		xListView.setAdapter(adapter);

		// 设置卷内的颜色
		swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
		// 设置下拉刷新监听
		swipeRefreshLayout.setOnRefreshListener(this);
		return view;
	}


	@Override
	public void onRefresh() {
		new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

			@Override
			public void run() {
				list.add(0, "添加新的item" + new Random().nextInt());
				adapter.notifyDataSetChanged();
				// 停止刷新动画
				swipeRefreshLayout.setRefreshing(false);
			}
		}, 2000);
	}
}
