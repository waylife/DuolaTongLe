package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sogou.contest.tongle.R;

public class EditTagActivity extends BaseActivity {

    public static void actionTo(Context context){
        Intent intent=new Intent(context,EditTagActivity.class);
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
    }

}
