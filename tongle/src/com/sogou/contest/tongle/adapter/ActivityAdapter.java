package com.sogou.contest.tongle.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.lidroid.xutils.BitmapUtils;
import com.sogou.contest.tongle.R;

public class ActivityAdapter extends BaseAdapter {
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
            convertView = View.inflate(mContext, R.layout.item_head_view, null);
            holder.head_view_civ = (CircularImageView) convertView.findViewById(R.id.head_view_civ);
            holder.head_view_info = (TextView) convertView.findViewById(R.id.head_view_info);
            holder.head_view_distance = (ImageView) convertView.findViewById(R.id.head_view_distance);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position % 3 == 0) {
            holder.head_view_civ.setBackgroundResource(R.drawable.head_view_civ_xqx);
            holder.head_view_info.setBackgroundResource(R.drawable.head_view_des_xx);
        } else if (position % 3 == 1) {
            holder.head_view_civ.setBackgroundResource(R.drawable.head_view_civ_nn);
            holder.head_view_info.setBackgroundResource(R.drawable.head_view_des_nn);
        } else if (position % 3 == 2) {
            holder.head_view_civ.setBackgroundResource(R.drawable.head_view_civ_fj);
            holder.head_view_info.setBackgroundResource(R.drawable.head_view_des_fj);
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
