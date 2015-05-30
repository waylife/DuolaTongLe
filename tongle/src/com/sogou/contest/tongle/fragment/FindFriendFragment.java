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
<<<<<<< HEAD
public class FindFriendFragment extends BaseSearchTabFragment {

	@Override
	public void doCreate(View view) {
		setAdapter(new BaseAdapter[]{},new String[]{"热门","附近","糖猫"});
	}
=======
public class FindFriendFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.findpager, null);
        return view;
    }

>>>>>>> 511ba5fdb8683ecbff55bc49932500e896bfeb0b
}
