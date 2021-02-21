package com.billion.helloworld.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.billion.helloworld.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mPu = (RecyclerView) findViewById(R.id.rv_pu);
        //设置瀑布流参差不齐的布局策略，并指定为垂直排列2列
        mPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置分隔条
        mPu.addItemDecoration(new Divider());
        //设置适配器，制定网格内容
        mPu.setAdapter(new StaggeredGridAdapter(PuRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "staggeredgrid单击：" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new StaggeredGridAdapter.OnItemLongClickListener() {
            @Override
            public boolean onLongClick(int pos) {
                Toast.makeText(PuRecyclerViewActivity.this, "staggeredgrid长按：" + pos, Toast.LENGTH_SHORT).show();
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
            int gap = getResources().getDimensionPixelSize(R.dimen.dividerHeight5dp);
            outRect.set(gap, gap, gap, gap);
        }
    }
}
