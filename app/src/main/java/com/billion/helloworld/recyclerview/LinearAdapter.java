package com.billion.helloworld.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.billion.helloworld.R;

/**
 * Created by 13360 on 2021/2/15.
 */

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;
//    展示的数据
//    private List<String> msg;

    public LinearAdapter(Context mContext/*, List<String> msg*/,
                         OnItemClickListener itemClickListener, OnItemLongClickListener itemLongClickListener){
        this.mContext = mContext;
//        this.msg = msg;
        this.mItemClickListener = itemClickListener;
        this.mItemLongClickListener = itemLongClickListener;
    }

    //根据position返回自定义viewType视图类型
    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    //根据子元素布局返回一个对应的ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){//position是偶数
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
        }else if(viewType == 1){//position是奇数
            return new StaggeredGridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_item, parent, false));
        }else {
            return null;
        }
    }

//    根据ViewHolder设置对应子元素布局中的控件内容
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            ((LinearViewHolder)holder).tv_title.setText("linear标题：Hello");
            ((LinearViewHolder)holder).tv_time.setText("linear时间：2020-2-20");
        }else if(getItemViewType(position) == 1){
            ((StaggeredGridViewHolder)holder).tv_title.setText("标题：美女");
            ((StaggeredGridViewHolder)holder).iv_staggered.setImageResource(R.drawable.jpg_540_960);
        }
        //为holder对应的子元素布局中的每一个控件添加单击响应事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return mItemLongClickListener.onLongClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
//        返回展示的数据长度
//        return msg.length;
        return 30;
    }

//    布局layout_linear_item.xml对应的viewHolder
    class LinearViewHolder extends RecyclerView.ViewHolder{
//        对应子元素布局里的控件
        public TextView tv_title;
        public TextView tv_time;

        /*
         * itemViem: 子元素控件
         */
        public LinearViewHolder(View itemView) {
            super(itemView);
            //绑定控件
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }

//    布局layout_staggered_grid_item.xml对应的viewHolder
    class StaggeredGridViewHolder extends RecyclerView.ViewHolder{
        //对应子元素布局里的控件
        public ImageView iv_staggered;
        public TextView tv_title;

        /*
         * itemViem: 子元素控件
         */
        public StaggeredGridViewHolder(View itemView) {
            super(itemView);
            //绑定控件
            iv_staggered = (ImageView) itemView.findViewById(R.id.iv_staggered);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    //单击响应事件接口
    interface OnItemClickListener {
        void onClick(int pos);
    }

    //长按响应事件接口
    interface OnItemLongClickListener{
        boolean onLongClick(int pos);
    }
}
