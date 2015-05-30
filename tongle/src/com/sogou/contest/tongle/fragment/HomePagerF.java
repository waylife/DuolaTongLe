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

public class HomePagerF extends Fragment {

	private View view;
	private ListView xListView;
	private List<String> list;
	private HomeAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.homepager, null);
		xListView = (ListView) view.findViewById(R.id.mListView);
		list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(i+"");
		}
		adapter = new HomeAdapter(list, getActivity());
		xListView.setAdapter(adapter);

		return view;
	}
}
