package com.billion.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.billion.helloworld.R;
import com.bumptech.glide.Glide;

/**
 * Created by 13360 on 2021/2/15.
 */

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyListAdapter(Context mContext){
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    //列表项个数
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //存储列表项内容
    static class ViewHolder{
        public ImageView img;
        public TextView tvTitle;
        public TextView tvTime;
        public TextView tvContent;
    }

    //为每个列表项关联内容
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_view_item, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //设置列表项内容
        holder.tvTitle.setText("标题：Hello");
        holder.tvTime.setText("时间：2020-2-2");
        holder.tvContent.setText("内容：熊大");
        Glide.with(mContext).load("https://www.baidu.com/img/dong_8f1d47bcb77d74a1e029d8cbb3b33854.gif").into(holder.img);
        return convertView;
    }
}
