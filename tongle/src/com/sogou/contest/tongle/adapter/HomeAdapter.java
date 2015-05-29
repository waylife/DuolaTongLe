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

import com.lidroid.xutils.BitmapUtils;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.utils.Utils;

public class HomeAdapter extends BaseAdapter {

	private List<?> lists;
	private Context mContext;
	private BitmapUtils bitmapUtils;

	public HomeAdapter(List<?> list, Context ct) {
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
			convertView = View.inflate(mContext, R.layout.xlixstview_item, null);
			holder.iv_left = (ImageView) convertView.findViewById(R.id.iv_itme_left);
			holder.iv_right = (ImageView) convertView.findViewById(R.id.iv_itme_right);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Object object = lists.get(position);
		if (position == 0) {
			int type = Utils.isNetworkAvailable(mContext);
			if (type == 1) {
				ImageView image = new ImageView(mContext);
				image.setScaleType(ScaleType.FIT_XY);
				DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
				int screenwidth = dm.widthPixels;
				LayoutParams layoutParams = new LayoutParams(screenwidth, screenwidth / 2);
				image.setLayoutParams(layoutParams);
				// bitmapUtils.display(image, object.listimage);
			} else {
				holder.iv_left.setImageResource(R.drawable.transparent);
			}
		} else {
			int type = Utils.isNetworkAvailable(mContext);
			if (type == 1) {
				// holder.iv_left.setVisibility(View.VISIBLE);
				// bitmapUtils.display(holder.iv_left, object.listimage);
				//
				// holder.iv_right.setVisibility(View.VISIBLE);
				// bitmapUtils.display(holder.iv_right, object.listimage);
			} else {
				holder.iv_left.setImageResource(R.drawable.transparent);
			}
		}
		return convertView;
	}

	class ViewHolder {
		ImageView iv_left;
		ImageView iv_right;
	}
}
