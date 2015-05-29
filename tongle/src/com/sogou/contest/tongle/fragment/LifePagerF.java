package com.sogou.contest.tongle.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sogou.contest.tongle.R;

public class LifePagerF extends Fragment {

	private View view;
	private ListView xlistview;
	private List<?> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.lifepager, null);
		return view;
	}
}
