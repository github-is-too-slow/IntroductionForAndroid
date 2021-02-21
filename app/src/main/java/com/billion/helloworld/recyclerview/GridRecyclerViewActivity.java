package com.billion.helloworld.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.billion.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRv_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRv_grid = (RecyclerView) findViewById(R.id.rv_grid);
        //设置grid网格布局管理器,并指定显示为3列
        mRv_grid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));
        //设置分隔条功能
        mRv_grid.addItemDecoration(new Divider());
        //设置适配器，指定网格项内容
        mRv_grid.setAdapter(new HorAdapter(GridRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "grid单击：" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new HorAdapter.OnItemLongClickListener() {
            @Override
            public boolean onLongClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "grid长按：" + pos, Toast.LENGTH_SHORT).show();
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
            outRect.set(0, 0, getResources().getDimensionPixelSize(R.dimen.dividerHeight),
                    getResources().getDimensionPixelSize(R.dimen.dividerHeight));
        }
    }
}
