package com.sogou.contest.tongle.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.HomeAdapter;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

/**
 * 找活动
 */
public class FindActivityFragment extends BaseSearchTabFragment {
	@Override
	public void doCreate(View view) {
		setAdapter(new BaseAdapter[]{},new String[]{"个人发起","商家发起"});
	}
}
