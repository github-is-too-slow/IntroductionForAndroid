package com.billion.helloworld.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.billion.helloworld.R;

public class HorRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRv_hor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
        mRv_hor = (RecyclerView) findViewById(R.id.rv_hor);
        //创建线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecyclerViewActivity.this);
        //设置水平布局
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv_hor.setLayoutManager(linearLayoutManager);
        //设置分隔条功能
        mRv_hor.addItemDecoration(new Divider());
        //设置适配器，填充视图子项内容
        mRv_hor.setAdapter(new HorAdapter(HorRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this, "hor单击：" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new HorAdapter.OnItemLongClickListener() {
            @Override
            public boolean onLongClick(int pos) {
                Toast.makeText(HorRecyclerViewActivity.this, "hor长按：" + pos, Toast.LENGTH_SHORT).show();
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
            outRect.set(0, 0, getResources().getDimensionPixelSize(R.dimen.dividerHeight), 0);
        }
    }
}
