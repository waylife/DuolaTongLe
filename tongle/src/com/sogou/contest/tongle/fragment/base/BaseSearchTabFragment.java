package com.sogou.contest.tongle.fragment.base;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sogou.contest.tongle.R;

import java.util.List;

/**
 * Created by rxread on 5/30/15.
 */
public abstract class BaseSearchTabFragment extends Fragment {
    private int mCurrentTab=0;
    LayoutInflater mInflater;
    protected View mMainView;
    protected ListView mListView;
    protected View mHeaderView;
    protected EditText mSearchEt;
    protected TextView[] mTabs;
    protected BaseAdapter[] mAdapters;
    protected ImageView mHeaderImage;

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mInflater = inflater;
        mMainView = inflater.inflate(R.layout.fragment_base_search_tab, null);
        initView();
        doCreate(mMainView);
        return mMainView;
    }

    public abstract void doCreate(View view);

    public void setHeadImage(int resId) {
        mHeaderImage.setBackgroundResource(resId);
    }

    private void initView() {
        mListView = (ListView) mMainView.findViewById(R.id.listview);
        mHeaderImage = (ImageView) mMainView.findViewById(R.id.head_image);
        mTabs = new TextView[3];
        mHeaderView = getHeaderView(mInflater);
        mListView.addHeaderView(mHeaderView);
        //init views
    }


    private void search(final String text) {
        if (mAdapters == null || mAdapters.length == 0 || mAdapters.length > 3) {
            return;
        }
        if(mCurrentTab>3){
            return;
        }
        Toast.makeText(getActivity(), "正在搜索:" + text, Toast.LENGTH_SHORT).show();
        if(mAdapters[mCurrentTab] instanceof ISearchTab){
            new AsyncDataTask((ISearchTab)mAdapters[mCurrentTab]).execute(text,String.valueOf(mCurrentTab));
        }
    }

    public void setAdapter(BaseAdapter[] adapters, String[] tabsTitle) {
        if (adapters == null || adapters.length == 0 || adapters.length > 3)
            throw new IllegalArgumentException("adapters can not be empty, null, or bigger than 3");
        if (tabsTitle == null || tabsTitle.length != adapters.length) {
            throw new IllegalArgumentException("adapter's length is not equal to tabsTitle's");
        }
        this.mAdapters = adapters;
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Integer index = (Integer) v.getTag();
                if (index >= mAdapters.length) {
                    return;
                }
                setTab(index);
            }
        };
        for (int i = 0; i < adapters.length; i++) {
            mTabs[i].setVisibility(View.VISIBLE);
            mTabs[i].setText(tabsTitle[i]);
            mTabs[i].setTag(i);
            mTabs[i].setOnClickListener(onClickListener);
        }
        setTab(0);
    }

    private void setTab(int selected) {
        for (int i = 0; i < mAdapters.length; i++) {
            if (selected == i) {
                mCurrentTab=selected;
                mTabs[i].setBackgroundColor(getActivity().getResources().getColor(R.color.tab_selected));
                mListView.setAdapter(mAdapters[selected]);
            } else {
                    mTabs[i].setBackgroundResource(0);
            }
        }
        search(mSearchEt.getText().toString());
    }

    private View getHeaderView(LayoutInflater inflater) {
        View headView = inflater.inflate(R.layout.view_title_and_search, null);
        mSearchEt = (EditText) headView.findViewById(R.id.view_head_search_et);
        mTabs[0] = (TextView) headView.findViewById(R.id.view_head_search_tab1);
        mTabs[1] = (TextView) headView.findViewById(R.id.view_head_search_tab2);
        mTabs[2] = (TextView) headView.findViewById(R.id.view_head_search_tab3);
        for (int i = 0; i < mTabs.length; i++) {
            mTabs[i].setVisibility(View.GONE);
        }

        mSearchEt.onEditorAction(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search(mSearchEt.getText().toString());
                }
                return false;
            }
        });

        return headView;
    }

}
