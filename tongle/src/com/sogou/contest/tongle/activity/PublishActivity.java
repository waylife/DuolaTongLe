package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sogou.contest.tongle.R;

/**
 * Created by bao on 2015/5/31.
 */
public class PublishActivity extends BaseActivity{
    public static void actionTo(Context context){
        Intent intent=new Intent(context,PublishActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publish_activity_view);
        initView();
    }

    private void initView() {

        View.OnClickListener onClickListener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id=v.getId();
                switch(id){
                    case R.id.person:
                        JoinedActivity.actionTo(PublishActivity.this);
                        break;
                    case R.id.back_imageView2:
                        PublishActivity.this.finish();
                        break;

                }
            }
        };

        findViewById(R.id.person).setOnClickListener(onClickListener);
        findViewById(R.id.back_imageView2).setOnClickListener(onClickListener);


    }

}
