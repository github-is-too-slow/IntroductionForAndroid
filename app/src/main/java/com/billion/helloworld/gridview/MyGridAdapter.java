package com.billion.helloworld.gridview;

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

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    //GridViewActivity.this上下文
    public MyGridAdapter(Context mContext){
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return 11;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //存储GridViewItem网格项的内容
    static class ViewHolder{
        public ImageView img_grid;
        public TextView tv_title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_view_item, null);
            holder = new ViewHolder();
            holder.img_grid = (ImageView) convertView.findViewById(R.id.iv_grid);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //设置网格项内容
        holder.tv_title.setText("玫瑰花");
        Glide.with(mContext).load("http://sjbz.fd.zol-img.com.cn/t_s240x320c/g5/M00/0F/0D/ChMkJ1fJRcqIN7aGAARAo8MrpOkAAU8ZgOpQvUABEC7685.jpg").into(holder.img_grid);
        return convertView;
    }
}
