package com.sogou.contest.tongle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.ActivityAdapter;
import com.sogou.contest.tongle.adapter.FriendAdapter;
import com.sogou.contest.tongle.db.entity.FrientEntity;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 找朋友
 */
public class FindFriendFragment extends BaseSearchTabFragment {
    private int tab=0;
    private List<FrientEntity> mList;

    @Override
    public void doCreate(View view) {
        mList = null;
        setHeadImage(R.drawable.tongle_top_friend);
        setAdapter(new BaseAdapter[]{new FriendAdapter(mList, getActivity()),
                new FriendAdapter(mList, getActivity()), new FriendAdapter(mList, getActivity())}, new String[]{"热门", "附近", "糖猫"});

    }


}
