package com.billion.helloworld.gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.billion.helloworld.R;

/**
 * Created by 13360 on 2021/2/15.
 */

public class GridViewActivity extends AppCompatActivity {
    private GridView mGv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv = (GridView) findViewById(R.id.gv1);
        //设置网格项内容
        mGv.setAdapter(new MyGridAdapter(GridViewActivity.this));
        //设置单击事件
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "单击Position：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "长按Position：" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
