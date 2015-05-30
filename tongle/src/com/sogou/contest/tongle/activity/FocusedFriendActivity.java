package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.FocusedFriendsAdater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bao on 2015/5/31.
 */
public class FocusedFriendActivity extends BaseActivity {
    public static void actionTo(Context context){
        Intent intent=new Intent(context,FocusedFriendActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focusedfriends_view);
        List<String> mList = new ArrayList<String>();
        mList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mList.add(i + "");
        }
        FocusedFriendsAdater adater = new FocusedFriendsAdater(mList,FocusedFriendActivity.this);
        ListView focusedfriends_listview = (ListView)findViewById(R.id.list_view);
        focusedfriends_listview.setAdapter(adater);
        initView();
    }

    private void initView() {

        View.OnClickListener onClickListener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id=v.getId();
                switch(id){
                    case R.id.back_imageView:
                        FocusedFriendActivity.this.finish();
                        break;

                }
            }

        };


        findViewById(R.id.back_imageView).setOnClickListener(onClickListener);


    }

}
