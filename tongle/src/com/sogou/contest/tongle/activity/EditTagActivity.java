package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.sogou.contest.tongle.MyApplication;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.adapter.EditTagAdapter;
import com.sogou.contest.tongle.db.entity.FrientEntity;

public class EditTagActivity extends BaseActivity {
    FrientEntity mEntity=null;
    private boolean isPositionTag;
    GridView mGridView;
    TextView mNameTv;

    public static void actionTo(Context context,boolean isPositionTag){
        Intent intent=new Intent(context,EditTagActivity.class);
        intent.putExtra("is_position_tag",isPositionTag);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tag);
        initView();
    }

    private void initView() {
        View.OnClickListener onClickListener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id=v.getId();
                switch(id){
                    case R.id.setting_save:
                        EditTagActivity.this.finish();
                        break;
                    case R.id.setting_cancel:
                        EditTagActivity.this.finish();
                        break;
                }
            }
        };

        findViewById(R.id.setting_save).setOnClickListener(onClickListener);
        findViewById(R.id.setting_cancel).setOnClickListener(onClickListener);
        mGridView= (GridView) findViewById(R.id.edit_tag_gridview);
        mNameTv= (TextView) findViewById(R.id.edit_tag_name);

        //loading values
        isPositionTag=getIntent().getBooleanExtra("is_position_tag",false);
        mEntity= MyApplication.getApp().getSelfEntity();
        mNameTv.setText(isPositionTag?"兴趣标签":"位置标签");
        mGridView.setAdapter(new EditTagAdapter(this,isPositionTag?mEntity.getPositionTag():mEntity.getInterestTag()));

    }

}
