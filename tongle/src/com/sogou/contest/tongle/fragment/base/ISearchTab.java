package com.sogou.contest.tongle.fragment.base;

import java.util.List;

/**
 * Created by rxread on 5/30/15.
 */
public interface ISearchTab<T> {
    /**UI Thread*/
    public void beforeRequestData();
    /**No UI Thread*/
    public List<T> requestData(String triggerText,int tab);
    /**UI Thread*/
    public void getData(List<T> data);
}
