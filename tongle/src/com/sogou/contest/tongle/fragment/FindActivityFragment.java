package com.sogou.contest.tongle.fragment;

import android.view.View;
import android.widget.BaseAdapter;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.ActivityAdapter;
import com.sogou.contest.tongle.adapter.FriendAdapter;
import com.sogou.contest.tongle.bean.User;
import com.sogou.contest.tongle.dao.ActivityDao;
import com.sogou.contest.tongle.fragment.base.BaseSearchTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 找活动
 */
public class FindActivityFragment extends BaseSearchTabFragment {

    @Override
    public void doCreate(View view) {

        ActivityDao dao=new ActivityDao(getActivity());
        List<User> mList= dao.queryAll();//("type", "0");
        for (int i=0; i<mList.size();i++){
            System.out.print(mList.get(i));
        }
        System.out.print(mList);
        System.out.print("-----------------------------------");

//        setHeadImage(R.drawable.find_activity_top);
//        setAdapter(new BaseAdapter[]{new ActivityAdapter(mList, getActivity()),
//                new ActivityAdapter(mList, getActivity())}, new String[]{"个人发起", "商家发起"});
    }
}
