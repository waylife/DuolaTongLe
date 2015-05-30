package com.sogou.contest.tongle.fragment.base;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by rxread on 5/31/15.
 */
public class AsyncDataTask extends AsyncTask<String,Object,List<Object>> {
    private ISearchTab mISearchTab;
    private int tab;

    public AsyncDataTask(ISearchTab iSearchTab){
        this.mISearchTab=iSearchTab;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mISearchTab.beforeRequestData();
    }

    @Override
    protected List<Object> doInBackground(String... params) {
        String searchText=params[0];
        int tab=Integer.parseInt(params[1]);
        return   mISearchTab.requestData(searchText,tab);
    }

    @Override
    protected void onPostExecute(List<Object> objects) {
        super.onPostExecute(objects);
        mISearchTab.getData(objects);
    }
}
