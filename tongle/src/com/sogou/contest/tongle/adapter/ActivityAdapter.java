package com.sogou.contest.tongle.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.bean.User;
import com.sogou.contest.tongle.dao.ActivityDao;
import com.sogou.contest.tongle.db.entity.FrientEntity;
import com.sogou.contest.tongle.fragment.base.ISearchTab;
import com.sogou.contest.tongle.utils.Logger;

public class ActivityAdapter extends BaseAdapter implements ISearchTab {
    @Override
    public void beforeRequestData() {

    }

    @Override
    public List requestData(String triggerText, int tab) {
        return getSearchResult(triggerText, tab);
    }

    @Override
    public void getData(List data) {
        lists = data;
        this.notifyDataSetChanged();
    }

    private List<User> getSearchResult(String tag, int tab) {
        ActivityDao dao = new ActivityDao(mContext);
        List<User> mList = null;
        if (tab == 0) {
            Logger.i(TAG,"0");
            mList = dao.query("type", "个人");
        } else if(tab==1){
            Logger.i(TAG,"1");
            mList = dao.query("type", "商家");
        }else{
            Logger.i(TAG,"else");
            mList = dao.query("title", tag);
        }
        for (int i=0;i<mList.size();i++){
            User u=mList.get(i);
            System.out.println(u);
        }
        return mList;
    }

    String TAG = ActivityAdapter.class.getSimpleName();
    private List<?> lists;
    private Context mContext;
    private BitmapUtils bitmapUtils;

    public ActivityAdapter(List<?> list, Context ct) {
        this.lists = list;
        this.mContext = ct;
        bitmapUtils = new BitmapUtils(ct);
    }

    @Override
    public int getCount() {
        return lists==null?0:lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists==null?null:lists.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_activity_view, null);
            holder.item_activity_view_civ = (CircularImageView) convertView.findViewById(R.id.item_activity_view_civ);
            holder.head_view_info = (TextView) convertView.findViewById(R.id.item_activity_view_info);
            holder.item_activity_view_lbs_info = (TextView) convertView.findViewById(R.id.item_activity_view_lbs_info);
            holder.item_activity_view_bq_info = (TextView) convertView.findViewById(R.id.item_activity_view_bq_info);
            holder.item_activity_view_zan = (ImageView) convertView.findViewById(R.id.item_activity_view_zan);
            holder.item_activity_view_pl = (ImageView) convertView.findViewById(R.id.item_activity_view_pl);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Object object = lists.get(position);
        return convertView;
    }

    class ViewHolder {
        CircularImageView item_activity_view_civ;//头像
        TextView head_view_info;//活动描述
        TextView item_activity_view_lbs_info;//lbs
        TextView item_activity_view_bq_info;//标签
        ImageView item_activity_view_zan;//点赞
        ImageView item_activity_view_pl;//评论
    }
}
