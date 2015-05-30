package com.sogou.contest.tongle.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.ActivityAdapter;

/**
 * 找活动
 */
public class FindActivityFragment extends Fragment {

	private View view;
	private ListView xListView;
	private List<String> list;
	private ActivityAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activitypager, null);
		xListView = (ListView) view.findViewById(R.id.mListView);
		list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(i+"");
		}
		adapter = new ActivityAdapter(list, getActivity());
		xListView.setAdapter(adapter);

		return view;
	}
}
