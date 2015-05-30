package com.sogou.contest.tongle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

/**
 * 找朋友
 */
public class FindFriendFragment extends BaseSearchTabFragment {

	@Override
	public void doCreate(View view) {
		setAdapter(new BaseAdapter[]{},new String[]{"热门","附近","糖猫"});
	}
}
