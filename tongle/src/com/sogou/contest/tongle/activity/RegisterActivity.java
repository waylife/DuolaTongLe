package com.sogou.contest.tongle.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sogou.contest.tongle.MainActivity;
import com.sogou.contest.tongle.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by bao on 2015/5/30.
 */
public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private Button registerButton;
    private Button cancelButton;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private String DEFAULT_PHONE="18500000000";
    private String DEFAULT_PASSWORD="1950037";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("serif").setFontAttrId(R.attr.fontPath).build());
        registerButton = (Button)findViewById(R.id.register);
        cancelButton = (Button)findViewById(R.id.cancel);
        phoneEditText = (EditText)findViewById(R.id.phone);
        passwordEditText = (EditText)findViewById(R.id.password);
        registerButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        //init values
        passwordEditText.setText(DEFAULT_PASSWORD);
        passwordEditText.setSelection(passwordEditText.getText().length());
        phoneEditText.setText(DEFAULT_PHONE);
        phoneEditText.setSelection(phoneEditText.getText().toString().length());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.register:
                if(!DEFAULT_PASSWORD.equals(passwordEditText.getText().toString())||!DEFAULT_PHONE.equals(phoneEditText.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                Animation animation = AnimationUtils.loadAnimation(RegisterActivity.this,R.anim.alpha);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        RegisterActivity.this.finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                registerButton.startAnimation(animation);
                break;
            case R.id.cancel:
                phoneEditText.setText("");
                passwordEditText.setText("");
                Animation animation1 = AnimationUtils.loadAnimation(RegisterActivity.this,R.anim.alpha);
                cancelButton.startAnimation(animation1);
                break;
        }
    }
}
