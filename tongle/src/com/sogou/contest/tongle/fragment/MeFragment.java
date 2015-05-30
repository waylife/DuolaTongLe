package com.sogou.contest.tongle.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sogou.contest.tongle.MyApplication;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.activity.FocusedFriendActivity;
import com.sogou.contest.tongle.activity.PublishActivity;
import com.sogou.contest.tongle.activity.SettingActivity;

/**
 * 我自己
 */
public class MeFragment extends Fragment {

	private View mMainView;
	private ImageButton mSettingIb;
	private LinearLayout focused_friend;
	private LinearLayout publish_activity;
	private TextView mNameTv;
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

		focused_friend = (LinearLayout)mMainView.findViewById(R.id.focused_friend);
		focused_friend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FocusedFriendActivity.actionTo(getActivity());
			}
		});

		publish_activity = (LinearLayout)mMainView.findViewById(R.id.publish_activity);
		publish_activity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PublishActivity.actionTo(getActivity());
			}
		});

		mNameTv=(TextView)mMainView.findViewById(R.id.setting_name);
		mNameTv.setText(MyApplication.getApp().getSelfEntity().getName());
	}


}
