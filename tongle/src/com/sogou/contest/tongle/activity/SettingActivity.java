package com.sogou.contest.tongle.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.sogou.contest.tongle.MyApplication;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.db.entity.FrientEntity;

public class SettingActivity extends BaseActivity {
    FrientEntity mEntity=null;
    EditText mParentNameEt;
    EditText mTangMaoAccountEt;
    TextView mGradeTv;
    TextView mSexTv;
    TextView mInterestTv;
    TextView mPositionTv;

    public static void actionTo(Context context){
        Intent intent=new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        View.OnClickListener onClickListener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id=v.getId();
                switch(id){
                    case R.id.setting_save:
                        SettingActivity.this.finish();
                        DbUtils dbUtils= DbUtils.create(SettingActivity.this);
                        dbUtils.configAllowTransaction(true);
                        mEntity.setTangmaoAccount(mTangMaoAccountEt.getText().toString());
                        mEntity.setParentName(mParentNameEt.getText().toString());
                        try {
                            dbUtils.saveOrUpdate(mEntity);
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.setting_cancel:
                        SettingActivity.this.finish();
                        break;
                    case R.id.setting_interest_layout:
                        EditTagActivity.actionTo(SettingActivity.this);
                        break;
                    case R.id.setting_position_layout:
                        EditTagActivity.actionTo(SettingActivity.this);
                        break;
                }
            }
        };

        findViewById(R.id.setting_save).setOnClickListener(onClickListener);
        findViewById(R.id.setting_cancel).setOnClickListener(onClickListener);
        findViewById(R.id.setting_interest_layout).setOnClickListener(onClickListener);
        findViewById(R.id.setting_position_layout).setOnClickListener(onClickListener);

        mParentNameEt= (EditText) findViewById(R.id.setting_parent_et);
        mTangMaoAccountEt=(EditText)findViewById(R.id.setting_tangmao_account_et);
        mGradeTv= (TextView) findViewById(R.id.setting_grade_tv);
        mSexTv= (TextView) findViewById(R.id.setting_sex_tv);
        mInterestTv=(TextView)findViewById(R.id.setting_interest_tv);
        mPositionTv= (TextView) findViewById(R.id.setting_position_tv);
        //loading values
        //loading values
        loadValues();
    }

    private void loadValues(){
        mEntity= MyApplication.getApp().getSelfEntity();
        mParentNameEt.setText(mEntity.getParentName());
        mTangMaoAccountEt.setText(mEntity.getTangmaoAccount());
        mGradeTv.setText(mEntity.getGrade()+"岁");
        mSexTv.setText(mEntity.getSex()==1?"男":"女");
        mInterestTv.setText(getTag(mEntity.getInterestTag()));
        mPositionTv.setText(getTag(mEntity.getPositionTag()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mParentNameEt!=null){
            loadValues();
        }
    }

    private String getTag(String original){
        String []tags=original.split("#");
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<tags.length;i++){
            if(i==2)
                break;
            sb.append('#').append(tags[i]).append('#');
        }
        return sb.toString();
    }


}
