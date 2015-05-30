package com.sogou.contest.tongle.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sogou.contest.tongle.R;

import java.util.ArrayList;

/**
 * Created by rxread on 5/31/15.
 */
public class EditTagAdapter extends BaseAdapter{
    private ArrayList mTagsList;
    private String DEFAULT_TAG_ADD="_1_";
    LayoutInflater mLayoutInflater;
    public EditTagAdapter(Context context,String tags){
        mTagsList=new ArrayList();
        String []strings=tags.split("#");
        for (int i=0;i<strings.length;i++){
            if(!TextUtils.isEmpty(strings[i])){
                mTagsList.add(strings[i]);
            }
        }
        mTagsList.add(DEFAULT_TAG_ADD);
        mLayoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mTagsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTagsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=mLayoutInflater.inflate(R.layout.item_edit_tag_view,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        String text=(String)getItem(position);
        if(DEFAULT_TAG_ADD.equals(text)){
            viewHolder.textview.setVisibility(View.GONE);
            viewHolder.imageview.setVisibility(View.VISIBLE);
        }else{
            viewHolder.textview.setText(text);
            viewHolder.textview.setVisibility(View.VISIBLE);
            viewHolder.imageview.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class ViewHolder{
        public TextView textview;
        public ImageView imageview;
        public ViewHolder(View convertView){
            textview= (TextView) convertView.findViewById(R.id.item_edit_tag_text);
            imageview= (ImageView) convertView.findViewById(R.id.item_edit_tag_iv);
        }

    }
}
