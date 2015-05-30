package com.sogou.contest.tongle.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.activity.SettingActivity;

/**
 * 我自己
 */
public class MeFragment extends Fragment {

	private View mMainView;
	private ImageButton mSettingIb;
	private ListView xlistview;
	private List<?> list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mMainView = inflater.inflate(R.layout.fragment_me, null);
		initView();
		return mMainView;
	}

	private void initView() {
		mSettingIb= (ImageButton) mMainView.findViewById(R.id.me_setting);
		mSettingIb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SettingActivity.actionTo(getActivity());
			}
		});
	}


}
