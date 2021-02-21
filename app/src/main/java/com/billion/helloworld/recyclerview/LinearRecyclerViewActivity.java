package com.billion.helloworld.recyclerview;


import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.billion.helloworld.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRv_main = (RecyclerView) findViewById(R.id.rv_main);
        //指定使用LinearRecycleView
        mRv_main.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        //添加分割线
        mRv_main.addItemDecoration(new Divider());
        //指定Adapter适配器填充每一个view子项并//为每一个item项添加单击响应事件
        mRv_main.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "单击pos：" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new LinearAdapter.OnItemLongClickListener() {
            @Override
            public boolean onLongClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "长按pos：" + pos, Toast.LENGTH_SHORT).show();
                return true;
            }
        }));

    }

    //实现分隔条功能
    class Divider extends RecyclerView.ItemDecoration{
        //在item项周围设置附属内容
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.dividerHeight));
        }
    }
}
