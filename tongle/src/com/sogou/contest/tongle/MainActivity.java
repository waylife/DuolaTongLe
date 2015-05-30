package com.sogou.contest.tongle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sogou.contest.tongle.activity.BaseActivity;
import com.sogou.contest.tongle.adapter.FragmentAdapters;

public class MainActivity extends BaseActivity implements OnClickListener {

    private ViewPager mViewPager;
    private View currentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviewID();
        listener();
        FragmentAdapters adapter = new FragmentAdapters(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);// 默认加载第一个布局
        mViewPager.setOffscreenPageLimit(2);// 设置缓存个数
        mViewPager.setOnPageChangeListener(changeListener);// 界面滑动监听

        bt1.performClick();
    }

    private void listener() {
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    private void initviewID() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
    }

    private OnPageChangeListener changeListener = new OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    setButton(bt1);
                    break;
                case 1:
                    setButton(bt2);
                    break;
                case 2:
                    setButton(bt3);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    private Button bt1, bt2, bt3;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                mViewPager.setCurrentItem(0, false);// 加载第1个布局
                setButton(v);
                break;
            case R.id.bt2:
                mViewPager.setCurrentItem(1, false);// 加载第2个布局,false 为设置不闪烁跳跃
                setButton(v);
                break;
            case R.id.bt3:
                mViewPager.setCurrentItem(2, false);// 加载第个布局
                setButton(v);
                break;

            default:
                break;
        }
    }

    /**
     * 设置选中状态
     *
     * @param v
     */
    private void setButton(View v) {
        if (currentButton != null && currentButton.getId() != v.getId()) {
            currentButton.setEnabled(true);
        }
        v.setEnabled(false);
        currentButton = v;
    }
}
