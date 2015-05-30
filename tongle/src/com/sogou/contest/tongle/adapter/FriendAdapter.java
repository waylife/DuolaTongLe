package com.sogou.contest.tongle.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;
import com.sogou.contest.tongle.R;
import com.sogou.contest.tongle.db.entity.FrientEntity;
import com.sogou.contest.tongle.fragment.base.ISearchTab;
import com.sogou.contest.tongle.utils.FormatUtil;

public class FriendAdapter extends BaseAdapter implements ISearchTab{
    String TAG = ActivityAdapter.class.getSimpleName();
    private List<FrientEntity> lists;
    private Context mContext;
    DbUtils mDbUtils;

    public FriendAdapter(List<FrientEntity> list, Context ct) {
        this.lists = list;
        this.mContext = ct;
        mDbUtils= DbUtils.create(ct);
        mDbUtils.configAllowTransaction(true);
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
            convertView = View.inflate(mContext, R.layout.item_friend_view, null);
            holder.head_view_civ = (CircularImageView) convertView.findViewById(R.id.head_view_civ);
            holder.head_view_uname = (TextView) convertView.findViewById(R.id.head_view_uname);
            holder.head_view_distance = (TextView) convertView.findViewById(R.id.head_view_distance);
            holder.head_view_add = (ImageView) convertView.findViewById(R.id.head_view_add);
            holder.head_tag=(ImageView)convertView.findViewById(R.id.item_friend_view_iv_tm);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        FrientEntity item = lists.get(position);
        if(item!=null){
            holder.head_view_civ.setImageResource(item.getAvatar());
            holder.head_view_distance.setText(FormatUtil.formatDistance(item.getDistance()));
            holder.head_view_uname.setText(item.getName());
            if(TextUtils.isEmpty(item.getTangmaoAccount())){
                holder.head_tag.setVisibility(View.GONE);
            }else{
                holder.head_tag.setVisibility(View.VISIBLE);
            }
        }
        return convertView;
    }

    @Override
    public void beforeRequestData() {

    }

    @Override
    public List requestData(String triggerText,int tab) {
        return getSearchResult(triggerText,tab);
    }

    @Override
    public void getData(List data) {
        lists=data;
        this.notifyDataSetChanged();
        if(lists==null||lists.size()==0){
            Toast.makeText(mContext,"没有搜索到结果",Toast.LENGTH_SHORT).show();
        }
    }

    private List<FrientEntity> getSearchResult(String tag,int tab) {
        Selector selector=Selector.from(FrientEntity.class).where("positionTag","like","%"+tag+"%").or("interestTag", "like", "%" + tag + "%");
        if(tab==0){
            selector.orderBy("isPopular desc,distance ",false);
        }else if(tab==1){
            selector.orderBy("distance", false);
        }else{
            selector.orderBy("tangmaoAccount desc, distance",false);
        }

        Log.e("error", selector.toString());
        List<FrientEntity> list = new ArrayList<FrientEntity>();
        try {
            list = mDbUtils.findAll(selector);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    class ViewHolder {
        CircularImageView head_view_civ;
        TextView head_view_uname;
        TextView head_view_distance;
        ImageView head_view_add;
        ImageView head_tag;
    }
}