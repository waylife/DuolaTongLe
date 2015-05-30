package com.sogou.contest.tongle.adapter;

import java.util.List;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.lidroid.xutils.BitmapUtils;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.utils.Utils;

public class ActivityAdapter extends BaseAdapter {

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
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
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
            convertView = View.inflate(mContext, R.layout.head_view, null);
            holder.head_view_civ = (CircularImageView) convertView.findViewById(R.id.head_view_civ);
            holder.head_view_info = (TextView) convertView.findViewById(R.id.head_view_info);
            holder.head_view_distance = (ImageView) convertView.findViewById(R.id.head_view_distance);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        for (int i = 0; i < lists.size(); i++) {
            if(i%3==0){

            }else if(i%3==1){

            }else if(i%3==2){
                
            }
        }
        Object object = lists.get(position);
        return convertView;
    }

    class ViewHolder {
        CircularImageView head_view_civ;
        TextView head_view_info;
        ImageView head_view_distance;
    }
}
