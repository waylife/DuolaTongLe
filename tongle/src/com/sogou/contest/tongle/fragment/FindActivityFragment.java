package com.sogou.contest.tongle.fragment;

import android.view.View;
import android.widget.BaseAdapter;

import com.sogou.contest.tongle.adapter.ActivityAdapter;
import com.sogou.contest.tongle.adapter.FriendAdapter;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 找活动
 */
public class FindActivityFragment extends BaseSearchTabFragment {
    private List<String> mList;

    @Override
    public void doCreate(View view) {
        mList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mList.add(i + "");
        }
        setAdapter(new BaseAdapter[]{
                new ActivityAdapter(mList, getActivity()),
                new ActivityAdapter(mList, getActivity())}, new String[]{"个人发起", "商家发起"});
    }
}
