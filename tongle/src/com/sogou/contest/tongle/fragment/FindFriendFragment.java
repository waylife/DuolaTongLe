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
import com.sogou.contest.tongle.adapter.ActivityAdapter;
import com.sogou.contest.tongle.adapter.FriendAdapter;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 找朋友
 */
public class FindFriendFragment extends BaseSearchTabFragment {
    private List<String> mList;

    @Override
    public void doCreate(View view) {
        mList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mList.add(i + "");
        }
        setAdapter(new BaseAdapter[]{new FriendAdapter(mList, getActivity()),
                new FriendAdapter(mList, getActivity()), new FriendAdapter(mList, getActivity())}, new String[]{"热门", "附近", "糖猫"});
    }
}
