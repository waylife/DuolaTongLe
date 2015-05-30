package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sogou.contest.tongle.R;

public class SettingActivity extends BaseActivity {

    public static void actionTo(Context context){
        Intent intent=new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

}
