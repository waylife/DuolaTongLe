package com.sogou.contest.tongle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by bao on 2015/5/30.
 */
public class RegisterActivity extends Activity implements View.OnClickListener {

    private Button registerButton;
    private Button cancelButton;
    private EditText phoneEditText;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath());
        registerButton = (Button)findViewById(R.id.register);
        cancelButton = (Button)findViewById(R.id.cancel);
        phoneEditText = (EditText)findViewById(R.id.phone);
        passwordEditText = (EditText)findViewById(R.id.password);
        registerButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.register:
                Animation animation = AnimationUtils.loadAnimation(RegisterActivity.this,R.anim.alpha);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
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
