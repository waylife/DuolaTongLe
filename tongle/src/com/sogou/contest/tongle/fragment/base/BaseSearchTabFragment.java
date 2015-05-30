package com.sogou.contest.tongle.fragment.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sogou.contest.tongle.R;

/**
 * Created by rxread on 5/30/15.
 */
public abstract class BaseSearchTabFragment extends Fragment {
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

    public void setHeadImage(int resId){
        mHeaderImage.setImageResource(resId);
    }

    private void initView() {
        mListView = (ListView) mMainView.findViewById(R.id.listview);
        mHeaderImage = (ImageView) mMainView.findViewById(R.id.head_image);
        mTabs = new EditText[3];
        mHeaderView = getHeaderView(mInflater);
        mListView.addHeaderView(mHeaderView);
        //init views
    }


    private void search(String text) {
        if (mAdapters == null || mAdapters.length == 0 || mAdapters.length >= 3) {
            return;
        }
        for (int i = 0; i < mAdapters.length; i++) {
            if (mAdapters[i] instanceof ISearchTab) {
                ((ISearchTab) mAdapters[i]).updateData(text);
            }
        }
    }

    public void setAdapter(BaseAdapter[] adapters, String[] tabsTitle) {
        if (adapters == null || adapters.length == 0 || adapters.length >= 3)
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
                mListView.setAdapter(mAdapters[index]);
            }
        };
        for (int i = 0; i < adapters.length; i++) {
            mTabs[i].setVisibility(View.VISIBLE);
            mTabs[i].setText(tabsTitle[i]);
            mTabs[i].setTag(i);
            mTabs[i].setOnClickListener(onClickListener);
        }
        mListView.setAdapter(mAdapters[0]);
    }

    private View getHeaderView(LayoutInflater inflater) {
        View headView = inflater.inflate(R.layout.view_title_and_search, null);
        mSearchEt = (EditText) headView.findViewById(R.id.view_head_search_et);
        mTabs[0] = (TextView) headView.findViewById(R.id.view_head_search_tab1);
        mTabs[1] = (TextView) headView.findViewById(R.id.view_head_search_tab2);
        mTabs[2] = (TextView) headView.findViewById(R.id.view_head_search_tab3);
        for (int i = 0; i > mTabs.length; i++) {
            mTabs[i].setVisibility(View.GONE);
        }

        return headView;
    }

}
